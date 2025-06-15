package sc.BubbleTrouble;

import javax.swing.*;

public class GameWindow {
    JFrame frame;

    public GameWindow(Engine engine) {
        frame = new JFrame("Bubble Trouble");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(engine);
        frame.pack(); // adjusts to Engine's preferred size
        frame.setLocationRelativeTo(null); // center on screen
        frame.setVisible(true);
    }
}
