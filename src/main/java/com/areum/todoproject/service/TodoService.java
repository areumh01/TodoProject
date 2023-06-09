package com.areum.todoproject.service;

import com.areum.todoproject.dto.PageRequestDTO;
import com.areum.todoproject.dto.PageResponseDTO;
import com.areum.todoproject.dto.TodoDTO;
import com.areum.todoproject.entity.TodoVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO);
    TodoDTO getOne(Long tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
}
