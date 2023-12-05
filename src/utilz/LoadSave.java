package utilz;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String SPRITE_PLAYER = "/player_sprites.png";
    public static final String LEVEL_ATLAS = "/outside_sprites.png";
    public static final String LEVEL_ONE_FORM_MAP = "/level_one_data.png";
    public static BufferedImage getImg(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream(fileName);
        try {
            img = ImageIO.read(is);
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
    public static int[][] getType(){
        int[][] type = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH ];
        BufferedImage img = getImg(LEVEL_ONE_FORM_MAP);
        for (int i=0; i<img.getHeight(); i++){
            for (int j=0; j<img.getWidth(); j++){
                Color color = new Color(img.getRGB(j,i));
                int value = color.getRed();
                if (value >= 48){
                    value = 0;
                }
                type[i][j] = value;
            }
        }
        return type;
    }
}
