package com.areum.todoproject.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate duedate;
    private String writer;
    private boolean finished;
}
