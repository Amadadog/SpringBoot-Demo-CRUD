package com.gao.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gao.domain.Book;
import com.gao.service.BookService;
import com.gao.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService IBookService;

    @GetMapping
    public List<Book> getAll() {
        return IBookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return IBookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return IBookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return IBookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return IBookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return IBookService.getPage(currentPage,pageSize);
    }
}
