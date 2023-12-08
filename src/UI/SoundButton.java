package UI;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.SOUNDS_BUTTON.SOUND_SIZE_DEFAULT;

public class SoundButton extends PauseButton{
    private BufferedImage[][] img;
    private int indexI, indexJ;
    private boolean isMoved, isPressed;
    private boolean isMuted;
    public SoundButton(int x, int y, int w, int h) {
        super(x, y, w, h);
        loadSoundImg();
    }

    private void loadSoundImg() {
        BufferedImage temp = LoadSave.getImg(LoadSave.SOUND_BUTTONS);
        img = new BufferedImage[2][3];
        for (int i=0; i<2; i++){
            for (int j=0; j<3; j++){
                img[i][j] = temp.getSubimage(j * SOUND_SIZE_DEFAULT,i * SOUND_SIZE_DEFAULT,SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT);
            }
        }
    }
    public void update(){
        if (isMuted) indexI = 1;
        else indexI = 0;
        indexJ = 0;
        if (isMoved) indexJ = 1;
        if (isPressed){
            indexJ = 2;
        }
    }
    public void reset(){
        isPressed = false;
        isMoved = false;
    }
    public void draw(Graphics g){
        g.drawImage(img[indexI][indexJ], x,y,w,h, null);
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public void setMuted(boolean muted) {
        isMuted = muted;
    }

    public boolean getMuted() {
        return isMuted;
    }
}
