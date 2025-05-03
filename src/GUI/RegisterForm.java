/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

//all goods
import Controller.*;
import Models.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RegisterForm extends javax.swing.JFrame implements imagesNbuttons {

    public RegisterForm() {
        initComponents();
        scaleImage();
        initializeButtons();
    }

    private void scaleImage() {
        String[] paths = {
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\freepik3.jpg",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png"
        };
        JLabel[] labels = {lbl_bgPhoto, jlbl_wlcmMssg1};
        scaleImages(paths, labels);

        initializeButtons(btn_login);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_bgPhoto = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        jlbl_wlcmMssg1 = new javax.swing.JLabel();
        txt_fName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_eMail = new javax.swing.JLabel();
        txt_fullname = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jtxt_mssg1 = new javax.swing.JLabel();
        jbtn_signUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlbl_wlcmMssg2 = new javax.swing.JLabel();
        txt_eMail1 = new javax.swing.JLabel();
        txt_phonenumber = new javax.swing.JTextField();
        txt_eMail2 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1011, 555));

        btn_login.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_login.setText("Login");
        btn_login.setBorderPainted(false);
        btn_login.setContentAreaFilled(false);
        btn_login.setFocusPainted(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jlbl_wlcmMssg1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbl_wlcmMssg1.setForeground(new java.awt.Color(72, 209, 204));

        txt_fName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_fName.setText("Full Name:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Password:");

        txt_eMail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_eMail.setText("E-mail:");

        txt_fullname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        txt_email.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        txt_username.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        txt_password.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        jtxt_mssg1.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        jtxt_mssg1.setText("Already have an account?");

        jbtn_signUp.setBackground(new java.awt.Color(0, 0, 255));
        jbtn_signUp.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbtn_signUp.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_signUp.setText("Sign Up");
        jbtn_signUp.setBorder(null);
        jbtn_signUp.setBorderPainted(false);
        jbtn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_signUpActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Register your account");

        jlbl_wlcmMssg2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbl_wlcmMssg2.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcmMssg2.setText("SCC Library Management System");

        txt_eMail1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_eMail1.setText("Phone No. :");

        txt_phonenumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        txt_eMail2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_eMail2.setText("Address:");

        txt_address.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_bgPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtn_signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxt_mssg1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_eMail)
                                    .addComponent(txt_fName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_eMail1)
                                    .addComponent(txt_eMail2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(524, 524, 524)
                .addComponent(jlbl_wlcmMssg1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcmMssg2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jlbl_wlcmMssg1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbl_wlcmMssg2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bgPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_eMail))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_eMail1))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_eMail2))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jbtn_signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_mssg1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        LoginForm lf = new LoginForm();
        lf.show();
        dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed

    }//GEN-LAST:event_txt_passwordActionPerformed

    private void jbtn_signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_signUpActionPerformed

        try {
            String name = txt_fullname.getText();
            String email = txt_email.getText();
            long phoneNum = Long.parseLong(txt_phonenumber.getText().trim());
            String address = txt_address.getText();
            String username = txt_username.getText();
            String password = txt_password.getText();

            StringBuilder errorMessage = new StringBuilder("Error: ");//catching empty fields.
            boolean error = false;
            if (txt_fullname.getText().trim().isEmpty()) {
                errorMessage.append("Full Name field is empty!\n");
                error = true;//confirm error.
            }
            if (txt_email.getText().trim().isEmpty()) {
                errorMessage.append("Email field is empty!\n");
                error = true;
            } else if (!email.matches("^[\\w.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|icloud\\.com)$")) {
                errorMessage.append("Invalid email input! Please try again.\n");
                error = true;
            }
            if (txt_phonenumber.getText().trim().isEmpty()) {
                errorMessage.append("Phone Number field is empty!\n");
                error = true;
            } else if (!txt_phonenumber.getText().matches("\\d+")) {
                errorMessage.append("Invalid input! Whole numbers only.\n");
                error = true;

            } else if (txt_phonenumber.getText().trim().length() != 11) {
                errorMessage.append("Invalid input! Phone Number must be 11 digits\n");
                error = true;
            }if (txt_address.getText().trim().isEmpty()) {
                errorMessage.append("Address field is empty!\n");
                error = true;
            }
            if (txt_username.getText().trim().isEmpty()) {
                errorMessage.append("Username field is empty!\n");
                error = true;
            }
            if (txt_password.getText().trim().isEmpty()) {
                errorMessage.append("Password field is empty!\n");
                error = true;
            }else if(txt_password.getText().trim().length() < 6){
                errorMessage.append("Invalid input! Password must be more than 6 characters.\n");
                error = true;
            }
            if (error) {
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);//error message for a specific field.
                return;
            }

            Users users = new Users(name, email, phoneNum, address, username, password);
            boolean success = UsersController.addUser(users);

            if (success) {
                JOptionPane.showMessageDialog(this, "User registered seccessfully!");
                LoginForm lf = new LoginForm();
                lf.show();
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Error. User failed to register. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtn_signUpActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_signUp;
    private javax.swing.JLabel jlbl_wlcmMssg1;
    private javax.swing.JLabel jlbl_wlcmMssg2;
    private javax.swing.JLabel jtxt_mssg1;
    private javax.swing.JLabel lbl_bgPhoto;
    private javax.swing.JTextField txt_address;
    private javax.swing.JLabel txt_eMail;
    private javax.swing.JLabel txt_eMail1;
    private javax.swing.JLabel txt_eMail2;
    private javax.swing.JTextField txt_email;
    private javax.swing.JLabel txt_fName;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_phonenumber;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
