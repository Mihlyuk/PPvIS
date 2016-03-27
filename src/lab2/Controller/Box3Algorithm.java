package lab2.Controller;

import lab2.Model.Train;

/**
 * Created by Константин on 26.03.2016.
 */
public class Box3Algorithm implements Algorithm {
    @Override
    public boolean favourite(Train trainModel, Train train1, Train train2) {
        if (trainModel.stationArriving.equals(train1.stationArriving) &&
                trainModel.stationDeparting.equals(train1.stationDeparting)) return true;
        else return false;
    }
}