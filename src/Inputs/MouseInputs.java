package Inputs;

import Entities.Player;
import gamestates.Gamestate;
import main.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.awt.event.MouseEvent.BUTTON3;

public class MouseInputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
//    private Player player;
    private boolean[] checkMousePressed = new boolean[1000];

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
//        this.player = gamePanel.getGame().getPlayer();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        gamePanel.setXYPosition(0,0);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mousePressed(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseReleased(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseDragged(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().mouseMoved(e);
            case PLAYING:
                gamePanel.getGame().getPlaying().mouseMoved(e);
        }
    }
}
