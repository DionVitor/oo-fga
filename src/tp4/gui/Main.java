package tp4.gui;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Fast Food");
        window.setVisible(true);
        window.setSize(1000, 600);
        window.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        Icon icon = new ImageIcon();

        ProdutoPanel produtoPanel = new ProdutoPanel();
        ClientePanel clientePanel = new ClientePanel();
        MenuPanel menuPanel = new MenuPanel();
        VendaPanel vendaPanel = new VendaPanel();

        tabbedPane.addTab("Produto", icon, produtoPanel);
        tabbedPane.addTab("Cliente", icon, clientePanel);
        tabbedPane.addTab("Cardápio", icon, menuPanel);
        tabbedPane.addTab("Venda", icon, vendaPanel);

        window.add(tabbedPane);
    }
}
