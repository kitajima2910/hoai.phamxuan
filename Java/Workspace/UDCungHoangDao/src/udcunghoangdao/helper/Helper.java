/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udcunghoangdao.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Kitajima2910
 */
public class Helper {

    public static BasicInternalFrameTitlePane titlePane(JInternalFrame frm) {
        return (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) frm.getUI()).getNorthPane();
    }

    public static void fullScreenJDesktopPane(JInternalFrame frm, JDesktopPane jdp) {
        frm.setLocation(0, 0);
        frm.setSize(jdp.getWidth(), jdp.getHeight());
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean isValidDate(final String date) {

        boolean valid = false;

        try {
            sdf.parse(date);
            // strict mode - check 30 or 31 days, leap year
            sdf.setLenient(false);
            valid = true;
        } catch (ParseException e) {
            valid = false;
        }

        return valid;
    }

    public static int checkZodiac(String date) {
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int day = ld.getDayOfMonth();
        int month = ld.getMonthValue();
        int year = ld.getYear();

        int result = 0;
        switch (month) {
            case 1:
                if (day >= 20) {
                    result = 11;
                } else {
                    result = 10;
                }
                break;

            case 2:
                if (day >= 19) {
                    result = 12;
                } else {
                    result = 11;
                }
                break;

            case 3:
                if (day >= 21) {
                    result = 1;
                } else {
                    result = 12;
                }
                break;

            case 4:
                if (day < 20) {
                    result = 1;
                } else {
                    result = 2;
                }
                break;

            case 5:
                if (day >= 21) {
                    result = 3;
                } else {
                    result = 2;
                }
                break;

            case 6:
                if (day < 21) {
                    result = 3;
                } else {
                    result = 4;
                }
                break;

            case 7:
                if (day >= 23) {
                    result = 5;
                } else {
                    result = 4;
                }
                break;

            case 8:
                if (day < 23) {
                    result = 5;
                } else {
                    result = 6;
                }
                break;

            case 9:
                if (day >= 23) {
                    result = 7;
                } else {
                    result = 6;
                }
                break;

            case 10:
                if (day < 23) {
                    result = 7;
                } else {
                    result = 8;
                }
                break;

            case 11:
                if (day >= 22) {
                    result = 9;
                } else {
                    result = 8;
                }
                break;

            case 12:
                if (day < 22) {
                    result = 9;
                } else {
                    result = 10;
                }
                break;
        }
        return result;
    }

}
