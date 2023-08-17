package com.ssafy.hellotoday.db.entity;

import com.ssafy.hellotoday.api.dto.member.request.ShowInfoEditRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ShowInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showInfoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private byte goalFlag;
    private byte oneDiaryFlag;
    private byte wishListFlag;
    private byte routineHistoryFlag;
    private byte ddayFlag;
    private byte galleryFlag;
    @Builder
    public ShowInfo(Member member) {
        this.member = member;
        this.goalFlag = 1;
        this.oneDiaryFlag = 1;
        this.wishListFlag = 1;
        this.routineHistoryFlag = 1;
        this.ddayFlag = 1;
        this.galleryFlag = 1;
    }
    public void updateShowInfo(ShowInfoEditRequestDto showInfoUpdateRequestDto) {
        this.ddayFlag = showInfoUpdateRequestDto.getDdayFlag();
        this.galleryFlag = showInfoUpdateRequestDto.getGalleryFlag();
        this.goalFlag = showInfoUpdateRequestDto.getGoalFlag();
        this.oneDiaryFlag = showInfoUpdateRequestDto.getOneDiaryFlag();
        this.routineHistoryFlag = showInfoUpdateRequestDto.getRoutineHistoryFlag();
        this.wishListFlag = showInfoUpdateRequestDto.getWishListFlag();
    }

}
