package com.guidjhonsen.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidjhonsen.springboot.di.app.springboot_di.models.Product;
import com.guidjhonsen.springboot.di.app.springboot_di.repositories.ProductoRepository;


@Service //Para acceder a la lógica de negocio
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductoRepository repository;//--new ProductRepositoryImpl();

    @Override
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

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
