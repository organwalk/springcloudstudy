package com.example.service.impl;

import com.example.client.BookClient;
import com.example.client.UserClient;
import com.example.entity.Book;
import com.example.entity.User;
import com.example.entity.Borrow;
import com.example.entity.UserBorrowDetail;
import com.example.mapper.BorrowMapper;
import com.example.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper mapper;
    @Resource
    UserClient userClient;
    @Resource
    BookClient bookClient;
    @Override
    public UserBorrowDetail getUserBoorowDetailByUid(Integer uid) {
        List<Borrow> borrow = mapper.getBorrowByUid(uid);

        User user = userClient.findUserById(uid);
        List<Book> bookList = borrow
                .stream()
                .map(b->bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);
    }
}
