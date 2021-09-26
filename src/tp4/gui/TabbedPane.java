package tp4.gui;

import javax.swing.*;


public class TabbedPane extends JTabbedPane {
    public TabbedPane() {
        Icon icone = new ImageIcon();

        ProdutoPanel produtoPanel = new ProdutoPanel();
        ClientePanel clientePanel = new ClientePanel();
        CardapioPanel cardapioPanel = new CardapioPanel();
        VendaPanel vendaPanel = new VendaPanel();

        this.addTab("Produto", icone, produtoPanel);
        this.addTab("Cliente", icone, clientePanel);
        this.addTab("Cardápio", icone, cardapioPanel);
        this.addTab("Venda", icone, vendaPanel);
    }
}
