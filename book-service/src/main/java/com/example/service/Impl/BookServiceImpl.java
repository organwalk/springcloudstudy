package com.example.service.Impl;

import com.example.entity.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(Integer bid) {
        return bookMapper.getBookById(bid);
    }
}
