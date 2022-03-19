package com.crq.boot.orm.controller;

import com.crq.boot.orm.entity.Book;
import com.crq.boot.orm.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 11:25
 **/
@RestController
@RequestMapping(value = "/api/book")
public class BookController {
    @Resource
    BookService bookService;

    @GetMapping("/book/no/query")
    public Page<Book> findBookNoCriteria(@RequestParam Integer page,@RequestParam Integer size) {
        return bookService.findBookNoCriteria(page,size);
    }

    @GetMapping("/book/query")
    public Page<Book> findBookCriteria(@RequestParam Integer page,@RequestParam Integer size,
                                       Integer id,String cover,String name) {
        Book book = Book.builder().id(id).cover(cover).name(name).build();
        return bookService.findBookCriteria(page,size,book);
    }
}
