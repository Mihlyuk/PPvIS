package lab2.View;

import lab2.Controller.*;
import lab2.Model.Train;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by Константин on 12.03.2016.
 */
public class SearchDialog {
    private JTextField trainNumber = new JTextField(20);
    private JSpinner dateArriving = new JSpinner(new SpinnerDateModel());
    private JSpinner timeArriving1 = new JSpinner();
    private JSpinner timeArriving2 = new JSpinner();
    private JSpinner timeDeparting1 = new JSpinner();
    private JSpinner timeDeparting2 = new JSpinner();
    private JTextField stationArriving = new JTextField(20);
    private JTextField stationDeparting = new JTextField(20);
    private JSpinner travelTime = new JSpinner(new SpinnerDateModel());

    public TablePanel table;

    public JDialog create(List<Train> modelTrains) {
        JDialog searchDialog = new JDialog();

        JButton closeButton = new JButton("Close");
        JButton searchButton = new JButton("Find");
        List<JRadioButton> listRadio = new ArrayList<>();
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(6, 6, 6, 6));

        Box box1 = Box.createHorizontalBox();
        JRadioButton box1Radio = new JRadioButton();
        box1Radio.setSelected(true);
        listRadio.add(box1Radio);
        box1.add(box1Radio);
        box1.add(createTrainNumber());
        box1.add(Box.createHorizontalStrut(6));
        box1.add(createDateArriving());

        Box box2 = Box.createHorizontalBox();
        JRadioButton box2Radio = new JRadioButton();
        listRadio.add(box2Radio);
        box2.add(box2Radio);
        box2.add(createTimeArriving());
        box2.add(Box.createHorizontalStrut(6));
        box2.add(createTimeDeparture());

        Box box3 = Box.createHorizontalBox();
        JRadioButton box3Radio = new JRadioButton();
        listRadio.add(box3Radio);
        box3.add(box3Radio);
        box3.add(createStationArrivingDeparting());

        Box box4 = Box.createHorizontalBox();
        JRadioButton box4Radio = new JRadioButton();
        listRadio.add(box4Radio);
        box4.add(box4Radio);
        box4.add(createTravelTime());

        table = new TablePanel();

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(box1Radio);
        radioButtons.add(box2Radio);
        radioButtons.add(box3Radio);
        radioButtons.add(box4Radio);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Searching searching = new Searching(modelTrains);
                for (JRadioButton radio : listRadio) {
                    if (radio.isSelected()) {
                        searching.setAlgorithm(getAlgorithm(listRadio.indexOf(radio)));
                        break;
                    }
                }
                table.setTrains(searching.search(getTrain1(),getTrain2()));

                table.updateTable();

            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDialog.setVisible(false);
            }
        });

        Box buttons = Box.createHorizontalBox();
        buttons.add(Box.createHorizontalGlue());
        buttons.add(searchButton);
        buttons.add(Box.createHorizontalStrut(6));
        buttons.add(closeButton);

        mainBox.add(box1);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(box2);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(box3);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(box4);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(table);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(buttons);

        searchDialog.add(mainBox);

        searchDialog.setSize(500,500);
        return searchDialog;
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
        timeArriving1.setModel(new SpinnerDateModel());
        timeArriving1.setEditor(new JSpinner.DateEditor(timeArriving1, "HH:mm"));
        timeArriving2.setModel(new SpinnerDateModel());
        timeArriving2.setEditor(new JSpinner.DateEditor(timeArriving2, "HH:mm"));

        box.add(new JLabel("С "));
        box.add(Box.createHorizontalStrut(3));
        box.add(timeArriving1);
        box.add(Box.createHorizontalStrut(3));
        box.add(new JLabel("По "));
        box.add(Box.createHorizontalStrut(6));
        box.add(timeArriving2);

        return box;
    }

    private Box createTimeDeparture() {
        Box box = Box.createHorizontalBox();
        box.setBorder(new TitledBorder("Время прибытия"));
        timeDeparting1.setModel(new SpinnerDateModel());
        timeDeparting1.setEditor(new JSpinner.DateEditor(timeDeparting1, "HH:mm"));
        timeDeparting2.setModel(new SpinnerDateModel());
        timeDeparting2.setEditor(new JSpinner.DateEditor(timeDeparting2, "HH:mm"));

        box.add(new JLabel("С "));
        box.add(Box.createHorizontalStrut(3));
        box.add(timeDeparting1);
        box.add(Box.createHorizontalStrut(3));
        box.add(new JLabel("По "));
        box.add(Box.createHorizontalStrut(6));
        box.add(timeDeparting2);
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

    private Algorithm getAlgorithm(int number) {
        Algorithm algorithm = new Box1Algorithm();
        switch (number) {
            case 0: {
                algorithm = new Box1Algorithm();
                break;
            }
            case 1: {
                algorithm = new Box2Algorithm();
                break;
            }
            case 2: {
                algorithm = new Box3Algorithm();
                break;
            }
            case 3: {
                algorithm = new Box4Alogrithm();
                break;
            }
        }
        return algorithm;
    }

    private Train getTrain1() {
        String stringArriving1 = new SimpleDateFormat("EEE MMM dd ", Locale.ENGLISH).format((Date) dateArriving.getValue()) +
                new SimpleDateFormat("HH:mm:ss z yyyy", Locale.ENGLISH).format((Date) timeArriving1.getValue());

        Date timeArriving = new Date();
        try {
            timeArriving = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(stringArriving1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Train train = new Train(trainNumber.getText(), stationArriving.getText(), stationDeparting.getText(),
                timeArriving, (Date) timeDeparting1.getValue(), (Date) travelTime.getValue());
        return train;
    }

    private Train getTrain2() {
        Train train = new Train(trainNumber.getText(), stationArriving.getText(), stationDeparting.getText(),
                (Date) timeArriving2.getValue(), (Date) timeDeparting2.getValue(), (Date) travelTime.getValue());
        return train;
    }
}
