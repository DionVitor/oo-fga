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
        JPanel createProductPanel = new JPanel();
        JPanel editProductPanel = new JPanel();
        JPanel listProductsPanel = new JPanel();
        Icon icon = new ImageIcon();
        tabbedPane.addTab("Adicionar produto", icon, createProductPanel);
        tabbedPane.addTab("Editar produto", icon, editProductPanel);
        tabbedPane.addTab("Listar produto", icon, listProductsPanel);

        // Create product panel - title
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        createProductPanel.add(new JLabel("Adicionar produto"));
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create product panel - inputs
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

        createProductPanel.add(nameLabel);
        createProductPanel.add(nameInput);
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        createProductPanel.add(priceLabel);
        createProductPanel.add(priceInput);
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        createProductPanel.add(descLabel);
        createProductPanel.add(descInput);
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        createProductPanel.add(inventLabel);
        createProductPanel.add(inventInput);

        // Create product panel - button
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.setPreferredSize(new Dimension(200, 30));
        createProductPanel.add(saveButton);

        this.add(tabbedPane);
    }
}
