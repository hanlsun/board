package com.hanlsun.board.domain;

import com.hanlsun.board.DTO.WritingDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Board {


    public Board(WritingDTO form) {
        id = form.getId();
        title = form.getTitle();
        context = form.getContext();

    }

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String userName;

    private String title;

    private String context;

    private LocalDateTime createDate;

}
