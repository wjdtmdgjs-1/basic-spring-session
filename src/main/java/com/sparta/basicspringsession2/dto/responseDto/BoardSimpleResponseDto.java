package com.sparta.basicspringsession2.dto.responseDto;

import lombok.Getter;

@Getter
public class BoardSimpleResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public BoardSimpleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
