package tp4.gui;

import javax.swing.*;
import java.awt.*;


public class ClientePanel extends JPanel {
    public ClientePanel() {
        super(false);

        // Break line
        this.add(Box.createRigidArea(new Dimension(1000, 8)));

        // Title
        JLabel filler = new JLabel("Cliente");
        this.add(filler);

        // Break line
        this.add(Box.createRigidArea(new Dimension(1000, 3)));

        // Main TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(950, 480));

        // Tabs
        JPanel createClientPane = new JPanel();
        JPanel editClientPane = new JPanel();
        JPanel listClientsPane = new JPanel();
        Icon icon = new ImageIcon();
        tabbedPane.addTab("Adicionar cliente", icon, createClientPane);
        tabbedPane.addTab("Editar cliente", icon, editClientPane);
        tabbedPane.addTab("Listar clientes", icon, listClientsPane);

        // Create client pane - title
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 10)));
        createClientPane.add(new JLabel("Adicionar cliente"));
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Create client pane - inputs
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

        createClientPane.add(nameLabel);
        createClientPane.add(nameInput);
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        createClientPane.add(addressLabel);
        createClientPane.add(addressInput);
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        createClientPane.add(phoneLabel);
        createClientPane.add(phoneInput);
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        createClientPane.add(paymentLabel);
        createClientPane.add(paymentInput);

        // Create client pane - button
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.setPreferredSize(new Dimension(200, 30));
        createClientPane.add(saveButton);

        // Edit client pane - title
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 10)));
        editClientPane.add(new JLabel("Editar cliente"));
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 20)));

        // Edit client pane - dropdown
        JLabel clientLabel = new JLabel("Cliente:");
        clientLabel.setPreferredSize(new Dimension(100, 30));
        editClientPane.add(clientLabel);
        String[] fakeChoices = {"a", "b", "c"};
        JComboBox<String> dropdown = new JComboBox<String>(fakeChoices);
        dropdown.setPreferredSize(new Dimension(700, 30));
        editClientPane.add(dropdown);
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));

        // Edit client pane - inputs
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

        editClientPane.add(nameEditLabel);
        editClientPane.add(nameEditInput);
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        editClientPane.add(addressEditLabel);
        editClientPane.add(addressEditInput);
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        editClientPane.add(phoneEditLabel);
        editClientPane.add(phoneEditInput);
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        editClientPane.add(paymentEditLabel);
        editClientPane.add(paymentEditInput);

        // Edit client pane - button
        editClientPane.add(Box.createRigidArea(new Dimension(1000, 30)));
        JButton editButton = new JButton("Editar");
        editButton.setPreferredSize(new Dimension(200, 30));
        editClientPane.add(editButton);

        // List clients pane - title
        listClientsPane.add(Box.createRigidArea(new Dimension(1000, 10)));
        listClientsPane.add(new JLabel("Listar clientes"));
        listClientsPane.add(Box.createRigidArea(new Dimension(1000, 20)));

        // List clients pane - list
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
        listClientsPane.add(clientsListScroll);

        this.add(tabbedPane);
    }
}
