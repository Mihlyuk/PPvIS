package lab2.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SearchDialog extends JDialog {
    public JTextField trainNumber = new JTextField(20);
    public JSpinner dateArriving = new JSpinner();
    public JSpinner timeArriving = new JSpinner();
    public JSpinner timeDeparture = new JSpinner();

    public JButton closeButton = new JButton("Close");
    public JButton nextButton = new JButton("Next");
    public JButton prevButton = new JButton("Prev");

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

        Box buttons = Box.createHorizontalBox();
        buttons.add(Box.createHorizontalGlue());
        buttons.add(prevButton);
        buttons.add(Box.createHorizontalStrut(6));
        buttons.add(nextButton);
        buttons.add(Box.createHorizontalStrut(6));
        buttons.add(closeButton);

        mainBox.add(box1);
        mainBox.add(Box.createRigidArea(new Dimension(12, 12)));
        mainBox.add(box2);
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
}
