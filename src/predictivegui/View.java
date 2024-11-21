package predictivegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private final MainPanel mainPanel;  // Replace keypad with MainPanel
    private final Model model;

    public View(Model model) {
        this.model = model;
        this.mainPanel = new MainPanel(this); // Pass the View instance to MainPanel

        setTitle("Predictive Text");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the MainPanel which includes both the text display and keypad
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "*" -> model.cycleWord();
            case "0" -> model.completeWord();
            case "#" -> model.backspace();
            default -> model.typeDigit(command);
        }
        updateDisplay();
    }

    private void updateDisplay() {
        // Set the text in the MainPanel display area
        mainPanel.setText(model.getCurrentText());
    }
}
