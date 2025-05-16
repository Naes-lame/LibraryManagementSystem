/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JLabel;
import java.util.List;
import Controller.IssuedBooksController;
import Models.IssuedBooks;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class IssuedBooksRecords extends javax.swing.JFrame implements imagesNbuttons {

    public IssuedBooksRecords() {
        initComponents();
        scaleImages();
        table("");
        String aP = "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png";
        ImageIcon icon = new ImageIcon(aP);
        setIconImage(icon.getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Dashboard dashboard = new Dashboard();
                dashboard.show();
                dispose();
            }
        });
    }

    private void scaleImages() {
        String[] paths = {
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\dashboard_1828673.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\book_1361594.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\team_2630156.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\exchange_3583309.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\avatar_7610196.png"
        };
        JLabel[] labels = {logo, dbIcon2, bookIcon, BrrwrIcon, TrnsactIcon, AccIcon};
        scaleImages(paths, labels);

        initializeButtons(btn_dshbrd2, btn_BRecords, btn_BrwrRecords, btn_trnsct, btn_Acc);
    }

    private void table(String keyword) {
        List<IssuedBooks> issuedBooks = IssuedBooksController.getIssuedBooks();

        DefaultTableModel model = (DefaultTableModel) issuedBooksRecordsTable.getModel();
        model.setRowCount(0);

        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        for (IssuedBooks issued : issuedBooks) {
            String issueDate = df.format(issued.getIssueDate());
            String dueDate = df.format(issued.getDueDate());

            model.addRow(new Object[]{
                issued.getTransactionId(),
                issued.getBorrowerName(),
                issued.getBookTitle(),
                issueDate,
                dueDate,
                issued.getStatus()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jlbl_wlcm8 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        dbIcon2 = new javax.swing.JLabel();
        btn_dshbrd2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        bookIcon = new javax.swing.JLabel();
        btn_BRecords = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        BrrwrIcon = new javax.swing.JLabel();
        btn_BrwrRecords = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        TrnsactIcon = new javax.swing.JLabel();
        btn_trnsct = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        AccIcon = new javax.swing.JLabel();
        btn_Acc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        issuedBooksRecordsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SCC Library Management System");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel7.setBackground(new java.awt.Color(224, 255, 255));

        jPanel8.setBackground(new java.awt.Color(224, 255, 255));

        btn_dshbrd2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_dshbrd2.setText("Dashboard");
        btn_dshbrd2.setBorderPainted(false);
        btn_dshbrd2.setContentAreaFilled(false);
        btn_dshbrd2.setFocusPainted(false);
        btn_dshbrd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dshbrd2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(dbIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dshbrd2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dbIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_dshbrd2))
        );

        jPanel9.setBackground(new java.awt.Color(224, 255, 255));

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(bookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BRecords)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_BRecords))
        );

        jPanel10.setBackground(new java.awt.Color(224, 255, 255));

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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(BrrwrIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_BrwrRecords)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BrrwrIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_BrwrRecords))
        );

        jPanel11.setBackground(new java.awt.Color(224, 255, 255));

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TrnsactIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trnsct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TrnsactIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_trnsct))
        );

        jPanel12.setBackground(new java.awt.Color(224, 255, 255));

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(AccIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Acc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AccIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Acc))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        issuedBooksRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Borrower Name", "Book Title", "Issue Date", "Due Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        issuedBooksRecordsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(issuedBooksRecordsTable);
        if (issuedBooksRecordsTable.getColumnModel().getColumnCount() > 0) {
            issuedBooksRecordsTable.getColumnModel().getColumn(0).setResizable(false);
            issuedBooksRecordsTable.getColumnModel().getColumn(1).setResizable(false);
            issuedBooksRecordsTable.getColumnModel().getColumn(2).setResizable(false);
            issuedBooksRecordsTable.getColumnModel().getColumn(3).setResizable(false);
            issuedBooksRecordsTable.getColumnModel().getColumn(4).setResizable(false);
            issuedBooksRecordsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setText("ISSUED BOOKS RECORDS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

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

    private void btn_dshbrd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dshbrd2ActionPerformed
        Dashboard db = new Dashboard();
        db.show();
        dispose();
    }//GEN-LAST:event_btn_dshbrd2ActionPerformed

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
        Account ac = new Account();
        ac.show();
        dispose();
    }//GEN-LAST:event_btn_AccActionPerformed

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
            java.util.logging.Logger.getLogger(IssuedBooksRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBooksRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBooksRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBooksRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBooksRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccIcon;
    private javax.swing.JLabel BrrwrIcon;
    private javax.swing.JLabel TrnsactIcon;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JButton btn_Acc;
    private javax.swing.JButton btn_BRecords;
    private javax.swing.JButton btn_BrwrRecords;
    private javax.swing.JButton btn_dshbrd2;
    private javax.swing.JButton btn_trnsct;
    private javax.swing.JLabel dbIcon2;
    private javax.swing.JTable issuedBooksRecordsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl_wlcm8;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
