package com.ssafy.hellotoday.db.entity;

import com.ssafy.hellotoday.api.dto.member.FileDto;
import com.ssafy.hellotoday.api.dto.member.request.MemberInfoUpdateRequestDto;
import com.ssafy.hellotoday.common.util.property.ApplicationProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    private String email;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String stMsg;

    private LocalDateTime withdrawalDate;

    private byte withdrawalFlag;

    private String profileOriginalName;

    private String profilePath;
    private String socialId;
    @Enumerated(EnumType.STRING)
    private Social socialType;

    public Member(Integer memberId) {
        super();
        this.memberId = memberId;
    }
    @Builder
    public Member(String email, String nickname, Role role, String profilePath, String socialId, Social socialType) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.profilePath = profilePath;
        this.socialId = socialId;
        this.socialType = socialType;
    }
    //회원정보 수정
    public void updateMemberInfo(MemberInfoUpdateRequestDto mypageUpdateRequestDto, FileDto fileDto) {
        this.nickname = mypageUpdateRequestDto.getNickname();
        this.stMsg = mypageUpdateRequestDto.getStMsg();
        this.profileOriginalName = fileDto.getFileOriginalName();
        this.profilePath = fileDto.getFilePath();
    }
    public void updateMemberInfo(MemberInfoUpdateRequestDto mypageUpdateRequestDto) {
        this.nickname = mypageUpdateRequestDto.getNickname();
        this.stMsg = mypageUpdateRequestDto.getStMsg();
    }
    public void updateMemberInfo(FileDto fileDto) {
        this.profileOriginalName = fileDto.getFileOriginalName();
        this.profilePath = fileDto.getFilePath();
    }

    //닉네임 수정
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getProfileImagePath() {
        if(profilePath == null) return null;
        else if(profilePath.contains("http://k.kakaocdn.net/")||profilePath.contains("pstatic.net/")) return profilePath;
        return ApplicationProperties.HOST_IMAGE_URL + "profile/" + profileOriginalName;
    }
}
