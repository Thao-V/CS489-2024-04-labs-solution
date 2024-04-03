package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import javax.sound.midi.SysexMessage;
import java.math.BigDecimal;

public class ProductMgmtApp {
    public static void main(String [] args){
        Product [] products = {
          new Product("1", "Banana", "2024-04-02", 100, new BigDecimal(1.00)),
                new Product("2", "Apple", "2024-04-02", 100, new BigDecimal(2.00)),
                new Product("3", "Orange", "2024-04-02", 100, new BigDecimal(2.00)),
        };
        printProducts(products);
    }
    private static void printProducts(Product[] products){
        printProductsInJSON(products);
        printProductsInXML(products);
        printProductsInCSV(products);
    }
    private static void printProductsInJSON(Product [] products){
        System.out.println("Printed in JSON format");
        System.out.println("[");
        for(Product p: products){
            String line = String.format("\t{\"ProdudctID\": \"%s\", \"price\": \"%,.2f\"},", p.getProductId(), p.getPrice());
            System.out.println(line);
        }
        System.out.println("]");
    }
    private static void printProductsInXML(Product [] products){
        System.out.println("Printed in XML format");
        System.out.println("<?xml version=\"1.0\">");
        System.out.println("<products>");
        for(Product p: products){
            String line = String.format("<product id=\"%s\" price=\"%,.2f\"/>", p.getProductId(), p.getPrice());
            System.out.println(line);
        }
        System.out.println("</products>");
    }
    private static void printProductsInCSV(Product [] products){
        System.out.println("Printed in CSV format");
        for(Product p: products){
            String line = String.format("%s, %,.2f", p.getProductId(), p.getPrice());
            System.out.println(line);
        }
    }
}
