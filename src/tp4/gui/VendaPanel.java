package tp4.gui;

import tp4.domain.Cardapio;
import tp4.domain.Produto;
import tp4.domain.Cliente;
import tp4.domain.Venda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class VendaPanel extends JPanel {
    public JComboBox<String> clientDropdown;
    public JComboBox<String> productDropdown;
    public JComboBox<String> clientDropdownEdit;
    public JComboBox<String> productDropdownEdit;

    public VendaPanel(ArrayList<Cliente> clients, ArrayList<Produto> products, ArrayList<Venda> sales) {
        super(false);
        JPanel saleListPanel = new JPanel();

        // Title
        this.add(Box.createRigidArea(new Dimension(1000, 8)));
        JLabel filler = new JLabel("Vendas");
        this.add(filler);
        this.add(Box.createRigidArea(new Dimension(1000, 3)));

        // Main TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(950, 480));

        // Tabs
        JPanel registerSalePanel = new JPanel();
        JPanel editSalePanel = new JPanel();
        JPanel listSalePanel = new JPanel();
        Icon icon = new ImageIcon();
        tabbedPane.addTab("Realizar venda", icon, registerSalePanel);
        tabbedPane.addTab("Editar venda", icon, editSalePanel);
        tabbedPane.addTab("Listar vendas", icon, listSalePanel);

        // Create menu panel - title
        registerSalePanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        registerSalePanel.add(new JLabel("Adicionar venda"));
        registerSalePanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Client dropdown
        this.clientDropdown = new JComboBox<>();
        this.clientDropdownEdit = new JComboBox<>();
        JLabel clientLabel = new JLabel("Cliente:");
        clientLabel.setPreferredSize(new Dimension(100, 30));
        registerSalePanel.add(clientLabel);
        for (Cliente client : clients) {
            this.clientDropdown.addItem(client.getNome());
        }
        this.clientDropdown.setPreferredSize(new Dimension(700, 30));
        registerSalePanel.add(this.clientDropdown);
        registerSalePanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Product dropdown
        this.productDropdown = new JComboBox<>();
        this.productDropdownEdit = new JComboBox<>();
        JLabel productLabel = new JLabel("Produto:");
        productLabel.setPreferredSize(new Dimension(100, 30));
        registerSalePanel.add(productLabel);
        for (Produto product : products) {
            this.productDropdown.addItem(product.getNome());
        }
        this.productDropdown.setPreferredSize(new Dimension(700, 30));
        registerSalePanel.add(this.productDropdown);
        registerSalePanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Create quantity input
        JLabel quantityLabel = new JLabel("Quantidade:");
        quantityLabel.setPreferredSize(new Dimension(100, 30));
        JTextField quantityInput = new JTextField();
        quantityInput.setPreferredSize(new Dimension(700, 30));

        registerSalePanel.add(quantityLabel);
        registerSalePanel.add(quantityInput);

        //Create sale save button
        registerSalePanel.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.addActionListener(
                e -> {
                    VendaPanel.registerSale(
                            sales,
                            clientDropdown.getSelectedItem().toString(),
                            productDropdown.getSelectedItem().toString(),
                            quantityInput.getText()
                    );
                    JOptionPane.showMessageDialog(
                            null,
                            "Venda cadastrada ao cliente: " + clientDropdown.getSelectedItem(),
                            null,
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    saleListPanel.add(new JLabel("Cliente: " + clientDropdown.getSelectedItem().toString() + " - Produto: " + productDropdown.getSelectedItem().toString() + " - Quantidade: " + quantityInput.getText()));
                    saleListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    clientDropdownEdit.addItem(clientDropdown.getSelectedItem().toString() + " - " + productDropdown.getSelectedItem().toString() + " - " + quantityInput.getText());
                }
        );
        registerSalePanel.setPreferredSize(new Dimension(200, 30));
        registerSalePanel.add(saveButton);

        // Edit sales panel
        editSalePanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        editSalePanel.add(new JLabel("Editar quantidade do produto"));
        editSalePanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create dropdown in edit sales panel
        JLabel clientEditLabel = new JLabel("Venda:");
        clientEditLabel.setPreferredSize(new Dimension(100, 30));
        editSalePanel.add(clientEditLabel);
        for (Venda sale : sales) {
            clientDropdownEdit.addItem(sale.getNomeCliente() + " - " +  sale.getNomeProduto() + " - " + sale.getQuantProduto());
        }
        clientDropdownEdit.setPreferredSize(new Dimension(700, 30));
        editSalePanel.add(clientDropdownEdit);
        editSalePanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Edit sale panel - input
        JLabel quantityEditLabel = new JLabel("Quantidade:");
        quantityEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField quantityEditInput = new JTextField();
        quantityEditInput.setPreferredSize(new Dimension(700, 30));

        editSalePanel.add(quantityEditLabel);
        editSalePanel.add(quantityEditInput);

        // Edit sale panel - buttons
        JButton editButton = new JButton("Editar");
        editButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String _data = clientDropdownEdit.getSelectedItem().toString();
                        String[] data = _data.split(" - ");
                        if (!Objects.equals(quantityEditInput.getText(), "")) {
                            editSale(sales, data[0], data[1], quantityEditInput.getText());

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Venda editada: " + _data,
                                    null,
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            clientDropdownEdit.removeItem(clientDropdownEdit.getSelectedItem().toString());
                            clientDropdownEdit.addItem(data[0] + " - " + data[1] + " - " + quantityEditInput.getText());
                            saleListPanel.removeAll();
                            for (Venda sale : sales) {
                                saleListPanel.add(new JLabel("Cliente: " + sale.getNomeCliente() + " - Produto: " + sale.getNomeProduto() + " - Quantidade: " + sale.getQuantProduto()));
                                saleListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo quantidade nulo!", null, JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
        );
        editButton.setPreferredSize(new Dimension(200, 30));
        JButton deleteButton = new JButton("Deletar");
        deleteButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String _data = clientDropdownEdit.getSelectedItem().toString();
                        String[] data = _data.split(" - ");
                        deleteSale(sales, data[0], data[1], data[2]);

                        JOptionPane.showMessageDialog(
                                null,
                                "Venda deletada: " + clientDropdownEdit.getSelectedItem().toString(),
                                null,
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        clientDropdownEdit.removeItem(clientDropdownEdit.getSelectedItem().toString());
                        saleListPanel.removeAll();
                        for (Venda sale : sales) {
                            saleListPanel.add(new JLabel("Cliente: " + sale.getNomeCliente() + " - Produto: " + sale.getNomeProduto() + " - Quantidade: " + sale.getQuantProduto()));
                            saleListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                        }
                    }
                }
        );
        deleteButton.setPreferredSize(new Dimension(200, 30));

        editSalePanel.add(Box.createRigidArea(new Dimension(1000, 200)));
        editSalePanel.add(editButton);
        editSalePanel.add(deleteButton);
        // Title of list sales tab
        listSalePanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        listSalePanel.add(new JLabel("Listar vendas"));
        listSalePanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // List sales
        saleListPanel.setLayout(new BoxLayout(saleListPanel, BoxLayout.PAGE_AXIS));
        for (Venda sale : sales) {
            saleListPanel.add(new JLabel("Cliente: " + sale.getNomeCliente() + " - Produto: " + sale.getNomeProduto() + " - Quantidade: " + sale.getQuantProduto()));
            saleListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane salesListScroll = new JScrollPane(saleListPanel);
        salesListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        salesListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        salesListScroll.setPreferredSize(new Dimension(800, 350));
        listSalePanel.add(salesListScroll);

        this.add(tabbedPane);
    }

    public static void registerSale(ArrayList<Venda> sales, String nameClient, String nameProduct, String quantity) {
        Venda sale = new Venda(nameClient, nameProduct, quantity);
        sales.add(sale);
    }

    public static void deleteSale(ArrayList<Venda> sales, String nameClient, String productName, String quantity) {
        sales.removeIf(sale -> Objects.equals(sale.getNomeCliente(), nameClient) &&
                Objects.equals(sale.getNomeProduto(), productName) &&
                Objects.equals(sale.getQuantProduto(), quantity));
    }

    public static void editSale(ArrayList<Venda> sales, String nameClient, String nameProduct, String quantity) {
        for (Venda sale : sales) {
            if (Objects.equals(sale.getNomeCliente(), nameClient)) {
                sale.edit(nameClient, nameProduct, quantity);
            }
        }
    }
}
