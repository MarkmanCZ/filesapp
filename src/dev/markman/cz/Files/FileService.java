package dev.markman.cz.Files;

import dev.markman.cz.GUI.MainWindow;
import dev.markman.cz.Models.Person;
import dev.markman.cz.Utils.Messages;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {

    private String SPLITTER = ",";

    private MainWindow mainWindow;
    public FileService(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }
    public boolean writeToFile(File file, ArrayList<JTextField> data) {
        try {
            FileWriter writer = new FileWriter(file,true);
            int finish=0;
            for (JTextField a : data) {
                finish++;
                String formated = (finish != data.size()) ? a.getText()+getSPLITTER() : a.getText()+"\n";
                writer.append(formated);
            }
            writer.close();
            return true;
        }catch (IOException e) {
            Messages.showErroMessage(mainWindow.getMainPanel(),e.getMessage(),"Errro");
            return false;
        }
    }

    public ArrayList<Person> readFromFile(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        ArrayList<Person> people =  new ArrayList<>();
        if(scan.hasNextLine()) {
            while(scan.hasNextLine()) {
               String[] row = scan.nextLine().split(getSPLITTER());
               Person p = new Person(row[0],row[1],Integer.parseInt(row[2]));
               people.add(p);
            }
        }else {
            Messages.showInfoMessage(mainWindow.getMainPanel(),"Soubor byl načten, ale je prázdný.","Info");
        }
        return people;
    }

    public JFileChooser showChooser(JPanel mainPanel) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Vyber soubor pro ulozeni dat...");
        int resp = chooser.showDialog(mainPanel,"Vyber");
        if(resp == JFileChooser.CANCEL_OPTION || resp == JFileChooser.CANCEL_OPTION) {
            Messages.showWarnMessage(mainPanel,"Nebyl vybrán žádný soubor.", "Info");
        }else if(resp == JFileChooser.ERROR) {
            Messages.showErroMessage(mainPanel,"Nastala chyba", "Error");
        }else if(resp == JFileChooser.APPROVE_OPTION) {
            return chooser;
        }
        return null;
    }

    public String getSPLITTER() {
        return SPLITTER;
    }

    public void setSPLITTER(String SPLITTER) {
        this.SPLITTER = SPLITTER;
    }
}
