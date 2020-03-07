package com.numanstc.caching;

import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
    @Override
    public Book getByIsbn(String isbn) {

        simulateSlowService();
        return new Book(isbn, "Some Book");
    }
//    Kasten yavaşlatıyoruz
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }

    }
}