package lab2.View;

import javax.swing.*;

public class MainView extends JFrame {
    public AddDialog addDialog = new AddDialog(this);
    public SearchDialog searchDialog = new SearchDialog(this);
    public JScrollPane table = new TablePanel().create();
    public MenuBar menuBar = new MenuBar();

    public MainView(String name) {
        setName(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setJMenuBar(menuBar);
        searchDialog.setVisible(false);
        addDialog.setVisible(false);

        getContentPane().add(table);

        setSize(1000, 500);
    }
}
