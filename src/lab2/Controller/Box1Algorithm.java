package lab2.Controller;

import lab2.Model.Train;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Box1Algorithm implements Algorithm {
    @Override
    public boolean favourite(Train trainModel, Train train1, Train train2) {
        if (trainModel.number.equals(train1.number) &&
                equalDate(trainModel.dateArriving, train1.dateArriving)) return true;
        else return false;
    }

    private boolean equalDate(Date date1, Date date2) {
        if (getDay(date1) == getDay(date2) && getMonth(date1) == getMonth(date2)) {
            return true;
        } else return false;
    }

    private int getDay(Date date) {
        return Integer.parseInt(new SimpleDateFormat("dd").format(date));
    }

    private int getMonth(Date date) {
        return Integer.parseInt(new SimpleDateFormat("MM").format(date));
    }
}
