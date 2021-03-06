package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

