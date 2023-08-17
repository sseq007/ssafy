package com.ssafy.hellotoday.db.repository.routine;

import com.ssafy.hellotoday.db.entity.routine.RoutineCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineCheckRepository extends JpaRepository<RoutineCheck, Integer> {
    RoutineCheck findByRoutineCheckIdAndCheckDaySeq(Integer routineCheckId,Integer checkDaySeq);
}

