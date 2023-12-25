/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gameloft.crud;

import com.gameloft.common.ValidMSG;
import com.gameloft.dao.UsersDAO;
import com.gameloft.model.Users;
import com.gameloft.utils.Database;
import com.gameloft.utils.Helper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Kitajima2910
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        Helper.JFrameMain.init(this);
        Helper.JTableMain.init(tblShow);
        try {
            Helper.JTableMain.showData(tblShow, false, "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu chưa được kết nối!", "Hệ thống", JOptionPane.WARNING_MESSAGE);
        }
        txtID.setVisible(false);
        txtCountry.setVisible(false);

        Helper.JComboBoxMain.country(cbCountry);

        search();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        cbCountry = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShow = new javax.swing.JTable();
        btnFaker = new javax.swing.JButton();
        progressBarData = new javax.swing.JProgressBar();
        txtSearch = new javax.swing.JTextField();
        btnExportExcelCSV = new javax.swing.JButton();
        btnExportPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ĐĂNG KÝ");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setEnabled(false);

        jLabel3.setText("Tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Quốc gia:");

        jLabel6.setText("Mật khẩu:");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblError.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtID.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtName)
                            .addComponent(txtEmail)
                            .addComponent(txtCountry)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ & Tên", "Email", "Kí Hiệu Quốc Gia", "Mật Khẩu"
            }
        ));
        tblShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblShow);

        btnFaker.setText("Tạo dữ liệu giả");
        btnFaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFakerActionPerformed(evt);
            }
        });

        progressBarData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnExportExcelCSV.setText("Xuất ra Excel / CSV");
        btnExportExcelCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelCSVActionPerformed(evt);
            }
        });

        btnExportPDF.setText("Xuất ra PDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(btnFaker)
                                .addGap(18, 18, 18)
                                .addComponent(progressBarData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExportExcelCSV)
                                .addGap(18, 18, 18)
                                .addComponent(btnExportPDF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btnFaker))
                        .addComponent(progressBarData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExportExcelCSV)
                        .addComponent(btnExportPDF)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFakerActionPerformed

        Helper.JProgressBarMain.processJTable(progressBarData, tblShow, "Đã tạo dữ liệu giả thành công!", "Hệ thống");
        Helper.JTextFieldMain.reset(new Object[]{txtID, txtName, txtEmail, txtCountry, txtPassword, txtSearch});
    }//GEN-LAST:event_btnFakerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        lblError.setText("");

        try {
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
//            String country = txtCountry.getText().trim();
            String country = cbCountry.getSelectedItem().toString();
            String password = String.valueOf(txtPassword.getPassword());

            int validErrors = checkErrors(name, email, country, password).size();

            if (validErrors == 3) {

                lblError.setText("");

                if (UsersDAO.insert(new Users(name, email, country, password))) {
                    Helper.JTableMain.showData(tblShow, false, "");
                    JOptionPane.showMessageDialog(this, "Đã thêm dữ liệu thành công!", "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
                    Helper.JTextFieldMain.reset(new Object[]{txtID, txtName, txtEmail, txtCountry, txtPassword, txtSearch});
                } else {
                    JOptionPane.showMessageDialog(this, "Dữ liệu thêm vào lỗi!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu thêm vào lỗi!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void tblShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowMouseClicked
        lblError.setText("");

        int row = tblShow.getSelectedRow();
        String id = tblShow.getModel().getValueAt(row, 0).toString();
        String name = tblShow.getModel().getValueAt(row, 1).toString();
        String email = tblShow.getModel().getValueAt(row, 2).toString();
        String country = tblShow.getModel().getValueAt(row, 3).toString();
        String password = tblShow.getModel().getValueAt(row, 4).toString();

        txtID.setText(id);
        txtName.setText(name);
        txtEmail.setText(email);
//        txtCountry.setText(country);
        cbCountry.setSelectedItem(country);
        txtPassword.setText(password);

    }//GEN-LAST:event_tblShowMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        lblError.setText("");
        try {
            String id = txtID.getText().trim();
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String country = txtCountry.getText().trim();
            String password = String.valueOf(txtPassword.getPassword());

            int validErrors = checkErrors(name, email, country, password).size();

            if (validErrors == 3) {

                lblError.setText("");

                if (UsersDAO.update(new Users(Long.valueOf(id), name, email, country, password))) {
                    Helper.JTableMain.showData(tblShow, false, "");
                    JOptionPane.showMessageDialog(this, "Đã cập nhật dữ liệu thành công!", "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
                    Helper.JTextFieldMain.reset(new Object[]{txtID, txtName, txtEmail, txtCountry, txtPassword, txtSearch});
                } else {
                    JOptionPane.showMessageDialog(this, "Dữ liệu cập nhật vào lỗi!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu cập nhật vào lỗi!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        lblError.setText("");
        try {
            String id = txtID.getText().trim();
            String name = txtName.getText().trim();
            String email = txtEmail.getText().trim();
            String country = txtCountry.getText().trim();
            String password = String.valueOf(txtPassword.getPassword());

            if (UsersDAO.delete(new Users(Long.valueOf(id), name, email, country, password))) {
                Helper.JTableMain.showData(tblShow, false, "");
                JOptionPane.showMessageDialog(this, "Đã xoá dữ liệu thành công!", "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
                Helper.JTextFieldMain.reset(new Object[]{txtID, txtName, txtEmail, txtCountry, txtPassword, txtSearch});
            } else {
                JOptionPane.showMessageDialog(this, "Dữ liệu xoá bị lỗi!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu xoá bị lỗi!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportExcelCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelCSVActionPerformed

        // Xử lý chọn nơi lưu file và lấy đường dẫn
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("CHỌN NƠI LƯU");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV of Excel (*.csv)", "csv"));

        int userSelection = fileChooser.showSaveDialog(this);
//        String filename = "Z:\\DataQLTK.csv";
        String filename = "";

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            filename = fileToSave.getAbsolutePath() + ".csv";
//            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        } else {
            return;
        }

        // Xử lý viết vào file
        Path path = Paths.get(filename);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            String sql = "select * from users order by id desc";
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                writer.append(rs.getString("id")).append(",")
                        .append(rs.getString("name")).append(",")
                        .append(rs.getString("country")).append(",")
                        .append(rs.getString("password")).append("\n");
            }

            JOptionPane.showMessageDialog(this, "Đã xuất dữ liệu ra file CSV thành công!", "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi xuất dữ liệu!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
        }

//        try {
//            
//            Writer w = new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8);
//            
//            String sql = "select * from users order by id desc";
//            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                w.append(rs.getString("id")).append(",")
//                        .append(rs.getString("name")).append(",")
//                        .append(rs.getString("country")).append(",")
//                        .append(rs.getString("password")).append("\n");
//            }
//            w.flush();
//            w.close();
//            
//            JOptionPane.showMessageDialog(this, "Đã xuất dữ liệu ra file CSV thành công!", "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
//        } catch (IOException | SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Lỗi xuất dữ liệu!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
//        }

    }//GEN-LAST:event_btnExportExcelCSVActionPerformed

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed

        // Xử lý chọn nơi lưu file và lấy đường dẫn
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("CHỌN NƠI LƯU");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF (*.pdf)", "pdf"));

        int userSelection = fileChooser.showSaveDialog(this);
//        String filename = "Z:\\DataQLTK.pdf";
        String filename = "";

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            filename = fileToSave.getAbsolutePath() + ".pdf";
//            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        } else {
            return;
        }

        // Xử lý viết vào file
        try {
            String sql = "select * from users order by id desc";
            PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            
            PdfPTable table = new PdfPTable(5);
            PdfPCell cell;
            
            while(rs.next()) {
                String pid = rs.getString("id");
                cell = new PdfPCell(new Phrase(pid));
                table.addCell(cell);
                
                String name = rs.getString("name");
                cell = new PdfPCell(new Phrase(name));
                table.addCell(cell);
                
                String email = rs.getString("email");
                cell = new PdfPCell(new Phrase(email));
                table.addCell(cell);
                
                String country = rs.getString("country");
                cell = new PdfPCell(new Phrase(country));
                table.addCell(cell);
                
                String password = rs.getString("password");
                cell = new PdfPCell(new Phrase(password));
                table.addCell(cell);
            }
            document.add(table);
            document.close();
            JOptionPane.showMessageDialog(this, "Đã xuất dữ liệu ra file PDF thành công!", "Hệ thống", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi xuất dữ liệu!", "Hệ thống", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnExportPDFActionPerformed

    private List<String> checkErrors(String name, String email, String country, String password) {
        List<String> errors = new ArrayList<>();
        errors.add("<html><div style='margin-left: 50px'>");
        errors.add("<p style='text-indent: -10px; margin-bottom: 5px;'>Lỗi:</p>");

        if (ValidMSG.isEmpty(name)) {
            errors.add("<p>Tên chưa được nhập.</p>");
        } else {
            if (ValidMSG.isMin(name, 3)) {
                errors.add("<p>Tên phải lớn hơn 3 kí tự.</p>");
            }
        }

        if (ValidMSG.isEmpty(email)) {
            errors.add("<p>Email chưa được nhập.</p>");
        } else {
            if (!ValidMSG.isEmail(email)) {
                errors.add("<p>Email chưa đúng định dạng.</p>");
            }
        }

//        if (ValidMSG.isEmpty(country)) {
//            errors.add("<p>Quốc gia chưa được nhập.</p>");
//        }
        if (ValidMSG.isEmpty(password)) {
            errors.add("<p>Mật khẩu chưa được nhập.</p>");
        } else {
            if (ValidMSG.isMin(password, 3)) {
                errors.add("<p>Mật khẩu phải lớn hơn 3 kí tự.</p>");
            }
        }

        errors.add("</div></html>");
        lblError.setText(errors.stream().collect(Collectors.joining()));

        return errors;
    }

    private void search() {

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            public void update() {
                Helper.JTableMain.showData(tblShow, true, txtSearch.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExportExcelCSV;
    private javax.swing.JButton btnExportPDF;
    private javax.swing.JButton btnFaker;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JProgressBar progressBarData;
    private javax.swing.JTable tblShow;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
