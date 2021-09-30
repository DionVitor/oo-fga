package tp4.gui;

import javax.swing.*;
import java.awt.*;


public class MenuPanel extends JPanel {
    public MenuPanel() {
        super(false);

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


        this.add(tabbedPane);
    }
}