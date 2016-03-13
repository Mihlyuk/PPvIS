package lab2.View;

import javax.swing.*;

/**
 * Created by Константин on 12.03.2016.
 */
public class TablePanel extends JTable {
    public TablePanel() {
        super(new Object[100][6], new Object[]{"Номер поезда", "Станция отправления",
                "Станция прибытия", "Дата и время отправления", "Дата и время прибытия", "Время в пути"});
        setColumnSelectionAllowed(true);
        setRowSelectionAllowed(true);
        setRowSelectionInterval(2,2);
        setColumnSelectionInterval(2,2);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
