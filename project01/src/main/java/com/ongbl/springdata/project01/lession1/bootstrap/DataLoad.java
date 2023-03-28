package com.ongbl.springdata.project01.lession1.bootstrap;

import com.ongbl.springdata.project01.lession1.entities.Product;
import com.ongbl.springdata.project01.lession1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoad implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        //run();
    }

    public void run(){
        System.out.println("DDD");

        Product product = new Product();
        product.setId(1);
        product.setName("IPhone");
        product.setDesc("Awesome");
        product.setPrice(100d);

        productRepository.save(product);

        Product findedProduct = productRepository.findById(1).get();
        System.out.println(findedProduct);

        findedProduct.setDesc("SSSSSS");
        productRepository.save(findedProduct);
        System.out.println(findedProduct);

        boolean result = productRepository.existsById(1);
        System.out.println("result before delete: " + result);

        productRepository.delete(findedProduct);

        result = productRepository.existsById(1);
        System.out.println("result after delete: " + result);
    }

}
