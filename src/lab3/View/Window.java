package lab3.View;

import lab3.Controller.GraphicPanel;
import lab3.Model.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Konstantin on 12.04.16.
 */
public class Window {
    boolean firstRunThread = true;
    JFrame create() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TablePanel table = new TablePanel();
        GraphicPanel graphicPanel = new GraphicPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(toolsPanel(graphicPanel, table, graphicPanel), BorderLayout.SOUTH);
        mainPanel.add(table, BorderLayout.WEST);
        mainPanel.add(graphicPanel.create(), BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.setSize(new Dimension(1200, 600));
        frame.setVisible(true);
        return frame;
    }

    private JPanel toolsPanel(GraphicPanel graphicPanel, TablePanel table, GraphicPanel graphic) {
        JPanel panel = new JPanel();

        JLabel numberSortLabel = new JLabel("Введите количество массивов");
        JSpinner countSort = new JSpinner(new SpinnerNumberModel(2, 1, 100, 1));
        JButton makeGraph = new JButton("make graph");
        JButton clearGraph = new JButton("clearGraph");

        JLabel scaleX = new JLabel("X: ");
        JButton scaleXPlus = new JButton("+");
        JButton scaleXMinus = new JButton("-");
        JLabel scaleY = new JLabel("Y: ");
        JButton scaleYPlus = new JButton("+");
        JButton scaleYMinus = new JButton("-");

        makeGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                graphic.clearGraph();
                Thread thread = new ThreadMas((int)countSort.getValue(), graphic, table);
                    thread.start();
                    firstRunThread = false;
            }
        });
        clearGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.clearGraph();
            }
        });
        scaleXMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.scaleXMinus();
            }
        });
        scaleXPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.scaleXPlus();
            }
        });
        scaleYMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.scaleYMinus();
            }
        });
        scaleYPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicPanel.scaleYPlus();
            }
        });

        panel.add(numberSortLabel);
        panel.add(countSort);
        panel.add(makeGraph);
        panel.add(clearGraph);

        panel.add(scaleX);
        panel.add(scaleXMinus);
        panel.add(scaleXPlus);
        panel.add(scaleY);
        panel.add(scaleYMinus);
        panel.add(scaleYPlus);
        return panel;
    }


//1. ArrayList на List
//2. мож вынести поток, чтобы можно было редактировать во время рисования

    public static void main(String[] args) {
        new Window().create();
    }
}