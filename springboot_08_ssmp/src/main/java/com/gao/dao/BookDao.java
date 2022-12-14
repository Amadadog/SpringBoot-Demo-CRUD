package com.gao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gao.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
