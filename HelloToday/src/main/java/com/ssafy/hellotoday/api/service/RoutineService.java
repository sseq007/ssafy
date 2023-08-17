package com.ssafy.hellotoday.api.service;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.hellotoday.api.dto.BaseResponseDto;
import com.ssafy.hellotoday.api.dto.member.FileDto;
import com.ssafy.hellotoday.api.dto.routine.RoutineCheckDto;
import com.ssafy.hellotoday.api.dto.routine.RoutineDetailDto;
import com.ssafy.hellotoday.api.dto.routine.request.RoutineCheckRequestDto;
import com.ssafy.hellotoday.api.dto.routine.request.RoutineRequestDto;
import com.ssafy.hellotoday.api.dto.routine.response.*;
import com.ssafy.hellotoday.common.exception.validator.RoutineValidator;
import com.ssafy.hellotoday.common.util.constant.RoutineEnum;
import com.ssafy.hellotoday.common.util.file.FileUploadUtil;
import com.ssafy.hellotoday.db.entity.Member;
import com.ssafy.hellotoday.db.entity.routine.*;
import com.ssafy.hellotoday.db.repository.routine.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.ssafy.hellotoday.db.entity.routine.QRoutine.routine;
import static com.ssafy.hellotoday.db.entity.routine.QRoutineCheck.routineCheck;
import static com.ssafy.hellotoday.db.entity.routine.QRoutineDetail.routineDetail;
import static com.ssafy.hellotoday.db.entity.routine.QRoutineDetailCat.routineDetailCat;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
@EnableScheduling
public class RoutineService {
    private final RoutineDetailRepository routineDetailRepository;
    private final RoutineRecMentRepository routineRecMentRepository;
    private final RoutineRepository routineRepository;
    private final JPAQueryFactory queryFactory;
    private final FileUploadUtil fileUploadUtil;
    private final RoutineTagRepository routineTagRepository;
    private final RoutineValidator routineValidator;

    public List<RoutineDetailResponseDto> detailRoutine() {
        List<RoutineDetailResponseDto> list = new ArrayList<>();
        list.add(new RoutineDetailResponseDto(1, detailRoutine(1)));
        list.add(new RoutineDetailResponseDto(2, detailRoutine(2)));
        list.add(new RoutineDetailResponseDto(3, detailRoutine(3)));

        return list;
    }

    public List<RoutineDetailDto> detailRoutine(Integer categoryId) {
        return routineDetailRepository.findByRoutineBigCat_RoutineBigCatId(categoryId).stream()
                .map(RoutineDetailDto::new)
                .collect(Collectors.toList());
    }

    public List<RoutineRecMentResponseDto> getRecommendMents() {

        List<RoutineRecMentResponseDto> list = new LinkedList<>();
        list.add(getRecommendMent(1));
        list.add(getRecommendMent(2));
        list.add(getRecommendMent(3));

        return list;
    }

    public RoutineRecMentResponseDto getRecommendMent(Integer categoryId) {
        long qty = routineRecMentRepository.countByRoutineBigCat_RoutineBigCatId(categoryId);
        int idx = (int) (Math.random() * qty);

        List<RecommendMent> recommendMents = routineRecMentRepository.findByRoutineBigCat_RoutineBigCatId(categoryId, PageRequest.of(idx, 1));

        RecommendMent recommendMent = recommendMents.get(0);

        return new RoutineRecMentResponseDto(recommendMent);
    }

    public BaseResponseDto makeRoutine(RoutineRequestDto routineRequestDto, Member member) {

        // 현재 사용자가 진행하는 루틴이 있는지 확인하고 error;
        routineValidator.checkPrivateRoutineExist(routineRepository, member);

        Routine routine = Routine.createRoutine(
                member.getMemberId()
                , LocalDateTime.now()
                , (byte) 1
        );

        List<RoutineDetailDto> routineDetailDtoList = routineRequestDto.getRoutineDetailDtoList();

        for (RoutineDetailDto routineDetailDto : routineDetailDtoList) {
            RoutineDetailCat routineDetailCat = RoutineDetailCat.createRoutineDetailCat(routineDetailDto, routine);
            for (int i = 1; i < 8; i++) {
                routineDetailCat.addRoutineCheck(
                        RoutineCheck.createRoutineCheck(i, null, null, null, routineDetailCat, null));
            }

            routine.addRoutineDetailCat(routineDetailCat);
        }

        routineRepository.save(routine);

        return BaseResponseDto.builder()
                .success(true)
                .message(RoutineEnum.SUCCESS_MAKE_ROTUINE.getName())
                .data(RoutineResponseDto.builder()
                        .routineId(routine.getRoutineId())
                        .startDate(routine.getStartDate())
                        .endDate(routine.getEndDate())
                        .activeFlag(routine.getActiveFlag())
                        .build())
                .build();
    }

