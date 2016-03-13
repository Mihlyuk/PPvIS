package lab2.View;

import javax.swing.*;

/**
 * Created by Константин on 12.03.2016.
 */
public class TablePanel {
    public JScrollPane create() {
       JTable table = new JTable(new Object[30][6], new Object[]{"Номер поезда", "Станция отправления",
                "Станция прибытия", "Дата и время отправления", "Дата и вермя прибытия", "Время в пути"});

        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);

        table.setRowSelectionInterval(2,2);
        table.setColumnSelectionInterval(2,2);

        JScrollPane tableScrollPane = new JScrollPane(table);

        return tableScrollPane;
    }
}
