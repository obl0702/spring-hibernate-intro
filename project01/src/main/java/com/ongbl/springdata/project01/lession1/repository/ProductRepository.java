package com.ongbl.springdata.project01.lession1.repository;

import com.ongbl.springdata.project01.lession1.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name, String desc);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double price1, Double price2);

    List<Product> findByDescLike(String desc);

    //List<Product> findByNameIn(List<String> name);

    List<Product> findByNameIn(Pageable pageable, List<String> name);

}