    public RoutinePrivateCheckResponseDto getPrivateRoutineCheck(Member member) {
        List<RoutineCheckResponseDto> resultlist = new ArrayList<>();

        try {
            Routine currentRoutine = queryFactory.selectFrom(routine)
                    .where(routine.member.memberId.eq(member.getMemberId())
                            .and(routine.activeFlag.eq((byte) 1))).fetchFirst();

            List<Integer> routiuneDetailCatIds = queryFactory.selectDistinct(routineDetailCat.routineDetailCatId)
                    .from(routineCheck)
                    .where(routineDetailCat.routine.routineId.eq(currentRoutine.getRoutineId())).fetch();

            for (Integer routineDetailCatId : routiuneDetailCatIds) {

                List<RoutineCheckDto> fetch = queryFactory
                        .select(Projections.constructor(RoutineCheckDto.class, routineCheck))
                        .from(routineCheck)
                        .where(routineCheck.routineDetailCat.routineDetailCatId.eq(routineDetailCatId)).fetch();

                RoutineDetailDto routineDetailDto = queryFactory.select(Projections.constructor(RoutineDetailDto.class, routineDetail))
                        .from(routineDetail)
                        .where(routineDetail.routineDetailId.eq(
                                queryFactory.select(routineDetailCat.routineDetail.routineDetailId)
                                        .from(routineDetailCat)
                                        .where(routineDetailCat.routineDetailCatId.eq(routineDetailCatId)).fetchFirst()
                        )).fetchFirst();

                resultlist.add(new RoutineCheckResponseDto(routineDetailDto, fetch));
            }

            return new RoutinePrivateCheckResponseDto((byte) 1, currentRoutine.getRoutineId(), currentRoutine.getStartDate(), resultlist);


        } catch (Exception e) {
            return new RoutinePrivateCheckResponseDto((byte) 0, 0, null,  null);
        }
    }

    public BaseResponseDto checkPrivateRoutine(RoutineCheckRequestDto routineCheckRequestDto,
                                               Member findMember, MultipartFile file) {
        RoutineCheck routineCheck =
                queryFactory.selectFrom(QRoutineCheck.routineCheck)
                        .leftJoin(routineDetailCat)
                        .on(QRoutineCheck.routineCheck.routineDetailCat.routineDetailCatId
                                .eq(routineDetailCat.routineDetailCatId))
                        .where(routineDetailCat.routine.routineId
                                .eq(routineCheckRequestDto.getRoutineId())
                                .and(QRoutineCheck.routineCheck.checkDaySeq
                                        .eq(routineCheckRequestDto.getCheckDaySeq())
                                        .and(routineDetailCat.routineDetail.routineDetailId
                                                .eq(routineCheckRequestDto.getRoutineDetailId()))))
                        .fetchFirst();

        if (!findMember.getMemberId()
                .equals(routineCheck.getRoutineDetailCat().getRoutine().getMember().getMemberId())) {
            throw new IllegalArgumentException("잘못된 접근입니다");
        }

        routineValidator.checkRoutineCheckExist(routineCheck);

        if (file != null) {
            FileDto fileDto = fileUploadUtil.uploadRoutineFile(file, routineCheck);
            routineCheck.update(routineCheckRequestDto, fileDto);
            routineCheck.getRoutineImagePath();
        } else {
            routineCheck.update(routineCheckRequestDto);
        }


        return BaseResponseDto.builder()
                .success(true)
                .message("루틴 인증 작성을 성공하셨습니다")
                .data(RoutineCheckUpdateDto.builder()
                        .routineCheck(routineCheck)
                        .build())
                .build();
    }

    public List<TagResponseDto> getTags() {
        return routineTagRepository.findAll().stream()
                .map(TagResponseDto::new)
                .collect(Collectors.toList());
    }
}
