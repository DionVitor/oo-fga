package tp5.gui;

import tp4.domain.Cardapio;
import tp4.domain.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class MenuPanel extends JPanel {
    public JPanel menuCheckBoxPanel;

    public MenuPanel(ArrayList<Cardapio> menus, ArrayList<Produto> products) {
        super(false);
        final JComboBox<String> dropdown = new JComboBox<>();
        JPanel menuListPanel = new JPanel();

        // Title
        this.add(Box.createRigidArea(new Dimension(1000, 8)));
        JLabel filler = new JLabel("Cardápio");
        this.add(filler);
        this.add(Box.createRigidArea(new Dimension(1000, 3)));

        // Main TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(950, 480));

        // Tabs
        JPanel createMenuPanel = new JPanel();
        JPanel editMenuPanel = new JPanel();
        JPanel listMenuPanel = new JPanel();
        Icon icon = new ImageIcon();
        tabbedPane.addTab("Adicionar cardápio", icon, createMenuPanel);
        tabbedPane.addTab("Editar cardápio", icon, editMenuPanel);
        tabbedPane.addTab("Listar cardápios", icon, listMenuPanel);

        // Create menu panel - title
        createMenuPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        createMenuPanel.add(new JLabel("Adicionar cardápio"));
        createMenuPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create menu panel - input
        JLabel typeLabel = new JLabel("Tipo:");
        typeLabel.setPreferredSize(new Dimension(100, 30));
        JTextField typeInput = new JTextField();
        typeInput.setPreferredSize(new Dimension(700, 30));

        createMenuPanel.add(typeLabel);
        createMenuPanel.add(typeInput);

        // Create menu panel - checkbox
        ArrayList<String> productsCheckBox = this.getProductNames(products);
        this.menuCheckBoxPanel = new JPanel();
        this.menuCheckBoxPanel.setLayout(new BoxLayout(this.menuCheckBoxPanel, BoxLayout.PAGE_AXIS));
        for (String menuType : productsCheckBox){
            this.menuCheckBoxPanel.add(new JCheckBox("- " + menuType));
            this.menuCheckBoxPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane scrollPane = new JScrollPane(this.menuCheckBoxPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(700, 250));
        createMenuPanel.add(Box.createRigidArea(new Dimension(1000, 20)));
        createMenuPanel.add(scrollPane);

        // Create menu panel - button
        createMenuPanel.add(Box.createRigidArea(new Dimension(1000, 20)));
        JButton createMenuButton = new JButton("Adicionar");
        createMenuButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!Objects.equals(typeInput.getText(), "")) {
                            MenuPanel.registerMenu(
                                    menus,
                                    typeInput.getText()
                            );
                            JOptionPane.showMessageDialog(
                                    null, "Cardápio adicionado: " + typeInput.getText(), null, JOptionPane.INFORMATION_MESSAGE
                            );
                            menuListPanel.add(new JLabel("- " + typeInput.getText()));
                            menuListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                            dropdown.addItem(typeInput.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo tipo nulo!", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
        createMenuButton.setPreferredSize(new Dimension(200, 30));
        createMenuPanel.add(createMenuButton);

        // Edit menu panel - title
        editMenuPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        editMenuPanel.add(new JLabel("Editar cardápio"));
        editMenuPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Edit menu panel - dropdown
        JLabel menuLabel = new JLabel("Cardápio:");
        menuLabel.setPreferredSize(new Dimension(100, 30));
        editMenuPanel.add(menuLabel);
        for (Cardapio menu : menus) {
            dropdown.addItem(menu.getTipo());
        }
        dropdown.setPreferredSize(new Dimension(700, 30));
        editMenuPanel.add(dropdown);
        editMenuPanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Edit menu panel - inputs
        JLabel typeEditLabel = new JLabel("Tipo:");
        typeEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField typeEditInput = new JTextField();
        typeEditInput.setPreferredSize(new Dimension(700, 30));

        editMenuPanel.add(typeEditLabel);
        editMenuPanel.add(typeEditInput);
        editMenuPanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Edit menu panel - buttons
        JButton editButton = new JButton("Editar");
        editButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!Objects.equals(typeEditInput.getText(), "")) {
                            MenuPanel.editMenu(menus, dropdown.getSelectedItem().toString(), typeEditInput.getText());
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Cardápio editado: " + dropdown.getSelectedItem().toString(),
                                    null,
                                    JOptionPane.INFORMATION_MESSAGE
                            );

                            menuListPanel.removeAll();
                            ArrayList<String> menuTypes = getMenuTypes(menus);
                            for (String menuType : menuTypes) {
                                menuListPanel.add(new JLabel("- " + menuType));
                                menuListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                            }
                            dropdown.removeItem(dropdown.getSelectedItem().toString());
                            dropdown.addItem(typeEditInput.getText());
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo tipo nulo!", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
        JButton deleteButton = new JButton("Deletar");
        deleteButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MenuPanel.deleteMenu(menus, dropdown.getSelectedItem().toString());

                        JOptionPane.showMessageDialog(
                                null,
                                "Cardápio deletado: " + dropdown.getSelectedItem().toString(),
                                null,
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        menuListPanel.removeAll();
                        ArrayList<String> menuTypes = getMenuTypes(menus);
                        for (String menuType : menuTypes) {
                            menuListPanel.add(new JLabel("- " + menuType));
                            menuListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                        }

                        dropdown.removeItem(dropdown.getSelectedItem().toString());
                    }
                }
        );
        editButton.setPreferredSize(new Dimension(200, 30));
        deleteButton.setPreferredSize(new Dimension(200, 30));

        editMenuPanel.add(Box.createRigidArea(new Dimension(1000, 180)));
        editMenuPanel.add(editButton);
        editMenuPanel.add(deleteButton);

        // List menu panel - title
        listMenuPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        listMenuPanel.add(new JLabel("Listar clientes"));
        listMenuPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // List menu panel - list
        ArrayList<String> menuTypes = this.getMenuTypes(menus);
        menuListPanel.setLayout(new BoxLayout(menuListPanel, BoxLayout.PAGE_AXIS));
        for (String menuType : menuTypes) {
            menuListPanel.add(new JLabel("- " + menuType));
            menuListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane clientsListScroll = new JScrollPane(menuListPanel);
        clientsListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        clientsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        clientsListScroll.setPreferredSize(new Dimension(800, 350));
        listMenuPanel.add(clientsListScroll);

        this.add(tabbedPane);
    }

    private ArrayList<String> getMenuTypes(ArrayList<Cardapio> menus) {
        ArrayList<String> menuTypes = new ArrayList<>();
        for (Cardapio menu : menus) {
            menuTypes.add(menu.getTipo());
        }
        return menuTypes;
    }

    private ArrayList<String> getProductNames(ArrayList<Produto> products) {
        ArrayList<String> productNames = new ArrayList<>();
        for (Produto product : products) {
            productNames.add(product.getNome());
        }
        return productNames;
    }

    public static void registerMenu(ArrayList<Cardapio> menus, String type) {
        Cardapio menu = new Cardapio(type, new Produto[] {});
        menus.add(menu);
    }

    public static void deleteMenu(ArrayList<Cardapio> menus, String type) {
        menus.removeIf(menu -> Objects.equals(menu.getTipo(), type));
    }
    public static void editMenu(ArrayList<Cardapio> menus, String type, String newType) {
        for (Cardapio menu : menus) {
            if (Objects.equals(menu.getTipo(), type)) {
                menu.edit(newType);
            }
        }
    }
}