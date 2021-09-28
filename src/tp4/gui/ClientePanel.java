package tp4.gui;

import javax.swing.*;
import java.awt.*;


public class ClientePanel extends JPanel {
    public ClientePanel() {
        super(false);

        // Break line
        this.add(Box.createRigidArea(new Dimension(0, 30)));

        // Title
        JLabel filler = new JLabel("Cliente");
        this.add(filler);

        // Break line
        this.add(Box.createRigidArea(new Dimension(0, 30)));

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

        this.add(tabbedPane);
    }
}
