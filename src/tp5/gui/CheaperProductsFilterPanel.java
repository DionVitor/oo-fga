package tp5.gui;

import tp5.domain.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;


/**
 * Classe de filtro de produtos mais baratos
 *
 * @author Dion Vitor e Eurico Abreu
 * @version 1.0
 */
public class CheaperProductsFilterPanel extends JPanel {
    public CheaperProductsFilterPanel(ArrayList<Produto> products) {
        super(false);

        // List
        products.sort(new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                if (Objects.equals(o1.getPreco(), o2.getPreco())) {
                    return 0;
                }
                return Integer.parseInt(o1.getPreco()) < Integer.parseInt(o2.getPreco()) ? -1 : 1;
            }
        });
        JPanel productsListPanel = new JPanel();
        productsListPanel.setLayout(new BoxLayout(productsListPanel, BoxLayout.PAGE_AXIS));
        for (Produto product : products) {
            productsListPanel.add(new JLabel("- " + product.getNome() + " - " + product.getPreco() + " reais"));
            productsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane productsListScroll = new JScrollPane(productsListPanel);

        // Title
        this.add(Box.createRigidArea(new Dimension(1000, 8)));
        JLabel filler = new JLabel("Produtos mais caros");
        this.add(filler);
        this.add(Box.createRigidArea(new Dimension(1000, 10)));

        // Refresh button
        JButton refreshButton = new JButton("Atualizar");
        refreshButton.addActionListener(
                e -> {
                    Component[] componentList = getComponents();
                    for (Component c : componentList) {
                        if (c instanceof JScrollPane) {
                            remove(c);
                        }
                    }

                    products.sort(new Comparator<Produto>() {
                        @Override
                        public int compare(Produto o1, Produto o2) {
                            if (Objects.equals(o1.getPreco(), o2.getPreco())) {
                                return 0;
                            }
                            return Integer.parseInt(o1.getPreco()) < Integer.parseInt(o2.getPreco()) ? -1 : 1;
                        }
                    });

                    JPanel _productsListPanel = new JPanel();
                    _productsListPanel.setLayout(new BoxLayout(_productsListPanel, BoxLayout.PAGE_AXIS));
                    for (Produto product : products) {
                        _productsListPanel.add(new JLabel("- " + product.getNome() + " - " + product.getPreco() + " reais"));
                        _productsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    }
                    JScrollPane _productsListScroll = new JScrollPane(_productsListPanel);
                    _productsListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    _productsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    _productsListScroll.setPreferredSize(new Dimension(800, 350));
                    this.add(_productsListScroll);

                    revalidate();
                    repaint();
                }
        );
        refreshButton.setPreferredSize(new Dimension(200, 30));
        this.add(Box.createRigidArea(new Dimension(1000, 40)));
        this.add(refreshButton);

        productsListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        productsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        productsListScroll.setPreferredSize(new Dimension(800, 350));
        this.add(productsListScroll);
    }
}
