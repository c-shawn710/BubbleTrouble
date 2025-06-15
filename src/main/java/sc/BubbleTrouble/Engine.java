package sc.BubbleTrouble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Engine extends JPanel implements Runnable, KeyListener {
    private Thread gameThread;
    private int playerX = 600;
    private boolean movingLeft;
    private boolean movingRight;
    private int speed = 10;
    private boolean running = true;

    public Engine() {
        setPreferredSize(new Dimension(1500, 800));
        setFocusable(true);     // allows key input
        addKeyListener(this); // attach key input
        requestFocusInWindow(); // ask to receive focus

        gameThread = new Thread(this); // 'this' is Runnable
        gameThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(playerX, 700, 50, 100);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            movingLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            movingRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            movingLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            movingRight = false;
        }
    }

    private void updateGame() {
        if (movingRight) {
            playerX += speed;
        }
        if (movingLeft) {
            playerX -= speed;
        }
    }

    @Override
    public void run() {
        while (running) {
            updateGame();
            repaint();

            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
