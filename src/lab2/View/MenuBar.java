package lab2.View;

import lab2.Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Константин on 12.03.2016.
 */
public class MenuBar {

    public JMenuBar create(TablePanel tablePanel, JDialog addDialog, JDialog searchDialog, JDialog deleteDialog, Parser mainHandler) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenuFile(tablePanel, mainHandler));
        menuBar.add(createMenuTools(addDialog, searchDialog, deleteDialog));
        return menuBar;
    }

    private JMenu createMenuFile(TablePanel tablePanel, Parser mainHandler) {
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenu menu = new JMenu("File");
        menu.setFont(font);

        JMenuItem itemNewFile = new JMenuItem("New file");
        itemNewFile.setFont(font);
        menu.add(itemNewFile);
        itemNewFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.getTrains().clear();
                tablePanel.updateTable();
            }
        });

        JMenuItem itemOpenFile = new JMenuItem("Open file");
        itemOpenFile.setFont(font);
        menu.add(itemOpenFile);
        itemOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainHandler.openFile();
            }
        });

        JMenuItem itemSaveFile = new JMenuItem("Save");
        itemSaveFile.setFont(font);
        menu.add(itemSaveFile);
        itemSaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainHandler.saveFile();
            }
        });

        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.setFont(font);
        menu.add(itemExit);
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to go?", "Exit",
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        return menu;
    }

    private JMenu createMenuTools(JDialog addDialog, JDialog searchDialog, JDialog deleteDialog) {
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenu menu = new JMenu("Tools");
        menu.setFont(font);

        JMenuItem itemAdd = new JMenuItem("Add");
        itemAdd.setFont(font);
        menu.add(itemAdd);
        itemAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog.setVisible(true);
            }
        });

        JMenuItem itemSearch = new JMenuItem("Search");
        itemSearch.setFont(font);
        menu.add(itemSearch);
        itemSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDialog.setVisible(true);
            }
        });

        JMenuItem itemDelete = new JMenuItem("Delete");
        itemDelete.setFont(font);
        menu.add(itemDelete);
        itemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDialog.setVisible(true);
            }
        });

        return menu;
    }
}
