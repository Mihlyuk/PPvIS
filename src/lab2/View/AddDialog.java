package lab2.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddDialog extends JDialog {
    public JTextField trainNumber = new JTextField(20);
    public JSpinner dateArriving = new JSpinner(new SpinnerDateModel());
    public JSpinner timeArriving = new JSpinner(new SpinnerNumberModel(0,0,24,1));
    public JSpinner timeDeparting = new JSpinner(new SpinnerNumberModel(24,0,24,1));
    public JTextField stationArriving = new JTextField(20);
    public JTextField stationDeparting = new JTextField(20);

    public JButton addButton = new JButton("Add");


    AddDialog(JFrame frame) {
        super(frame,false);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(6, 6, 6, 6));

        Box box1 = Box.createHorizontalBox();
        box1.add(createTrainNumber());
        box1.add(Box.createHorizontalStrut(6));
        box1.add(createDateArriving());

        Box buttons = Box.createHorizontalBox();
        buttons.add(Box.createHorizontalGlue());
        buttons.add(addButton);

        mainBox.add(box1);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(createTimeArrivingDeparting());
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(createStationArrivingDeparting());
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
        box.setBorder(new TitledBorder("Дата отправления"));

        dateArriving.setEditor(new JSpinner.DateEditor(dateArriving, "dd MMMM"));

        box.add(dateArriving);
        return box;
    }

    private Box createTimeArrivingDeparting() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Время отправления"));

        JLabel from = new JLabel("От");
        JLabel till = new JLabel("До");

        box.add(from);
        box.add(Box.createHorizontalStrut(3));
        box.add(timeArriving);
        box.add(Box.createHorizontalStrut(6));
        box.add(till);
        box.add(Box.createHorizontalStrut(3));
        box.add(timeDeparting);
        return box;
    }

    private Box createStationArrivingDeparting() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Станция"));

        JLabel from = new JLabel("Отправления");
        JLabel till = new JLabel("Прибытия");

        box.add(from);
        box.add(Box.createHorizontalStrut(3));
        box.add(stationArriving);
        box.add(Box.createHorizontalStrut(6));
        box.add(till);
        box.add(Box.createHorizontalStrut(3));
        box.add(stationDeparting);
        return box;
    }

    public void addButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
