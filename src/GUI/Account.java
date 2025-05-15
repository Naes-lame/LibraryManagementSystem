/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

//DOESN'T REFRESH UI AFTER UPDATING 
import Controller.UsersController;
import Models.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Account extends javax.swing.JFrame implements imagesNbuttons {

    public Account() {
        initComponents();
        scaleImages();
        loadUserData();
    }

    private void loadUserData() {
        String username = SessionManager.getLoggedInUsername();

        if (username == null || username.isEmpty()) {
            System.out.println("No user logged in!");
            return;
        }
        Users user = UsersController.getLoggedInUser(username);

        if (user != null) {
            SessionManager.setLoggedInUserId(user.getUserId());
            SessionManager.setLoggedInUsername(user.getUsername());

            txt_username.setText(user.getUsername());
            txt_email.setText(user.getEmail());

            usernameTextField.setText(user.getUsername());
            fullNameTextField.setText(user.getFullName());
            phoneNumberTextField.setText(String.valueOf(user.getPhoneNum()));
            emailTextField.setText(user.getEmail());
            addressTextField.setText(user.getAddress());
            passwordTextField.setText(user.getPassword());
        } else {
            System.out.println("User not found! Make sure database contains this username.");
        }
    }

    private void refreshData() {
        String username = SessionManager.getLoggedInUsername();

        Users user = UsersController.getLoggedInUser(username);

        txt_username.setText(user.getUsername());
        txt_email.setText(user.getEmail());
        usernameTextField.setText(user.getUsername());
        fullNameTextField.setText(user.getFullName());
        phoneNumberTextField.setText(String.valueOf(user.getPhoneNum()));
        emailTextField.setText(user.getEmail());
        addressTextField.setText(user.getAddress());
        passwordTextField.setText(user.getPassword());
    }

    private void scaleImages() {
        String[] paths = {
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\dashboard_1828673.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\book_1361594.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\team_2630156.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\exchange_3583309.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\avatar_7610196.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\avatar_7610196.png"
        };
        JLabel[] labels = {logo, dbIcon, bookIcon, BrrwrIcon, TrnsactIcon, AccIcon, pfp};
        scaleImages(paths, labels);

        initializeButtons(btn_dshbrd, btn_BRecords, btn_BrwrRecords, btn_trnsct, btn_Acc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dbIcon = new javax.swing.JLabel();
        btn_dshbrd = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        bookIcon = new javax.swing.JLabel();
        btn_BRecords = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        BrrwrIcon = new javax.swing.JLabel();
        btn_BrwrRecords = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        TrnsactIcon = new javax.swing.JLabel();
        btn_trnsct = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        AccIcon = new javax.swing.JLabel();
        btn_Acc = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jlbl_wlcm8 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_username = new javax.swing.JLabel();
        txt_email = new javax.swing.JLabel();
        txt_name2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pfp = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        adress = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        usernameTextField = new javax.swing.JTextField();
        fullNameTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        btn_logout1 = new javax.swing.JButton();
        adress1 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        adress2 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        adress3 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(224, 255, 255));

        jPanel4.setBackground(new java.awt.Color(224, 255, 255));

        btn_dshbrd.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_dshbrd.setText("Dashboard");
        btn_dshbrd.setBorderPainted(false);
        btn_dshbrd.setContentAreaFilled(false);
        btn_dshbrd.setFocusPainted(false);
        btn_dshbrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dshbrdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dshbrd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_dshbrd))
        );

        jPanel5.setBackground(new java.awt.Color(224, 255, 255));

        btn_BRecords.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_BRecords.setText("Book Records");
        btn_BRecords.setBorderPainted(false);
        btn_BRecords.setContentAreaFilled(false);
        btn_BRecords.setFocusPainted(false);
        btn_BRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BRecordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(bookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BRecords)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_BRecords))
        );

        jPanel9.setBackground(new java.awt.Color(224, 255, 255));

        btn_BrwrRecords.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_BrwrRecords.setText("Borrower Records");
        btn_BrwrRecords.setBorderPainted(false);
        btn_BrwrRecords.setContentAreaFilled(false);
        btn_BrwrRecords.setFocusPainted(false);
        btn_BrwrRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BrwrRecordsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(BrrwrIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BrwrRecords)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BrrwrIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_BrwrRecords))
        );

        jPanel10.setBackground(new java.awt.Color(224, 255, 255));

        btn_trnsct.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_trnsct.setText("Transactions");
        btn_trnsct.setBorderPainted(false);
        btn_trnsct.setContentAreaFilled(false);
        btn_trnsct.setFocusPainted(false);
        btn_trnsct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trnsctActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TrnsactIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trnsct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TrnsactIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_trnsct))
        );

        jPanel11.setBackground(new java.awt.Color(224, 255, 255));

        btn_Acc.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_Acc.setText("Account");
        btn_Acc.setBorderPainted(false);
        btn_Acc.setContentAreaFilled(false);
        btn_Acc.setFocusPainted(false);
        btn_Acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(AccIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Acc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AccIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Acc))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 570));

        jPanel16.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm8.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm8.setText("SCC Library Management System");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm8)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setFont(new java.awt.Font("Calibri", 2, 24)); // NOI18N
        txt_username.setText("Username");
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 107, 155, -1));

        txt_email.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(102, 102, 102));
        txt_email.setText("email");
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 143, 164, -1));

        txt_name2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txt_name2.setText("Edit Personal Information:");
        jPanel2.add(txt_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 46, -1, -1));

        name.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        name.setText("Username:");
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 112, 64, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Admin Profile");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 17, -1, -1));
        jPanel2.add(pfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 68, 155, 140));

        phone.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        phone.setText("Full Name:");
        jPanel2.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 148, -1, -1));

        adress.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        adress.setText("Phone Number:");
        jPanel2.add(adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 178, -1, -1));

        updateBtn.setBackground(new java.awt.Color(25, 25, 112));
        updateBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel2.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 365, 169, 35));

        usernameTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 109, 169, -1));

        fullNameTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(fullNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 142, 169, -1));

        phoneNumberTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(phoneNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 175, 169, -1));

        btn_logout1.setBackground(new java.awt.Color(25, 25, 112));
        btn_logout1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_logout1.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout1.setText("Logout");
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 169, 35));

        adress1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        adress1.setText("Email:");
        jPanel2.add(adress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 211, 50, -1));

        emailTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 208, 169, -1));

        adress2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        adress2.setText("Address:");
        jPanel2.add(adress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 244, 50, -1));

        addressTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 241, 169, -1));

        adress3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        adress3.setText("Password:");
        jPanel2.add(adress3, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 277, 70, -1));

        passwordTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 274, 169, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 820, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dshbrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dshbrdActionPerformed
        Dashboard db = new Dashboard();
        db.show();
        dispose();
    }//GEN-LAST:event_btn_dshbrdActionPerformed

    private void btn_BRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BRecordsActionPerformed
        BookRecords br = new BookRecords();
        br.show();
        dispose();
    }//GEN-LAST:event_btn_BRecordsActionPerformed

    private void btn_BrwrRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrwrRecordsActionPerformed
        BorrowerRecords br = new BorrowerRecords();
        br.show();
        dispose();
    }//GEN-LAST:event_btn_BrwrRecordsActionPerformed

    private void btn_trnsctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trnsctActionPerformed
        TransactionRecords tr = new TransactionRecords();
        tr.show();
        dispose();
    }//GEN-LAST:event_btn_trnsctActionPerformed

    private void btn_AccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccActionPerformed
    }//GEN-LAST:event_btn_AccActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            StringBuilder errorMessage = new StringBuilder("Error:\n");
            boolean error = false;

            if (usernameTextField.getText().trim().isEmpty()) {
                errorMessage.append("Username field is empty!\n");
                error = true;
            }
            if (fullNameTextField.getText().trim().isEmpty()) {
                errorMessage.append("Full Name field is empty!\n");
                error = true;
            }
            if (phoneNumberTextField.getText().trim().isEmpty()) {
                errorMessage.append("Phone Number field is empty!");
                error = true;
            } else if (!phoneNumberTextField.getText().matches("\\d+")) {
                errorMessage.append("Invalid input! Whole numbers only.\n");
                error = true;
            } else if (phoneNumberTextField.getText().trim().length() != 11) {
                errorMessage.append("Invalid input! Phone Number must be 11 digits\n");
                error = true;
            }
            if (emailTextField.getText().trim().isEmpty()) {
                errorMessage.append("Email field is empty!\n");
                error = true;
            } else if (!emailTextField.getText().matches("^[\\w.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|icloud\\.com)$")) {
                errorMessage.append("Invalid email input! Please try again.\n");
                error = true;
            }
            if (addressTextField.getText().trim().isEmpty()) {
                errorMessage.append("Address field is empty!\n");
                error = true;
            }
            if (passwordTextField.getText().trim().isEmpty()) {
                errorMessage.append("Password field is empty!\n");
                error = true;
            }

            String fullname = fullNameTextField.getText().trim();
            String email = emailTextField.getText().trim();
            long phoneNumber = Long.parseLong(phoneNumberTextField.getText().trim());
            String address = addressTextField.getText().trim();
            String username = usernameTextField.getText().trim();
            String password = passwordTextField.getText().trim();

            int userId = SessionManager.getLoggedInUserId();
            Users users = new Users(userId, fullname, email, phoneNumber, address, username, password);
            boolean success = UsersController.updateUserInfo(users);

            if (success) {
                JOptionPane.showMessageDialog(this, "Admin info updated successfully!");

                Users user = new Users();

                user.setFullName(fullname);
                user.setEmail(email);
                user.setPhoneNum(phoneNumber);
                user.setAddress(address);
                user.setUsername(username);
                user.setPassword(password);
                loadUserData();}
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout1ActionPerformed
        LoginForm lf = new LoginForm();
        lf.show();
        dispose();
    }//GEN-LAST:event_btn_logout1ActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccIcon;
    private javax.swing.JLabel BrrwrIcon;
    private javax.swing.JLabel TrnsactIcon;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel adress;
    private javax.swing.JLabel adress1;
    private javax.swing.JLabel adress2;
    private javax.swing.JLabel adress3;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JButton btn_Acc;
    private javax.swing.JButton btn_BRecords;
    private javax.swing.JButton btn_BrwrRecords;
    private javax.swing.JButton btn_dshbrd;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JButton btn_trnsct;
    private javax.swing.JLabel dbIcon;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField fullNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jlbl_wlcm8;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel name;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel pfp;
    private javax.swing.JLabel phone;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JLabel txt_email;
    private javax.swing.JLabel txt_name2;
    private javax.swing.JLabel txt_username;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
