package com.company.service;

import com.company.dao.BookDaoImpl;

public class BookService {

    private BookDaoImpl bookDao;

    public BookService (){
        bookDao = new BookDaoImpl();
    }


}
