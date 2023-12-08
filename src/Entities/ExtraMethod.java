package Entities;

import main.Game;

import java.awt.geom.Rectangle2D;

import static main.Game.GAME_HEIGHT;
import static main.Game.TILES_DEFAULT_SIZE;
import static utilz.LoadSave.LEVEL_ONE_FORM_MAP;

public class ExtraMethod{
    public static boolean isSolid(float x, float y, int[][] type){
        int maxX = type[0].length * TILES_DEFAULT_SIZE;
        if (x < 0 || x >= maxX) return true;
        if (y < 0 || y >= GAME_HEIGHT) return true;
        float yPos = y / Game.TILE_SIZE;
        float xPos = x / Game.TILE_SIZE;
        int value = type[(int)yPos][(int)xPos];
        return (value >= 48 || value < 0 || value != 11);
    }
    public static boolean isMovingPossible(float x, float y, float width, float height, int[][] type){
        System.out.println(x + " " + y);
        if (!isSolid(x, y, type))
            if (!isSolid(x+width,y+height, type))
                if (!isSolid(x+width, y, type))
                    return !isSolid(x, y + height, type);
        return false;
    }
    public static float updateSpaceBetweenXandWall(Rectangle2D.Float border, float xSpeed){
        int currentTile = (int) (border.x / Game.TILE_SIZE);
        if (xSpeed > 0){
            int tileXPos = currentTile * Game.TILE_SIZE;
            int xDrawOffSet = (int)( Game.TILE_SIZE - border.width);
            return tileXPos + xDrawOffSet - 1;
        }
        else{
            return currentTile * Game.TILE_SIZE;
        }
    }
    public static float updateSpaceBetweenYandWall(Rectangle2D.Float border, float airSpeed){
        int currentTile = (int) (border.y / Game.TILE_SIZE);
        if (airSpeed > 0){
            int tileYPos = currentTile * Game.TILE_SIZE;
            int yDrawOffSet = (int)( Game.TILE_SIZE - border.height);
            return tileYPos + yDrawOffSet - 1;
        }
        else{
            return currentTile * Game.TILE_SIZE;
        }
    }
    public static boolean isEntityOnTheFloor(Rectangle2D.Float border, int[][] type){
        if (!isSolid(border.x, border.y + border.height + Game.SCALE, type))
            if (!isSolid(border.x + border.width, border.y + border.height + Game.SCALE, type)) return false;
        return true;
    }
}