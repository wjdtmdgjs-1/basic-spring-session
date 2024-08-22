package com.sparta.basicspringsession2.dto.requestDto;

import lombok.Getter;

@Getter
public class BoardSaveRequestDto {
    private Long id;
    private String title;
    private String contents;

}
