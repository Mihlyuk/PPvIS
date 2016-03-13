package lab2;
import lab2.Controller.Controller;
import lab2.Model.*;
import lab2.View.*;

import javax.swing.*;

/**
 * Created by Константин on 12.03.2016.
 */

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        MainView theView = new MainView("Window");

        MainModel theModel = new MainModel();

        Controller theController = new Controller(theView, theModel);

        theView.setVisible(true);
    }
}
