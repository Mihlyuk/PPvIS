package lab3.Controller;

import lab3.Model.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

/**
 * Created by Konstantin on 12.04.16.
 */
public class GraphicPanel {
    private Graphic graphic;

    public JPanel create() {
        graphic = new Graphic();
        graphic.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation() < 0) {
                    graphic.setSize((int) Math.floor(graphic.getWidth() + 20),
                            (int) Math.floor(graphic.getHeight() + 20));
                    graphic.setPreferredSize(new Dimension((int) Math.floor(graphic.getWidth() + 20),
                            (int) Math.floor(graphic.getHeight() + 20)));
                    graphic.repaint();
                } else if (e.getWheelRotation() > 0) {
                    graphic.setSize((int) Math.floor(graphic.getWidth() - 20),
                            (int) Math.floor(graphic.getHeight() - 20));
                    graphic.setPreferredSize(new Dimension((int) Math.floor(graphic.getWidth() - 20),
                            (int) Math.floor(graphic.getHeight() - 20)));
                    graphic.repaint();
                }
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(graphic);
        MyMouseAdapter adapter = new MyMouseAdapter(scroll);
        graphic.addMouseListener(adapter);
        graphic.addMouseMotionListener(adapter);
        panel.add(scroll);

        return panel;
    }

    public void clearGraph() {
        graphic.clearGraph();
    }

    public void scaleXMinus() {
        graphic.scaleXMinus();
    }

    public void scaleXPlus() {
        graphic.scaleXPlus();
    }

    public void scaleYMinus() {
        graphic.scaleYMinus();
    }

    public void scaleYPlus() {
        graphic.scaleYPlus();
    }

    public void addValue(Value value) {
        graphic.addValue(value);
    }

    public ArrayList<Value> getValues() {
        return graphic.getValues();
    }
}


