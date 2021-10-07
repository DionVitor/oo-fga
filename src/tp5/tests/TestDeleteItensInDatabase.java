package tp5.tests;

import tp5.domain.Cardapio;
import tp5.domain.Cliente;
import tp5.domain.Produto;
import tp5.domain.Venda;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tp5.gui.MenuPanel;
import tp5.gui.ProdutoPanel;
import tp5.gui.VendaPanel;
import tp5.repositories.ClientRepository;
import tp5.repositories.ProductRepository;


public class TestDeleteItensInDatabase {
    private final ArrayList<Cardapio> arrayMenu;
    private final ArrayList<Cliente> arrayClients;
    private final ArrayList<Venda> arraySales;
    private final ArrayList<Produto> arrayProducts;

    public TestDeleteItensInDatabase() {
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
        ClientRepository repository = new ClientRepository(this.arrayClients);

        repository.registerClient("Dion", "Gama", "61-923434220", "Cartão");
        repository.deleteClient("Dion");
        assertEquals(this.arrayClients.toArray().length, 0);
    }

    @Test
    void testDeleteProductInDatabase() {
        ProductRepository repository = new ProductRepository(this.arrayProducts);
        repository.registerProduct("Maça", "4", "Gostosa fruta.", "5");
        repository.deleteProduct("Maça");
        assertEquals(this.arrayProducts.toArray().length, 0);
    }

    @Test
    void testDeleteMenuInDatabase() {
        MenuPanel.registerMenu(this.arrayMenu, "Frutas");
        MenuPanel.deleteMenu(this.arrayMenu, "Frutas");
        assertEquals(this.arrayMenu.toArray().length, 0);
    }
}
