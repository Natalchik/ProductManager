package ru.netology.domain;

import ru.netology.domain.Product;

import java.util.Objects;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
}
