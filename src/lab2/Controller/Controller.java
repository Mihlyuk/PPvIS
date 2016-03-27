package lab2.Controller;

import javafx.scene.control.CheckBox;
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

    public int removeTrains(List<Train> trains) {
        int i = 0;
        for (Train removeTrain : trains) {
            for (Train modelTrain : theModel.trains) {
                if (modelTrain.equals(removeTrain)) {
                    theModel.trains.remove(modelTrain);
                    break;
                }
            }
        }
        return i;
    }



}
