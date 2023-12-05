package gamestates;

import Entities.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.MouseEvent.BUTTON3;

public class Playing extends State implements StateMethods {
    private Player player;
    private final boolean[] keyPressed = new boolean[1000];
    private boolean[] checkMousePressed = new boolean[1000];

    public Playing(Player player) {
        this.player = player;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player.setLeft(false);
            case KeyEvent.VK_W:
                player.setUp(false);
            case KeyEvent.VK_S:
                player.setDown(false);
            case KeyEvent.VK_D:
                player.setRight(false);
            case KeyEvent.VK_H:
                player.setJump(false);
                break;
            case KeyEvent.VK_J:
                player.setAttack(false);
                player.setAttackJump1(false);
                player.setAttackJump2(false);

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                Gamestate.state = Gamestate.MENU;
                break;
            case KeyEvent.VK_A:
                player.setLeft(true);
            case KeyEvent.VK_W:
                player.setUp(true);
            case KeyEvent.VK_S:
                player.setDown(true);
                break;
            case KeyEvent.VK_D:
                player.setRight(true);
                break;
            case KeyEvent.VK_H:
                player.setJump(true);
                break;
            case KeyEvent.VK_J:
                if (keyPressed['K']) player.setAttackJump2(true);
                else if (keyPressed['H']) player.setAttackJump1(true);
                player.setAttack(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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

    }
}
