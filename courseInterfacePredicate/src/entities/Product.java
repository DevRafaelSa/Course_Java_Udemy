package entities;

public class Product {

    private String name;
    private Double price;

    public Product() {
    }

    //metodo estático trabalha com o argumento que eu passar, enquanto que o nao estatico trabalha
    // com o metodo da instancia, por isso n tem argumento.
    public static boolean staticProductPredicate(Product p) {
        return p.getPrice() >= 100.0;
    }

    //metodo estático trabalha com o argumento que eu passar, enquanto que o nao estatico trabalha
    // com o metodo da instancia, por isso n tem argumento e eu preciso passar o atributo dessa classe
    public boolean nonStaticProductPredicate() {
        return price >= 100.0;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }
}