package com.gao.controller;


import com.gao.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private MyDataSource dataSource;
    @GetMapping
    public String getById(){
        System.out.println("boot is running...");
        System.out.println(dataSource.toString());
        return "boot is running...";
    }
}
