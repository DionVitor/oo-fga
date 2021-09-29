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

        // "Adicionar produto" tab add title
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        createProductPanel.add(new JLabel("Adicionar produto"));
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // "Adicionar produto" tab add inputs
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

        // "Adicionar produto" tab add button
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.setPreferredSize(new Dimension(200, 30));
        createProductPanel.add(saveButton);

        // "Editar produto" tab add title
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        editProductPanel.add(new JLabel("Editar produto"));
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // "Editar produto" tab add dropdown
        JLabel productLabel = new JLabel("Produto:");
        productLabel.setPreferredSize(new Dimension(100, 30));
        editProductPanel.add(productLabel);
        String[] testProducts = {"Hambúrguer", "Batata frita", "Coca-Cola"};
        JComboBox<String> dropdown = new JComboBox<String>(testProducts);
        dropdown.setPreferredSize(new Dimension(700, 30));
        editProductPanel.add(dropdown);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // "Editar produto" tab add inputs
        JLabel nameEditLabel = new JLabel("Nome:");
        nameEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField nameEditInput = new JTextField();
        nameEditInput.setPreferredSize(new Dimension(700, 30));
        JLabel priceEditLabel = new JLabel("Preço:");
        priceEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField priceEditInput = new JTextField();
        priceEditInput.setPreferredSize(new Dimension(700, 30));
        JLabel descEditLabel = new JLabel("Descrição:");
        descEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField descEditInput = new JTextField();
        descEditInput.setPreferredSize(new Dimension(700, 30));
        JLabel inventEditLabel = new JLabel("Estoque:");
        inventEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField inventEditInput = new JTextField();
        inventEditInput.setPreferredSize(new Dimension(700, 30));

        editProductPanel.add(nameEditLabel);
        editProductPanel.add(nameEditInput);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editProductPanel.add(priceEditLabel);
        editProductPanel.add(priceEditInput);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editProductPanel.add(descEditLabel);
        editProductPanel.add(descEditInput);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editProductPanel.add(inventEditLabel);
        editProductPanel.add(inventEditInput);

        // "Editar produto" tab add buttons
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        JButton editButton = new JButton("Editar");
        editButton.setPreferredSize(new Dimension(200, 30));
        JButton deleteButton = new JButton("Deletar");
        deleteButton.setPreferredSize(new Dimension(200, 30));
        editProductPanel.add(editButton);
        editProductPanel.add(deleteButton);

        // "Listar produto" tab add title
        listProductsPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        listProductsPanel.add(new JLabel("Listar produtos"));
        listProductsPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // "Listar produto" tab add list
        JPanel productsListPanel = new JPanel();
        productsListPanel.setLayout(new BoxLayout(productsListPanel, BoxLayout.PAGE_AXIS));
        for (String testProduct : testProducts) {
            productsListPanel.add(new JLabel("- " + testProduct));
            productsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane productsListScroll = new JScrollPane(productsListPanel);
        productsListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        productsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        productsListScroll.setPreferredSize(new Dimension(800, 350));
        listProductsPanel.add(productsListScroll);

        this.add(tabbedPane);
    }
}
