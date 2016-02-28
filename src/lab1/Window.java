package lab1;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Window {

    public JFrame createFrame(String name) {
        JFrame frame = new JFrame();
        frame.setName(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 3, 12, 12));

        mainPanel.add(getPanel1());
        mainPanel.add(getPanel2());
        mainPanel.add(getPanel3());
        mainPanel.add(getPanel4());
        mainPanel.add(getPanel5());

        frame.setContentPane(mainPanel);
        frame.setSize(850, 500);
        return frame;
    }

    private Box getPanel1() {
        ArrayList<String> comboBoxItems = new ArrayList();
        JComboBox<String> menu = new JComboBox();
        JTextField textField = new JTextField("Enter the text");
        JLabel addButton = new StarLabel().createStarLabel("Add");
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (String item : comboBoxItems) {
                    if (item.equals(textField.getText())) {
                        JOptionPane.showMessageDialog(null, "The element already exists", "Information",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                comboBoxItems.add(textField.getText());
                menu.addItem(textField.getText());
            }
        });

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(textField);
        horizontalBox.add(Box.createHorizontalStrut(6));
        horizontalBox.add(addButton);

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(6, 6, 6, 6)));
        box.add(menu);
        box.add(Box.createVerticalGlue());
        box.add(horizontalBox);

        return box;
    }

    private Box getPanel2() {
        JTextField textField = new JTextField("Enter the text");
        JLabel renameButton = new StarLabel().createStarLabel("Rename button");
        JLabel exchangeButton = new StarLabel().createStarLabel("Exchange");
        exchangeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String tempButton = exchangeButton.getText();
                exchangeButton.setText(renameButton.getText());
                renameButton.setText(tempButton);
            }
        });
        renameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exchangeButton.setText(textField.getText());
            }
        });

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(renameButton);
        horizontalBox.add(Box.createHorizontalGlue());
        horizontalBox.add(exchangeButton);

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(Box.createHorizontalStrut(6));
        box.add(horizontalBox);
        box.add(Box.createHorizontalStrut(6));

        return box;
    }

    private Box getPanel3() {
        JTextField textField = new JTextField("Enter the text");
        JLabel choiceButton = new StarLabel().createStarLabel("Choice button");
        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("2");
        JRadioButton radioButton3 = new JRadioButton("3");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        choiceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (radioButton1.getText().equals(textField.getText())) {
                    radioButton1.setSelected(true);
                    return;
                }
                if (radioButton2.getText().equals(textField.getText())) {
                    radioButton2.setSelected(true);
                    return;
                }
                if (radioButton3.getText().equals(textField.getText())) {
                    radioButton3.setSelected(true);
                    return;
                }
                JOptionPane.showMessageDialog(null, "This name does not exist", "Information",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(choiceButton);
        box.add(radioButton1);
        box.add(radioButton2);
        box.add(radioButton3);

        return box;
    }

    private Box getPanel4() {
        JTextField textField = new JTextField("Enter the text");
        JCheckBox checkBox1 = new JCheckBox("1");
        JCheckBox checkBox2 = new JCheckBox("2");
        JCheckBox checkBox3 = new JCheckBox("3");
        JLabel choiceButton = new StarLabel().createStarLabel("Choice Button");
        choiceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (checkBox1.getText().equals(textField.getText())) {
                    checkBox1.setSelected(!checkBox1.isSelected());
                    return;
                }
                if (checkBox2.getText().equals(textField.getText())) {
                    checkBox2.setSelected(!checkBox2.isSelected());
                    return;
                }
                if (checkBox3.getText().equals(textField.getText())) {
                    checkBox3.setSelected(checkBox3.isSelected());
                    return;
                }
                JOptionPane.showMessageDialog(null, "This name does not exist", "Information",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(choiceButton);
        box.add(checkBox1);
        box.add(checkBox2);
        box.add(checkBox3);

        return box;
    }

    private Box getPanel5() {
        JTable table = new JTable(new Object[10][2], new Object[]{"Column 1", "Column 2"});
        table.setColumnSelectionAllowed(true);
        JScrollPane tableScrollPane = new JScrollPane(table);
        JTextField textField = new JTextField("Enter the text");

        JLabel addTextButton = new StarLabel().createStarLabel("Button 1");
        addTextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    table.setValueAt(textField.getText(), i, 0);
                }
            }
        });
        JLabel textMoveButton1 = new StarLabel().createStarLabel("Button 2");
        textMoveButton1.addMouseListener(new TableAdapter(table, 1, 0));

        JLabel textMoveButton2 = new StarLabel().createStarLabel("Button 3");
        textMoveButton2.addMouseListener(new TableAdapter(table, 0, 1));

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(addTextButton);
        horizontalBox.add(Box.createHorizontalStrut(6));
        horizontalBox.add(textMoveButton1);
        horizontalBox.add(Box.createHorizontalStrut(6));
        horizontalBox.add(textMoveButton2);

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(horizontalBox);
        box.add(tableScrollPane);

        return box;
    }

    class TableAdapter extends MouseAdapter {
        JTable table;
        int col1;
        int col2;

        TableAdapter(JTable table, int col1, int col2) {
            this.table = table;
            this.col1 = col1;
            this.col2 = col2;
        }

        public void mouseClicked(MouseEvent e) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "You haven't selected a line",
                        "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ((col1 == 0) && (table.getSelectedColumn() == 0)) {
                JOptionPane.showMessageDialog(null, "You must select the first column",
                        "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if ((col1 == 1) && (table.getSelectedColumn() == 1)) {
                JOptionPane.showMessageDialog(null, "You must select the first column",
                        "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) != null) {
                table.setValueAt(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()),
                        table.getSelectedRow(), col1);
                table.setValueAt(null, table.getSelectedRow(), col2);
            }
        }
    }

    class StarLabel {
       public JLabel createStarLabel(String text) {
           JLabel label = new JLabel(text, new ImageIcon("favorite.png"), SwingConstants.CENTER);
           label.setHorizontalTextPosition(JLabel.CENTER);
           label.setVerticalTextPosition(JLabel.BOTTOM);
           label.setPreferredSize(new Dimension(100, 80));
           return label;
        }
    }
}
