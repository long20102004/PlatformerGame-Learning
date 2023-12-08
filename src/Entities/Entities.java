package Entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entities {
    public float x,y;
    public int width,height;
    public Rectangle2D.Float border;
    public Entities(float x,float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void initBorder(float x, float y, float width, float height){
        this.border = new Rectangle2D.Float(x,y,width,height);
    }
    public void drawBorder(Graphics g){
        g.setColor(Color.PINK);
        g.drawRect((int)border.x,(int)border.y,(int)border.width,(int) border.height);
    }
    public Rectangle2D.Float getHitBox(){
        return this.border;
    }
}
