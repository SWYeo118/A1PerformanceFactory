package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Board")
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/All")
    public String BoardAll(Model model) {
        List<Board> BoardAll = boardRepository.viewAll();
        model.addAttribute("BoardAll", BoardAll);
        return "BoardAll";
    }
}
