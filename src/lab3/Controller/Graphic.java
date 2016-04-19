package lab3.Controller;

import lab3.Model.Value;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static lab3.Controller.GraphicConstants.*;

/**
 * Created by konstantin on 17.04.16.
 */
public class Graphic extends JPanel {
    private double minValueX = DEFAULT_MIN_VALUE_X;
    private double maxValueX = DEFAULT_MAX_VALUE_X;
    private double minValueY = DEFAULT_MIN_VALUE_Y;
    private double maxValueY = DEFAULT_MAX_VALUE_Y;

    private int prevX = 0;
    private int prevY = 0;

    private double longestVectorX;
    private double longestVectorY;

    private double coeffX;
    private double coeffY;

    private ArrayList<Value> valueList = new ArrayList<>();

    public Graphic() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 200));
        setSize(new Dimension(400, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        longestVectorX = getLongestVector(maxValueX, minValueX);
        longestVectorY = getLongestVector(maxValueY, minValueY);
        coeffX = getWidth() / longestVectorX / 2;
        coeffY = getHeight() / longestVectorY / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;


        g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

        int zoomNumbersX = getZoomNumbers   (longestVectorX);
        for (int x = zoomNumbersX; x <= longestVectorX; x += zoomNumbersX) {
            g.drawLine((int) Math.ceil(Math.abs(centerX) + coeffX * x), centerY - 4,
                    (int) Math.ceil(Math.abs(centerX) + coeffX * x), Math.abs(centerY) + 4);
            g.drawLine((int) Math.ceil(Math.abs(centerX) - coeffX * x), centerY - 4,
                    (int) Math.ceil(Math.abs(centerX) - coeffX * x), Math.abs(centerY) + 4);
        }
        for (int i = zoomNumbersX; i <= longestVectorX; i += zoomNumbersX) {
            g.drawString(Integer.toString(i), (int) (Math.abs(centerX) + coeffX * i) - 2, Math.abs(centerY) - 5);
            g.drawString(Integer.toString(i), (int) (Math.abs(centerX) - coeffX * i) - 2, Math.abs(centerY) - 5);
        }

        int zoomNumbersY = getZoomNumbers(longestVectorY);
        for (int y = zoomNumbersY; y < longestVectorY; y += zoomNumbersY) {
            g.drawLine(centerX + 4, (int) Math.ceil(Math.abs(centerY) + coeffY * y),
                    Math.abs(centerX) - 4, (int) Math.ceil(Math.abs(centerY) + coeffY * y));
            g.drawLine(centerX + 4, (int) Math.ceil(Math.abs(centerY) - coeffY * y),
                    Math.abs(centerX) - 4, (int) Math.ceil(Math.abs(centerY) - coeffY * y));
        }
        for (int j = zoomNumbersY; j < longestVectorY; j += zoomNumbersY) {
            g.drawString(Integer.toString(j), Math.abs(centerX) + 5, (int) (Math.abs(centerY) + coeffY * j) + 4);
            g.drawString(Integer.toString(j), Math.abs(centerX) + 5, (int) (Math.abs(centerY) - coeffY * j) + 4);
        }

        g.drawString("mS", centerX - 25, 15);
        g.drawString("arrays", getWidth() - 45, getHeight() / 2 + 17);

        prevX = 0;
        prevY = 0;
        for (int i = 0; i < valueList.size(); i++) {
            addAndDraw(valueList.get(i).countSort, (int) valueList.get(i).time, g);
        }
    }

    private double getLongestVector(double value1, double value2) {
        if (Math.abs(value1) > Math.abs(value2)) return Math.abs(value1);
        else return Math.abs(value2);
    }

    private int getZoomNumbers(double maxValue) {
        if (maxValue < 20) return 1;
        else if (maxValue < 60) return 5;
        else if (maxValue < 100) return 10;
        else return 20;
    }

    public void clearGraph() {
        prevX = 0;
        prevY = 0;
        valueList.clear();
        repaint();
    }

    public void scaleXMinus() {
        if (Math.abs(minValueX) < 200 && Math.abs(maxValueX) < 200) {
            minValueX -= 5;
            maxValueX += 5;
            repaint();
        }
    }
    public void scaleXPlus() {
        if (Math.abs(minValueX) > 5 && Math.abs(maxValueX) > 5) {
            minValueX += 5;
            maxValueX -= 5;
            repaint();
        }
    }
    public void scaleYMinus() {
        if (Math.abs(minValueY) < 200 && Math.abs(maxValueY) < 200) {
            minValueY -= 5;
            maxValueY += 5;
            repaint();
        }
    }
    public void scaleYPlus() {
        if (Math.abs(minValueY) > 5 && Math.abs(maxValueY) > 5) {
            minValueY += 5;
            maxValueY -= 5;
            repaint();
        }
    }

    public ArrayList<Value> getValues() {
        return valueList;
    }
    public void print(int countMas) {
        Graphics g = getGraphics();
        clearGraph();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i < countMas; i++) {
                    Sort quickSort = new Sort();
                    ArrayList<Integer> array = quickSort.generateArray(i);
                    long start = System.nanoTime();
                    quickSort.bubbleSort(array);
                    long end = System.nanoTime();
                    long traceTime = (end - start);
                    addAndDraw(i, (int) traceTime / 700, g);
                    valueList.add(new Value(i, (int) traceTime / 700));
                }
            }
        });
        thread.run();
    }

    public synchronized void addAndDraw(int cordX, int cordY, Graphics g) {
        coeffX = getWidth() / longestVectorX / 2;
        coeffY = getHeight() / longestVectorY / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g.drawLine(centerX + (int) (prevX * coeffX), centerY - (int) (prevY * coeffY),
                centerX + (int) (cordX * coeffX), centerY - (int) (cordY * coeffY));
        g.drawOval(centerX + (int) (cordX * coeffX) - 2, centerY - (int) (cordY * coeffY) - 2, 4, 4);
       /* Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                0, new float[]{4, 5}, 0));

        graphics2D.drawLine(centerX + (int) (cordX * coeffX), centerY - (int) (cordY * coeffY),
                centerX + (int) (cordX * coeffX), centerY);

        graphics2D.drawLine(centerX + (int) (cordX * coeffX), centerY - (int) (cordY * coeffY),
                centerX, centerY - (int) (cordY * coeffY));*/
        prevX = cordX;
        prevY = cordY;
    }
}