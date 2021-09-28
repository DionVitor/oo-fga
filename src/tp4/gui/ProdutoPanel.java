package tp4.gui;

import javax.swing.*;
import java.awt.*;

public class ProdutoPanel extends JPanel {
    public ProdutoPanel() {
        super(false);

        // Break line
        this.add(Box.createRigidArea(new Dimension(1000, 8)));

        // Title
        JLabel filler = new JLabel("Produto");
        this.add(filler);

        // Break line
        this.add(Box.createRigidArea(new Dimension(1000, 3)));

        // Main TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(950, 480));

        // Tabs
        JPanel createProductPane = new JPanel();
        JPanel editProductPane = new JPanel();
        JPanel listProductsPane = new JPanel();
        Icon icon = new ImageIcon();
        tabbedPane.addTab("Adicionar produto", icon, createProductPane);
        tabbedPane.addTab("Editar produto", icon, editProductPane);
        tabbedPane.addTab("Listar produto", icon, listProductsPane);

        // Create client pane - title
        createProductPane.add(Box.createRigidArea(new Dimension(1000, 10)));
        createProductPane.add(new JLabel("Adicionar produto"));
        createProductPane.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create produto pane - inputs
        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField nameInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(700, 30));
        JLabel priceLabel = new JLabel("Preço:");
        priceLabel.setPreferredSize(new Dimension(100, 30));
        JTextField priceInput = new JTextField();
        priceInput.setPreferredSize(new Dimension(700, 30));
        JLabel descLabel = new JLabel("Descrição:");
        descLabel.setPreferredSize(new Dimension(100, 30));
        JTextField descInput = new JTextField();
        descInput.setPreferredSize(new Dimension(700, 30));
        JLabel inventLabel = new JLabel("Estoque:");
        inventLabel.setPreferredSize(new Dimension(100, 30));
        JTextField inventInput = new JTextField();
        inventInput.setPreferredSize(new Dimension(700, 30));

        createProductPane.add(nameLabel);
        createProductPane.add(nameInput);
        createProductPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        createProductPane.add(priceLabel);
        createProductPane.add(priceInput);
        createProductPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        createProductPane.add(descLabel);
        createProductPane.add(descInput);
        createProductPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        createProductPane.add(inventLabel);
        createProductPane.add(inventInput);

        // Create product pane - button
        createProductPane.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.setPreferredSize(new Dimension(200, 30));
        createProductPane.add(saveButton);

        this.add(tabbedPane);
    }
}
