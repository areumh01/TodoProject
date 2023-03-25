package com.areum.todoproject.service;

import com.areum.todoproject.dao.TodoMapper;
import com.areum.todoproject.dto.TodoDTO;
import com.areum.todoproject.entity.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoMapper dao;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        java.sql.Date sqldueDate = java.sql.Date.valueOf(todoDTO.getDuedate());
        dao.insert(todoDTO.getTitle(), sqldueDate, todoDTO.getWriter());
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoVO> voList = dao.selectAll();
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO vo = dao.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }

    @Override
    public void remove(Long tno) {
        log.info("service실행");
        dao.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        log.info(todoDTO.getTitle());
        log.info(todoDTO.getDuedate());
        log.info(todoDTO.getWriter());
        log.info(todoDTO.getFinished());
        log.info(todoDTO.getTno());
        java.sql.Date sqldueDate = java.sql.Date.valueOf(todoDTO.getDuedate());
        dao.update(todoDTO.getTitle(), sqldueDate, todoDTO.getWriter(), todoDTO.getFinished(), todoDTO.getTno());
    }
}
