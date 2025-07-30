package com.guidjhonsen.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.guidjhonsen.springboot.di.app.springboot_di.models.Product;
import com.guidjhonsen.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository=new ProductRepository();

    public List<Product> findAll(){

        return repository.findAll().stream().map(p -> {
            Double  priceTax=p.getPrice() * 1.25d;
            //Product newProd=new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            //p.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}
