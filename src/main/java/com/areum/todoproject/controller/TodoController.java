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
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;
    private final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


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

    @PostMapping("/register")
    public String register(String title, String dueDate, String writer, Model model){
        TodoDTO dto = TodoDTO.builder()
                .title(title)
                .duedate(LocalDate.parse((dueDate),DATETIMEFORMATTER))
                .writer(writer)
                .build();
        service.register(dto);
        return "redirect:/todo/list";
    }

    @PostMapping("modify")
    public String view_modify(String title, String dueDate, String writer,String done,String tno, Model model){
        log.info(tno);
        TodoDTO dto = TodoDTO.builder()
                .tno(Long.valueOf(tno))
                .title(title)
                .duedate(LocalDate.parse((dueDate),DATETIMEFORMATTER))
                .writer(writer)
                .finished(Integer.parseInt(done))
                .build();
        log.info(dto);
        service.modify(dto);
        return "redirect:/todo/list";
    }

    @GetMapping("modify")
    public void modify(long tno, Model model){
        model.addAttribute("list", service.getOne(tno));
    }

    @GetMapping("remove")
    public String delete(long tno){
        service.remove(tno);
        return "redirect:/todo/list";
    }

}
