package lab2.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Константин on 12.03.2016.
 */
public class OpenListener implements ActionListener {
    JFileChooser fileChooser = new JFileChooser();

    public void actionPerformed(ActionEvent event) {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        }
    }
}