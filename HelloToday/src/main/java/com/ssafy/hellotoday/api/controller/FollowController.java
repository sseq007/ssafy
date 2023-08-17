package com.ssafy.hellotoday.api.controller;

import com.ssafy.hellotoday.api.dto.follow.request.FollowSaveRequestDto;
import com.ssafy.hellotoday.api.dto.BaseResponseDto;
import com.ssafy.hellotoday.api.dto.follow.response.FollowerPageResponseDto;
import com.ssafy.hellotoday.api.dto.follow.response.FollowingPageResponseDto;
import com.ssafy.hellotoday.api.service.FollowService;
import com.ssafy.hellotoday.jwt.MemberDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Follow", description = "팔로우 관련 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/follow")
public class FollowController {
    private final FollowService followService;

    @Operation(summary = "사용자의 팔로워 목록 조회",
            description = "요청한 회원을 팔로우하고 있는 사용자들을 조회하는 API")
    @GetMapping("/follower")
    public FollowerPageResponseDto getFollowers(@RequestParam int memberId,
                                                @RequestParam(
                                                        required = false,
                                                        defaultValue = "1",
                                                        value = "page") int page,
                                                @RequestParam(required = false,
                                                        defaultValue = "10",
                                                        value = "size") int size) {
        return followService.getFollowers(memberId, page - 1, size);
    }

    @Operation(summary = "사용자의 팔로잉 목록 조회",
            description = "요청한 회원이 팔로우하고 있는 사용자들을 조회하는 API")
    @GetMapping("/following")
    public FollowingPageResponseDto getFollowings(@RequestParam int memberId,
                                                  @RequestParam(
                                                         required = false,
                                                         defaultValue = "1",
                                                         value = "page") int page,
                                                  @RequestParam(required = false,
                                                         defaultValue = "10",
                                                         value = "size") int size) {
        return followService.getFollowings(memberId, page - 1, size);
    }

    @Operation(summary = "팔로우 등록", description = "로그인 한 회원이 팔로우를 신청하는 API")
    @PostMapping
    public BaseResponseDto enrollFollow(@AuthenticationPrincipal MemberDetailsImpl member,
                                        @RequestBody FollowSaveRequestDto followSaveRequestDto) {

        return followService.enrollFollow(member.getUser().getMemberId(), followSaveRequestDto);
    }

    @Operation(summary = "팔로우 취소", description = "팔로우를 취소하는 API")
    @DeleteMapping
    public BaseResponseDto deleteFollow(@AuthenticationPrincipal MemberDetailsImpl member,
                                        @RequestParam(name = "target") int targetId) {

        return followService.deleteFollow(member.getUser().getMemberId(), targetId);
    }

    @Operation(summary = "팔로우 상태 확인", description = "팔로우를 상태를 확인하는 API")
    @GetMapping
    public BaseResponseDto checkFollowStatus(@RequestParam int memberId,
                                             @AuthenticationPrincipal MemberDetailsImpl member) {

        return followService.checkFollowStatus(member.getUser().getMemberId(), memberId);
    }
}
