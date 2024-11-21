package predictivegui;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String text1, String text2) {
        setLayout(new BorderLayout());
        JLabel top = new JLabel(text1, JLabel.CENTER);
        JLabel bottom = new JLabel(text2, JLabel.CENTER);
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
    }

    public Button(String text) {
        super(text);
    }
}
