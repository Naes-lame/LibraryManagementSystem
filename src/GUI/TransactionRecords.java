/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

//all goods
import Models.*;
import Controller.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransactionRecords extends javax.swing.JFrame implements imagesNbuttons {
        private int transactionId = -1;
        
    public TransactionRecords() {
        initComponents();
        ScaleImages();
        table("");
        populateComboBoxes();
        
        txt_searchfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String searchText = txt_searchfield.getText().trim();
                table(searchText); // Call your table function with the search text
            }
        });
        
        transactionRecordsTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    int selectedRow = transactionRecordsTable.getSelectedRow();
                    
                    if (selectedRow != -1){
                        transactionId = Integer.parseInt(transactionRecordsTable.getValueAt(selectedRow, 0).toString());
                        borrowerNameComboBox.setSelectedItem(transactionRecordsTable.getValueAt(selectedRow, 1).toString());
                        bookTitleComboBox.setSelectedItem(transactionRecordsTable.getValueAt(selectedRow, 2).toString());
                        System.out.println("selected transac id: "+ transactionId);
                    }
                }
            }
        });
    }
    
    private void populateComboBoxes() {
        TransactionsComboBoxHelper.populateComboBox(bookTitleComboBox, "SELECT book_title FROM bookrecords WHERE deleted_at IS NULL", "book_title", "-- Select Book Title --");
        TransactionsComboBoxHelper.populateComboBox(borrowerNameComboBox, "SELECT borrower_name FROM borrowerrecords WHERE deleted_at IS NULL", "borrower_name", "-- Select Borrower Name --");
    }

    private void table(String keyword) {
        List<Transactions> transaction = TransactionsController.getTransaction();

        DefaultTableModel model = (DefaultTableModel) transactionRecordsTable.getModel();
        model.setRowCount(0);

        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        for (Transactions tr : transaction) {

            String transactionDate = df.format(tr.getTransactionDate());
            String dueDate = df.format(tr.getDueDate());

            if (keyword == null || keyword.trim().isEmpty()
                    || tr.getStatus().toLowerCase().contains(keyword.toLowerCase())) {
                model.addRow(new Object[]{
                    tr.getTransactionId(),
                    tr.getBorrowerName(),
                    tr.getBookTitle(),
                    transactionDate,
                    dueDate,
                    tr.getStatus()
                });
            }
        }
        transactionRecordsTable.setModel(model);
        transactionRecordsTable.revalidate();
        
        transactionRecordsTable.getColumnModel().getColumn(0).setMinWidth(0);
        transactionRecordsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        transactionRecordsTable.getColumnModel().getColumn(0).setWidth(0);
    }


    

    private void ScaleImages() {
        String[] paths = {
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\dashboard_1828673.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\book_1361594.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\team_2630156.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\exchange_3583309.png",
            "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\avatar_7610196.png"
        };
        JLabel[] labels = {logo, dbIcon, bookIcon, BrrwrIcon, TrnsactIcon, AccIcon};
        scaleImages(paths, labels);

        initializeButtons(btn_dshbrd, btn_BRecords, btn_BrwrRecords, btn_trnsct);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txt_brrwr = new javax.swing.JLabel();
        txt_bk = new javax.swing.JLabel();
        btn_return = new javax.swing.JButton();
        btn_issue = new javax.swing.JButton();
        borrowerNameComboBox = new javax.swing.JComboBox<>();
        bookTitleComboBox = new javax.swing.JComboBox<>();
        txt_searchfield = new javax.swing.JTextField();
        btn_search2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionRecordsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setText("TRANSACTIONS");

        jPanel6.setBackground(new java.awt.Color(224, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 25, 112)));

        txt_brrwr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_brrwr.setText("Borrower Name:");

        txt_bk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_bk.setText("Book Title:");

        btn_return.setBackground(new java.awt.Color(25, 25, 112));
        btn_return.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setText("Return");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        btn_issue.setBackground(new java.awt.Color(25, 25, 112));
        btn_issue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_issue.setForeground(new java.awt.Color(255, 255, 255));
        btn_issue.setText("Issue");
        btn_issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issueActionPerformed(evt);
            }
        });

        borrowerNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bookTitleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_issue, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowerNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_brrwr)
                    .addComponent(txt_bk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(txt_brrwr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowerNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txt_bk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookTitleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btn_issue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchfieldActionPerformed(evt);
            }
        });

        btn_search2.setBackground(new java.awt.Color(25, 25, 112));
        btn_search2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_search2.setForeground(new java.awt.Color(255, 255, 255));
        btn_search2.setText("Search");
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
            }
        });

        transactionRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Borrower Name", "Book Title", "Transaction Date", "Due Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionRecordsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(transactionRecordsTable);
        if (transactionRecordsTable.getColumnModel().getColumnCount() > 0) {
            transactionRecordsTable.getColumnModel().getColumn(0).setResizable(false);
            transactionRecordsTable.getColumnModel().getColumn(1).setResizable(false);
            transactionRecordsTable.getColumnModel().getColumn(2).setResizable(false);
            transactionRecordsTable.getColumnModel().getColumn(3).setResizable(false);
            transactionRecordsTable.getColumnModel().getColumn(4).setResizable(false);
            transactionRecordsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_search2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    }//GEN-LAST:event_btn_trnsctActionPerformed

    private void btn_AccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccActionPerformed
        Account ac = new Account();
        ac.show();
        dispose();
    }//GEN-LAST:event_btn_AccActionPerformed

    private void txt_searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchfieldActionPerformed

    }//GEN-LAST:event_txt_searchfieldActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed
        String searchText = txt_searchfield.getText().trim();
        table(searchText);

    }//GEN-LAST:event_btn_search2ActionPerformed

    private void btn_issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issueActionPerformed
        try {
            // Validation of required fields.
            StringBuilder errorMessage = new StringBuilder("Error: ");
            boolean error = false;
            if (borrowerNameComboBox.getSelectedItem()== null) {
                errorMessage.append("Borrower Name field is empty!\n");
                error = true;
            }
            if (bookTitleComboBox.getSelectedItem()== null) {
                errorMessage.append("Book Title field is empty!\n");
                error = true;
            }
            if (error) {
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String borrowerName = borrowerNameComboBox.getSelectedItem().toString();
            String bookTitle = bookTitleComboBox.getSelectedItem().toString();

            // Set timestamps and status.
            Timestamp transactionDate = new Timestamp(System.currentTimeMillis());
            Timestamp dueDate = new Timestamp(System.currentTimeMillis());
            String status = "Issued";

            // Create transaction object.
            Transactions tr = new Transactions(transactionId, borrowerName, bookTitle, transactionDate, dueDate, status);
            boolean success = TransactionsController.issueBook(tr);

            if (success) {
                JOptionPane.showMessageDialog(this, "Book was issued successfully!");
                
                table("");  // Refresh or update table view
            } else {
                JOptionPane.showMessageDialog(this, "Failed to issue book. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_issueActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        try {
            String borrowerName = borrowerNameComboBox.getSelectedItem().toString();
            String bookTitle = bookTitleComboBox.getSelectedItem().toString();
            //validation
            StringBuilder errorMessage = new StringBuilder("Error: ");
            boolean error = false;
            if (borrowerNameComboBox.getSelectedItem() == null) {
                errorMessage.append("Borrower Name field is empty!\n");
                error = true;
            }
            if (bookTitleComboBox.getSelectedItem() == null) {
                errorMessage.append("Book Title field is empty!\n");
                error = true;
            }
            if (error) {
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String fetchBookIdQuery = "SELECT book_id FROM bookrecords WHERE book_title = ?";
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_database", "root", "");
                 PreparedStatement stmt = conn.prepareStatement(fetchBookIdQuery)) {

                stmt.setString(1, bookTitle);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    int bookId = rs.getInt("book_id"); // Now you have bookId correctly fetched
                    System.out.println("Fetched Book ID: " + bookId);
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found in database!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            

            //generating timestamps
            Timestamp transactionDate = new Timestamp(System.currentTimeMillis());

            Timestamp dueDate = new Timestamp(System.currentTimeMillis());
            //retrieving stats
            List<Transactions> transactions = TransactionsController.getTransaction();
            String status = transactions.isEmpty() ? "No Transactions Found" : transactions.get(0).getStatus();

            //grouping transaction details into object for easier manage.
            Transactions tr = new Transactions(transactionId,  borrowerName, bookTitle, transactionDate, dueDate, status);

            //calling the returnBooks method through the controller.
            boolean success = TransactionsController.returnBooks(tr);

            if (success) {
                JOptionPane.showMessageDialog(this, "Book was returned successfully!");
                
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to return book. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_returnActionPerformed

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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccIcon;
    private javax.swing.JLabel BrrwrIcon;
    private javax.swing.JLabel TrnsactIcon;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JComboBox<String> bookTitleComboBox;
    private javax.swing.JComboBox<String> borrowerNameComboBox;
    private javax.swing.JButton btn_Acc;
    private javax.swing.JButton btn_BRecords;
    private javax.swing.JButton btn_BrwrRecords;
    private javax.swing.JButton btn_dshbrd;
    private javax.swing.JButton btn_issue;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_trnsct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dbIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl_wlcm8;
    private javax.swing.JLabel logo;
    private javax.swing.JTable transactionRecordsTable;
    private javax.swing.JLabel txt_bk;
    private javax.swing.JLabel txt_brrwr;
    private javax.swing.JTextField txt_searchfield;
    // End of variables declaration//GEN-END:variables
}
