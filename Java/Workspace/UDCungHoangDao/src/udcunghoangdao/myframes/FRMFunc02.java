/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udcunghoangdao.myframes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import udcunghoangdao.helper.Data;
import udcunghoangdao.helper.Helper;

/**
 *
 * @author Kitajima2910
 */
public class FRMFunc02 extends javax.swing.JInternalFrame {

    /**
     * Creates new form FRMFunc02
     */
    public FRMFunc02() {
        initComponents();
        init();
    }
    
    private void init() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formatted = df.format(new Date());
        LocalDate ld = LocalDate.parse(formatted, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int day = ld.getDayOfMonth();
        int month = ld.getMonthValue();
        int year = ld.getYear();
        
        int zodiac = Helper.checkZodiac(formatted);
        lblCON02.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/images/" + zodiac + ".png")));
        lblView02.setText("Cung " + Data.getZodiac(zodiac));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCON02 = new javax.swing.JLabel();
        lblView02 = new javax.swing.JLabel();

        lblCON02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblView02.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblView02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblView02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCON02, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCON02, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblView02, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCON02;
    private javax.swing.JLabel lblView02;
    // End of variables declaration//GEN-END:variables
}
