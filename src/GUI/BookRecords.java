/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
//All goods!
import Controller.BooksController;
import Models.Books;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookRecords extends javax.swing.JFrame implements imagesNbuttons {

    public BookRecords() {
        initComponents();
        scaleImages();
        initializeButtons();
        getId();
        table("");
    }
    
    private void table(String keyword) {
     List<Books> books = BooksController.getBooks(); 
     DefaultTableModel model = (DefaultTableModel) tbl_bookRecords.getModel();

     model.setRowCount(0); // Clear the table before reloading
     
     for (Books book : books) {
         if (keyword == null || keyword.trim().isEmpty() || // If no keyword is provided, show all books
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

     tbl_bookRecords.setModel(model); // Ensure the table uses the updated model
     tbl_bookRecords.revalidate(); // Refresh UI
 }



//    
    private void getId(){
            //fetch data
            List<Books> bookList = BooksController.getBooks();
            
            //validation
            if(bookList.isEmpty()){
                JOptionPane.showMessageDialog(this, "Book Records is currently empty.","Info",JOptionPane.INFORMATION_MESSAGE);
            }
            
            //remove existing row to add id
            cb_id.removeAllItems();
            
            //store new id
            for(Books b : bookList){
                cb_id.addItem(String.valueOf(b.getBookId()));
            }
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

        initializeButtons(btn_dshbrd, btn_BRecords, btn_BrwrRecords, btn_trnsct, btn_Acc );
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
        tbl_bookRecords = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txt_trnscID = new javax.swing.JLabel();
        txt_brrwr = new javax.swing.JLabel();
        txt_bk = new javax.swing.JLabel();
        txt_g = new javax.swing.JLabel();
        txt_q = new javax.swing.JLabel();
        txt_title = new javax.swing.JTextField();
        txt_author = new javax.swing.JTextField();
        txt_genre = new javax.swing.JTextField();
        txt_quantity = new javax.swing.JTextField();
        cb_id = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        isbn = new javax.swing.JLabel();
        txt_isbn = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
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

        tbl_bookRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Title", "Author", "Genre", "ISBN", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bookRecords.setSelectionBackground(new java.awt.Color(64, 224, 208));
        tbl_bookRecords.setSelectionForeground(new java.awt.Color(0, 0, 139));
        tbl_bookRecords.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_bookRecords);
        if (tbl_bookRecords.getColumnModel().getColumnCount() > 0) {
            tbl_bookRecords.getColumnModel().getColumn(0).setResizable(false);
            tbl_bookRecords.getColumnModel().getColumn(1).setResizable(false);
            tbl_bookRecords.getColumnModel().getColumn(2).setResizable(false);
            tbl_bookRecords.getColumnModel().getColumn(3).setResizable(false);
            tbl_bookRecords.getColumnModel().getColumn(4).setResizable(false);
            tbl_bookRecords.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 120, 552, 490));

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel1.setText("BOOK RECORDS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jPanel6.setBackground(new java.awt.Color(224, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 25, 112)));

        txt_trnscID.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_trnscID.setText("Book ID:");

        txt_brrwr.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_brrwr.setText("Title:");

        txt_bk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_bk.setText("Author:");

        txt_g.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_g.setText("Genre:");

        txt_q.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_q.setText("Quantity:");

        txt_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_titleActionPerformed(evt);
            }
        });

        txt_author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorActionPerformed(evt);
            }
        });

        txt_genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_genreActionPerformed(evt);
            }
        });

        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });

        cb_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_idActionPerformed(evt);
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

        btn_search.setBackground(new java.awt.Color(25, 25, 112));
        btn_search.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        btn_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btn_searchKeyTyped(evt);
            }
        });

        isbn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        isbn.setText("ISBN:");

        txt_isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_isbnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_g, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_bk)
                            .addComponent(txt_brrwr)
                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_genre)
                            .addComponent(txt_author)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_isbn)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txt_trnscID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btn_search))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txt_q, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(txt_trnscID)
                            .addGap(5, 5, 5))
                        .addComponent(cb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_brrwr)
                    .addComponent(txt_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bk)
                    .addComponent(txt_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_g)
                    .addComponent(txt_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbn))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_q)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void txt_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_titleActionPerformed

    private void txt_authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorActionPerformed

    private void txt_genreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_genreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_genreActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try{
            StringBuilder errorMessage = new StringBuilder("Error: ");//catching empty fields.
            boolean error = false;
            if(txt_title.getText().trim().isEmpty()){
                errorMessage.append("Title field is empty!\n");
                error = true;//confirm error.
            }if(txt_author.getText().trim().isEmpty()){
                errorMessage.append("Author field is empty!\n");
                error = true;
            }if(txt_genre.getText().trim().isEmpty()){
                errorMessage.append("Genre field is empty!\n");
                error = true;
            }if(txt_isbn.getText().trim().isEmpty()){
                errorMessage.append("ISBN field is empty!\n");
                error = true;
            }if(txt_quantity.getText().trim().isEmpty()){
                errorMessage.append("Quantity field is empty!");
                error = true;
            }if (error){
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(),"Error",JOptionPane.ERROR_MESSAGE);//error message for a specific field.
                return;
            }
                        
            Object selectedID = cb_id.getSelectedItem();
            int bookId = (selectedID != null) ? Integer.parseInt(selectedID.toString()) : 0; // Default to 0
            String title = txt_title.getText().trim();
            String author = txt_author.getText().trim();
            String genre = txt_genre.getText().trim();
            String isbn = txt_isbn.getText().trim();
            if(! Books.isbnValidation(isbn)){
                JOptionPane.showMessageDialog(this, "Invalid ISBN! Please enter the right 13-digit code.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }          
            int quantity;
            try{
               quantity = Integer.parseInt(txt_quantity.getText());
            } catch (NumberFormatException e) {//validation for 'Quantity'
            JOptionPane.showMessageDialog(this, "Invalid! Whole number only for 'Quantity'.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            }
                     
            Books b = new Books(bookId, title, author, genre,isbn,quantity);
            boolean success = BooksController.addBook(b);

            if (success){
                JOptionPane.showMessageDialog(this, "Book added successfully!");
                txt_title.setText("");
                txt_author.setText("");
                txt_genre.setText("");
                txt_isbn.setText("");   
                txt_quantity.setText("");
                table("");
            }else{
                JOptionPane.showMessageDialog(this, "Failed to add book.");
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "An unexpected error occurred."+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        try{
            //validation
            if (cb_id.getSelectedItem() == null || cb_id.getSelectedItem().toString().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please select a Book ID","Error", JOptionPane.ERROR_MESSAGE);
            }
            
            int selectedBookID = Integer.parseInt(cb_id.getSelectedItem().toString());
            //fetch data from database.
            List<Books> bookList = BooksController.getBooks();
            
            Books matchBook = bookList.stream()
               .filter(book -> book.getBookId() == selectedBookID).findFirst().orElse(null);
            
            //display details
            if(matchBook !=null){
                txt_title.setText(matchBook.getTitle());
                txt_author.setText(matchBook.getAuthor());
                txt_genre.setText(matchBook.getGenre());
                txt_isbn.setText(matchBook.getIsbn());
                txt_quantity.setText(Integer.toString(matchBook.getQuantity()));
            } else{
                JOptionPane.showMessageDialog(this, "No record detected.");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "An unexpected error occurred.","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void cb_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_idActionPerformed

    private void txt_isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_isbnActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try{
            StringBuilder errorMessage = new StringBuilder("Error: ");//catching empty fields.
            boolean error = false;
            if(txt_title.getText().trim().isEmpty()){
                errorMessage.append("Title field is empty!\n");
                error = true;//confirm error.
            }if(txt_author.getText().trim().isEmpty()){
                errorMessage.append("Author field is empty!\n");
                error = true;
            }if(txt_genre.getText().trim().isEmpty()){
                errorMessage.append("Genre field is empty!\n");
                error = true;
            }if(txt_isbn.getText().trim().isEmpty()){
                errorMessage.append("ISBN field is empty!\n");
                error = true;
            }if(txt_quantity.getText().trim().isEmpty()){
                errorMessage.append("Quantity firld is empty!");
                error = true;
            }if (error){
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(),"Error",JOptionPane.ERROR_MESSAGE);//error message for a specific field.
                return;
            }
            Object selectedID = cb_id.getSelectedItem();
            int bookId =(selectedID != null) ? Integer.parseInt(selectedID.toString()): 0;
            String title = txt_title.getText().trim();
            String author = txt_author.getText().trim();
            String genre = txt_genre.getText().trim();
            String isbn = txt_isbn.getText().trim();
            if(! Books.isbnValidation(isbn)){
                JOptionPane.showMessageDialog(this, "Invalid ISBN! Please enter the right 13-digit code.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            int quantity;
                    try{
                        quantity = Integer.parseInt(txt_quantity.getText().trim());
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "Invalid! Whole numbers only for 'Quantity'.","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }

            Books b = new Books(bookId, title, author, genre, isbn, quantity);
            boolean success = BooksController.updateBook(b);

            if (success){
                JOptionPane.showMessageDialog(this, "Book updated successfully!");
                txt_title.setText("");
                txt_author.setText("");
                txt_genre.setText("");
                txt_isbn.setText("");   
                txt_quantity.setText("");
                table("");
            }else{
                JOptionPane.showMessageDialog(this, "Failed to update book.");
            }
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error! Numeric value only for 'Quantity'.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "An unexpected error occurred."+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchKeyTyped

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search2ActionPerformed
        String searchText = txt_search.getText().trim();
        table(searchText);
        
    }//GEN-LAST:event_btn_search2ActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try{
            StringBuilder errorMessage = new StringBuilder("Error: ");//catching empty fields.
            boolean error = false;
            if(txt_title.getText().trim().isEmpty()){
                errorMessage.append("Title field is empty!\n");
                error = true;//confirm error.
            }if(txt_author.getText().trim().isEmpty()){
                errorMessage.append("Author field is empty!\n");
                error = true;
            }if(txt_genre.getText().trim().isEmpty()){
                errorMessage.append("Genre field is empty!\n");
                error = true;
            }if(txt_isbn.getText().trim().isEmpty()){
                errorMessage.append("ISBN field is empty!\n");
                error = true;
            }if(txt_quantity.getText().trim().isEmpty()){
                errorMessage.append("Quantity firld is empty!");
                error = true;
            }if (error){
                JOptionPane.showMessageDialog(new JFrame(), errorMessage.toString(),"Error",JOptionPane.ERROR_MESSAGE);//error message for a specific field.
                return;
            }
            Object selectedID = cb_id.getSelectedItem();
            int bookId =(selectedID != null) ? Integer.parseInt(selectedID.toString()): 0;
            String title = txt_title.getText().trim();
            String author = txt_author.getText().trim();
            String genre = txt_genre.getText().trim();
            String isbn = txt_isbn.getText().trim();
            if(! Books.isbnValidation(isbn)){
                JOptionPane.showMessageDialog(this, "Invalid ISBN! Please enter the right 13-digit code.","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            int quantity;
                    try{
                        quantity = Integer.parseInt(txt_quantity.getText().trim());
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(this, "Invalid! Whole numbers only for 'Quantity'.","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }

            Books b = new Books(bookId, title, author, genre, isbn, quantity);
            boolean success = BooksController.deleteBook(b);

            if (success){
                JOptionPane.showMessageDialog(this, "Book deleted successfully!");
                txt_title.setText("");
                txt_author.setText("");
                txt_genre.setText("");
                txt_isbn.setText("");   
                txt_quantity.setText("");
                table("");
            }else{
                JOptionPane.showMessageDialog(this, "Failed to delete book.");
            }
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error! Numeric value only for 'Quantity'.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "An unexpected error occurred."+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel bookIcon;
    private javax.swing.JButton btn_Acc;
    private javax.swing.JButton btn_BRecords;
    private javax.swing.JButton btn_BrwrRecords;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_dshbrd;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_trnsct;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_id;
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
    private javax.swing.JTable tbl_bookRecords;
    private javax.swing.JTextField txt_author;
    private javax.swing.JLabel txt_bk;
    private javax.swing.JLabel txt_brrwr;
    private javax.swing.JLabel txt_g;
    private javax.swing.JTextField txt_genre;
    private javax.swing.JTextField txt_isbn;
    private javax.swing.JLabel txt_q;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_title;
    private javax.swing.JLabel txt_trnscID;
    // End of variables declaration//GEN-END:variables
}
