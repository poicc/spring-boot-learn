package com.crq.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-04 10:30
 **/
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpSession session) {
        request.setAttribute("a","a");
        request.setAttribute("a","b");
        request.getAttribute("a");
        request.removeAttribute("a");

        session.setAttribute("b","b");
        session.setAttribute("b","a");
        session.getAttribute("b");
        session.invalidate();
        return "hello world ----";
    }
}
