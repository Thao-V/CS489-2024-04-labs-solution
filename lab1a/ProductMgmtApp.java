package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product [] products = {
                new Product(1L, "Banana", "2024-04-02", 100, new BigDecimal(1.00)),
                new Product(2L, "Apple", "2024-04-02", 100, new BigDecimal(2.00)),
                new Product(3L, "Orange", "2024-04-02", 100, new BigDecimal(3.00)),
        };
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printProducts(products);
    }

    private static void printProducts(Product[] products) {
        printProductsInJson(products);
        printProductsInXML(products);
        printProductsInCSV(products);
    }

    private static void printProductsInJson(Product[] products) {
        System.out.println("Printed in JSON format");
        System.out.println("[");
        for(Product p: products){
            String line = String.format("\t{\"productId\": \"%d\", \"name\": \"%s\"}", p.getProductId(), p.getName());
            System.out.println(line);
        }
        System.out.println("]");
    }

    private static void printProductsInXML(Product[] products) {
        System.out.println("Printed in XML format");
        System.out.println("<?xml version=\"1.0\">");
        System.out.println("<products>");
        for(Product p: products){
            String line = String.format("\t<product productId=\"%d\" name=\"%s\"/>", p.getProductId(), p.getName());
            System.out.println(line);
        }
        System.out.println("</products>");
    }

    private static void printProductsInCSV(Product[] products) {
        System.out.println("Printed in CSV format");
        for(Product p: products){
            String line = String.format("%d, %s", p.getProductId(), p.getName());
            System.out.println(line);
        }
    }
}