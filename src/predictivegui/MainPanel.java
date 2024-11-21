package predictivegui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JPanel displayPanel = new JPanel();
    private JPanel keysPanel = new JPanel();
    private Button[] buttons = new Button[12];
    private JTextArea display = new JTextArea();

    public MainPanel(View view) {
        display.setLineWrap(true);
        display.setEditable(false);
        display.setPreferredSize(new Dimension(300, 150));
        display.setText("Predictive text: enter text with 8 keys.");

        displayPanel.add(display);

        keysPanel.setLayout(new GridLayout(4, 3));
        keysPanel.setPreferredSize(new Dimension(300, 200));
        initButtons(view);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(displayPanel);
        add(keysPanel);
    }

    private void initButtons(View view) {
        buttons[0] = new Button("1");
        buttons[1] = new Button("2", "abc");
        buttons[2] = new Button("3", "def");
        buttons[3] = new Button("4", "ghi");
        buttons[4] = new Button("5", "jkl");
        buttons[5] = new Button("6", "mno");
        buttons[6] = new Button("7", "pqrs");
        buttons[7] = new Button("8", "tuv");
        buttons[8] = new Button("9", "wxyz");
        buttons[9] = new Button("*");
        buttons[10] = new Button("0", "_");
        buttons[11] = new Button("#");

        for (int i = 0; i < 12; i++) {
            buttons[i].setActionCommand(buttons[i].getText());
            buttons[i].addActionListener(view);  // Add View as action listener
            keysPanel.add(buttons[i]);
        }
    }

    public void setText(String text) {
        display.setText(text);
    }
}
