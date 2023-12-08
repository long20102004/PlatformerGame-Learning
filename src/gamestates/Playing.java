package gamestates;

import Entities.Player;
import Level.LevelManager;
import UI.PauseButton;
import UI.PauseOverlay;
import UI.SoundButton;
import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.MouseEvent.BUTTON3;
import static main.Game.*;

public class Playing extends State implements StateMethods {
    private Player player;
    private LevelManager levelManager;
    private Game game;
    private boolean paused;
    private PauseOverlay pauseOverlay;

    private int xLvLOffset;
    private int leftBorder = (int) (0.2 * GAME_WIDTH);
    private int rightBorder = (int) (0.8 * GAME_WIDTH);
    private int levelTilesWide = (int) (LoadSave.getType()[0].length);
    private int maxTilesOffset = levelTilesWide - TILES_IN_WIDTH;
    private int maxLevelOffsetX = maxTilesOffset * TILE_SIZE;
    public Playing(Game game) {
        this.game = game;
        initClass();
    }

    private void initClass() {
        levelManager = new LevelManager(game);
        player = new Player(200, 200, (int) (64 * SCALE), (int) (40 * SCALE));
        player.setType(levelManager.getLevel_One().getLevelType());
        pauseOverlay = new PauseOverlay(this);
    }

    private void checkCloseToBorder(){
        int playerX = (int) player.getHitBox().x;
        int diff = playerX - xLvLOffset;
        if (diff > rightBorder){
            xLvLOffset += diff - rightBorder;
        }
        else if (diff < leftBorder){
            xLvLOffset += diff - leftBorder;
        }
        if (xLvLOffset > maxLevelOffsetX) xLvLOffset = maxLevelOffsetX;
        else if (xLvLOffset < 0) xLvLOffset = 0;
        System.out.println(maxLevelOffsetX);
    }

    @Override
    public void draw(Graphics g) {
        levelManager.render(g, xLvLOffset);
        player.render(g, xLvLOffset);
        if (paused) {
            pauseOverlay.draw(g);
        }
    }

    @Override
    public void update() {
        if (!paused) {
            levelManager.update();
            player.update();
            checkCloseToBorder();
        }
        else pauseOverlay.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player.setLeft(false);
                break;
            case KeyEvent.VK_D:
                player.setRight(false);
                break;
            case KeyEvent.VK_H:
                player.setJump(false);
                break;
            case KeyEvent.VK_J:
                player.setAttack(false);
                break;
            case KeyEvent.VK_ESCAPE:
                paused = true;
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player.setLeft(true);
                break;
            case KeyEvent.VK_D:
                player.setRight(true);
                break;
            case KeyEvent.VK_H:
                player.setJump(true);
                break;
            case KeyEvent.VK_J:
                player.setAttack(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (paused) pauseOverlay.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (paused) pauseOverlay.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (paused) pauseOverlay.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (paused) pauseOverlay.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (paused) pauseOverlay.mouseMoved(e);
    }

    public Player getPlayer() {
        return player;
    }
    public void setPaused(boolean paused){
        this.paused = paused;
    }
}
