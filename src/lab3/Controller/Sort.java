package lab3.Controller;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by konstantin on 17.04.16.
 */
public class Sort {
    void bubbleSort(ArrayList<Integer> arr) {
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

    public ArrayList<Integer> generateArray(int size) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(new Random().nextInt());
        }
        return array;
    }
}