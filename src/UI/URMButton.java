package UI;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import static utilz.Constant.UI.URM_BUTTONS.URM_DEFAULT_SIZE;

public class URMButton extends PauseButton{
    private BufferedImage img[][];
    private int indexI, indexJ;
    private boolean replay, gameContinue, gameHome;
    private boolean moved, pressed;
    public URMButton(int x, int y, int w, int h) {
        super(x, y, w, h);
        loadImg();
    }

    private void loadImg() {
        BufferedImage tmp = LoadSave.getImg(LoadSave.URM_BUTTONS);
        img = new BufferedImage[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3;j++){
                img[i][j] = tmp.getSubimage(j * URM_DEFAULT_SIZE, i*URM_DEFAULT_SIZE, URM_DEFAULT_SIZE, URM_DEFAULT_SIZE);
            }
        }
    }

    public void update(){
        if (gameContinue) indexI = 0;
        if (replay) indexI = 1;
        if (gameHome) indexI = 2;
        indexJ = 0;
        if (moved) indexJ = 1;
        if (pressed) indexJ = 2;
    }
    public void draw(Graphics g){
        g.drawImage(img[indexI][indexJ], x, y, w, h, null);
    }

    public void reset(){
        moved = false;
        pressed = false;
    }

    public void setReplay(boolean replay) {
        this.replay = replay;
    }

    public void setGameContinue(boolean gameContinue) {
        this.gameContinue = gameContinue;
    }

    public void setGameHome(boolean gameHome) {
        this.gameHome = gameHome;
    }


    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

}
