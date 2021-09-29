package tp4.gui;

import javax.swing.*;
import java.awt.*;


public class ClientePanel extends JPanel {
    public ClientePanel() {
        super(false);

        // Title
        this.add(Box.createRigidArea(new Dimension(1000, 8)));
        JLabel filler = new JLabel("Cliente");
        this.add(filler);
        this.add(Box.createRigidArea(new Dimension(1000, 3)));

        // Main TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(950, 480));

        // Tabs
        JPanel createClientPanel = new JPanel();
        JPanel editClientPanel = new JPanel();
        JPanel listClientsPanel = new JPanel();
        Icon icon = new ImageIcon();
        tabbedPane.addTab("Adicionar cliente", icon, createClientPanel);
        tabbedPane.addTab("Editar cliente", icon, editClientPanel);
        tabbedPane.addTab("Listar clientes", icon, listClientsPanel);

        // Create client panel - title
        createClientPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        createClientPanel.add(new JLabel("Adicionar cliente"));
        createClientPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create client panel - inputs
        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setPreferredSize(new Dimension(100, 30));
        JTextField nameInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(700, 30));
        JLabel addressLabel = new JLabel("Endereço:");
        addressLabel.setPreferredSize(new Dimension(100, 30));
        JTextField addressInput = new JTextField();
        addressInput.setPreferredSize(new Dimension(700, 30));
        JLabel phoneLabel = new JLabel("Telefone:");
        phoneLabel.setPreferredSize(new Dimension(100, 30));
        JTextField phoneInput = new JTextField();
        phoneInput.setPreferredSize(new Dimension(700, 30));
        JLabel paymentLabel = new JLabel("Pagamento:");
        paymentLabel.setPreferredSize(new Dimension(100, 30));
        JTextField paymentInput = new JTextField();
        paymentInput.setPreferredSize(new Dimension(700, 30));

        createClientPanel.add(nameLabel);
        createClientPanel.add(nameInput);
        createClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        createClientPanel.add(addressLabel);
        createClientPanel.add(addressInput);
        createClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        createClientPanel.add(phoneLabel);
        createClientPanel.add(phoneInput);
        createClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        createClientPanel.add(paymentLabel);
        createClientPanel.add(paymentInput);

        // Create client panel - button
        createClientPanel.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.setPreferredSize(new Dimension(200, 30));
        createClientPanel.add(saveButton);

        // Edit client pane - title
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        editClientPanel.add(new JLabel("Editar cliente"));
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Edit client panel - dropdown
        JLabel clientLabel = new JLabel("Cliente:");
        clientLabel.setPreferredSize(new Dimension(100, 30));
        editClientPanel.add(clientLabel);
        String[] fakeChoices = {"a", "b", "c"};
        JComboBox<String> dropdown = new JComboBox<String>(fakeChoices);
        dropdown.setPreferredSize(new Dimension(700, 30));
        editClientPanel.add(dropdown);
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Edit client panel - inputs
        JLabel nameEditLabel = new JLabel("Nome:");
        nameEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField nameEditInput = new JTextField();
        nameEditInput.setPreferredSize(new Dimension(700, 30));
        JLabel addressEditLabel = new JLabel("Endereço:");
        addressEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField addressEditInput = new JTextField();
        addressEditInput.setPreferredSize(new Dimension(700, 30));
        JLabel phoneEditLabel = new JLabel("Telefone:");
        phoneEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField phoneEditInput = new JTextField();
        phoneEditInput.setPreferredSize(new Dimension(700, 30));
        JLabel paymentEditLabel = new JLabel("Pagamento:");
        paymentEditLabel.setPreferredSize(new Dimension(100, 30));
        JTextField paymentEditInput = new JTextField();
        paymentEditInput.setPreferredSize(new Dimension(700, 30));

        editClientPanel.add(nameEditLabel);
        editClientPanel.add(nameEditInput);
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editClientPanel.add(addressEditLabel);
        editClientPanel.add(addressEditInput);
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editClientPanel.add(phoneEditLabel);
        editClientPanel.add(phoneEditInput);
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        editClientPanel.add(paymentEditLabel);
        editClientPanel.add(paymentEditInput);

        // Edit client panel - buttons
        editClientPanel.add(Box.createRigidArea(new Dimension(1000, 30)));
        JButton editButton = new JButton("Editar");
        editButton.setPreferredSize(new Dimension(200, 30));
        JButton deleteButton = new JButton("Deletar");
        deleteButton.setPreferredSize(new Dimension(200, 30));
        editClientPanel.add(editButton);
        editClientPanel.add(deleteButton);

        // List clients panel - title
        listClientsPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        listClientsPanel.add(new JLabel("Listar clientes"));
        listClientsPanel.add(Box.createRigidArea(new Dimension(1000, 20)));

        // List clients panel - list
        String[] fakeClients = {"Dion", "Eurico"};
        JPanel clientsListPanel = new JPanel();
        clientsListPanel.setLayout(new BoxLayout(clientsListPanel, BoxLayout.PAGE_AXIS));
        for (String fakeClient : fakeClients) {
            clientsListPanel.add(new JLabel("- " + fakeClient));
            clientsListPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane clientsListScroll = new JScrollPane(clientsListPanel);
        clientsListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        clientsListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        clientsListScroll.setPreferredSize(new Dimension(800, 350));
        listClientsPanel.add(clientsListScroll);

        this.add(tabbedPane);
    }
}
