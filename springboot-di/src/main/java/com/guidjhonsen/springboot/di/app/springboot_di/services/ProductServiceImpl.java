package com.guidjhonsen.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.guidjhonsen.springboot.di.app.springboot_di.models.Product;
import com.guidjhonsen.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service //Para acceder a la lógica de negocio
public class ProductServiceImpl implements ProductService {

   // @Autowired
    private ProductRepository repository;//--new ProductRepositoryImpl();

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){

        return repository.findAll().stream().map(p -> {
            Double  priceTax=p.getPrice() * 1.25d;
            //Product newProd=new Product(p.getId(), p.getName(), priceTax.longValue());
            //Product newProd = (Product) p.clone();
            //newProd.setPrice(priceTax.longValue());
            //return newProd;
            p.setPrice(priceTax.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}
