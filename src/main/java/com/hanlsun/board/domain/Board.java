package com.hanlsun.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String title;
    private String context;
    private LocalDateTime createdTime;







}
