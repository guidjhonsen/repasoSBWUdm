package com.guidjhonsen.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;


@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;
    
    @Value("${invoice.description.office}")
    private String descripcion;

    @Autowired
    @Qualifier("default")
    private List <Item> items;



    
    public Invoice() {
        System.out.println("Creando el componente de la factura");
    }

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Pepe"));
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public int getTotal(){

        //int total=0;
        //
        //for (Item item: items){
        //    total += item.getImporte();
        //}

        int total=items.stream()
        .map(item->item.getImporte())
        .reduce(0, (sum, importe)->sum + importe);

        return total;
    }
}
