package lab1;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Window extends JFrame {
    private ArrayList<String> comboBoxItems = new ArrayList();

    Window(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 3, 12, 12));

        mainPanel.add(getPanel1());
        mainPanel.add(getPanel2());
        mainPanel.add(getPanel3());
        mainPanel.add(getPanel4());
        mainPanel.add(getPanel5());

        setContentPane(mainPanel);
        setSize(850, 500);
    }

    private Box getPanel1() {
        JComboBox<String> menu = new JComboBox();
        JTextField textField = new JTextField("Enter the text");
        JButton addButton = new JButton("Add");
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

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
        horizontalBox.add(Box.createHorizontalGlue());
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
        JButton renameButton = new JButton("Rename button");
        JButton exchangeButton = new JButton("Exchange");
        renameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                exchangeButton.setText(textField.getText());
            }
        });
        exchangeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String tempButton = exchangeButton.getText();
                exchangeButton.setText(renameButton.getText());
                renameButton.setText(tempButton);
            }
        });

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(renameButton);
        horizontalBox.add(Box.createHorizontalGlue());
        horizontalBox.add(exchangeButton);

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(horizontalBox);

        return box;
    }

    private Box getPanel3() {
        JTextField textField = new JTextField("Enter the text");
        JButton choiceButton = new JButton("Choice button");
        JRadioButton radioButton1 = new JRadioButton("Flag 1");
        JRadioButton radioButton2 = new JRadioButton("Flag 2");
        JRadioButton radioButton3 = new JRadioButton("Flag 3");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        choiceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (textField.getText().equals(radioButton1.getText())) {
                    radioButton1.setSelected(true);
                    return;
                }
                if (textField.getText().equals(radioButton2.getText())) {
                    radioButton2.setSelected(true);
                    return;
                }
                if (textField.getText().equals(radioButton3.getText())) {
                    radioButton3.setSelected(true);
                    return;
                }
                 JOptionPane.showMessageDialog(null,"This name does not exist", "Information",
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
        JCheckBox checkBox1 = new JCheckBox("Flag 1");
        JCheckBox checkBox2 = new JCheckBox("Flag 2");
        JCheckBox checkBox3 = new JCheckBox("Flag 3");
        JButton choiceButton = new JButton("Choice Button");
        choiceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (textField.getText().equals(checkBox1.getText())) {
                    checkBox1.setSelected(true);
                    return;
                }
                if (textField.getText().equals(checkBox2.getText())) {
                    checkBox2.setSelected(true);
                    return;
                }
                if (textField.getText().equals(checkBox3.getText())) {
                    checkBox3.setSelected(true);
                    return;
                }
                JOptionPane.showMessageDialog(null,"This name does not exist", "Information",
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

        JButton addTextButton = new JButton("Button 1");
        addTextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for (int i = 0; i < table.getRowCount(); i++) {
                    table.setValueAt(textField.getText(), i, 0);
                }
            }
        });

        JButton textMoveButton1 = new JButton("Button 2");
        textMoveButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "You haven't selected a line",
                            "Information", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (table.getSelectedColumn() == 1) {
                    JOptionPane.showMessageDialog(null, "You must select the first column",
                            "Information", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                table.setValueAt(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()),
                        table.getSelectedRow(), 1);
                table.setValueAt(null, table.getSelectedRow(), 0);
            }
        });

        JButton textMoveButton2 = new JButton("Button 3");
        textMoveButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "You haven't selected a line", "Information",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (table.getSelectedColumn() == 0) {
                    JOptionPane.showMessageDialog(null, "You must select the second column", "Information",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                table.setValueAt(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()),
                        table.getSelectedRow(), 0);
                table.setValueAt(null, table.getSelectedRow(), 1);
            }
        });

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(addTextButton);
        horizontalBox.add(textMoveButton1);
        horizontalBox.add(textMoveButton2);

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(horizontalBox);
        box.add(tableScrollPane);

        return box;
    }
}