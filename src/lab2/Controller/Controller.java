package lab2.Controller;

import lab2.Model.*;
import lab2.View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Константин on 12.03.2016.
 */
public class Controller {
    public MainModel theModel;
    public MainView theView;

    public Controller(MainView theView, MainModel theModel) {
        this.theModel = theModel;
        this.theView = theView;

        this.theView.menuBar.addItemSearchListener(new ItemSearchListener());
        this.theView.menuBar.addItemAddListener(new ItemAddListener());
        this.theView.addDialog.addButtonListener(new AddButtonListener());
    }

    class ItemSearchListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            theView.searchDialog.setVisible(true);
        }
    }

    class ItemAddListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            theView.addDialog.setVisible(true);

        }
    }

    class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if ("".equals(theView.addDialog.trainNumber.getText())) {
                JOptionPane.showMessageDialog(theView.addDialog, "Enter the correct train number, please",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Train newTrain = new Train();
            newTrain.number = theView.addDialog.trainNumber.getText();

            newTrain.timeArriving = (Integer) theView.addDialog.timeArriving.getValue();
            newTrain.timeDeparting = (Integer) theView.addDialog.timeDeparting.getValue();

            newTrain.stationArriving = theView.addDialog.stationArriving.getText();
            newTrain.stationDeparting = theView.addDialog.stationDeparting.getText();

            System.out.println(newTrain.timeArriving);

        }
    }
}
