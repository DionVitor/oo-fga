package tp5.repositories;

import tp5.domain.Venda;

import java.util.ArrayList;
import java.util.Objects;


public class SalesRepository {
    private final ArrayList<Venda> sales;

    public SalesRepository(ArrayList<Venda> sales) {
        this.sales = sales;
    }

    public void registerSale(String nameClient, String nameProduct, String quantity) {
        Venda sale = new Venda(nameClient, nameProduct, quantity);
        this.sales.add(sale);
    }

    public void deleteSale(String nameClient, String productName, String quantity) {
        this.sales.removeIf(sale -> Objects.equals(sale.getNomeCliente(), nameClient) &&
                Objects.equals(sale.getNomeProduto(), productName) &&
                Objects.equals(sale.getQuantProduto(), quantity));
    }

    public void editSale(String nameClient, String nameProduct, String quantity) {
        for (Venda sale : this.sales) {
            if (Objects.equals(sale.getNomeCliente(), nameClient)) {
                sale.edit(nameClient, nameProduct, quantity);
            }
        }
    }
}
