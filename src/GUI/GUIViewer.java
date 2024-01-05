package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIViewer extends JFrame {

    private final GamePanel mainPanel = new GamePanel();
    Timer timer = new Timer(0, e -> mainPanel.updateImage());
    public GUIViewer() {
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setSize(1000, 1000);
        setVisible(true);

        mainPanel.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    public void update() {
        timer.start();
    }
}

