package main;

import Inputs.KeyboardInput;
import Inputs.MouseInputs;
import utilz.Constant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import static main.Game.GAME_WIDTH;
import static main.Game.GAME_HEIGHT;
public class GamePanel extends JComponent {
    private Game game;
    MouseInputs mouseInputs = new MouseInputs(this);
    public GamePanel(Game game) {
        this.game = game;
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        setPanelSize();
    }
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        game.update();
        game.render(graphics);
    }
    public Game getGame(){
        return this.game;
    }
}
