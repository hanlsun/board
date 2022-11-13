package com.hanlsun.board.repository;

import com.hanlsun.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {


    Optional<Board> findById(Long id);



}
