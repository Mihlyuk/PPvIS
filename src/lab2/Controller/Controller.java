package lab2.Controller;

import lab2.Model.*;
import lab2.View.MainView;
import lab2.View.TablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        this.theView.addDialog.addButtonListener(new ButtonListener());
        this.theView.searchDialog.addCloseButtonListener(new CloseButtonListener());
        this.theView.searchDialog.addFindButtonListener(new FindButtonListener());
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

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if ("".equals(theView.addDialog.trainNumber.getText())) {
                JOptionPane.showMessageDialog(theView.addDialog, "Enter the correct train number, please",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if ("".equals(theView.addDialog.stationArriving.getText())) {
                JOptionPane.showMessageDialog(theView.addDialog, "Enter the correct arrival station, please",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if ("".equals(theView.addDialog.stationDeparting.getText())) {
                JOptionPane.showMessageDialog(theView.addDialog, "Enter the correct departure station, please",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Train newTrain = new Train();
            newTrain.number = theView.addDialog.trainNumber.getText();

            newTrain.stationArriving = theView.addDialog.stationArriving.getText();
            newTrain.stationDeparting = theView.addDialog.stationDeparting.getText();

            newTrain.dateArriving = (Date) theView.addDialog.dateArriving.getValue();
            newTrain.dateDeparting = (Date) theView.addDialog.dateDeparting.getValue();

            newTrain.travelTime = (Date) theView.addDialog.travelTime.getValue();

            theModel.trains.add(newTrain);

            repaintTable();
        }
    }

    class CloseButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            theView.searchDialog.setVisible(false);
        }
    }

    class FindButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            for (int i = 0; i < theModel.trains.size(); i++) {
              /*  if ((theModel.trains.get(i).number.equals(theView.searchDialog.trainNumber.getText())) &&
                        (theModel.trains.get(i).stationArriving.equals(theView.searchDialog.stationArriving.getText())) &&
                        (theModel.trains.get(i).stationDeparting.equals(theView.searchDialog.stationDeparting.getText())) &&
                        (theModel.trains.get(i).dateArriving == theView.searchDialog.dateArriving.getValue()) &&
                        (theModel.trains.get(i).dateDeparting.equals(theView.searchDialog.getText())) &&
                        (theModel.trains.get(i).number.equals(theView.searchDialog.trainNumber.getText()))) {
                }*/
            }
        }
    }

    public void repaintTable() {
        for (int i = 0; i < theModel.trains.size(); i++) {
            theView.tablePanel.setValueAt(theModel.trains.get(i).number, i, 0);
            theView.tablePanel.setValueAt(theModel.trains.get(i).stationArriving, i, 1);
            theView.tablePanel.setValueAt(theModel.trains.get(i).stationDeparting, i, 2);
            theView.tablePanel.setValueAt(new SimpleDateFormat("dd MMMM HH:mm").format(theModel.trains.get(i).dateArriving),
                    i, 3);
            theView.tablePanel.setValueAt(new SimpleDateFormat("dd MMMM HH:mm").format(theModel.trains.get(i).dateDeparting),
                    i, 4);
            theView.tablePanel.setValueAt(new SimpleDateFormat("HH:mm").format(theModel.trains.get(i).travelTime),
                    i, 5);
        }
    }
}
