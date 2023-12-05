package Level;

import main.Game;
import utilz.LoadSave;

import java.awt.image.BufferedImage;

public class Level {
    private int[][] type;
    public Level(int[][] type){
        this.type = type;
    }
    public int getType(int xPos, int yPos){
        return type[yPos][xPos];
    }
    public int[][] getLevelType(){
        return this.type;
    }
}
