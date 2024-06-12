package view;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import database.DatabaseConnection;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author AN
 */
public class Register extends javax.swing.JFrame {

    int attempts;
    private static PublicKey serverPublicKey;

    /**
     * Creates new form Login
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datetxt = new javax.swing.JTextField();
        repasswordtxt = new javax.swing.JPasswordField();
        Register = new com.k33ptoo.components.KButton();
        jLabel4 = new javax.swing.JLabel();
        login = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fullnametxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passwordtxt = new javax.swing.JPasswordField();
        idtxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("WELCOME TO TECH");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 240, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Re-enter password:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Birth Date:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, -1));

        datetxt.setBackground(new java.awt.Color(238, 235, 235));
        datetxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        datetxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        datetxt.setToolTipText("");
        datetxt.setActionCommand("<Not Set>");
        datetxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        datetxt.setCaretColor(new java.awt.Color(51, 153, 255));
        datetxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datetxt.setSelectionColor(new java.awt.Color(51, 153, 255));
        jPanel4.add(datetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 340, 35));

        repasswordtxt.setBackground(new java.awt.Color(238, 235, 235));
        repasswordtxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        repasswordtxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        repasswordtxt.setCaretColor(new java.awt.Color(51, 153, 255));
        repasswordtxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        repasswordtxt.setDoubleBuffered(true);
        repasswordtxt.setEchoChar('.');
        jPanel4.add(repasswordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 340, 35));

        Register.setForeground(new java.awt.Color(0, 0, 0));
        Register.setText("REGISTER");
        Register.setToolTipText("");
        Register.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        Register.setkBorderRadius(20);
        Register.setkEndColor(new java.awt.Color(255, 255, 255));
        Register.setkHoverEndColor(new java.awt.Color(51, 153, 255));
        Register.setkHoverForeGround(new java.awt.Color(51, 153, 255));
        Register.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Register.setkPressedColor(new java.awt.Color(255, 255, 255));
        Register.setkSelectedColor(new java.awt.Color(255, 255, 255));
        Register.setkStartColor(new java.awt.Color(51, 153, 255));
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        jPanel4.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 300, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Password:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setText("LOGIN");
        login.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        login.setkBorderRadius(20);
        login.setkEndColor(new java.awt.Color(255, 255, 255));
        login.setkHoverEndColor(new java.awt.Color(51, 153, 255));
        login.setkHoverForeGround(new java.awt.Color(51, 153, 255));
        login.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        login.setkPressedColor(new java.awt.Color(255, 255, 255));
        login.setkSelectedColor(new java.awt.Color(255, 255, 255));
        login.setkStartColor(new java.awt.Color(51, 153, 255));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel4.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 300, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setText("Username:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        usertxt.setBackground(new java.awt.Color(238, 235, 235));
        usertxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usertxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usertxt.setToolTipText("");
        usertxt.setActionCommand("<Not Set>");
        usertxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        usertxt.setCaretColor(new java.awt.Color(51, 153, 255));
        usertxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usertxt.setSelectionColor(new java.awt.Color(51, 153, 255));
        jPanel4.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 340, 35));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 255));
        jLabel6.setText("Full Name:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        fullnametxt.setBackground(new java.awt.Color(238, 235, 235));
        fullnametxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullnametxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fullnametxt.setToolTipText("");
        fullnametxt.setActionCommand("<Not Set>");
        fullnametxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fullnametxt.setCaretColor(new java.awt.Color(51, 153, 255));
        fullnametxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fullnametxt.setSelectionColor(new java.awt.Color(51, 153, 255));
        jPanel4.add(fullnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 340, 35));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setText("Citizen ID:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        passwordtxt.setBackground(new java.awt.Color(238, 235, 235));
        passwordtxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        passwordtxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        passwordtxt.setCaretColor(new java.awt.Color(51, 153, 255));
        passwordtxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordtxt.setDoubleBuffered(true);
        passwordtxt.setEchoChar('.');
        passwordtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordtxtActionPerformed(evt);
            }
        });
        jPanel4.add(passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 340, 35));

        idtxt.setBackground(new java.awt.Color(238, 235, 235));
        idtxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        idtxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        idtxt.setToolTipText("");
        idtxt.setActionCommand("<Not Set>");
        idtxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        idtxt.setCaretColor(new java.awt.Color(51, 153, 255));
        idtxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        idtxt.setSelectionColor(new java.awt.Color(51, 153, 255));
        jPanel4.add(idtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 340, 35));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        String username = usertxt.getText().trim();
        String password = new String(passwordtxt.getPassword());
        String fullName = fullnametxt.getText().trim();
        String citizenID = idtxt.getText();
        String date = datetxt.getText().trim();
        String reEnterPassword = new String(repasswordtxt.getPassword());

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty.", "Invalid Username", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Full Name cannot be empty.", "Invalid Full Name", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (citizenID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Citizen ID cannot be empty.", "Invalid Citizen ID", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (date.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Date cannot be empty.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(reEnterPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isRegistered = registerUser("register",username, password,fullName,citizenID,date);
        if (isRegistered) {
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to register user. Please try again later.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RegisterActionPerformed
    
     private boolean registerUser(String requestType,String username, String password, String fullname, String citizenID, String date) {
        try (Socket socket = new Socket("192.168.1.22", 1236);
             OutputStream output = socket.getOutputStream();
             ObjectOutputStream objectOutput = new ObjectOutputStream(output);
             InputStream input = socket.getInputStream();
             ObjectInputStream objectInput = new ObjectInputStream(input)) {

            objectOutput.writeObject(new String[]{username, password, fullname, citizenID, date});
            objectOutput.flush();

            boolean isRegistered = objectInput.readBoolean();
            return isRegistered;

        } catch (EOFException eofEx) {
        } catch (IOException ioEx) {
        }
        return false;
}

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void passwordtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordtxtActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton Register;
    private javax.swing.JTextField datetxt;
    private javax.swing.JTextField fullnametxt;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private com.k33ptoo.components.KButton login;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JPasswordField repasswordtxt;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables

}
