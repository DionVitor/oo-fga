package tp4.gui;


public class Main {
    public static void main(String[] args) {
        View janela = new View("Fast Food");

        TabbedPane tabbedPane = new TabbedPane();
        janela.add(tabbedPane);
    }
}
