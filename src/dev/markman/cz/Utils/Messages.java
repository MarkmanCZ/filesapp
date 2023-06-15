package dev.markman.cz.Utils;

import javax.swing.*;

public class Messages {
    public static void showMessage(JPanel comp,String msg, String title,int type) {
        JOptionPane.showMessageDialog(comp,msg,title,type);
    }

    public static void showErroMessage(JPanel comp,String msg, String title) {
        showMessage(comp,msg,title,JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfoMessage(JPanel comp,String msg, String title) {
        showMessage(comp,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showWarnMessage(JPanel comp,String msg, String title) {
        showMessage(comp,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}
