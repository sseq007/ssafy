package com.ssafy.hellotoday.common.exception.message;

import lombok.Getter;

@Getter
public enum SearchErrorEnum {
    INVALID_KEY(5000, "key에는 닉네임 또는 태그가 주어져야 합니다."),
    INVALID_WORD_STRING(5001, "word에 값을 입력되지 않았습니다."),
    INVALID_WORD_INT(5002, "태그 기반 검색의 word에는 숫자가 주어져야 합니다.");

    private final int code;
    private final String message;

    SearchErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
