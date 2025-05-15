/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class TransactionsComboBoxHelper {
    public static void populateComboBox(JComboBox<String> comboBox, String query, String columnName, String placeholder) {
        comboBox.removeAllItems();
        comboBox.setEditable(true);
        comboBox.addItem(placeholder);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_database", "root", "");
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                comboBox.addItem(rs.getString(columnName));
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTextField textField = (JTextField) comboBox.getEditor().getEditorComponent();
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText(""); // Clears the placeholder
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = textField.getText().toLowerCase();
                filterComboBox(comboBox, query, columnName, input, textField);
            }
        });
    }

    public static void filterComboBox(JComboBox<String> comboBox, String query, String columnName, String input, JTextField textField) {
        comboBox.hidePopup();
        comboBox.removeAllItems();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_database", "root", "");
            PreparedStatement pst = conn.prepareStatement(query + " WHERE " + columnName + " LIKE ?");
            pst.setString(1, input + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                comboBox.addItem(rs.getString(columnName));
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        comboBox.showPopup();
        SwingUtilities.invokeLater(() -> textField.setText(input));
    }
}
    

