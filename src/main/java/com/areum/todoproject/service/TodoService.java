package com.areum.todoproject.service;

import com.areum.todoproject.dto.TodoDTO;
import com.areum.todoproject.entity.TodoVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    void register(TodoVO todoVO);
    List<TodoVO> getAll();
    TodoVO getOne(Long tno);
    void remove(Long tno);
    void modify(TodoVO todoVO);
}
