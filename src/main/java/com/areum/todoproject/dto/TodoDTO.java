package com.areum.todoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate duedate;
    private String writer;
    private boolean finished;
}
