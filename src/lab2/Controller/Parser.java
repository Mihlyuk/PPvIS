package lab2.Controller;

import lab2.Model.MainModel;
import lab2.Model.Train;
import lab2.View.TablePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.stream.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Константин on 12.03.2016.
 */
public class Parser {

    private TablePanel table;
    public MainModel theModel;

    public Parser(MainModel theModel, TablePanel table) {
        this.table = table;
        this.theModel = theModel;
    }

/*   public void openFile() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            openXMLFile(fc.getSelectedFile().getPath());
        }
    }*/
    public void saveFile() {
        try {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                XMLOutputFactory output = XMLOutputFactory.newInstance();
                XMLStreamWriter writer = output.createXMLStreamWriter
                        (new FileWriter(fc.getSelectedFile() + "." + "xml"));
                writer.writeStartDocument("UTF-8", "1.0");
                writer.writeStartElement("trains");
                writer.writeStartElement("numberExam");
                for (Train train : table.getTrains()) {
                    writer.writeStartElement("train");
                    writer.writeAttribute("numberTrain", train.number);
                    writer.writeAttribute("stationArriving", train.stationArriving);
                    writer.writeAttribute("stationDeparting", train.stationDeparting);
                    writer.writeAttribute("dateArriving", String.valueOf(train.dateArriving));
                    writer.writeAttribute("dateDeparting", String.valueOf(train.dateDeparting));
                    writer.writeAttribute("travelTime", String.valueOf(train.travelTime));
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeEndDocument();
                writer.flush();
            }
        } catch (Exception eSave) {
            JOptionPane.showMessageDialog
                    (null, "Can't save file", "ERROR", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);
        }
    }

  public void openFile() {
      JFileChooser fc = new JFileChooser();
      fc.setFileFilter(new FileNameExtensionFilter(".xml", "xml"));
      if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          String fileName = fc.getSelectedFile().getPath();

          try {
              String numberTrain = "";
              String stationArriving = "";
              String stationDeparting = "";
              Date dateArriving = new Date();
              Date dateDeparting = new Date();
              Date travelTime = new Date();
              table.getTrains().clear();

              XMLStreamReader xmlr = XMLInputFactory.newInstance()
                      .createXMLStreamReader(fileName, new FileInputStream(fileName));
              while (xmlr.hasNext()) {
                  xmlr.next();
                  if (xmlr.isStartElement()) {
                      if (xmlr.getLocalName().equals("train")) {
                          numberTrain = xmlr.getAttributeValue(null, "numberTrain");
                          stationArriving = xmlr.getAttributeValue(null, "stationArriving");
                          stationDeparting = xmlr.getAttributeValue(null, "stationDeparting");
                          dateArriving = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
                                  .parse(xmlr.getAttributeValue(null, "dateArriving"));
                          dateDeparting = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
                                  .parse(xmlr.getAttributeValue(null, "dateDeparting"));
                          travelTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
                                  .parse(xmlr.getAttributeValue(null, "travelTime"));
                      }
                  } else if (xmlr.isEndElement()) {
                      if (xmlr.getLocalName().equals("train")) {
                          table.getTrains().add(new Train(numberTrain, stationArriving, stationDeparting,
                                  dateArriving, dateDeparting, travelTime));
                      }
                  }
              }
              table.updateTable();
          } catch (Exception e) {
              JOptionPane.showMessageDialog
                      (null, "Can't open file", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
      }
  }
}
