package tp5.repositories;

import tp5.domain.Venda;

import java.util.ArrayList;
import java.util.Objects;


/**
 * Classe de manipulação de dados de vendas
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class SalesRepository {
    private final ArrayList<Venda> sales;

    public SalesRepository(ArrayList<Venda> sales) {
        this.sales = sales;
    }

    /**
     * Método para salvar uma venda
     *
     * @param nameClient nome do cliente
     * @param nameProduct nome do produto
     * @param quantity quantidade de produtos vendidos
     */
    public void registerSale(String nameClient, String nameProduct, String quantity) {
        Venda sale = new Venda(nameClient, nameProduct, quantity);
        this.sales.add(sale);
    }

    /**
     * Método para deletar uma venda
     *
     * @param nameClient nome do cliente
     * @param productName nome do produto
     * @param quantity quantidade de produtos vendidos
     */
    public void deleteSale(String nameClient, String productName, String quantity) {
        this.sales.removeIf(sale -> Objects.equals(sale.getNomeCliente(), nameClient) &&
                Objects.equals(sale.getNomeProduto(), productName) &&
                Objects.equals(sale.getQuantProduto(), quantity));
    }

    /**
     * Método para editar os dados de uma venda
     *
     * @param nameClient nome do cliente
     * @param nameProduct nome do produto
     * @param quantity quantidade de produtos vendidos
     */
    public void editSale(String nameClient, String nameProduct, String quantity) {
        for (Venda sale : this.sales) {
            if (Objects.equals(sale.getNomeCliente(), nameClient)) {
                sale.edit(nameClient, nameProduct, quantity);
            }
        }
    }
}
