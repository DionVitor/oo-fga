package tp5.repositories;

import tp5.domain.Produto;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRepository {
    private final ArrayList<Produto> products;

    public ProductRepository(ArrayList<Produto> products) {
        this.products = products;
    }

    public void registerProduct(String name, String price, String desc, String invent) {
        Produto product = new Produto(name, price, desc, invent);
        this.products.add(product);
    }

    public void deleteProduct(String name) {
        this.products.removeIf(product -> Objects.equals(product.getNome(), name));
    }

    public void editProduct(String name, String price, String desc, String invent) {
        for (Produto product : this.products) {
            if (Objects.equals(product.getNome(), name)) {
                product.edit(name, price, desc, invent);
            }
        }
    }
}
