package main;

import gamestates.Gamestate;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {
    private JFrame jframe;
    public GameWindow(GamePanel gamePanel){
        jframe = new JFrame("Tao la frame");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(true);
        jframe.pack();
        jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                switch (Gamestate.state){
                    case PLAYING:
                        gamePanel.getGame().getPlaying().getPlayer().windowFocusLost();
                        break;
                    case MENU:
                        gamePanel.getGame().getMenu().getPlayer().windowFocusLost();
                }
            }
        });

    }
}
