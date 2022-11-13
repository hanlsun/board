package com.hanlsun.board.controller;

import com.hanlsun.board.DTO.WritingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("")
    public String home(Model model){
        return "home";
    }
    @GetMapping("/writing")
    public String createWriting(Model model){
        model.addAttribute("form", new WritingDTO());

        return "create_writing";
    }
}
