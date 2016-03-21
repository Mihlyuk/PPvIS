package lab2.View;

import lab2.Controller.Controller;

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
public class DeleteDialog {
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

    public JDialog create(Controller controller, TablePanel tablePanel) {
        JDialog searchDialog = new JDialog();

        JButton closeButton = new JButton("Close");
        JButton findButton = new JButton("Find");
        JButton removeButton = new JButton("Remove");

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(6, 6, 6, 6));

        Box box1 = Box.createHorizontalBox();
        JCheckBox box1CheckBox = new JCheckBox();
        box1CheckBox.setSelected(true);
        box1CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainNumber.setEnabled(box1CheckBox.isSelected());
                dateArriving.setEnabled(box1CheckBox.isSelected());
            }
        });
        box1.add(box1CheckBox);
        box1.add(createTrainNumber());
        box1.add(Box.createHorizontalStrut(6));
        box1.add(createDateArriving());

        Box box2 = Box.createHorizontalBox();
        JCheckBox box2CheckBox = new JCheckBox();
        box2CheckBox.setSelected(true);
        box2CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeArriving1.setEnabled(box2CheckBox.isSelected());
                timeDeparting1.setEnabled(box2CheckBox.isSelected());
                timeArriving2.setEnabled(box2CheckBox.isSelected());
                timeDeparting2.setEnabled(box2CheckBox.isSelected());
            }
        });
        box2.add(box2CheckBox);
        box2.add(createTimeArriving());
        box2.add(Box.createHorizontalStrut(6));
        box2.add(createTimeDeparture());

        Box box3 = Box.createHorizontalBox();
        JCheckBox box3CheckBox = new JCheckBox();
        box3CheckBox.setSelected(true);
        box3CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stationArriving.setEnabled(box3CheckBox.isSelected());
                stationDeparting.setEnabled(box3CheckBox.isSelected());
            }
        });
        box3.add(box3CheckBox);
        box3.add(createStationArrivingDeparting());

        Box box4 = Box.createHorizontalBox();
        JCheckBox box4CheckBox = new JCheckBox();
        box4CheckBox.setSelected(true);
        box4CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                travelTime.setEnabled(box4CheckBox.isSelected());
            }
        });
        box4.add(box4CheckBox);
        box4.add(createTravelTime());

        table = new TablePanel();

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.removeTrains(table.getTrains());
                tablePanel.updateTable();
            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setTrains(controller.findTrains(trainNumber.getText(), (Date) dateArriving.getValue(),
                        (Date) timeArriving1.getValue(), (Date) timeArriving2.getValue(),
                        (Date) timeDeparting1.getValue(), (Date) timeDeparting2.getValue(), stationArriving.getText(),
                        stationDeparting.getText(), (Date) travelTime.getValue(), box1CheckBox.isSelected(),
                        box2CheckBox.isSelected(), box3CheckBox.isSelected(), box4CheckBox.isSelected()));
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
        buttons.add(removeButton);
        buttons.add(Box.createHorizontalStrut(6));
        buttons.add(findButton);
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

    private boolean checking(JDialog dialog) {
        if (trainNumber.isEnabled() && "".equals(trainNumber.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct train number, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (trainNumber.isEnabled() && "".equals(stationArriving.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct arrival station, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (trainNumber.isEnabled() && "".equals(stationDeparting.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct departure station, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (trainNumber.isEnabled() && "".equals(trainNumber.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct train number, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (trainNumber.isEnabled() && "".equals(stationArriving.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct arrival station, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (trainNumber.isEnabled() && "".equals(stationDeparting.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct departure station, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (trainNumber.isEnabled() && "".equals(trainNumber.getText())) {
            JOptionPane.showMessageDialog(dialog, "Enter the correct train number, please",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
}
