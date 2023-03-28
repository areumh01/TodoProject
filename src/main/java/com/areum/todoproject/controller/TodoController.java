package com.areum.todoproject.controller;

import com.areum.todoproject.dto.PageRequestDTO;
import com.areum.todoproject.dto.TodoDTO;
import com.areum.todoproject.service.TodoService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
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
    public void list(@RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value= "field", defaultValue = "title") String field,
                     @RequestParam(value= "keyword", defaultValue = "") String keyword_,
                     @RequestParam(value= "finished", defaultValue = "all") String finished,
                     @RequestParam(value= "startDate", defaultValue = "1111-01-01") String startDate_,
                     @RequestParam(value= "endDate", defaultValue = "9999-12-31") String endDate_,
                     Model model){
        String keyword = "%"+keyword_+"%";
        //java.time.LocalDate startDate = LocalDate.parse(startDate_);
        java.sql.Date startDate = Date.valueOf(startDate_);
        //java.time.LocalDate endDate = LocalDate.parse(endDate_);
        java.sql.Date endDate = Date.valueOf(endDate_);
        log.info(finished);
        PageRequestDTO requestDTO = new PageRequestDTO(page, 10, field, keyword, finished, startDate, endDate);
        log.info(service.getList(requestDTO));
        model.addAttribute("lists", service.getList(requestDTO));
        model.addAttribute("page", page);
        model.addAttribute("field", field);
        model.addAttribute("keyword", keyword_);
        model.addAttribute("finished", finished);
        model.addAttribute("startDate", startDate_);
        model.addAttribute("endDate", endDate_);
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
    public String view_modify(String title, String dueDate, String writer, @RequestParam(value = "done", defaultValue = "0") String done, String tno, Model model){
        if(!done.equals("0")) done = "1";
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
