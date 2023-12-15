/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.utils;

import com.gameloft.dao.UsersDAO;
import com.gameloft.model.Users;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kitajima2910
 */
public class Helper {

    public static class JFrameMain {

        public static void init(JFrame frame) {
            frame.setResizable(false);
        }

    }

    public static class JTableMain {

        public static void init(JTable table) {
            ((DefaultTableModel) table.getModel()).setNumRows(0);
            table.setDefaultEditor(Object.class, null);
        }

        public static void showData(JTable table, boolean flag, String keyword) {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setNumRows(0);
            
            List<Users> list = "".equals(keyword) & !flag ? UsersDAO.getAll() : UsersDAO.getSearch(keyword);
            list.forEach((u) -> {
                Object object[] = {
                    u.getId(), u.getName(), u.getEmail(), u.getCountry(), u.getPassword()
                };
                dtm.addRow(object);
            });
        }

    }

    public static class JProgressBarMain {

        public static void processJTable(JProgressBar progressBar, JTable table, String msg, String title) {

            progressBar.setValue(0);

            final Timer timer = new Timer(10, (ActionEvent e) -> {
                progressBar.setStringPainted(true);
                progressBar.setForeground(Color.BLUE);
                progressBar.setValue(progressBar.getValue() + 1);
                progressBar.setString(progressBar.getValue() + "%");
                if (progressBar.getValue() == 100) {
                    Database.Table.createUsers();
                    Helper.JTableMain.showData(table, false, "");
                    JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
                    progressBar.setValue(0);
                    progressBar.setString("");
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();

        }

    }

    public static class JTextFieldMain {

        public static void reset(Object... objs) {
            for (Object txt : objs) {
                if (txt instanceof JTextField) {
                    ((JTextField) txt).setText("");
                }
                if (txt instanceof JPasswordField) {
                    ((JPasswordField) txt).setText("");
                }
            }
        }

    }

    public static class JComboBoxMain {

        public static void country(JComboBox comboBox) {

            String[] countryCodes = java.util.Locale.getISOCountries();
            comboBox.setModel(new DefaultComboBoxModel(countryCodes));

        }

    }

}
