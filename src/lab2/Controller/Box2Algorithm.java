package lab2.Controller;

import lab2.Model.Train;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Box2Algorithm implements Algorithm {
    @Override
    public boolean favourite(Train trainModel, Train train1, Train train2) {
        if (inTimeLine(trainModel.dateArriving, train1.dateArriving, train2.dateArriving) &&
                inTimeLine(trainModel.dateDeparting, train1.dateDeparting, train2.dateDeparting)) return true;
        else return false;
    }

    private boolean inTimeLine(Date date, Date date1, Date date2) {
        int dateMinutes = getHour(date) * 60 + getMinutes(date);
        int date1Minutes = getHour(date1) * 60 + getMinutes(date1);
        int date2Minutes = getHour(date2) * 60 + getMinutes(date2);
        if (dateMinutes >= date1Minutes && dateMinutes <= date2Minutes) {
            return true;
        } else return false;
    }

    private int getMinutes(Date date) {
        return Integer.parseInt(new SimpleDateFormat("mm").format(date));
    }

    private int getHour(Date date) {
        return Integer.parseInt(new SimpleDateFormat("HH").format(date));
    }
}
