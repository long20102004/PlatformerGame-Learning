package utilz;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String SPRITE_PLAYER = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
//    public static final String LEVEL_ONE_FORM_MAP = "level_one_data.png";
    public static final String LEVEL_ONE_FORM_MAP = "level_one_data_long.png";
    public static final String MENU_BUTTON = "button_atlas.png";
    public static final String MENU_BACKGROUND = "menu_background.png";
    public static final String PAUSE_BACKGROUND = "pause_menu.png";
    public static final String SOUND_BUTTONS = "sound_button.png";
    public static final String URM_BUTTONS = "urm_buttons.png";
    public static final String VOLUME_BUTTONS = "volume_buttons.png";
    public static final String PAUSE_ENTIRE_BACKGROUND = "background_menu.png";
    public static BufferedImage getImg(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
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
        BufferedImage img = getImg(LEVEL_ONE_FORM_MAP);
        int[][] type = new int[img.getHeight()][img.getWidth()];
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
