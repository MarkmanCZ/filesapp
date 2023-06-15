package dev.markman.cz.GUI;

import dev.markman.cz.Files.FileService;
import dev.markman.cz.Models.Person;
import dev.markman.cz.Utils.Messages;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataView extends JFrame{
    private JPanel mainPanel;
    private JTextArea dataArrea;

    ArrayList<Person> people;
    private FileService fileService;
    public DataView(FileService fileService, File activeFile) {
        this.fileService = fileService;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(new Dimension(500,500));


        try {
            if(activeFile == null) {
                JFileChooser chooser = fileService.showChooser(mainPanel);
                if (chooser != null) {
                    people = fileService.readFromFile(chooser.getSelectedFile());
                }else {
                    people = new ArrayList<>();
                }
            }else {
                people = fileService.readFromFile(activeFile);
            }
            if(people.size() < 1) {
                Messages.showInfoMessage(mainPanel,"Žádný soubor nebyl vybrán, není co k vyspání...","Info");
            }
            for (Person p : people) {
                dataArrea.append("Jméno a přijmení: "+p.getName() + " E-mail: "+p.getEmial() + " Vek: "+p.getAge()+"\n");
            }
        }catch(FileNotFoundException e) {
            Messages.showErroMessage(mainPanel,e.getMessage(),"Error");
        }

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
