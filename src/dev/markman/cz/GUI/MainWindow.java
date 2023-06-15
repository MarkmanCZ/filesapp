package dev.markman.cz.GUI;

import dev.markman.cz.Files.FileService;
import dev.markman.cz.Utils.Messages;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainWindow extends JFrame{
    private JPanel mainPanel;
    private JButton saveBtn;
    private JTextField inFullname;
    private JTextField inEmail;
    private JTextField inAge;
    private JButton showDataView;
    private ArrayList<JTextField> fields = new ArrayList<>(3);
    private FileService fileService;
    //pokud mam nacteny soubor z predesleho ukladani noveho zaznumu, prenesu pomoci
    //tohoto variablu soubor pro nacteni dat do noveho okna DataView
    private File activeFile;

    public MainWindow() {
        this.fileService = new FileService(this);
        this.fileService.setSPLITTER(";");

        fields.add(inFullname);
        fields.add(inEmail);
        fields.add(inAge);

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFields();
                JFileChooser chooser = fileService.showChooser(mainPanel);
                if(fileService.writeToFile(chooser.getSelectedFile(),fields)) {
                    cleanFileds();
                    activeFile = chooser.getSelectedFile();
                    Messages.showInfoMessage(mainPanel,"Úspěšně uloženo.","Success");
                }
            }
        });
        showDataView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataView dataView = new DataView(fileService,activeFile);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void checkFields() {
        if(fields.get(0).getText().length() == 0) {
            Messages.showMessage(mainPanel,"Vyplň pole Jméno a Přijímení", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(fields.get(1).getText().length() == 0) {
            Messages.showMessage(mainPanel,"Vyplň pole E-mail", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(fields.get(2).getText().length() == 0) {
            Messages.showMessage(mainPanel,"Vyplň pole Věk", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cleanFileds() {
        for (JTextField a : fields) {
            a.setText("");
        }
    }
}
