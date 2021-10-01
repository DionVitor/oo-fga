package tp4.gui;

import tp4.domain.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ProdutoPanel extends JPanel {

    public ProdutoPanel(ArrayList<Produto> products, MenuPanel menuPanel, VendaPanel vendaPanel) {
        super(false);
        JPanel productsListPanel = new JPanel();
        final JComboBox<String> dropdown = new JComboBox<>();

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

        // Create title at product panel
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        createProductPanel.add(new JLabel("Adicionar produto"));
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create inputs at product panel
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

        // Create button at product panel
        createProductPanel.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");

        saveButton.addActionListener(
                e -> {
                    if (!Objects.equals(nameInput.getText(), "")) {
                        ProdutoPanel.registerProduct(
                                products,
                                nameInput.getText(),
                                priceInput.getText(),
                                descInput.getText(),
                                inventInput.getText()
                        );
                        JOptionPane.showMessageDialog(
                                null,
                                "Produto adicionado: " + nameInput.getText(),
                                null,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        productsListPanel.add(new JLabel("- " + nameInput.getText()));
                        productsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                        dropdown.addItem(nameInput.getText());
                        vendaPanel.productDropdown.addItem(nameInput.getText());
                        vendaPanel.productDropdownEdit.addItem(nameInput.getText());

                        menuPanel.menuCheckBoxPanel.add(new JCheckBox("- " + nameInput.getText()));
                        menuPanel.menuCheckBoxPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Campo nome nulo",
                                null,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        saveButton.setPreferredSize(new Dimension(200, 30));
        createProductPanel.add(saveButton);

        // Add tittle at "Editar produto" tab
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        editProductPanel.add(new JLabel("Editar produto"));
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Add dropdown at "Editar produto" tab
        JLabel productLabel = new JLabel("Produto:");
        productLabel.setPreferredSize(new Dimension(100, 30));
        editProductPanel.add(productLabel);

        for (Produto product : products) {
            dropdown.addItem(product.getNome());
        }

        dropdown.setPreferredSize(new Dimension(700, 30));
        editProductPanel.add(dropdown);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Add inputs at "Editar produto" tab
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

        editProductPanel.add(priceEditLabel);
        editProductPanel.add(priceEditInput);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editProductPanel.add(descEditLabel);
        editProductPanel.add(descEditInput);
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editProductPanel.add(inventEditLabel);
        editProductPanel.add(inventEditInput);

        // Add buttons at "Editar produto" tab
        editProductPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        JButton editButton = new JButton("Editar");

        editButton.addActionListener(
                e -> {
                    ProdutoPanel.editProduct(
                            products,
                            Objects.requireNonNull(dropdown.getSelectedItem()).toString(),
                            priceEditInput.getText(),
                            descEditInput.getText(),
                            inventEditInput.getText()
                    );
                    JOptionPane.showMessageDialog(
                            null,
                            "Produto editado: " + dropdown.getSelectedItem().toString(),
                            null,
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
        );

        editButton.setPreferredSize(new Dimension(200, 30));
        JButton deleteButton = new JButton("Deletar");

        deleteButton.addActionListener(
                e -> {
                    ProdutoPanel.deleteProduct(products,
                            Objects.requireNonNull(dropdown.getSelectedItem()).toString());

                    JOptionPane.showMessageDialog(
                            null,
                            "Produto deletado: " + dropdown.getSelectedItem().toString(),
                            null,
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    productsListPanel.removeAll();
                    ArrayList<String> productsNames = getProductsInfo(products);
                    for (String productName : productsNames) {
                        productsListPanel.add(new JLabel("- " + productName));
                        productsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    }

                    vendaPanel.productDropdown.removeItem(dropdown.getSelectedItem().toString());
                    dropdown.removeItem(dropdown.getSelectedItem().toString());
                    vendaPanel.productDropdownEdit.removeItem(nameInput.getText().toString());

                    menuPanel.menuCheckBoxPanel.removeAll();
                    for (Produto product : products) {
                        menuPanel.menuCheckBoxPanel.add(new JCheckBox("- " + product.getNome()));
                        menuPanel.menuCheckBoxPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    }
                }
        );

        deleteButton.setPreferredSize(new Dimension(200, 30));
        editProductPanel.add(editButton);
        editProductPanel.add(deleteButton);

        // Add title at "Listar produto" tab
        listProductsPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        listProductsPanel.add(new JLabel("Listar produtos"));
        listProductsPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Add listing at "Listar produto" tab
        ArrayList<String> productsNames = this.getProductsInfo(products);
        productsListPanel.setLayout(new BoxLayout(productsListPanel, BoxLayout.PAGE_AXIS));
        for (String productName : productsNames) {
            productsListPanel.add(new JLabel("- " + productName));
            productsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane productsListScroll = new JScrollPane(productsListPanel);
        productsListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        productsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        productsListScroll.setPreferredSize(new Dimension(800, 350));
        listProductsPanel.add(productsListScroll);

        this.add(tabbedPane);
    }

    private ArrayList<String> getProductsInfo(ArrayList<Produto> products) {
        ArrayList<String> productsNames = new ArrayList<>();
        for (Produto product : products) {
            productsNames.add(product.getNome());
        }
        return productsNames;
    }

    public static void registerProduct(ArrayList<Produto> products, String name, String price, String desc, String invent) {
        Produto product = new Produto(name, price, desc, invent);
        products.add(product);
    }

    public static void deleteProduct(ArrayList<Produto> products, String name) {
        products.removeIf(product -> Objects.equals(product.getNome(), name));
    }

    public static void editProduct(ArrayList<Produto> products, String name, String price, String desc, String invent) {
        for (Produto product : products) {
            if (Objects.equals(product.getNome(), name)) {
                product.edit(name, price, desc, invent);
            }
        }
    }
}
