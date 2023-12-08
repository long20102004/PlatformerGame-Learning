package UI;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.VOLUME_BUTTONS.*;

public class VolumeButton extends PauseButton{
    private BufferedImage[] img;
    private BufferedImage slider;
    private int buttonX, minX, maxX;
    private int index;
    private boolean moved, pressed;
    public VolumeButton(int x, int y, int w, int h) {
        super(x, y, w, h);
        buttonX = x + w / 2;
        minX = x;
        maxX = x + w - VOLUME_WIDTH;
        bound = new Rectangle(buttonX, y, VOLUME_WIDTH, VOLUME_HEIGHT);
        loadButtons();
    }
    public void changeX(int x){
        if (x < minX) buttonX = minX;
        else if (x > maxX) buttonX = maxX;
        else buttonX = x;
        bound.x = buttonX;
    }
    private void loadButtons() {
        BufferedImage tmp = LoadSave.getImg(LoadSave.VOLUME_BUTTONS);
        img = new BufferedImage[3];
        for (int i=0; i<3; i++){
            img[i] = tmp.getSubimage(i * VOLUME_DEFAULT_WIDTH, 0, VOLUME_DEFAULT_WIDTH,  VOLUME_DEFAULT_HEIGHT);
        }
        slider = tmp.getSubimage(3 * VOLUME_DEFAULT_WIDTH, 0 , SLIDER_DEFAULT_WIDTH, VOLUME_DEFAULT_HEIGHT);
    }
    public void update(){
        index = 0;
        if (pressed) index = 2;
        if (moved) index = 1;
    }
    public void draw(Graphics g){
        g.drawImage(slider, x, y, SLIDER_WIDTH, VOLUME_HEIGHT, null);
        g.drawImage(img[index],buttonX, y, VOLUME_WIDTH, VOLUME_HEIGHT, null);
    }
    public void reset(){
        moved = false;
        pressed = false;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isMoved() {
        return moved;
    }

    public boolean isPressed() {
        return pressed;
    }
}
