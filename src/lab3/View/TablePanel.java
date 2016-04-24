package lab3.View;

import lab3.Model.Value;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by konstantin on 13.04.16.
 */
public class TablePanel extends JPanel {
    private List<Value> values;
    private JTable table;
    public TablePanel() {
        this.values = new ArrayList<>();
        add(new JScrollPane(makeTable(values)));

    }

    private JTable makeTable(List<Value> values) {
        JTable table = new JTable(new Object[values.size()][2],
                new Object[]{"Number of arrays", "Sorting time(mS)"});
        for (int i = 0; i < values.size(); i++) {
            table.setValueAt(values.get(i).time, i, 0);
            table.setValueAt(values.get(i).countSort, i, 1);
        }
        table.setPreferredSize(new Dimension(150, 600));
        table.setEnabled(false);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        return table;
    }

    public void updateTable() {
        removeAll();
        add(new JScrollPane(makeTable(values)));
        updateUI();
    }

    public void addValue(Value value) {
        this.values.add(value);
        updateTable();
    }
}