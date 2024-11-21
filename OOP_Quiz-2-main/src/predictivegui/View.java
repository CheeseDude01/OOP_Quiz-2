package predictivegui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

// View class that renders the contents of the model
public class View implements ActionListener, Observer {
    private MainPanel panel = new MainPanel();
    private Model model = new Model();
    
    public void init(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding action listener to every button in panel
        for (int i = 0; i < 12; i++) {
            panel.buttons[i].addActionListener(this);
        }
        
        // Adding this class as an observer for model
        model.addObserver(this);
        
        // Setting JFrame and making it visible
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Handling actions performed when pressing button
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("*")) {
            model.cycleWords();
        } else if (s.equals("0")) {
            model.completeWord();
        } else if (s.equals("#")) {
            model.doBackspace();
        } else if (!s.equals("1")) {
            model.doTyping(s);
        }
    }

    // Set display text of panel if there is an update from model
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            panel.setText("" + arg);
        }
    }
}
