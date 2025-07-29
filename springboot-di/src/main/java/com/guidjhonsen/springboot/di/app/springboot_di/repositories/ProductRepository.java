package com.guidjhonsen.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.guidjhonsen.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository() {
        this.data=Arrays.asList(
            new Product(1L, "Memora 31", 300L),
            new Product(2L, "Memora cORE I9", 900L),
            new Product(3L, "tECLADO Razer mini", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return data;
    }    

    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
