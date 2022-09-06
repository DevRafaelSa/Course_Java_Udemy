package util;

import java.util.function.Function;

import entities.Product;

public class UpperCaseName implements Function<Product, String> {

    @Override
    public String apply(Product p) {//recebe um Product e retorna um String
        return p.getName().toUpperCase();
    }
}