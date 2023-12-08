package gamestates;

import Entities.Player;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class State {
    private Player player;
    public static boolean isIn(MouseEvent e, Rectangle rectangle){
        return rectangle.contains(e.getX(), e.getY());
    }
}
