package com.areum.todoproject.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PageResponseDTO<E> {
    //requestDTO에서 받아올 값
    private int page;
    private int size;
    private int total;

    //블록 시작과 끝
    private int start;
    private int end;

    //마지막 페이지
    private int last;

    //이전 다음 페이지 존재 여부
    private boolean prev;
    private boolean next;

    private List<E> dtoList;

    @Builder
    public PageResponseDTO(PageRequestDTO requestDTO, List<E> dtoList, int total){
        this.page = requestDTO.getPage();
        this.size = requestDTO.getSize();
        this.total = total;

        this.start = page-(page%10)+1;
        this.end = start+9;

        this.last = (int)Math.ceil(total/(double)size);

        this.prev = this.page>=1;
        this.next = this.page<=last;

        this.dtoList = dtoList;
    }
}
