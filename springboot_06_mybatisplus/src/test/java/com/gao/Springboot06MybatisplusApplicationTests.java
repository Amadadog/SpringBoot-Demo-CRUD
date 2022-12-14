package com.gao;

import com.gao.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06MybatisplusApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(2));
    }
    @Test
    void findAll() {
        System.out.println(bookDao.selectList(null));
    }
}
