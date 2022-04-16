package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    @org.junit.jupiter.api.Test
    public void shouldSaveNewProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product first = new Product(1, "smartphone1", 500);
        Product second = new Product(2, "book1", 100);
        Product third = new Product(3, "book2", 200);
        Product forth = new Product(4, "iPhone", 1000);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);

        Product[] expected = {first, second, third, forth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldSearchByNameBook2() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "book1", 500, "author1");
        Smartphone smartphone1 = new Smartphone(2, "smartphone1", 1000, "China");
        Book book2 = new Book(3, "book2", 200, "author2");
        Smartphone smartphone2 = new Smartphone(4, "iPhone", 10000, "USA");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.searchBy("book2");

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldSearchBySmartphone1() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "book1", 500, "author1");
        Smartphone smartphone1 = new Smartphone(2, "smartphone1", 1000, "China");
        Book book2 = new Book(3, "book2", 200, "author2");
        Smartphone smartphone2 = new Smartphone(4, "iPhone", 10000, "USA");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.searchBy("smartphone1");


        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("smartphone1");

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldSearchByBook1() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "book1", 500, "author1");
        Smartphone smartphone1 = new Smartphone(2, "smartphone1", 1000, "China");
        Book book2 = new Book(3, "book2", 200, "author2");
        Smartphone smartphone2 = new Smartphone(4, "iPhone", 10000, "USA");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.searchBy("book1");
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("book1");
        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldSearchBySmartphone2() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "book1", 500, "author1");
        Smartphone smartphone1 = new Smartphone(2, "smartphone1", 1000, "China");
        Book book2 = new Book(3, "book2", 200, "author2");
        Smartphone iPhone = new Smartphone(4, "iPhone", 10000, "USA");

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(iPhone);

        manager.searchBy("iPhone");


        Product[] expected = {iPhone};
        Product[] actual = manager.searchBy("iPhone");

        assertArrayEquals(expected, actual);
    }
}





