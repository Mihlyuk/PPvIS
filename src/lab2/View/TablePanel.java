package lab2.View;


import lab2.Model.Train;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Константин on 12.03.2016.
 */
public class TablePanel extends JPanel {
    private List<Train> trains;
    private int currentPage = 1;
    private int countTrainsOnPage = 10;

    public TablePanel(List<Train> trains) {
        this.trains = trains;
        setLayout(new BorderLayout());
        add(new JScrollPane(makeTable(trains)));
        add(makeToolBar(), BorderLayout.SOUTH);
    }

    public TablePanel() {
        this.trains = new ArrayList<>();
        setLayout(new BorderLayout());
        add(new JScrollPane(makeTable(trains)));
        add(makeToolBar(), BorderLayout.SOUTH);
    }

    private JTable makeTable(List<Train> trains) {
        JTable table = new JTable(new Object[countTrainsOnPage][6], new Object[]{"Номер поезда", "Станция отправления",
                "Станция прибытия", "Дата и время отправления", "Дата и время прибытия", "Время в пути"});

        table.setEnabled(false);
        int firstTrainOnPage = countTrainsOnPage * (currentPage - 1);
            for (int x = 0, train = firstTrainOnPage; x < countTrainsOnPage && train < trains.size(); x++, train++) {
                table.setValueAt(trains.get(train).number, x, 0);
                table.setValueAt(trains.get(train).stationArriving, x, 1);
                table.setValueAt(trains.get(train).stationDeparting, x, 2);
                table.setValueAt(new SimpleDateFormat("dd MMMM HH:mm").format(trains.get(train).dateArriving),
                        x, 3);
                table.setValueAt(new SimpleDateFormat("dd MMMM HH:mm").format(trains.get(train).dateDeparting),
                        x, 4);
                table.setValueAt(new SimpleDateFormat("HH:mm").format(trains.get(train).travelTime),
                        x, 5);
            }
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        return table;
    }

    private JPanel makeToolBar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        String statusBar = "Страница " + currentPage + "/" + getNumberMaxPage();
        panel.add(new JLabel(statusBar));
        JButton firstButton = new JButton("First");
        panel.add(firstButton);
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage = 1;
                    updateTable();
                }
            }
        });
    JButton prevButton = new JButton("Prev");
        panel.add(prevButton);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updateTable();
                }
            }
        });
        JButton nextButton = new JButton("Next");
        panel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trains.size() > countTrainsOnPage * (currentPage - 1) + countTrainsOnPage) {
                    currentPage++;
                    updateTable();
                }
            }
        });
        JButton lastButton = new JButton("Last");
        panel.add(lastButton);
        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage != getNumberMaxPage()) {
                    currentPage = getNumberMaxPage();
                    updateTable();
                }
            }
        });

        JLabel label = new JLabel(" Поездов на странице: ");
        panel.add(label);
        String[] sizeStudent = {"10", "20", "30", "50", "100"};
        JComboBox<String> sizeBox = new JComboBox<String>(sizeStudent);
        sizeBox.setSelectedIndex(Arrays.asList(sizeStudent).indexOf(Integer.toString(countTrainsOnPage)));
        sizeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String change = (String) sizeBox.getSelectedItem();
                if (countTrainsOnPage != Integer.parseInt(change)) {
                    countTrainsOnPage = Integer.parseInt(change);
                    updateTable();
                }
            }
        });
        panel.add(sizeBox);
        return panel;
    }

    private int getNumberMaxPage() {
        return ((trains.size() - 1) / countTrainsOnPage) + 1;
    }

    public void updateTable() {
        removeAll();
        updateUI();
        add(new JScrollPane(makeTable(trains)));
        add(makeToolBar(), BorderLayout.SOUTH);
        revalidate();
        repaint();
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public void addTrains(List<Train> trains) {
        for (Train train: trains) {
            this.trains.add(train);
        }
    }

    public List<Train> getTrains() {
        return trains;
    }
}
