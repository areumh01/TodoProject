package com.areum.todoproject.controller;

import com.areum.todoproject.dto.TodoDTO;
import com.areum.todoproject.service.TodoService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("msg", "Hello");
        model.addAttribute("lists", service.getAll());
        //log.info(service.getAll());
    }

    @GetMapping("/view")
    public void view(long tno, Model model){
        model.addAttribute("list", service.getOne(tno));
        log.info(service.getOne(tno));
    }

    @GetMapping("/register")
    public void view_register(){
    }






}
