package com.ssafy.hellotoday.db.entity.mypage;

import com.ssafy.hellotoday.api.dto.mypage.request.DdayModifyRequestDto;
import com.ssafy.hellotoday.db.entity.BaseEntity;
import com.ssafy.hellotoday.db.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Dday extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ddayId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private LocalDateTime finalDate;
    private String content;

    @Builder
    public Dday(Integer ddayId, Member member, LocalDateTime finalDate, String content) {
        this.ddayId = ddayId;
        this.member = member;
        this.finalDate = finalDate;
        this.content = content;
    }

    public void update(DdayModifyRequestDto ddayModifyRequestDto, Member member) {
        this.finalDate = ddayModifyRequestDto.getFinalDate();
        this.content = ddayModifyRequestDto.getContent();
        this.member = member;
    }
}
