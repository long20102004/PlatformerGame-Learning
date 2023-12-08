package Inputs;

import Entities.Player;
import gamestates.Gamestate;
import gamestates.Playing;
import main.GamePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constant.Direction.*;
import static utilz.Constant.PlayerConstant.*;

public class KeyboardInput extends JComponent implements KeyListener {
    private final boolean[] keyPressed = new boolean[1000];
    private GamePanel gamePanel; // Tại sao nếu khởi tạo new Panel ở đây bị lỗi
//    private Player player;

    public KeyboardInput(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
//        this.player = this.gamePanel.getGame().getPlayer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyTyped(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().keyTyped(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyReleased(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().keyReleased(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyPressed(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
        }
    }
}