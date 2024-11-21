package predictivegui;

import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View implements ActionListener, Observer {
    private MainPanel panel;
    private Model model;

    public View() {
        model = new Model();
        panel = new MainPanel();
        model.addObserver(this); // Menambahkan View sebagai Observer untuk Model

        // Menambahkan action listener pada setiap tombol di panel
        for (int i = 0; i < 12; i++) {
            panel.buttons[i].addActionListener(this); // Menambahkan listener ke tombol
        }
    }

    // Menginisialisasi tampilan
    public void init(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Menangani aksi tombol yang diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("*")) {
            model.cycleWords();
        } else if (s.equals("0")) {
            model.completeWord();
        } else if (s.equals("#")) {
            model.doBackspace();
        } else {
            model.doTyping(s);  // Menangani input teks
        }
    }

    // Update metode untuk Observer yang memperbarui tampilan dengan teks terbaru
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            panel.setText((String) arg);  // Memperbarui tampilan dengan teks baru
        }
    }
}