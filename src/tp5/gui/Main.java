package tp5.gui;

import tp5.domain.Cardapio;
import tp5.domain.Cliente;
import tp5.domain.Produto;
import tp5.domain.Venda;
import tp5.gui.*;

import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Fast Food");
        window.setSize(1000, 600);
        window.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        Icon icon = new ImageIcon();

        ArrayList<Cardapio> menus = new ArrayList<>();
        ArrayList<Produto> products = new ArrayList<>();
        ArrayList<Cliente> clients = new ArrayList<>();
        ArrayList<Venda> sales = new ArrayList<>();

        // Data injection
        Produto apple = new Produto("Maça", "10", "Gostoso.", "1");
        products.add(apple);
        Produto banana = new Produto("Banana", "3", "Saboroso.", "10");
        products.add(banana);
        products.add(new Produto("Chiclete", "5", "Sem açúcar.", "100"));
        menus.add(new Cardapio("Frutas", new Produto[] {apple, banana}));
        clients.add(new Cliente("Dion", "Gama", "619329842734", "Cartão"));
        sales.add(new Venda("Dion", "Batata", "4"));

        MenuPanel menuPanel = new MenuPanel(menus, products);
        VendaPanel vendaPanel = new VendaPanel(clients, products, sales);
        ClientePanel clientePanel = new ClientePanel(clients, vendaPanel);
        ProdutoPanel produtoPanel = new ProdutoPanel(products, menuPanel, vendaPanel);
        ProductsFilterPanel productsFilterPanel = new ProductsFilterPanel(products);
        CheaperProductsFilterPanel cheaperProductsFilterPanel = new CheaperProductsFilterPanel(products);

        tabbedPane.addTab("Produto", icon, produtoPanel);
        tabbedPane.addTab("Cliente", icon, clientePanel);
        tabbedPane.addTab("Cardápio", icon, menuPanel);
        tabbedPane.addTab("Venda", icon, vendaPanel);
        tabbedPane.addTab("Produtos mais caros", icon, productsFilterPanel);
        tabbedPane.addTab("Produtos mais baratos", icon, cheaperProductsFilterPanel);
        window.add(tabbedPane);
        window.setVisible(true);
    }
}
