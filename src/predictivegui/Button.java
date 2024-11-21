package predictivegui;

import java.awt.*;
import javax.swing.*;

// Class for making JButton with multi-line or singular line text
public class Button extends JButton {
    private JLabel label1;
    private JLabel label2;
    
    public Button(String text1, String text2) {
        label1 = new JLabel(text1);
        label1.setHorizontalAlignment(CENTER);
        label2 = new JLabel(text2);
        label2.setHorizontalAlignment(CENTER);
        setLayout(new BorderLayout());
        add(label1, BorderLayout.NORTH);
        add(label2, BorderLayout.SOUTH);
    }
    
    public Button(String text) {
        label1 = new JLabel(text);
        label1.setHorizontalAlignment(CENTER);
        setLayout(new BorderLayout());
        add(label1);
    }
}
