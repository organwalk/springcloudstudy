package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Resource
    BookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid")Integer bid,
                      HttpServletRequest request){
        System.out.println(request.getHeader("Test"));
        return service.getBookById(bid);
    }
}
