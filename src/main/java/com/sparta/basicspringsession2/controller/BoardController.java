package com.sparta.basicspringsession2.controller;

import com.sparta.basicspringsession2.dto.requestDto.BoardSaveRequestDto;
import com.sparta.basicspringsession2.dto.requestDto.BoardUpdateContentsRequestDto;
import com.sparta.basicspringsession2.dto.requestDto.BoardUpdateRequestDto;
import com.sparta.basicspringsession2.dto.requestDto.BoardUpdateTitleRequestDto;
import com.sparta.basicspringsession2.dto.responseDto.*;
import com.sparta.basicspringsession2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return ResponseEntity.ok(boardService.saveBoard(boardSaveRequestDto));
    }
    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getBoards(){
        return ResponseEntity.ok(boardService.getBoards());
    }
    @GetMapping("/boards/{id}")
    public ResponseEntity<BoardGetResponseDto> getBoard(@PathVariable Long id){
        return ResponseEntity.ok(boardService.getBoard(id));
    }
    @PutMapping("/boards/{id}")
    public ResponseEntity<BoardUpdateResponseDto> updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        return ResponseEntity.ok(boardService.updateBoard(id,boardUpdateRequestDto));
    }
    @DeleteMapping("/boards/{id}")
    public void deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
    }
    @PutMapping("/boards/title/{id}")
    public ResponseEntity<BoardUpdateTitleResponseDto> updateBoardTitle(@PathVariable Long id, @RequestBody BoardUpdateTitleRequestDto boardUpdateTitleRequestDto){
        return ResponseEntity.ok(boardService.updateBoardTitle(id,boardUpdateTitleRequestDto));
    }
    @PutMapping("/boards/contents/{id}")
    public ResponseEntity<BoardUpdateContentsResponseDto> updateBoardContents(@PathVariable Long id, @RequestBody BoardUpdateContentsRequestDto boardUpdateContentsRequestDto){
        return ResponseEntity.ok(boardService.updateBoardContents(id,boardUpdateContentsRequestDto));
    }
}
