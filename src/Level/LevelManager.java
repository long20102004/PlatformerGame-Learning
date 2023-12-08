package Level;

import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Game.SCALE;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;
    private Level Level_One;
    public void importImg(){
        importOutsideSprite();
    }
    private void importOutsideSprite() {
        BufferedImage image = LoadSave.getImg(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for (int i=0; i < 4; i++){
            for (int j=0; j<12; j++){
                int index = i * 12 + j;
                levelSprite[index] = image.getSubimage(j*32, i*32, 32, 32);
            }
        }
    }

    public LevelManager(Game game){
        this.game = game;
        importImg();
        Level_One = new Level(LoadSave.getType());
    }
    public void render(Graphics graphics, int XlevelOffset){
        for (int i=0; i< Game.TILES_IN_HEIGHT; i++){
            for (int j=0; j<Level_One.getLevelType()[0].length; j++){
                int position = Level_One.getType(j,i);
                graphics.drawImage(levelSprite[position], (int) (j* Game.TILE_SIZE - XlevelOffset), i*Game.TILE_SIZE, Game.TILE_SIZE, Game.TILE_SIZE, null);
            }
        }
    }
    public void update(){
    }

    public Game getGame() {
        return game;
    }

    public Level getLevel_One() {
        return Level_One;
    }
}
