package lab3.View;

import lab3.Controller.GraphicPanel;
import lab3.Model.Value;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by konstantin on 24.04.16.
 */
public class ThreadMas extends Thread {
    int countSort;
    GraphicPanel graphic;
    TablePanel table;
    ThreadMas(int countSort, GraphicPanel graphic, TablePanel table) {
        this.countSort = countSort;
        this.graphic = graphic;
        this.table = table;
    }
        @Override
        public void run() {
            for (int i = 2; i < countSort; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ArrayList<Integer> array = generateArray(i);
                long start = System.nanoTime();
                bubbleSort(array);
                long end = System.nanoTime();
                long traceTime = (end - start);
                table.addValue(new Value(i, traceTime / 700));
                graphic.addValue(new Value(i, traceTime / 700));

                System.out.println("X: " + i + " Y: " + traceTime / 700);
            }
        }
    private void bubbleSort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int t = arr.get(j);
                    arr.set(j, j + 1);
                    arr.set(j + 1, t);
                }
            }
        }
    }

    private ArrayList<Integer> generateArray(int size) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(new Random().nextInt());
        }
        return array;
    }
}
