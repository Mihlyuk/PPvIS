package lab2.View;

import lab2.Controller.Controller;
import lab2.Controller.Parser;
import lab2.Model.MainModel;

import javax.swing.*;

/**
 * Created by Константин on 12.03.2016.
 */
public class MainView {
    public MainView (MainModel theModel, Controller controller, String name) {
        JFrame theView = new JFrame();
        theView.setName(name);
        theView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theView.setResizable(false);


        TablePanel tablePanel = new TablePanel(controller.getTrains());

        Parser fileHandler = new Parser(theModel, tablePanel);

        JDialog addDialog = new AddDialog().create(controller, tablePanel);
        addDialog.setVisible(false);

        JDialog searchDialog = new SearchDialog().create(controller, tablePanel);
        searchDialog.setVisible(false);

        JDialog deleteDialog = new DeleteDialog().create(controller, tablePanel);
        searchDialog.setVisible(false);

        JMenuBar menuBar = new MenuBar().create(addDialog, searchDialog, deleteDialog, fileHandler);
        theView.setJMenuBar(menuBar);

        theView.setVisible(true);
        theView.getContentPane().add(tablePanel);
        theView.setSize(1000, 500);
    }
}
