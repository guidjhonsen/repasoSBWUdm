package com.guidjhonsen.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.guidjhonsen.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.guidjhonsen.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding="UTF-8")
public class AppConfig {

    @Bean("default")
    List<Item> itemsInvoice(){
        Product p1=new Product("Cámara Sony",800);
        Product p2=new Product("Bicicleta de los Huanca",1800);
        
        List<Item> items= Arrays.asList(new Item(p1, 2), new Item(p2, 4));
        
        return items;
    }

    @Bean
    //@Primary
    List<Item> itemsInvoiceOffice(){
        Product p1= new Product("Monitor Asus 51",700);
        Product p2= new Product("Impresora",2800);
        Product p3= new Product("Escritorio de oficina",900);
        Product p4= new Product("Notebook Razer",1800);
        
        List<Item> items= Arrays.asList(new Item(p1, 2), new Item(p2, 4), new Item(p3, 1), new Item(p4, 3));
        
        return items;
    }
}
