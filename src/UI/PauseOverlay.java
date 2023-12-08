package UI;

import gamestates.Gamestate;
import gamestates.Playing;
import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static gamestates.State.isIn;
import static main.Game.*;
import static utilz.Constant.UI.SOUNDS_BUTTON.SOUND_SIZE;
import static utilz.Constant.UI.URM_BUTTONS.URM_SIZE;
import static utilz.Constant.UI.VOLUME_BUTTONS.*;

public class PauseOverlay {
    private BufferedImage background;
    private BufferedImage pause_background;
    private int bgX, bgY, bgW, bgH;
    private SoundButton musicButton, sfxButton;
    private URMButton replayButton, homeButton, continueButton;
    private VolumeButton volumeButton;
    private Playing playing;
    public PauseOverlay(Playing playing){
        this.playing = playing;
         loadBackground();
         createButtonSound();
         createURMButton();
         createVolumeButton();
    }
    public void createButtonSound(){
        int soundX = (int) (455 * SCALE);
        int soundY = (int) (145 * SCALE);
        int sfxY = (int) (191 * SCALE);
        musicButton = new SoundButton(soundX, soundY, SOUND_SIZE, SOUND_SIZE);
        sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
    }
    public void createVolumeButton(){
        int volumeX = (int) (bgX + 20 * SCALE), volumeY = bgY + (int) (250 * SCALE);
        volumeButton = new VolumeButton(volumeX, volumeY, SLIDER_WIDTH, VOLUME_HEIGHT);
    }
    public void createURMButton(){
        int homeX = (int) (315 * SCALE);
        int replayX = (int) (390 * SCALE);
        int continueX = (int) (465 * SCALE);
        int urmY = (int) (330 * SCALE);
        homeButton = new URMButton(homeX, urmY, URM_SIZE, URM_SIZE);
        homeButton.setGameHome(true);
        replayButton = new URMButton(replayX, urmY, URM_SIZE, URM_SIZE);
        replayButton.setReplay(true);
        continueButton = new URMButton(continueX, urmY, URM_SIZE, URM_SIZE);
        continueButton.setGameContinue(true);
    }
    private void loadBackground(){
        pause_background = LoadSave.getImg(LoadSave.PAUSE_ENTIRE_BACKGROUND);
        background = LoadSave.getImg(LoadSave.PAUSE_BACKGROUND);
        bgW = (int) (background.getWidth() * SCALE);
        bgH = (int) (background.getHeight() * SCALE);
        bgX = GAME_WIDTH / 2 - bgW / 2;
        bgY = GAME_HEIGHT / 2 - bgH / 2;
    }
    public void draw(Graphics g){
        g.drawImage(pause_background, 0, 0, (int) (pause_background.getWidth() * SCALE), (int) (pause_background.getHeight() * SCALE), null);
        g.drawImage(background, bgX, bgY, bgW, bgH, null);
        musicButton.draw(g);
        sfxButton.draw(g);
        homeButton.draw(g);
        replayButton.draw(g);
        continueButton.draw(g);
        volumeButton.draw(g);
    }
    public void update(){
        musicButton.update();
        sfxButton.update();
        homeButton.update();
        replayButton.update();
        continueButton.update();
        volumeButton.update();
    }
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton.getBound())) {
            musicButton.setPressed(true);
        }
        if (isIn(e, sfxButton.getBound())) {
            sfxButton.setPressed(true);
        }
        if (isIn(e, homeButton.getBound())){
            homeButton.setPressed(true);
        }
        if (isIn(e, replayButton.getBound())){
            replayButton.setPressed(true);
        }
        if (isIn(e, continueButton.getBound())){
            continueButton.setPressed(true);
        }
        if (isIn(e, volumeButton.getBound())){
            volumeButton.setPressed(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton.getBound())) {
            if (musicButton.isPressed()){
                musicButton.setMuted(!musicButton.getMuted());
            }
        }
        if (isIn(e, sfxButton.getBound())) {
            if (sfxButton.isPressed()){
                sfxButton.setMuted(!sfxButton.getMuted());
            }
        }
        if (isIn(e, homeButton.getBound())){
            if (homeButton.isPressed()) {
                Gamestate.state = Gamestate.MENU;
                playing.setPaused(false);
            }
        }
        if (isIn(e, replayButton.getBound())){
            // code
        }
        if (isIn(e, continueButton.getBound())){
            if (continueButton.isPressed()) playing.setPaused(false);
        }
        musicButton.reset();
        sfxButton.reset();
        homeButton.reset();
        replayButton.reset();
        continueButton.reset();
        volumeButton.reset();
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        if (volumeButton.isPressed()){
            volumeButton.changeX(e.getX());
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (isIn(e, musicButton.getBound())) {
            musicButton.setMoved(true);
        }
        else musicButton.setMoved(false);
        if (isIn(e, sfxButton.getBound())) {
            sfxButton.setMoved(true);
        }
        else sfxButton.setMoved(false);
        if (isIn(e, homeButton.getBound())){
            homeButton.setMoved(true);
        }
        else homeButton.setMoved(false);
        if (isIn(e, replayButton.getBound())){
            replayButton.setMoved(true);
        }
        else replayButton.setMoved(false);
        if (isIn(e, continueButton.getBound())){
            continueButton.setMoved(true);
        }
        else continueButton.setMoved(false);
        if (isIn(e, volumeButton.getBound())){
            volumeButton.setMoved(true);
        }
        else volumeButton.setMoved(false);
    }

    public Playing getPlaying() {
        return playing;
    }
}
