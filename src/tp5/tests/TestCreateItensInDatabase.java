package tp5.tests;

import tp5.domain.Cardapio;
import tp5.domain.Cliente;
import tp5.domain.Produto;
import tp5.domain.Venda;
import tp5.gui.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tp5.repositories.ClientRepository;


public class TestCreateItensInDatabase {
    private final ArrayList<Cardapio> arrayMenu;
    private final ArrayList<Cliente> arrayClients;
    private final ArrayList<Venda> arraySales;
    private final ArrayList<Produto> arrayProducts;

    public TestCreateItensInDatabase() {
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
        ClientRepository repository = new ClientRepository(this.arrayClients);
        repository.registerClient("Dion", "Gama", "61-923434220", "Cartão");
        assertEquals(this.arrayClients.toArray().length, 1);
    }

    @Test
    void testCreateProductInDatabase() {
        ProdutoPanel.registerProduct(this.arrayProducts, "Maça", "4", "Gostosa fruta.", "5");
        assertEquals(this.arrayProducts.toArray().length, 1);
    }

    @Test
    void testCreateMenuInDatabase() {
        MenuPanel.registerMenu(this.arrayMenu, "Frutas");
        assertEquals(this.arrayMenu.toArray().length, 1);
    }
}
