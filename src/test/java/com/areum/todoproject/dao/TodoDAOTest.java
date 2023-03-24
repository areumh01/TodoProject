package com.areum.todoproject.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class TodoDAOTest {

    @Autowired
    private TodoMapper dao;

    @Test
    public void test(){
        log.info(dao.selectAll());
    }
}