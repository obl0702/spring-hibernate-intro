package com.ongbl.springdata.project01.lesson1.repository;

import com.ongbl.springdata.project01.lession1.entities.Product;
import com.ongbl.springdata.project01.lession1.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    /*
    insert into product values (1, 'IWatch', 'From Apple Inc', 400);
    insert into product values (2, 'TV', 'From Samsung Inc', 1000);
    insert into product values (3, 'Washer', 'From LG Inc', 500);
    insert into product values (4, 'Dryer', 'From LG Inc', 1500);
     */

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testInsert(){
        Product product = new Product();
        product.setId(2);
        product.setName("Samsung");
        product.setDesc("Best");
        product.setPrice(100d);

        productRepository.save(product);

        Product findedProduct = productRepository.findById(2).get();
        System.out.println(findedProduct);

        boolean result = productRepository.existsById(2);
        System.out.println(result);

        System.out.println("Total Records: " + productRepository.count());

    }

    @Test
    public void testFindByName(){
        List<Product> products = productRepository.findByName("IWatch");
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindByNameAndDesc(){
        List<Product> products = productRepository.findByNameAndDesc("IWatch", "From App1le Inc");
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindByPriceGreaterThan(){
        List<Product> products = productRepository.findByPriceGreaterThan(999.0);
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindByDescContains(){
        List<Product> products = productRepository.findByDescContains("LG");
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindPriceBetween(){
        List<Product> products = productRepository.findByPriceBetween(400.0,1000.0);
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindByDescLike(){
        List<Product> products = productRepository.findByDescLike("%LG%");
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindByNameIn(){
        List<String> names = new ArrayList<>(Arrays.asList("Washer","IWatch"));

        Pageable paging = PageRequest.of(0,1, Sort.by("id"));

        List<Product> products = productRepository.findByNameIn(paging, names);
        products.stream().forEach(System.out::println);
    }

    @Test
    public void testFindAllPaging(){
        Pageable paging = PageRequest.of(0,2, Sort.by(Sort.Direction.DESC,"price"));
        Page<Product> results = productRepository.findAll(paging);
        results.forEach(System.out::println);
    }

    @Test
    public void testFindAllSorting(){
        List<Product> results = productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        results.forEach(System.out::println);
    }

    @Test
    public void testFindAllSortingMultiCriteriaSingleDirection(){
        List<Product> results = productRepository.findAll(Sort.by(Sort.Direction.DESC, "desc","name"));
        results.forEach(System.out::println);
    }

    @Test
    public void testFindAllSortingMultiCriteriaMultiDirection(){

        Sort.Order or1 = new Sort.Order(Sort.Direction.DESC, "desc");
        Sort.Order or2 = new Sort.Order(Sort.Direction.ASC, "name");
        List<Sort.Order> orders = new ArrayList<>(Arrays.asList(or1,or2));

        List<Product> results = productRepository.findAll(Sort.by(orders));
        results.forEach(System.out::println);
    }

    @Test
    public void testFindAllPagingAndSorting(){
        Sort.Order or1 = new Sort.Order(Sort.Direction.DESC, "desc");
        Sort.Order or2 = new Sort.Order(Sort.Direction.ASC, "name");
        List<Sort.Order> orders = new ArrayList<>(Arrays.asList(or1,or2));

        Pageable paging = PageRequest.of(0,2, Sort.by(orders));
        Page<Product> results = productRepository.findAll(paging);
        results.forEach(System.out::println);
    }

    @Test
    public void testCaching(){
        List<Product> products = productRepository.findByName("IWatch");
        List<Product> products2 = productRepository.findByName("IWatch");
    }
}