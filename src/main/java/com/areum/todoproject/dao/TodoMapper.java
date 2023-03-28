package com.areum.todoproject.dao;

import com.areum.todoproject.dto.PageRequestDTO;
import com.areum.todoproject.entity.TodoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    void insert(String title, java.sql.Date duedate, String writer);
    List<TodoVO> selectAll();
    List<TodoVO> selectList(PageRequestDTO requestDTO);
    TodoVO selectOne(Long tno);
    void delete(Long tno);
    void update(String title, java.sql.Date duedate, String writer, int finished, Long tno);
    int getCount();
}
