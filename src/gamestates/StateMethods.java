package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.MouseEvent.BUTTON3;

public interface StateMethods {
    public void draw(Graphics g);
    public void update();
    public void keyTyped(KeyEvent e);
    public void keyReleased(KeyEvent e);
    public void keyPressed(KeyEvent e);
    public void mouseClicked(MouseEvent e) ;
    public void mousePressed(MouseEvent e);
    public void mouseReleased(MouseEvent e);

    public void mouseEntered(MouseEvent e);

    public void mouseExited(MouseEvent e) ;

    public void mouseDragged(MouseEvent e);
    public void mouseMoved(MouseEvent e);
}
