package com.sparta.basicspringsession2.service;

import com.sparta.basicspringsession2.dto.requestDto.BoardSaveRequestDto;
import com.sparta.basicspringsession2.dto.requestDto.BoardUpdateContentsRequestDto;
import com.sparta.basicspringsession2.dto.requestDto.BoardUpdateRequestDto;
import com.sparta.basicspringsession2.dto.requestDto.BoardUpdateTitleRequestDto;
import com.sparta.basicspringsession2.dto.responseDto.*;
import com.sparta.basicspringsession2.entity.Board;
import com.sparta.basicspringsession2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveResponseDto saveBoard(BoardSaveRequestDto boardSaveRequestDto) {
        Board board = new Board(boardSaveRequestDto.getTitle(),boardSaveRequestDto.getContents());
        Board savedBoard = boardRepository.save(board);
        return new BoardSaveResponseDto(savedBoard.getId(), savedBoard.getTitle(),savedBoard.getContents());
    }

    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardSimpleResponseDto> dto = new ArrayList<>();
        for(Board board : boards){
            dto.add(new BoardSimpleResponseDto(board.getId(), board.getTitle(), board.getContents()));
        }
        return dto;
    }

    public BoardGetResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()->new NullPointerException("보드가 없습니다."));
        return new BoardGetResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    @Transactional
    public BoardUpdateResponseDto updateBoard(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(()->new NullPointerException("보드가 없습니다."));
        board.update(boardUpdateRequestDto.getTitle(),boardUpdateRequestDto.getContents());
        return new BoardUpdateResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

    @Transactional
    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()->new NullPointerException("보드가 없습니다."));
        boardRepository.delete(board);
    }

    @Transactional
    public BoardUpdateTitleResponseDto updateBoardTitle(Long id, BoardUpdateTitleRequestDto boardUpdateTitleRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(()->new NullPointerException("보드가 없습니다."));
        board.updateTitle(boardUpdateTitleRequestDto.getTitle());
        return new BoardUpdateTitleResponseDto(board.getId(), board.getTitle(), board.getContents());
    }
    @Transactional
    public BoardUpdateContentsResponseDto updateBoardContents(Long id, BoardUpdateContentsRequestDto boardUpdateContentsRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(()->new NullPointerException("보드가 없습니다."));
        board.updateContents(boardUpdateContentsRequestDto.getContents());
        return new BoardUpdateContentsResponseDto(board.getId(), board.getTitle(), board.getContents());
    }
}
