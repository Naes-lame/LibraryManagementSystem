/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//all goods!
package GUI;

import Controller.UsersController;
import Models.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginForm extends javax.swing.JFrame implements imagesNbuttons {

    public LoginForm() {
        initComponents();
        scaleImage();
        String aP = "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png";
        ImageIcon icon = new ImageIcon(aP);
        setIconImage(icon.getImage());

        KeyAdapter preventLeadingSpaces = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JTextField field = (JTextField) e.getSource();
                if (field.getText().isEmpty() && e.getKeyChar() == ' ') {
                    e.consume();
                }
            }
        };

        txt_username.addKeyListener(preventLeadingSpaces);
        txt_password.addKeyListener(preventLeadingSpaces);
    }

    private void scaleImage() {
        String[] paths = {
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\freepik3.jpg",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png"
        };

        JLabel[] labels = {bgPic, jlbl_wlcmMssg2};
        scaleImages(paths, labels);

        initializeButtons(btn_register);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbl_wlcm = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bgPic = new javax.swing.JLabel();
        jlbl_wlcmMssg2 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jtxt_mssg1 = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC Library Management System");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1011, 555));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbl_wlcm.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbl_wlcm.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm.setText("SCC Library Management System");
        jPanel1.add(jlbl_wlcm, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 6, -1, 53));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Login your account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 65, 170, 20));

        txt_username.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 118, 302, -1));

        btn_login.setBackground(new java.awt.Color(0, 0, 255));
        btn_login.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Login");
        btn_login.setBorder(null);
        btn_login.setBorderPainted(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 249, 302, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, 20));
        jPanel1.add(bgPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 65, 460, 390));

        jlbl_wlcmMssg2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbl_wlcmMssg2.setForeground(new java.awt.Color(72, 209, 204));
        jPanel1.add(jlbl_wlcmMssg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 20, 40, 28));
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 165, 302, -1));

        jtxt_mssg1.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        jtxt_mssg1.setText("New here?");
        jPanel1.add(jtxt_mssg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 60, -1));

        btn_register.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_register.setText("Create an account");
        btn_register.setBorderPainted(false);
        btn_register.setContentAreaFilled(false);
        btn_register.setFocusPainted(false);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        jPanel1.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 302, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        try {
            // Retrieve input values
            String username = txt_username.getText();
            String password = txt_password.getText();

            // Check if either field is empty
            StringBuilder errorMessage = new StringBuilder("Error: ");
            boolean error = false;
            if (username.trim().isEmpty()) {
                errorMessage.append("Username field is empty!\n");
                error = true;
            }
            if (password.trim().isEmpty()) {
                errorMessage.append("Password field is empty!\n");
                error = true;
            }
            if (error) {
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Retrieve the user based on the username
            Users matchUser = UsersController.getUserByUsername(username);

            if (matchUser != null) {
                int userId = matchUser.getUserId();  // Get userId for session tracking
                String storedHash = matchUser.getPassword();  // Hashed password from database

                if (Account.comparePasswords(password, storedHash)) {  // Validate password
                    // Store userId instead of username for session
                    SessionManager.setLoggedInUserId(userId);

                    JOptionPane.showMessageDialog(this, "User login successful!");
                    Users users = new Users();
                    users.setPassword(storedHash);
                    Dashboard db = new Dashboard();
                    db.show();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        RegisterForm rf = new RegisterForm();
        rf.show();
        dispose();
    }//GEN-LAST:event_btn_registerActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgPic;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbl_wlcm;
    private javax.swing.JLabel jlbl_wlcmMssg2;
    private javax.swing.JLabel jtxt_mssg1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
