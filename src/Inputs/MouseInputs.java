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

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (Gamestate.state){
            case MENU:
                break;
            case PLAYING:
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (checkMousePressed[BUTTON3]) {
                        gamePanel.getGame().getPlayer().setAttackJump2(true);
                    } else gamePanel.getGame().getPlayer().setAttack(true);
                } else if (e.getButton() == BUTTON3) checkMousePressed[BUTTON3] = true;
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

    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        gamePanel.setXYPosition(e.getX(), e.getY());
    }
}
