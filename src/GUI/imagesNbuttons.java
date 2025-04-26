package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public interface imagesNbuttons {
    
    default void scaleImages(String[] imagePaths, JLabel[] labels) {
        if (imagePaths.length != labels.length) {
            throw new IllegalArgumentException("The number of image paths must match the number of labels.");
        }
        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(labels[i].getWidth(), labels[i].getHeight(), Image.SCALE_SMOOTH);
            labels[i].setIcon(new ImageIcon(scaledImg));
        }
    }
    
    default void initializeButtons(JButton... buttons) {
        
        MouseAdapter commonMouseListener = new MouseAdapter() {
            private final Color babyBlue = new Color(72, 209, 204);

            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setForeground(babyBlue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setForeground(Color.BLACK);
            }
        };

        for (JButton btn : buttons) {
            btn.addMouseListener(commonMouseListener);
        }
    }
}
