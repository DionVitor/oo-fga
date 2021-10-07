package tp5.tests;

import tp5.domain.Cardapio;
import tp5.domain.Cliente;
import tp5.domain.Produto;
import tp5.domain.Venda;
import tp5.gui.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestCreateItemInDatabase {
    private ArrayList<Cardapio> arrayMenu;
    private ArrayList<Cliente> arrayClients;
    private ArrayList<Venda> arraySales;
    private ArrayList<Produto> arrayProducts;

    public TestCreateItemInDatabase() {
        this.arrayMenu = new ArrayList<>();
        this.arrayClients = new ArrayList<>();
        this.arraySales = new ArrayList<>();
        this.arrayProducts = new ArrayList<>();
    }

    @Test
    void testCreateSaleInDatabase() {
        VendaPanel.registerSale(this.arraySales, "Dion", "Maça", "10");
        assertEquals(this.arraySales.toArray().length, 1);
    }

    @Test
    void testCreateClientInDatabase() {
        ClientePanel.registerClient(this.arrayClients, "Dion", "Gama", "61-923434220", "Cartão");
        assertEquals(this.arrayClients.toArray().length, 1);
    }

    @Test
    void testCreateProductInDatabase() {
        ProdutoPanel.registerProduct(this.arrayProducts, "Maça", "4", "Gostosa fruta.", "5");
        assertEquals(this.arrayProducts.toArray().length, 1);
    }

    @Test
    void testCreateMenuInDatabase() {
        MenuPanel.registerMenu(this.arrayMenu, "Maça");
        assertEquals(this.arrayMenu.toArray().length, 1);
    }
}
