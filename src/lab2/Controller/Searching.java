package lab2.Controller;

import lab2.Model.Train;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 26.03.2016.
 */
public class Searching {
    protected Algorithm algorithm;
    private List<Train> trains;

    public Searching(List<Train> trains) {
        this.trains = trains;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Train> search(Train train1, Train train2) {
        List<Train> searchingTrains = new ArrayList<>();
        for (Train train : trains) {
            if (algorithm.favourite(train, train1, train2)) searchingTrains.add(train);
        }
        return searchingTrains;
    }
}
