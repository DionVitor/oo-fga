package tp4.gui;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Fast Food");
        window.setVisible(true);
        window.setSize(1000, 600);
        window.setLocationRelativeTo(null);

        TabbedPane tabbedPane = new TabbedPane();
        window.add(tabbedPane);
    }
}
