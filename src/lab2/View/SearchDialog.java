package lab2.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchDialog extends JDialog {
    public JTextField trainNumber = new JTextField(20);
    public JSpinner dateArriving = new JSpinner(new SpinnerDateModel());

    public JSpinner timeArriving = new JSpinner();
    public JSpinner timeDeparture = new JSpinner();

    public JTextField stationArriving = new JTextField(20);
    public JTextField stationDeparting = new JTextField(20);

    public JSpinner travelTime = new JSpinner(new SpinnerDateModel());

    public JButton closeButton = new JButton("Close");
    public JButton findButton = new JButton("Find");

    public JTable table;
    SearchDialog(JFrame frame) {
        super(frame, false);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(6, 6, 6, 6));

        Box box1 = Box.createHorizontalBox();
        box1.add(createTrainNumber());
        box1.add(Box.createHorizontalStrut(6));
        box1.add(createDateArriving());

        Box box2 = Box.createHorizontalBox();
        box2.add(createTimeArriving());
        box2.add(Box.createHorizontalStrut(6));
        box2.add(createTimeDeparture());

        table = new JTable(new Object[30][6], new Object[]{"Номер поезда", "Станция отправления",
                "Станция прибытия", "Дата и время отправления", "Дата и время прибытия", "Время в пути"});

        Box buttons = Box.createHorizontalBox();
        buttons.add(Box.createHorizontalGlue());
        buttons.add(findButton);
        buttons.add(Box.createHorizontalStrut(6));
        buttons.add(closeButton);

        mainBox.add(box1);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(box2);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(createStationArrivingDeparting());
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(createTravelTime());
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(new JScrollPane(table));
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(buttons);

        add(mainBox);

        setSize(400,500);
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

        dateArriving.setModel(new SpinnerDateModel());
        dateArriving.setEditor(new JSpinner.DateEditor(dateArriving, "dd MMMM"));

        box.add(dateArriving);
        return box;
    }

    private Box createTimeArriving() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Время отправления"));

        timeArriving.setModel(new SpinnerDateModel());

        timeArriving.setEditor(new JSpinner.DateEditor(timeArriving, "dd MMMM"));

        box.add(timeArriving);
        return box;
    }

    private Box createTimeDeparture() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Время прибытия"));

        timeDeparture.setModel(new SpinnerDateModel());

        timeDeparture.setEditor(new JSpinner.DateEditor(timeDeparture, "dd MMMM"));

        box.add(timeDeparture);
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

    public void addCloseButtonListener(ActionListener listener) {
        closeButton.addActionListener(listener);
    }

    public void addFindButtonListener(ActionListener listener) {
       findButton.addActionListener(listener);
    }
}
