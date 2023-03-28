package com.areum.todoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Min(value = 1)
    private int page = 1;

    @Min(value = 10)
    @Max(value = 100)
    private int size = 10;

    private String field;
    private String keyword;
    private String finished;
    private java.sql.Date startDate;
    private java.sql.Date endDate;

    public int getFirstTodo(){
        return (page-1)*10+1;
    }
    public int getLastTodo(){
        return getFirstTodo()+9;
    }
}