package model.services;

import java.util.List;
import java.util.function.Predicate;

import model.entities.Product;

public class ProductService {

    public double filteredSum(List<Product> list, Predicate<Product> criteria) {
        double sum = 0.0;//inicia uma variavel
        for (Product p : list) {//percorrer a lista
            if (criteria.test(p)) {
                sum += p.getPrice();
            }
        }
        return sum;
    }
}