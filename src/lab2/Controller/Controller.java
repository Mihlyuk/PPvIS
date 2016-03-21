package lab2.Controller;

import lab2.Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Константин on 12.03.2016.
 */
public class Controller {
    public MainModel theModel;

    public Controller(MainModel theModel) {
        this.theModel = theModel;
    }

    public void addTrain(Train newTrain) {
        theModel.trains.add(newTrain);
    }

    public List<Train> getTrains() {
        return theModel.trains;
    }

    public List<Train> findTrains(String trainNumber, Date dateArriving, Date timeArriving1,
                                  Date timeArriving2, Date timeDeparting1, Date timeDeparting2,
                                  String stationArriving, String stationDeparting, Date travelTime,
                                  boolean checkBox1, boolean checkBox2, boolean checkBox3,
                                  boolean checkBox4) {
        List<Train> trains = new ArrayList<>();
        for (Train train : theModel.trains) {
            if (checkBox1 && (!train.number.equals(trainNumber) ||
                    !equalDate(train.dateArriving, dateArriving))) continue;
            if (checkBox2 && (!inTimeLine(train.dateArriving, timeArriving1, timeArriving2) ||
                    !inTimeLine(train.dateDeparting, timeDeparting1, timeDeparting2))) continue;
            if ((checkBox3) && (!train.stationArriving.equals(stationArriving) ||
                    !train.stationDeparting.equals(stationDeparting))) continue;
            if ((checkBox4) && !train.travelTime.equals(travelTime)) continue;
            trains.add(train);
        }
        return trains;
    }

    public int removeTrains(List<Train> trains) {
        int i = 0;
        for (Train removeTrain : trains) {
            for (i = 0; i < theModel.trains.size(); i++) {
                if (theModel.trains.get(i).equals(removeTrain)) {
                    theModel.trains.remove(i);
                    break;
                }
            }
        }
        return i;
    }

    private boolean inTimeLine(Date date, Date date1, Date date2) {
        int dateMinutes = getHour(date) * 60 + getMinutes(date);
        int date1Minutes = getHour(date1) * 60 + getMinutes(date1);
        int date2Minutes = getHour(date2) * 60 + getMinutes(date2);
        if (dateMinutes >= date1Minutes && dateMinutes <= date2Minutes) {
            return true;
        } else return false;
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

    private int getHour(Date date) {
        return Integer.parseInt(new SimpleDateFormat("HH").format(date));
    }

    private int getMinutes(Date date) {
        return Integer.parseInt(new SimpleDateFormat("mm").format(date));
    }

    /*   class CloseButtonListener implements ActionListener {

           public void actionPerformed(ActionEvent event) {
               theView.searchDialog.setVisible(false);
           }
       }
   */



    class FindButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for (int i = 0; i < theModel.trains.size(); i++) {
              /*  if ((theModel.trains.get(i).number.equals(theView.searchDialog.trainNumber.getText())) &&
                        (theModel.trains.get(i).stationArriving.equals(theView.searchDialog.stationArriving.getText())) &&
                        (theModel.trains.get(i).stationDeparting.equals(theView.searchDialog.stationDeparting.getText())) &&
                        (theModel.trains.get(i).dateArriving == theView.searchDialog.dateArriving.getValue()) &&
                        (theModel.trains.get(i).dateDeparting.equals(theView.searchDialog.getText())) &&
                        (theModel.trains.get(i).number.equals(theView.searchDialog.trainNumber.getText()))) {
                }*/
            }
        }
    }
}
