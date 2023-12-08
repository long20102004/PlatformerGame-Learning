package UI;
import java.awt.*;
public class PauseButton {
    protected int x,y,w,h;
    protected Rectangle bound;
    public PauseButton(int x,int y,int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        bound = new Rectangle(x,y,w,h);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Rectangle getBound() {
        return bound;
    }

    public void setBound(Rectangle bound) {
        this.bound = bound;
    }
}
