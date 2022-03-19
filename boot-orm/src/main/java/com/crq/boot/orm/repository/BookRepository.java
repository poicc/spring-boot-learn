package com.crq.boot.orm.repository;

import com.crq.boot.orm.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 11:11
 **/
public interface BookRepository extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
}
