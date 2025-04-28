/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import Controller.*;
import Models.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RegisterForm extends javax.swing.JFrame implements imagesNbuttons{

    public RegisterForm() {
        initComponents();
        scaleImage();
        initializeButtons();
    }
    
    private void scaleImage(){
        String[] paths = {
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\freepik3.jpg",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png"
        };      
        JLabel[] labels = { lbl_bgPhoto, jlbl_wlcmMssg1 };
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
        txt_name = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jtxt_mssg1 = new javax.swing.JLabel();
        jbtn_signUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlbl_wlcmMssg2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1011, 555));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lbl_bgPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 460, 390));

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
        jPanel1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, 60, 30));

        jlbl_wlcmMssg1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbl_wlcmMssg1.setForeground(new java.awt.Color(72, 209, 204));
        jPanel1.add(jlbl_wlcmMssg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 18, 40, 28));

        txt_fName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_fName.setText("Full Name:");
        jPanel1.add(txt_fName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 57, 14));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 255, 60, 10));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 57, 30));

        txt_eMail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_eMail.setText("E-mail:");
        jPanel1.add(txt_eMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        txt_name.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 162, 302, -1));

        txt_email.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 195, 302, -1));

        txt_username.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 249, 302, -1));

        txt_password.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 285, 302, -1));

        jtxt_mssg1.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        jtxt_mssg1.setText("Already have an account?");
        jPanel1.add(jtxt_mssg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, 30));

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
        jPanel1.add(jbtn_signUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 371, 302, 40));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Register your account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 60, 170, 20));

        jlbl_wlcmMssg2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jlbl_wlcmMssg2.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcmMssg2.setText("SCC Library Management System");
        jPanel1.add(jlbl_wlcmMssg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 6, -1, 53));

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
        try{
            if(txt_name.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(),"Error. Full Name is missing!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if(txt_email.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(),"Error. Email is missing!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if(txt_username.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(),"Error. Username is missing!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }if(txt_password.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(),"Error. Password is missing!","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String name = txt_name.getText();
            String email = txt_email.getText();
            String username = txt_username.getText();
            String password = txt_password.getText();
            
            Users users = new Users(name, email, username, password);
            boolean success = UsersController.addUser(users);
            
            if (success){
                JOptionPane.showMessageDialog(this, "User registered seccessfully!");
                LoginForm lf = new LoginForm();
                lf.show();
                dispose();
                
            }else{
                JOptionPane.showMessageDialog(this, "Error. User failed to register. Please try again.","Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Unexpected system issue. Please contact support.","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.","Error",JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel txt_eMail;
    private javax.swing.JTextField txt_email;
    private javax.swing.JLabel txt_fName;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
