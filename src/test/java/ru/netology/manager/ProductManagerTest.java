package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    @org.junit.jupiter.api.Test
    public void shouldSaveNewProduct(ProductRepository repository) {
        ProductManager manager = new ProductManager(repository);
        Product first = new Product(1, "smartphone1", 500);

        manager.add(first);

        Product[] expected = {first};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    }

