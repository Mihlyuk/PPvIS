package lab2.View;

import lab2.Controller.Controller;
import lab2.Model.Train;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Константин on 12.03.2016.
 */
public class AddDialog {
    private JTextField trainNumber = new JTextField(20);
    private JSpinner dateArriving = new JSpinner(new SpinnerDateModel());
    private JSpinner dateDeparting = new JSpinner(new SpinnerDateModel());
    private JTextField stationArriving = new JTextField(20);
    private JTextField stationDeparting = new JTextField(20);
    private JSpinner travelTime = new JSpinner(new SpinnerDateModel());

    Controller controller;

    public JDialog create(Controller controller, TablePanel tablePanel) {
        this.controller = controller;
        JDialog addDialog = new JDialog();

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(6, 6, 6, 6));

        Box box1 = Box.createHorizontalBox();
        box1.add(createTrainNumber());

        Box box2 = Box.createHorizontalBox();
        box2.add(createDateArriving());
        box2.add(Box.createHorizontalStrut(6));
        box2.add(createDateDeparting());

        Box buttons = Box.createHorizontalBox();
        JButton addButton = new JButton("Add");
        buttons.add(Box.createHorizontalGlue());
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               if (checking(addDialog))
                controller.addTrain(new Train(trainNumber.getText(),
                                              stationArriving.getText(),
                                              stationDeparting.getText(),
                                              (Date) dateArriving.getValue(),
                                              (Date) dateDeparting.getValue(),
                                              (Date) travelTime.getValue()));
                tablePanel.updateTable();
            }
        });
        buttons.add(addButton);

        mainBox.add(createTrainNumber());
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(box2);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(createStationArrivingDeparting());
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(createTravelTime());
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(buttons);

        addDialog.add(mainBox);

        addDialog.pack();
        return addDialog;
    }

    private Box createTrainNumber() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Номер поезда"));

        box.add(trainNumber);
        return box;
    }

    private Box createDateArriving() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Дата и время отправления"));

        dateArriving.setEditor(new JSpinner.DateEditor(dateArriving, "dd MMMM HH:mm"));

        box.add(dateArriving);
        return box;
    }

    private Box createDateDeparting() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Дата и время прибытия"));

        dateDeparting.setEditor(new JSpinner.DateEditor(dateDeparting, "dd MMMM HH:mm"));

        box.add(dateDeparting);
        return box;
    }

    private Box createStationArrivingDeparting() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Станция"));

        box.add(new JLabel("Отправления"));
        box.add(Box.createHorizontalStrut(3));
        box.add(stationArriving);
        box.add(Box.createHorizontalStrut(6));
        box.add(new JLabel("Прибытия"));
        box.add(Box.createHorizontalStrut(3));
        box.add(stationDeparting);
        return box;
    }

    private Box createTravelTime() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Время в пути"));

        travelTime.setEditor(new JSpinner.DateEditor(travelTime, "HH:mm"));

        box.add(travelTime);

        return box;
    }

    private boolean checking(JDialog addDialog) {
        if ("".equals(trainNumber.getText())) {
            JOptionPane.showMessageDialog(addDialog, "Enter the correct train number, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if ("".equals(stationArriving.getText())) {
            JOptionPane.showMessageDialog(addDialog, "Enter the correct arrival station, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if ("".equals(stationDeparting.getText())) {
            JOptionPane.showMessageDialog(addDialog, "Enter the correct departure station, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}
