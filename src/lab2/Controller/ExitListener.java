package lab2.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Константин on 12.03.2016.
 */
public class ExitListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(null, "Do you want to go?", "Exit",
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }
}