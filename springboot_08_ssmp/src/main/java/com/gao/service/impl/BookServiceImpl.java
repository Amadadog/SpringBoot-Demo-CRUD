package com.gao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.dao.BookDao;
import com.gao.domain.Book;
import com.gao.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(!Strings.isEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(!Strings.isEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(!Strings.isEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage page = new Page(currentPage,pageSize);

        bookDao.selectPage(page,lqw);
        return page;
    }
}
