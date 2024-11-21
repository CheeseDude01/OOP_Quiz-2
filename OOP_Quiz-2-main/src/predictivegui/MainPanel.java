package predictivegui;

import java.awt.*;
import javax.swing.*;

// Main panel class for the main content pane
public class MainPanel extends JPanel {
    // Components used inside panel
    private JPanel displayPanel = new JPanel();
    private JPanel keysPanel = new JPanel();
    protected Button[] buttons = new Button[12]; 
    private JTextArea display = new JTextArea();
    
    public MainPanel() {
        // Setting the display text area
        display.setLineWrap(true);
        display.setEditable(false);
        display.setPreferredSize(new Dimension(300, 150));
        display.setText("Predictive text: enter text with 8 keys.");
        
        // Adding the display to display panel
        displayPanel.add(display);
        
        // Setting the keys panel
        keysPanel.setLayout(new GridLayout(4, 3));
        keysPanel.setPreferredSize(new Dimension(300, 200));
        initButtons(keysPanel);
        
        // Setting main panel layout and adding the components
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(displayPanel);
        add(keysPanel);
    }
    
    // Function to initialize all buttons
    private void initButtons(JPanel panel) {
        // Creating buttons with text
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
        
        // Setting action command for each button
        buttons[0].setActionCommand("1");
        buttons[1].setActionCommand("2");
        buttons[2].setActionCommand("3");
        buttons[3].setActionCommand("4");
        buttons[4].setActionCommand("5");
        buttons[5].setActionCommand("6");
        buttons[6].setActionCommand("7");
        buttons[7].setActionCommand("8");
        buttons[8].setActionCommand("9");
        buttons[9].setActionCommand("*");
        buttons[10].setActionCommand("0");
        buttons[11].setActionCommand("#");
        
        // Adding button to panel
        for (int i = 0; i < 12; i++) {
            panel.add(buttons[i]);
        }
    }
    
    // Function for setting display text
    public void setText(String text) {
        display.setText(text);
    }
}
