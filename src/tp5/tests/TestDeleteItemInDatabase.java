package tp5.tests;

import tp5.domain.Cardapio;
import tp5.domain.Cliente;
import tp5.domain.Produto;
import tp5.domain.Venda;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tp5.gui.ClientePanel;
import tp5.gui.MenuPanel;
import tp5.gui.ProdutoPanel;
import tp5.gui.VendaPanel;


public class TestDeleteItemInDatabase {
    private final ArrayList<Cardapio> arrayMenu;
    private final ArrayList<Cliente> arrayClients;
    private final ArrayList<Venda> arraySales;
    private final ArrayList<Produto> arrayProducts;

    public TestDeleteItemInDatabase() {
        this.arrayMenu = new ArrayList<>();
        this.arrayClients = new ArrayList<>();
        this.arraySales = new ArrayList<>();
        this.arrayProducts = new ArrayList<>();
    }

    @Test
    void testDeleteSaleInDatabase() {
        VendaPanel.registerSale(this.arraySales, "Dion", "Maça", "10");
        VendaPanel.deleteSale(this.arraySales, "Dion", "Maça", "10");
        assertEquals(this.arraySales.toArray().length, 0);
    }

    @Test
    void testDeleteClientInDatabase() {
        ClientePanel.registerClient(this.arrayClients, "Dion", "Gama", "61-923434220", "Cartão");
        ClientePanel.deleteClient(this.arrayClients, "Dion");
        assertEquals(this.arrayClients.toArray().length, 0);
    }

    @Test
    void testDeleteProductInDatabase() {
        ProdutoPanel.registerProduct(this.arrayProducts, "Maça", "4", "Gostosa fruta.", "5");
        ProdutoPanel.deleteProduct(this.arrayProducts, "Maça");
        assertEquals(this.arrayProducts.toArray().length, 0);
    }

    @Test
    void testDeleteMenuInDatabase() {
        MenuPanel.registerMenu(this.arrayMenu, "Frutas");
        MenuPanel.deleteMenu(this.arrayMenu, "Frutas");
        assertEquals(this.arrayMenu.toArray().length, 0);
    }
}
