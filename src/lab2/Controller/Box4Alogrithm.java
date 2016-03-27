package lab2.Controller;

import lab2.Model.Train;

public class Box4Alogrithm implements Algorithm {
    @Override
    public boolean favourite(Train trainModel, Train train1, Train train2) {

        if (trainModel.travelTime.equals(train1.travelTime)) return true;
        else return false;
    }
}
