package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    // 더미데이터 추가
    @PostConstruct
    public void init() {
        boardRepository.saveToDB(new Board("운영자", "안녕하세요 운영자입니다", "더미데이터1"));
        boardRepository.saveToDB(new Board("운영자2", "안녕하세요 김영자입니다", "더미데이터2"));
        boardRepository.saveToDB(new Board("운영자3", "안녕하세요 잘자입니다", "더미데이터3"));
        boardRepository.saveToDB(new Board("운영자4", "안녕하세요 유자입니다", "더미데이터4"));
    }

    @GetMapping("{contentNumber}")
    public String BoardOne(@PathVariable("contentNumber") String contentNumber, Model model) {
        Long contentNumberLong = Long.parseLong(contentNumber);
        Board boardOne = boardRepository.findContentByContentNumber(contentNumberLong);
        model.addAttribute("boardOne", boardOne);
        return "BoardOne";
    }

    @GetMapping("/WrittingPage")
    public String WrittingPage(Model model) {
        model.addAttribute("nickName", boardRepository.getBasicNickName());
        model.addAttribute("userIdx", boardRepository.getBasicUserIdx());
        return "WrittingPage";
    }

    @PostMapping("/CreateBoard")
    public String CreateBoard(Board board) {
        boardRepository.saveToDB(board);
        return "BoardAll";
    }

    @GetMapping
    public String BoardAll(Model model) {
        List<Board> BoardAll = boardRepository.viewAll();
        model.addAttribute("BoardAll", BoardAll);
        return "BoardAll";
    }
}
