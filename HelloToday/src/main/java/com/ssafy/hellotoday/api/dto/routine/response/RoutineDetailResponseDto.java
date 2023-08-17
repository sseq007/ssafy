package com.ssafy.hellotoday.api.dto.routine.response;

import com.ssafy.hellotoday.api.dto.routine.RoutineDetailDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RoutineDetailResponseDto {
    private Integer routineBigCatId;
    private List<RoutineDetailDto> routineDetail;

    @Builder
    public RoutineDetailResponseDto(Integer routineBigCatId, List<RoutineDetailDto> routineDetail) {
        this.routineBigCatId = routineBigCatId;
        this.routineDetail = routineDetail;
    }
}
