package com.sparta.basicspringsession2.dto.responseDto;

import lombok.Getter;

@Getter
public class BoardUpdateContentsResponseDto {

    private final Long id;
    private final String title;
    private final String contents;

    public BoardUpdateContentsResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
