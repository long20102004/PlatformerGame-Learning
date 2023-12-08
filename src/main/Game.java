package main;

import Entities.Player;
import Level.LevelManager;
import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;

import java.awt.*;

public class Game implements Runnable {
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILE_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_IN_WIDTH * TILE_SIZE;
    public final static int GAME_HEIGHT = TILES_IN_HEIGHT * TILE_SIZE;

    private final int FPS = 120;
    private final int UPS = 100;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Playing playing;
    private Menu menu;

    public Game() {
        classInit();
        gamePanel = new GamePanel(this);
        this.gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        start();
    }

    public void classInit() {
        playing = new Playing(this);
        menu = new Menu(this);
    }

    private void start() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        switch (Gamestate.state) {
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
        }
    }

    public void render(Graphics graphics) {
        switch (Gamestate.state) {
            case MENU:
                menu.draw(graphics);
                break;
            case PLAYING:
                playing.draw(graphics);
                break;
        }
    }

    @Override
    public void run() {
        Double timePerFrame = 1000000000.0 / FPS;
        Double timePerUpdate = 1000000000.0 / UPS;
        long lastCheck = System.nanoTime();
        long lastTime = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;
        Double timeFrameLeft = 0.0, timeUpdateLeft = 0.0;
        while (true) {
            long now = System.nanoTime();
            timeUpdateLeft += (now - lastCheck) / timePerUpdate;
            timeFrameLeft += (now - lastCheck) / timePerFrame;
            lastCheck = now;
            if (timeUpdateLeft >= 1) {
                update();
                updates++;
                timeUpdateLeft--;
            }
            if (timeFrameLeft >= 1) {
                gamePanel.repaint();
                frames++;
                timeFrameLeft--;
            }
            if (System.currentTimeMillis() - lastTime >= 1000) {
                System.out.println("FPS: " + frames + "| UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTime = System.currentTimeMillis();
            }
        }
    }


    public Playing getPlaying() {
        return playing;
    }

    public Menu getMenu() {
        return menu;
    }
}
