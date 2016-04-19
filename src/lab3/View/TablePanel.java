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

    public TablePanel(List<Value> values) {
        this.values = values;
        add(new JScrollPane(makeTable(values)));
    }

    public TablePanel() {
        this.values = new ArrayList<>();
        add(new JScrollPane(makeTable(values)));
    }
    //asdasdads
    private JTable makeTable(List<Value> values) {
        JTable table = new JTable(new Object[values.size()][2], new Object[]{"The number of elements", "sorting"});
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
        updateUI();
        add(new JScrollPane(makeTable(values)));
        revalidate();
        repaint();
    }

    public void setValues(List<Value> values) {
        this.values = values;
        updateTable();
    }
}