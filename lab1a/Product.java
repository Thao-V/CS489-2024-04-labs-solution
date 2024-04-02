package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.math.BigDecimal;

public class Product {
    private Long productId;
    private String name;
    private String dateSupplied;
    private Integer quantityInStock;
    private BigDecimal price;

    public Product(){}

    public Product(Long productId, String name, String dateSupplied, Integer quantityInStock, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }

    public Product(Long productId, String name, String dateSupplied) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(String dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
