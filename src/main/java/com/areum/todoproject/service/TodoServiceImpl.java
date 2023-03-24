package com.areum.todoproject.service;

import com.areum.todoproject.dao.TodoMapper;
import com.areum.todoproject.dto.TodoDTO;
import com.areum.todoproject.entity.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoMapper dao;

    @Override
    public void register(TodoVO todoVO) {
    }

    @Override
    public List<TodoVO> getAll() {
        log.info("service 실행");
        return dao.selectAll();
    }

    @Override
    public TodoVO getOne(Long tno) {
        log.info("service 실행");
        return dao.selectOne(tno);
    }

    @Override
    public void remove(Long tno) {

    }

    @Override
    public void modify(TodoVO todoVO) {

    }
}
