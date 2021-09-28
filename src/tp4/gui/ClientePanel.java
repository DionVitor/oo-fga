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

        // Create cliente pane - inputs
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

        // Create cliente pane - button
        createClientPane.add(Box.createRigidArea(new Dimension(1000, 80)));
        JButton saveButton = new JButton("Adicionar");
        saveButton.setPreferredSize(new Dimension(200, 30));
        createClientPane.add(saveButton);

        this.add(tabbedPane);
    }
}
