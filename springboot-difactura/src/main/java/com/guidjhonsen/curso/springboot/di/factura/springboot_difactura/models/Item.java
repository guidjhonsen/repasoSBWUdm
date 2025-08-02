package com.guidjhonsen.curso.springboot.di.factura.springboot_difactura.models;



public class Item {
    private Product product;
    private Integer quality;

    public Item() {
    }
    
    public Item(Product product, Integer quality) {
        this.product = product;
        this.quality = quality;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuality() {
        return quality;
    }
    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    
}
