package com.guidjhonsen.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.guidjhonsen.springboot.di.app.springboot_di.models.Product;


@Primary
//@RequestScope
@SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data=Arrays.asList(
            new Product(1L, "Memora 31", 300L),
            new Product(2L, "Memora cORE I9", 900L),
            new Product(3L, "tECLADO Razer mini", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        
        return data;
    }    

    @Override
    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
