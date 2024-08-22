package com.sparta.basicspringsession2.repository;

import com.sparta.basicspringsession2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
