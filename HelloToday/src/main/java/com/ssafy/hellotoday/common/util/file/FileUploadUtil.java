package com.ssafy.hellotoday.common.util.file;

import com.ssafy.hellotoday.api.dto.member.FileDto;
import com.ssafy.hellotoday.common.util.property.ApplicationProperties;
import com.ssafy.hellotoday.db.entity.Member;
import com.ssafy.hellotoday.db.entity.routine.RoutineCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;


@Component
@Slf4j
public class FileUploadUtil {

    public FileDto uploadRoutineFile(MultipartFile multipartFile, RoutineCheck routineCheck) {
        // 파일이 첨부되지 않은 경우
        if (multipartFile == null)
            throw new IllegalArgumentException("파일이 첨부되지 않았습니다.");

        // 확장자명이 존재하지 않을 경우 에러
        validateContentType(multipartFile);

        // 루틴체크 사진이 설정되어 있다면 삭제
        if(routineCheck.getRoutineImagePath() != null) {
            File originalFilePath = new File(ApplicationProperties.ROUTINECHECK_PATH + routineCheck.getImgPath());

            if (originalFilePath.exists()) {
                if(!originalFilePath.delete()) log.error("기존에 설정된 루틴체크 사진 삭제에 실패했습니다.");
            }
        }

        // 파일명 저장 경로 및 파일명 설정
        // 유니크한 파일명 설정
        String fileName = System.nanoTime() + multipartFile.getOriginalFilename();
        String filePath = ApplicationProperties.ROUTINECHECK_PATH  + fileName;

        // 업로드 한 파일 데이터를 지정한 파일에 저장
        File file = new File(filePath);
        FileDto fileDto = new FileDto();
        log.info("루틴체크 사진 저장 경로: " + filePath);
        try {
            multipartFile.transferTo(file);

            fileDto.setFilePath(filePath);
            fileDto.setFileOriginalName(fileName);
        } catch (Exception e) {
            throw new IllegalArgumentException("루틴체크 사진 변경에 실패했습니다: " + e);
        }

        return fileDto;
    }

    public FileDto uploadFile(MultipartFile multipartFile, Member member) {
        // 파일이 첨부되지 않은 경우
        if (multipartFile == null)
            throw new IllegalArgumentException("파일이 첨부되지 않았습니다.");

        // 확장자명이 존재하지 않을 경우 에러
        validateContentType(multipartFile);

        // 프로필 사진이 설정되어 있다면 삭제
        if(member.getProfilePath() != null) {
            File originalFilePath = new File(ApplicationProperties.PROFILE_PATH + member.getProfilePath());

            if (originalFilePath.exists()) {
                if(!originalFilePath.delete()) log.error("기존에 설정된 프로필 사진 삭제에 실패했습니다.");
            }
        }

        // 파일명 저장 경로 및 파일명 설정
        String fileName = member.getMemberId() + "_" + multipartFile.getOriginalFilename();
        String filePath = ApplicationProperties.PROFILE_PATH  + fileName;

        // 업로드 한 파일 데이터를 지정한 파일에 저장
        File file = new File(filePath);
        FileDto fileDto = new FileDto();
        log.info("프로필 사진 저장 경로: " + filePath);
        try {
            multipartFile.transferTo(file);

            fileDto.setFilePath(filePath);
            fileDto.setFileOriginalName(fileName);
        } catch (Exception e) {
            throw new IllegalArgumentException("프로필 사진 변경에 실패했습니다: " + e);
        }

        return fileDto;
    }

    private void validateContentType(MultipartFile multipartFile) {
        // 파일의 확장자 추출
        String contentType = multipartFile.getContentType();

        if(ObjectUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("사진 파일만 업로드해주세요.");
        }
        // 확장자가 jpeg, png인 파일들만 받아서 처리
        else if(!contentType.contains("image/jpeg") && !contentType.contains("image/png")) {

            throw new IllegalArgumentException("사진 파일만 업로드해주세요.");
        }
    }

}
