package lab2.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddDialog extends JDialog {
    public JTextField trainNumber = new JTextField(20);

    public JSpinner dateArriving = new JSpinner(new SpinnerDateModel());
    public JSpinner dateDeparting = new JSpinner(new SpinnerDateModel());

    public JTextField stationArriving = new JTextField(20);
    public JTextField stationDeparting = new JTextField(20);

    public JSpinner travelTime = new JSpinner(new SpinnerDateModel());

    public JButton addButton = new JButton("Add");

    AddDialog(JFrame frame) {
        super(frame,false);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(6, 6, 6, 6));

        Box box1 = Box.createHorizontalBox();
        box1.add(createTrainNumber());

        Box box2 = Box.createHorizontalBox();
        box2.add(createDateArriving());
        box2.add(Box.createHorizontalStrut(6));
        box2.add(createDateDeparting());

        Box buttons = Box.createHorizontalBox();
        buttons.add(Box.createHorizontalGlue());
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

        add(mainBox);

        pack();
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

    public void addButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
