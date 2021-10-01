package tp4.gui;

import tp4.domain.Cardapio;
import tp4.domain.Cliente;
import tp4.domain.Produto;
import tp4.domain.Venda;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Fast Food");
        window.setVisible(true);
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

        tabbedPane.addTab("Produto", icon, produtoPanel);
        tabbedPane.addTab("Cliente", icon, clientePanel);
        tabbedPane.addTab("Cardápio", icon, menuPanel);
        tabbedPane.addTab("Venda", icon, vendaPanel);

        window.add(tabbedPane);
    }
}
