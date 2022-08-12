package com.gao.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.domain.Book;
import com.gao.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookService bookService;

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据1111");
        book.setName("测试数据1111");
        book.setDescription("测试数据1111");
        bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setType("测试数据1111000");
        book.setName("测试数据1111000");
        book.setDescription("测试数据1111000");
        bookService.update(book);
    }
    @Test
    void testDeleteById(){
        bookService.delete(15);
    }
    @Test
    void testGetById(){
        System.out.println(bookService.getById(3));
    }
    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }
    @Test
    void testGetPage(){
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
//    @Test
//    void testGetBy(){
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name","spring");
//        bookService.selectList(qw);
//    }@Test
//    void testGetBy2(){
//        String name = "1";
//        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        lqw.like(name != null, Book::getName,name);
//        bookService.selectList(lqw);
//    }
}
