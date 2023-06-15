package dev.markman.cz;

import dev.markman.cz.GUI.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static MainWindow mainWindow;
    public static void main(String[] args) {
        mainWindow = new MainWindow();
        mainWindow.setContentPane(mainWindow.getMainPanel());
        mainWindow.setTitle("Aplikace");
        mainWindow.setSize(new Dimension(520,340));
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}