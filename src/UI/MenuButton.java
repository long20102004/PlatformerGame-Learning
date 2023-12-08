package UI;

import gamestates.Gamestate;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static utilz.Constant.UI.MenuButton.*;


public class MenuButton {
    private int xPos, yPos, rowIndex;
    private Gamestate state;
    private BufferedImage[] img;
    private int index;
    private int xOffSetPosition = B_WIDTH / 2;
    private boolean mouseMoved, mousePressed;
    private Rectangle bounds;

    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        initBounds();
        loadImages();
    }

    private void initBounds() {
        bounds = new Rectangle(xPos - xOffSetPosition, yPos, B_WIDTH, B_HEIGHT);
    }

    private void loadImages() {
        img = new BufferedImage[3];
        BufferedImage temp = LoadSave.getImg(LoadSave.MENU_BUTTON);
        for (int i = 0; i < 3; i++) {
            img[i] = temp.getSubimage(i * B_WIDTH_DEFAULT , rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(img[index], xPos - xOffSetPosition, yPos, B_WIDTH, B_HEIGHT, null);
    }

    public void update() {
        index = 0;
        if (mouseMoved) index = 1;
        else if (mousePressed) index = 2;
    }

    public void reset() {
        mouseMoved = false;
        mousePressed = false;
    }

    public void setGameState() {
        Gamestate.state = state;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public void setMouseMoved(boolean mouseMoved){
        this.mouseMoved = mouseMoved;
    }

    public Rectangle getBounds() {
        return bounds;
    }


}
