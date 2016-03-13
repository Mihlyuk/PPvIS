package lab2.View;

import lab2.Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Константин on 12.03.2016.
 */
public class MenuBar extends JMenuBar{

    JMenuItem itemNewFile;
    JMenuItem itemOpenFile;
    JMenuItem itemSaveFile;
    JMenuItem itemExit;
    JMenuItem itemAdd;
    JMenuItem itemSearch;
    JMenuItem itemDelete;

    public MenuBar() {
        add(createMenuFile());
        add(createMenuTools());
    }

    private JMenu createMenuFile() {
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenu menu = new JMenu("File");
        menu.setFont(font);

        itemNewFile = new JMenuItem("New file");
        itemNewFile.setFont(font);
        menu.add(itemNewFile);

        itemOpenFile = new JMenuItem("Open file");
        itemOpenFile.setFont(font);
        menu.add(itemOpenFile);
        itemOpenFile.addActionListener(new OpenListener());

        itemSaveFile = new JMenuItem("Save");
        itemSaveFile.setFont(font);
        menu.add(itemSaveFile);
        itemSaveFile.addActionListener(new SaveListener());

        itemExit = new JMenuItem("Exit");
        itemExit.setFont(font);
        menu.add(itemExit);
        itemExit.addActionListener(new ExitListener());

        return menu;
    }

    private JMenu createMenuTools() {
        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenu menu = new JMenu("Tools");
        menu.setFont(font);

        itemAdd = new JMenuItem("Add");
        itemAdd.setFont(font);
        menu.add(itemAdd);

        itemSearch = new JMenuItem("Search");
        itemSearch.setFont(font);
        menu.add(itemSearch);

        itemDelete = new JMenuItem("Delete");
        itemDelete.setFont(font);
        menu.add(itemDelete);

        return menu;
    }

    public void addItemSearchListener(ActionListener listener) {
        itemSearch.addActionListener(listener);
    }

    public void addItemAddListener(ActionListener listener) {
        itemAdd.addActionListener(listener);
    }

}
