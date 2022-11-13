package com.hanlsun.board.controller;

import com.hanlsun.board.DTO.WritingDTO;
import com.hanlsun.board.domain.Board;
import com.hanlsun.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("")
    public String home(Model model){

        List<Board> writings = boardRepository.findAll();
        Collections.reverse(writings);
        if(writings.isEmpty()){
            model.addAttribute("writings",null);
        }
        else{
            model.addAttribute("writings",writings);
        }


        return "home";
    }
    @GetMapping("/writing")
    public String createWriting(Model model){
        model.addAttribute("form", new WritingDTO());

        return "create_writing";
    }
    @PostMapping("/writing")
    public String saveWriting(WritingDTO form){
        Board board = new Board(form);
        board.setUserName(form.getUserName());
        board.setTitle(form.getTitle());
        board.setContext(form.getContext());
        board.setCreateDate(LocalDateTime.now());
        boardRepository.save(board);
        return "redirect:";
    }
    @GetMapping("writing/{writingId}")
    public String writingById(@PathVariable("writingId") Long writingId, Model model){
        Optional<Board> writing = boardRepository.findById(writingId);
        model.addAttribute("userName", writing.get().getUserName());
        model.addAttribute("title", writing.get().getTitle());
        model.addAttribute("context", writing.get().getContext());
        model.addAttribute("createDate", writing.get().getCreateDate());
        return "one_writing";
    }
    @GetMapping("writing/update/{writingId}")
    public String updateById(@PathVariable("writingId") Long writingId, Model model){
        Optional<Board> writing = boardRepository.findById(writingId);
        model.addAttribute("id", writing.get().getId());
        model.addAttribute("userName", writing.get().getUserName());
        model.addAttribute("title", writing.get().getTitle());
        model.addAttribute("context", writing.get().getContext());

        model.addAttribute("form",new WritingDTO());

        return "update";
    }
    @PostMapping("writing/update/{writingId}")
    public String updateWriting(@PathVariable("writingId") Long writingId, WritingDTO form){

        Optional<Board> writing = boardRepository.findById(writingId);
        writing.get().setUserName(form.getUserName());
        writing.get().setTitle(form.getTitle());
        writing.get().setContext(form.getContext());

        boardRepository.save(writing.get());

        String pageUrl="redirect:/writing/"+writingId;
        return pageUrl;
    }
    @GetMapping("writing/delete/{writingId}")
    public String deleteWriting(@PathVariable("writingId") Long writingId){

        boardRepository.deleteById(writingId);
        return "redirect:/";
    }

}
