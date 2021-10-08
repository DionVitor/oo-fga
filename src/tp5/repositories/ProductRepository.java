package tp5.repositories;

import tp5.domain.Produto;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Classe de manipulação de dados de produtos
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class ProductRepository {
    private final ArrayList<Produto> products;

    public ProductRepository(ArrayList<Produto> products) {
        this.products = products;
    }

    /**
     * Método para registrar os dados de produto
     *
     * @param name nome do produto
     * @param price preço do produto
     * @param desc descrição do produto
     * @param invent estoque de produto
     */
    public void registerProduct(String name, String price, String desc, String invent) {
        Produto product = new Produto(name, price, desc, invent);
        this.products.add(product);
    }

    /**
     * Método para deletar produto
     *
     * @param name nome do produto
     */
    public void deleteProduct(String name) {
        this.products.removeIf(product -> Objects.equals(product.getNome(), name));
    }

    /**
     * Método para editar os dados de produto
     *
     * @param name nome do produto
     * @param price preço do produto
     * @param desc descrição do produto
     * @param invent estoque do produto
     */
    public void editProduct(String name, String price, String desc, String invent) {
        for (Produto product : this.products) {
            if (Objects.equals(product.getNome(), name)) {
                product.edit(name, price, desc, invent);
            }
        }
    }
}
