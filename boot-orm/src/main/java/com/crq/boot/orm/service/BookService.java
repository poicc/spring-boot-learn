package com.crq.boot.orm.service;

import com.crq.boot.orm.entity.Book;
import org.springframework.data.domain.Page;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 11:12
 **/
public interface BookService {
    /**
     * 不带条件查询
     * @param page page
     * @param size size
     * @return Page<Book>
     */
    Page<Book> findBookNoCriteria(Integer page,Integer size);

    /**
     * 带条件查询
     * @param page page
     * @param size size
     * @param book book
     * @return page
     */
    Page<Book> findBookCriteria(Integer page,Integer size,Book book);
}
