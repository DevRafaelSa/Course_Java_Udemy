package entities;

public class Product {
    private String name;
    private double price;
    private int quantity;

    //o construtor nao tem o tipo de retorno. o "this" significa que esta se referindo aquele proprio objeto
    public Product(String nome, double price, int quantity) {
        this.name = nome;
        this.price = price;
        this.quantity = quantity;
    }

    //sobrecarga eh vc disponibilizar mais de uma versao da mesma operacao
    public Product(String nome, double price) {
        this.name = nome;
        this.price = price;

    }

    public double totalValueInStock() {
        return price * quantity;
    }
    public void addProducts(int quantity) {
        this.quantity += quantity;
    }
    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }
    public String toString() {
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }

}
