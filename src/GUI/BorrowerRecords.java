/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//All Goods!
package GUI;

import Controller.BorrowersController;
import Models.Borrowers;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BorrowerRecords extends javax.swing.JFrame implements imagesNbuttons {

    private int selectedBorrowerId = -1;

    public BorrowerRecords() {
        initComponents();
        scaleImages();
        initializeButtons();
        table("");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Dashboard dashboard = new Dashboard();
                dashboard.show();
                dispose();
            }
        });
        String aP = "C:\\Users\\Sean Cole Calixton\\OneDrive\\Pictures\\Camera Roll\\logo-removebg-preview.png";
        ImageIcon icon = new ImageIcon(aP);
        setIconImage(icon.getImage());
        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String searchText = txt_search.getText().trim();
                table(searchText);
            }
        });

        borrowerRecordsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = borrowerRecordsTable.getSelectedRow();

                    if (selectedRow != -1) {
                        selectedBorrowerId = Integer.parseInt(borrowerRecordsTable.getValueAt(selectedRow, 0).toString());
                        txtName.setText(borrowerRecordsTable.getValueAt(selectedRow, 1).toString());
                        txtAddress.setText(borrowerRecordsTable.getValueAt(selectedRow, 2).toString());
                        txtPhoneNumber.setText(borrowerRecordsTable.getValueAt(selectedRow, 3).toString());
                        txtEmail.setText(borrowerRecordsTable.getValueAt(selectedRow, 4).toString()); // ✅ Fixed missing `.toString()`
                    }
                }
            }
        });

        KeyAdapter preventLeadingSpaces = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JTextField field = (JTextField) e.getSource();
                if (field.getText().isEmpty() && e.getKeyChar() == ' ') {
                    e.consume();
                }
            }
        };

        txt_search.addKeyListener(preventLeadingSpaces);
        txtName.addKeyListener(preventLeadingSpaces);
        txtAddress.addKeyListener(preventLeadingSpaces);
        txtPhoneNumber.addKeyListener(preventLeadingSpaces);
        txtEmail.addKeyListener(preventLeadingSpaces);
    }

    private void table(String keyword) {
        List<Borrowers> borrowers = BorrowersController.getBorrower();

        DefaultTableModel model = (DefaultTableModel) borrowerRecordsTable.getModel();
        model.setRowCount(0);

        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        for (Borrowers b : borrowers) {  // Loop through each Borrowers object
            String formattedDate = df.format(b.getMembershipDate());

            if (keyword == null || keyword.trim().isEmpty()
                    || b.getName().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAddress().toLowerCase().contains(keyword.toLowerCase())
                    || b.getEmail().toLowerCase().contains(keyword.toLowerCase())) {

                model.addRow(new Object[]{
                    b.getBorrowerId(),
                    b.getName(),
                    b.getAddress(),
                    b.getPhone(),
                    b.getEmail(),
                    formattedDate
                });
            }
        }
        borrowerRecordsTable.setModel(model);
        borrowerRecordsTable.revalidate();

        borrowerRecordsTable.getColumnModel().getColumn(0).setMinWidth(0);
        borrowerRecordsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        borrowerRecordsTable.getColumnModel().getColumn(0).setWidth(0);
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
        JLabel[] labels = {logo, dbIcon, bookIcon, BrrwrIcon, TrnsactIcon, AccIcon};
        scaleImages(paths, labels);

        initializeButtons(btn_dshbrd, btn_BRecords, btn_BrwrRecords, btn_trnsct, btn_Acc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlbl_wlcm = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jlbl_wlcm1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlbl_wlcm2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jlbl_wlcm3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jlbl_wlcm4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jlbl_wlcm5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jlbl_wlcm6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jlbl_wlcm7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        borrowerRecordsTable = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search2 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        txt_brrwr = new javax.swing.JLabel();
        txt_bk = new javax.swing.JLabel();
        txt_q = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        isbn = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm.setText("SCC Library Management System");

        jPanel6.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm1.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm1.setText("SCC Library Management System");

        jPanel7.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm2.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm2.setText("SCC Library Management System");

        jPanel8.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm3.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm3.setText("SCC Library Management System");

        jPanel12.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm4.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm4.setText("SCC Library Management System");

        jPanel13.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm5.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm5.setText("SCC Library Management System");

        jPanel14.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm6.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm6.setText("SCC Library Management System");

        jPanel15.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm7.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm7.setText("SCC Library Management System");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm7)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm6)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm5)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm4)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm3)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm2)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm1)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SCC Library Management System");
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
        jLabel1.setText("BORROWER RECORDS");

        borrowerRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Phone", "Email", "Membership Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        borrowerRecordsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(borrowerRecordsTable);
        if (borrowerRecordsTable.getColumnModel().getColumnCount() > 0) {
            borrowerRecordsTable.getColumnModel().getColumn(0).setResizable(false);
            borrowerRecordsTable.getColumnModel().getColumn(1).setResizable(false);
            borrowerRecordsTable.getColumnModel().getColumn(2).setResizable(false);
            borrowerRecordsTable.getColumnModel().getColumn(3).setResizable(false);
            borrowerRecordsTable.getColumnModel().getColumn(4).setResizable(false);
            borrowerRecordsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
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

        jPanel17.setBackground(new java.awt.Color(224, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 25, 112)));

        txt_brrwr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_brrwr.setText("Name:");

        txt_bk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_bk.setText("Address:");

        txt_q.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_q.setText("Email:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(25, 25, 112));
        btn_update.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(25, 25, 112));
        btn_add.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        isbn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        isbn.setText("Phone No. :");

        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(25, 25, 112));
        btn_delete.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bk)
                            .addComponent(txt_brrwr))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtName)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_q, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_brrwr)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bk)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbn))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_q)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btn_search2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_search2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))))))
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

    private void btn_trnsctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trnsctActionPerformed
        TransactionRecords tr = new TransactionRecords();
        tr.show();
        dispose();
    }//GEN-LAST:event_btn_trnsctActionPerformed

    private void btn_BrwrRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrwrRecordsActionPerformed

    }//GEN-LAST:event_btn_BrwrRecordsActionPerformed

    private void btn_AccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccActionPerformed
        Account ac = new Account();
        ac.show();
        dispose();
    }//GEN-LAST:event_btn_AccActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed
        String searchText = txt_search.getText().trim();
        table(searchText);

    }//GEN-LAST:event_btn_search2ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            String name = txtName.getText().trim();
            String address = txtAddress.getText().trim();
            String email = txtEmail.getText().trim();
            String phoneNum = txtPhoneNumber.getText().trim();

            StringBuilder errorMessage = new StringBuilder("Error:");
            boolean error = false;

            if (txtName.getText().trim().isEmpty()) {
                errorMessage.append(" Name field is empty!\n");
                error = true;
            }
            if (txtAddress.getText().trim().isEmpty()) {
                errorMessage.append(" Address field is empty!\n");
                error = true;
            }
            if (txtPhoneNumber.getText().trim().isEmpty()) {
                errorMessage.append("Phone Number field is empty!\n");
                error = true;
            } else if (!txtPhoneNumber.getText().matches("\\d+")) {
                errorMessage.append("Invalid input! Whole numbers only.\n");
                error = true;
            } else if (txtPhoneNumber.getText().trim().length() != 11) {
                errorMessage.append("Invalid input! Phone Number must be 11 digits\n");
                error = true;
            }
            if (txtEmail.getText().trim().isEmpty()) {
                errorMessage.append("Email field is empty!\n");
                error = true;
            } else if (!email.matches("^[\\w.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|icloud\\.com)$")) {
                errorMessage.append("Invalid email input! Please try again.\n");
                error = true;
            }

            if (error) {
                JOptionPane.showMessageDialog(this, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedBorrowerId == -1 || selectedBorrowerId == 0) {
                JOptionPane.showMessageDialog(this, "No valid borrower selected for update!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Timestamp membershipDate = new Timestamp(System.currentTimeMillis());

            Borrowers b = new Borrowers(selectedBorrowerId, name, address, phoneNum, email, membershipDate);
            boolean success = BorrowersController.updateBorrower(b); // ✅ Ensure update method is called instead of addBorrower

            if (success) {
                JOptionPane.showMessageDialog(this, "Borrower updated successfully!");
                txtName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update borrower.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String name = txtName.getText().trim();
            String address = txtAddress.getText().trim();
            String email = txtEmail.getText().trim();
            String phoneNum = txtPhoneNumber.getText().trim();

            StringBuilder errorMessage = new StringBuilder("Error:");
            boolean error = false;

            if (txtName.getText().trim().isEmpty()) {
                errorMessage.append(" Name field is empty!\n");
                error = true;
            }
            if (txtAddress.getText().trim().isEmpty()) {
                errorMessage.append(" Address field is empty!\n");
                error = true;
            }
            if (txtPhoneNumber.getText().trim().isEmpty()) {
                errorMessage.append("Phone Number field is empty!\n");
                error = true;
            } else if (!txtPhoneNumber.getText().matches("\\d+")) {
                errorMessage.append("Invalid input! Whole numbers only.\n");
                error = true;
            } else if (txtPhoneNumber.getText().trim().length() != 11) {
                errorMessage.append("Invalid input! Phone Number must be 11 digits\n");
                error = true;
            }
            if (txtEmail.getText().trim().isEmpty()) {
                errorMessage.append("Email field is empty!\n");
                error = true;
            } else if (!email.matches("^[\\w.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|icloud\\.com)$")) {
                errorMessage.append("Invalid email input! Please try again.\n");
                error = true;
            }

            if (error) {
                JOptionPane.showMessageDialog(this, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Timestamp membershipDate = new Timestamp(System.currentTimeMillis());
            Borrowers b = new Borrowers(selectedBorrowerId, name, address, phoneNum, email, membershipDate);
            boolean success = BorrowersController.addBorrower(b);

            if (success) {
                JOptionPane.showMessageDialog(this, "Borrower updated successfully!");
                txtName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update borrower.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            String name = txtName.getText().trim();
            String address = txtAddress.getText().trim();
            String email = txtEmail.getText().trim();
            String phoneNum = txtPhoneNumber.getText().trim();

            StringBuilder errorMessage = new StringBuilder("Error:");
            boolean error = false;

            if (txtName.getText().trim().isEmpty()) {
                errorMessage.append(" Name field is empty!\n");
                error = true;
            }
            if (txtAddress.getText().trim().isEmpty()) {
                errorMessage.append(" Address field is empty!\n");
                error = true;
            }
            if (txtPhoneNumber.getText().trim().isEmpty()) {
                errorMessage.append("Phone Number field is empty!\n");
                error = true;
            } else if (!txtPhoneNumber.getText().matches("\\d+")) {
                errorMessage.append("Invalid input! Whole numbers only.\n");
                error = true;
            } else if (txtPhoneNumber.getText().trim().length() != 11) {
                errorMessage.append("Invalid input! Phone Number must be 11 digits\n");
                error = true;
            }
            if (txtEmail.getText().trim().isEmpty()) {
                errorMessage.append("Email field is empty!\n");
                error = true;
            } else if (!email.matches("^[\\w.-]+@(gmail\\.com|outlook\\.com|yahoo\\.com|icloud\\.com)$")) {
                errorMessage.append("Invalid email input! Please try again.\n");
                error = true;
            }

            if (error) {
                JOptionPane.showMessageDialog(this, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedBorrowerId == -1 || selectedBorrowerId == 0) {
                JOptionPane.showMessageDialog(this, "No valid book selected for update!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Timestamp membershipDate = new Timestamp(System.currentTimeMillis());
            Borrowers b = new Borrowers(selectedBorrowerId, name, address, phoneNum, email, membershipDate);
            boolean success = BorrowersController.deleteBorrowers(b);

            if (success) {
                JOptionPane.showMessageDialog(this, "Borrower deleted successfully!");
                txtName.setText("");
                txtAddress.setText("");
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete borrower.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(BorrowerRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowerRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowerRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowerRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowerRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccIcon;
    private javax.swing.JLabel BrrwrIcon;
    private javax.swing.JLabel TrnsactIcon;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JTable borrowerRecordsTable;
    private javax.swing.JButton btn_Acc;
    private javax.swing.JButton btn_BRecords;
    private javax.swing.JButton btn_BrwrRecords;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_dshbrd;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_trnsct;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel dbIcon;
    private javax.swing.JLabel isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl_wlcm;
    private javax.swing.JLabel jlbl_wlcm1;
    private javax.swing.JLabel jlbl_wlcm2;
    private javax.swing.JLabel jlbl_wlcm3;
    private javax.swing.JLabel jlbl_wlcm4;
    private javax.swing.JLabel jlbl_wlcm5;
    private javax.swing.JLabel jlbl_wlcm6;
    private javax.swing.JLabel jlbl_wlcm7;
    private javax.swing.JLabel jlbl_wlcm8;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JLabel txt_bk;
    private javax.swing.JLabel txt_brrwr;
    private javax.swing.JLabel txt_q;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
