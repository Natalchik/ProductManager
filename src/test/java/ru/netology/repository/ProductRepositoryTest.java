package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @org.junit.jupiter.api.Test
    public void shouldSaveNewItem() {
        Product first = new Product(123, "book 1", 200);
        ProductRepository repository = new ProductRepository();
        repository.save(first);

        Product[] expected = {first};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }


    @org.junit.jupiter.api.Test
    public void shouldFindAll() {
        Product first = new Product(123, "book 1", 200);
        Product second = new Product(124, "Smartphone 1", 10000);
        Product third = new Product(125, "sim1", 300);
        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldRemoveByIdIfSeveral() {
        Product first = new Product(123, "book 1", 200);
        Product second = new Product(124, "Smartphone 1", 10000);
        Product third = new Product(125, "sim1", 300);
        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.removeById(125);
        Product[] expected = {first, second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);


    }

    @org.junit.jupiter.api.Test
    public void shouldRemoveByIdIfTwo() {
        Product first = new Product(123, "book 1", 200);
        Product second = new Product(124, "Smartphone 1", 10000);
        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.removeById(123);
        Product[] expected = {second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);


    }

    @org.junit.jupiter.api.Test
    public void shouldRemoveByIdIfOne() {
        Product first = new Product(123, "book 1", 200);
        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.removeById(123);
        Product[] expected = {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);


    }


    @org.junit.jupiter.api.Test
    public void shouldShowExceptionMessageIfNotFoundId() {
        Product first = new Product(123, "book 1", 200);
        Product second = new Product(124, "Smartphone 1", 10000);
        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(125);
        });
    }
}