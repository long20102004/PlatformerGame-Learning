package gamestates;

import Entities.Player;
import Level.LevelManager;
import UI.MenuButton;
import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static main.Game.*;
import static utilz.Constant.UI.MenuBackground.BACK_HEIGHT;
import static utilz.Constant.UI.MenuBackground.BACK_WIDTH;

public class Menu extends State implements StateMethods{
    private Player player;
    private LevelManager levelManager;
    private Game game;
    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage background;

    public Menu(Game game) {
        this.game = game;
        initClass();
        loadButtons();
        loadBackGround();
    }
    private void initClass(){
        levelManager = new LevelManager(game);
        player = new Player(200, 200, (int) (64 * SCALE), (int) (40 * SCALE));
        player.setType(levelManager.getLevel_One().getLevelType());
    }
    private void loadBackGround() {
        background = LoadSave.getImg(LoadSave.MENU_BACKGROUND);
    }
    private void drawBackground(Graphics g){
        g.drawImage(background, GAME_WIDTH / 2 - BACK_WIDTH / 2,GAME_HEIGHT / 2 - BACK_HEIGHT / 2 ,BACK_WIDTH, BACK_HEIGHT, null);
    }
    @Override
    public void draw(Graphics g) {
        drawBackground(g);
        for (MenuButton button : buttons){
            button.draw(g);
        }
    }
    private void loadButtons() {
        buttons[0] = new MenuButton(GAME_WIDTH / 2, (int) (160 * SCALE), 0, Gamestate.PLAYING);
        buttons[1] = new MenuButton(GAME_WIDTH / 2, (int) (230 * SCALE), 1, Gamestate.MENU);
        buttons[2] = new MenuButton(GAME_WIDTH / 2, (int) (300 * SCALE), 2, Gamestate.QUIT);
    }
    @Override
    public void update() {
        for (MenuButton button : buttons){
            button.update();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (MenuButton button : buttons){
            if (isIn(e, button.getBounds())){
                    button.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (MenuButton button : buttons){
            if (isIn(e, button.getBounds())){
                button.setGameState();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (MenuButton button : buttons){
            if (isIn(e, button.getBounds())){
                button.setMouseMoved(true);
            }
            else button.reset();
        }
    }

    public Player getPlayer() {
        return this.player;
    }
}
