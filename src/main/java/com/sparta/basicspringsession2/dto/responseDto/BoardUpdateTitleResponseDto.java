package com.sparta.basicspringsession2.dto.responseDto;

import lombok.Getter;

@Getter
public class BoardUpdateTitleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public BoardUpdateTitleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
