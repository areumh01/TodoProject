package com.areum.todoproject.dao;

import com.areum.todoproject.entity.TodoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    void insert(String title, java.sql.Date dueDate, String writer);
    List<TodoVO> selectAll();
    TodoVO selectOne(Long tno);
    void delete(Long tno);
    void update(TodoVO todoVO);
}
