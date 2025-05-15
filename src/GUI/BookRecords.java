/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
//All goods!

import Controller.BooksController;
import Models.Books;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class BookRecords extends javax.swing.JFrame implements imagesNbuttons {
    private int selectedBookId = -1;
    
    public BookRecords() {
        initComponents();
        scaleImages();
        initializeButtons();
        table("");
        Genres();

        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String searchText = txt_search.getText().trim();
                table(searchText);
            }
        });

        bookRecordsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { 
                    int selectedRow = bookRecordsTable.getSelectedRow();

                    if (selectedRow != -1) {
                        selectedBookId = Integer.parseInt(bookRecordsTable.getValueAt(selectedRow, 0).toString());
                        txtBookTitle.setText(bookRecordsTable.getValueAt(selectedRow, 1).toString());
                        txtBookAuthor.setText(bookRecordsTable.getValueAt(selectedRow, 2).toString());
                        bookGenreComboBox.setSelectedItem(bookRecordsTable.getValueAt(selectedRow, 3).toString());
                        txtBookIsbn.setText(bookRecordsTable.getValueAt(selectedRow, 4).toString());
                        txtBookQuantity.setText(String.valueOf(bookRecordsTable.getValueAt(selectedRow, 5)));

                        System.out.println("Selected book_id for update: " + selectedBookId);
                    }
                }
            }
        });

    }


    private void table(String keyword) {
        List<Books> books = BooksController.getBooks();
        DefaultTableModel model = (DefaultTableModel) bookRecordsTable.getModel();
        model.setRowCount(0);

        for (Books book : books) {
            System.out.println("DEBUG - Adding to Table: Book ID = " + book.getBookId());
            if (keyword == null || keyword.trim().isEmpty() ||
                book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getGenre().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getIsbn().toLowerCase().contains(keyword.toLowerCase())) {

                model.addRow(new Object[]{
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getIsbn(),
                    book.getQuantity()
                });
            }
        }

        bookRecordsTable.setModel(model);
        bookRecordsTable.revalidate();

        // Hide the bookid column
        bookRecordsTable.getColumnModel().getColumn(0).setMinWidth(0);
        bookRecordsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        bookRecordsTable.getColumnModel().getColumn(0).setWidth(0);
    }

    
    private void Genres() {
        bookGenreComboBox.removeAllItems();
        bookGenreComboBox.setEditable(true); // Make combo box editable
        bookGenreComboBox.addItem("-- Select Genre --"); // Placeholder

        // Define genres
        String[] genres = {"Fiction", "History", "Science", "Mathematics", "Information Technology"};

        for (String genre : genres) {
            bookGenreComboBox.addItem(genre);
        }

        // Get the editable text field from JComboBox
        JTextField textField = (JTextField) bookGenreComboBox.getEditor().getEditorComponent();

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("-- Select Genre --")) {
                    textField.setText(""); // Clears the placeholder
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = textField.getText().toLowerCase();
                filterComboBox(input, textField);
            }
        });
    }

    private void filterComboBox(String input, JTextField textField) {
        bookGenreComboBox.hidePopup();
        bookGenreComboBox.removeAllItems();

        String[] genres = {"Fiction", "History", "Science", "Mathematics", "Information Technology"};
        for (String genre : genres) {
            if (genre.toLowerCase().startsWith(input)) { // Matches user input
                bookGenreComboBox.addItem(genre);
            }
        }

        bookGenreComboBox.showPopup();
        SwingUtilities.invokeLater(() -> textField.setText(input));
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jPanel2 = new javax.swing.JPanel();
        jlbl_wlcm = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookRecordsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txt_brrwr = new javax.swing.JLabel();
        txt_bk = new javax.swing.JLabel();
        txt_g = new javax.swing.JLabel();
        txt_q = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        txtBookAuthor = new javax.swing.JTextField();
        txtBookQuantity = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        isbn = new javax.swing.JLabel();
        txtBookIsbn = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        bookGenreComboBox = new javax.swing.JComboBox<>();
        txt_search = new javax.swing.JTextField();
        btn_search2 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(25, 25, 112));

        jlbl_wlcm.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlbl_wlcm.setForeground(new java.awt.Color(72, 209, 204));
        jlbl_wlcm.setText("SCC Library Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbl_wlcm)
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlbl_wlcm, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bookRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Book Title", "Book author", "Book Genre", "ISBN", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookRecordsTable.setSelectionBackground(new java.awt.Color(64, 224, 208));
        bookRecordsTable.setSelectionForeground(new java.awt.Color(0, 0, 139));
        bookRecordsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(bookRecordsTable);
        if (bookRecordsTable.getColumnModel().getColumnCount() > 0) {
            bookRecordsTable.getColumnModel().getColumn(0).setResizable(false);
            bookRecordsTable.getColumnModel().getColumn(1).setResizable(false);
            bookRecordsTable.getColumnModel().getColumn(2).setResizable(false);
            bookRecordsTable.getColumnModel().getColumn(3).setResizable(false);
            bookRecordsTable.getColumnModel().getColumn(4).setResizable(false);
            bookRecordsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 120, 552, 490));

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setText("BOOK RECORDS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jPanel6.setBackground(new java.awt.Color(224, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 25, 112)));

        txt_brrwr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_brrwr.setText("Title:");

        txt_bk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_bk.setText("Author:");

        txt_g.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_g.setText("Genre:");

        txt_q.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_q.setText("Quantity:");

        txtBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitleActionPerformed(evt);
            }
        });

        txtBookAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookAuthorActionPerformed(evt);
            }
        });

        txtBookQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookQuantityActionPerformed(evt);
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
        isbn.setText("ISBN:");

        txtBookIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIsbnActionPerformed(evt);
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

        bookGenreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_g, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_bk)
                                    .addComponent(txt_brrwr)
                                    .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBookAuthor)
                                    .addComponent(txtBookIsbn)
                                    .addComponent(bookGenreComboBox, 0, 205, Short.MAX_VALUE)
                                    .addComponent(txtBookTitle)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txt_q, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_brrwr)
                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bk)
                    .addComponent(txtBookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_g)
                    .addComponent(bookGenreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbn))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_q)
                    .addComponent(txtBookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 490));

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 380, -1));

        btn_search2.setBackground(new java.awt.Color(25, 25, 112));
        btn_search2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btn_search2.setForeground(new java.awt.Color(255, 255, 255));
        btn_search2.setText("Search");
        btn_search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(936, 80, -1, -1));

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

    }//GEN-LAST:event_btn_BRecordsActionPerformed

    private void btn_trnsctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trnsctActionPerformed
        TransactionRecords tr = new TransactionRecords();
        tr.show();
        dispose();
    }//GEN-LAST:event_btn_trnsctActionPerformed

    private void btn_BrwrRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrwrRecordsActionPerformed
        BorrowerRecords br = new BorrowerRecords();
        br.show();
        dispose();
    }//GEN-LAST:event_btn_BrwrRecordsActionPerformed

    private void btn_AccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccActionPerformed
        Account ac = new Account();
        ac.show();
        dispose();
    }//GEN-LAST:event_btn_AccActionPerformed

    private void txtBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitleActionPerformed

    private void txtBookAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookAuthorActionPerformed

    private void txtBookQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookQuantityActionPerformed

    }//GEN-LAST:event_txtBookQuantityActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            StringBuilder errorMessage = new StringBuilder("Error: ");//catching empty fields.
            boolean error = false;
            if (txtBookTitle.getText().trim().isEmpty()) {
                errorMessage.append("Title field is empty!\n");
                error = true;//confirm error.
            }
            if (txtBookAuthor.getText().trim().isEmpty()) {
                errorMessage.append("Author field is empty!\n");
                error = true;
            }
            if (bookGenreComboBox.getSelectedItem() == null) {
                errorMessage.append("Genre field is empty!\n");
                error = true;
            }
            if (txtBookIsbn.getText().trim().isEmpty()) {
                errorMessage.append("ISBN field is empty!\n");
                error = true;
            }
            if (txtBookQuantity.getText().trim().isEmpty()) {
                errorMessage.append("Quantity firld is empty!");
                error = true;
            }
            if (error) {
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);//error message for a specific field.
                return;
            }
            String title = txtBookTitle.getText().trim();
            String author = txtBookAuthor.getText().trim();
            String genre = bookGenreComboBox.getSelectedItem().toString();
            String isbn = txtBookIsbn.getText().trim();

            // Ensure the input is exactly 13 digits and numeric
            if (!isbn.matches("\\d{13}")) {
                JOptionPane.showMessageDialog(this, "Invalid ISBN! Must be a 13-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(txtBookQuantity.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid! Whole numbers only for 'Quantity'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Books b = new Books(selectedBookId,title, author, genre, isbn, quantity);
            boolean success = BooksController.addBook(b);

            if (success) {
                JOptionPane.showMessageDialog(this, "Book added successfully!");
                txtBookTitle.setText("");
                txtBookAuthor.setText("");
                bookGenreComboBox.setSelectedIndex(0);
                txtBookIsbn.setText("");
                txtBookQuantity.setText("");
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add book.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void txtBookIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIsbnActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            StringBuilder errorMessage = new StringBuilder("Error:");
            boolean error = false;
            
            if (txtBookTitle.getText().trim().isEmpty()) {
                errorMessage.append(" Title field is empty!\n");
                error = true;
            }
            if (txtBookAuthor.getText().trim().isEmpty()) {
                errorMessage.append(" Author field is empty!\n");
                error = true;
            }
            if (bookGenreComboBox.getSelectedItem() == null) {
                errorMessage.append(" Genre field is empty!\n");
                error = true;
            }
            if (txtBookIsbn.getText().trim().isEmpty()) {
                errorMessage.append(" ISBN field is empty!\n");
                error = true;
            }
            if (txtBookQuantity.getText().trim().isEmpty()) {
                errorMessage.append(" Quantity field is empty!");
                error = true;
            }

            if (error) {
                JOptionPane.showMessageDialog(this, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String title = txtBookTitle.getText().trim();
            String author = txtBookAuthor.getText().trim();
            String genre = bookGenreComboBox.getSelectedItem().toString();
            String isbn = txtBookIsbn.getText().trim();

            if (!isbn.matches("\\d{13}")) {
                JOptionPane.showMessageDialog(this, "Invalid ISBN! Must be a 13-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(txtBookQuantity.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid! Whole numbers only for 'Quantity'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedBookId == -1 || selectedBookId == 0) {
                JOptionPane.showMessageDialog(this, "No valid book selected for update!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Books b = new Books(selectedBookId, title, author, genre, isbn, quantity);
            boolean success = BooksController.updateBook(b);

            if (success) {
                JOptionPane.showMessageDialog(this, "Book updated successfully!");
                txtBookTitle.setText("");
                txtBookAuthor.setText("");
                bookGenreComboBox.setSelectedIndex(0);
                txtBookIsbn.setText("");
                txtBookQuantity.setText("");
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update book.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed
        String searchText = txt_search.getText().trim();
        table(searchText);

    }//GEN-LAST:event_btn_search2ActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            StringBuilder errorMessage = new StringBuilder("Error:");
            boolean error = false;
            
            if (txtBookTitle.getText().trim().isEmpty()) {
                errorMessage.append(" Title field is empty!\n");
                error = true;
            }
            if (txtBookAuthor.getText().trim().isEmpty()) {
                errorMessage.append(" Author field is empty!\n");
                error = true;
            }
            if (bookGenreComboBox.getSelectedItem() == null) {
                errorMessage.append(" Genre field is empty!\n");
                error = true;
            }
            if (txtBookIsbn.getText().trim().isEmpty()) {
                errorMessage.append(" ISBN field is empty!\n");
                error = true;
            }
            if (txtBookQuantity.getText().trim().isEmpty()) {
                errorMessage.append(" Quantity field is empty!");
                error = true;
            }

            if (error) {
                JOptionPane.showMessageDialog(this, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String title = txtBookTitle.getText().trim();
            String author = txtBookAuthor.getText().trim();
            String genre = bookGenreComboBox.getSelectedItem().toString();
            String isbn = txtBookIsbn.getText().trim();

            if (!isbn.matches("\\d{13}")) {
                JOptionPane.showMessageDialog(this, "Invalid ISBN! Must be a 13-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(txtBookQuantity.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid! Whole numbers only for 'Quantity'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedBookId == -1 || selectedBookId == 0) {
                JOptionPane.showMessageDialog(this, "No valid book selected for update!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Books b = new Books(selectedBookId, title, author, genre, isbn, quantity);
            boolean success = BooksController.deleteBook(b);

            if (success) {
                JOptionPane.showMessageDialog(this, "Book updated successfully!");
                txtBookTitle.setText("");
                txtBookAuthor.setText("");
                bookGenreComboBox.setSelectedIndex(0);
                txtBookIsbn.setText("");
                txtBookQuantity.setText("");
                table("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update book.");
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
            java.util.logging.Logger.getLogger(BookRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccIcon;
    private javax.swing.JLabel BrrwrIcon;
    private javax.swing.JLabel TrnsactIcon;
    private javax.swing.JComboBox<String> bookGenreComboBox;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JTable bookRecordsTable;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jlbl_wlcm;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txtBookAuthor;
    private javax.swing.JTextField txtBookIsbn;
    private javax.swing.JTextField txtBookQuantity;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JLabel txt_bk;
    private javax.swing.JLabel txt_brrwr;
    private javax.swing.JLabel txt_g;
    private javax.swing.JLabel txt_q;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
