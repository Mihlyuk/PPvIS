package lab1;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
        JComboBox menu = new JComboBox();
        JTextField textField = new JTextField("Enter the text");
        StarButton addButton = new StarButton("Add");
        textField.setPreferredSize(addButton.getMaximumSize());
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(6, 6, 6, 6)));
        box.add(menu);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(textField);
        box.add(Box.createRigidArea(new Dimension(0, 5)));
        box.add(addButton);


        return box;
    }

    private Box getPanel2() {
        JTextField textField = new JTextField("Enter the text");
        StarButton renameButton = new StarButton("Rename");
        StarButton exchangeButton = new StarButton("Exchange");

        exchangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempButton = exchangeButton.getText();
                exchangeButton.setText(renameButton.getText());
                renameButton.setText(tempButton);
            }
        });
        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                exchangeButton.setText(textField.getText());
            }
        });

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(exchangeButton);
        horizontalBox.add(renameButton);
        Box box = Box.createVerticalBox();
        box.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(12, 12, 12, 12)));
        box.add(textField);
        box.add(horizontalBox);

        return box;
    }

    private Box getPanel3() {
        JTextField textField = new JTextField("Enter the text");
        StarButton choiceButton = new StarButton("Choice");
        JRadioButton radioButton1 = new JRadioButton("1");
        JRadioButton radioButton2 = new JRadioButton("2");
        JRadioButton radioButton3 = new JRadioButton("3");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        choiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        box.add(radioButton1);
        box.add(radioButton2);
        box.add(radioButton3);
        box.add(choiceButton);

        return box;
    }

    private Box getPanel4() {
        JTextField textField = new JTextField("Enter the text");
        JCheckBox checkBox1 = new JCheckBox("1");
        JCheckBox checkBox2 = new JCheckBox("2");
        JCheckBox checkBox3 = new JCheckBox("3");
        StarButton choiceButton = new StarButton("Choice");
        choiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        StarButton addTextButton = new StarButton("Button 1");
        addTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    table.setValueAt(textField.getText(), i, 0);
                }
            }
        });
        StarButton textMoveButton1 = new StarButton("Button 2");
        textMoveButton1.addActionListener(new TableAdapter(table, 1, 0));

        StarButton textMoveButton2 = new StarButton("Button 3");
        textMoveButton2.addActionListener(new TableAdapter(table, 0, 1));

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

    class TableAdapter implements ActionListener {
        JTable table;
        int col1;
        int col2;

        TableAdapter(JTable table, int col1, int col2) {
            this.table = table;
            this.col1 = col1;
            this.col2 = col2;
        }

        public void actionPerformed(ActionEvent e) {
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

    public class StarButton extends JButton {

        private BufferedImage image;

        StarButton(String name) {
            super(name);
            setContentAreaFilled(false);//заполнение background
            setBorderPainted(false);
            setMargin(new Insets(5, 5, 5, 5));
            setPreferredSize(new Dimension(40, 40));
            try {
                image = ImageIO.read(new File("favorite.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, null);
            if (getModel().isPressed()) {
                g.drawImage(image, 0, 1, null);
            } else if (getModel().isRollover()) {
                g.drawImage(image, 0, 0, null);
            }
            super.paintComponent(g);
        }
    }
}
