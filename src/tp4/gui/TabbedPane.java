package tp4.gui;

import javax.swing.*;


public class TabbedPane extends JTabbedPane {
    public TabbedPane() {
        Icon icon = new ImageIcon();

        ProdutoPanel produtoPanel = new ProdutoPanel();
        ClientePanel clientePanel = new ClientePanel();
        MenuPanel menuPanel = new MenuPanel();
        VendaPanel vendaPanel = new VendaPanel();

        this.addTab("Produto", icon, produtoPanel);
        this.addTab("Cliente", icon, clientePanel);
        this.addTab("Cardápio", icon, menuPanel);
        this.addTab("Venda", icon, vendaPanel);
    }
}
