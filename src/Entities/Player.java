package Entities;

import main.Game;
import main.Game.*;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import static Entities.ExtraMethod.*;
import static main.Game.SCALE;
import static utilz.Constant.PlayerConstant.*;

public class Player extends Entities {
    private int[][] type;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick;
    private final int aniSpeed = 20;
    private int aniIndex = 0;
    private boolean isLeft, isRight, isUp, isDown, isMoving;
    private boolean isAttack, isJump, isAttackJump1, isAttackJump2, isGround;
    private int player_action = IDLE;
    private final float playerSpeed = 1.0f;
    public float xDrawOffSet = 21 * SCALE;
    public float yDrawOffSet = 4 * SCALE;
    private float fallSpeedAfterCollision = 0.5f * SCALE;


    // Jumping and gravity
    private float airSpeed = 0f;
    private boolean inAir;
    private float gravity = 0.04f * SCALE;
    private float jumpSpeed = -2.25f * SCALE    ;
    private float fallSpeed = 0.5f * SCALE;

    Color color;
    private final Random rnd = new Random();

    private void importImage() {
        img = LoadSave.getImg(LoadSave.SPRITE_PLAYER);
    }

    public Player(int x, int y, float width, float height) {
        super(x, y, (int) width, (int) height);
        importImage();
        loadAnimation();
        initBorder(x, y, 20 * SCALE, 27 * SCALE );
    }



    private void loadAnimation() {
        animations = new BufferedImage[9][6];
        for (int i = 0; i < animations.length; i++) {
            for (int j = 0; j < animations[i].length; j++) {
                animations[i][j] = img.getSubimage(j * 64, i * 40, 64, 40);
            }
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(animations[player_action][aniIndex], (int) (border.x - xDrawOffSet), (int) (border.y - yDrawOffSet), width, height, null);

//        drawBorder(graphics);
    }

    public void update() {
        updateAnimationTick();
        chooseMode();
        updatePos();
    }

    private void chooseMode() {
        player_action = IDLE;
        if (isMoving) player_action = RUNNING;
        else if (isAttack) player_action = ATTACK_1;
        else if (isAttackJump1) player_action = ATTACK_1_JUMP;
        else if (isAttackJump2) player_action = ATTACK_2_JUMP;
        else if (isJump) player_action = JUMP;
        else if (isGround) player_action = GROUND;
        isGround = false;
    }

    public void updatePos() {
        isMoving = false;
        if (isJump) {
            jump();
        }
        System.out.println(isEntityOnTheFloor(border, type));
        if (!isLeft && !isRight && !inAir) return;
        float xSpeed = 0;
        if (isLeft) {
            xSpeed -= playerSpeed * SCALE;
        }
        if (isRight) {
            xSpeed += playerSpeed * SCALE;
        }
        if (!inAir){
            if (!isEntityOnTheFloor(border, type)) inAir = true;
        }
        if (inAir) {
            if (isMovingPossible(border.x, border.y + airSpeed, border.width, border.height, type)) {
                border.y += airSpeed;
                airSpeed += gravity;
                updateXPos(xSpeed);
            } else {
                border.y = updateSpaceBetweenYandWall(border, airSpeed);
                if (airSpeed > 0) {
                    resetInAir();
                } else airSpeed = fallSpeedAfterCollision;
                updateXPos(xSpeed);
            }
        } else {
            updateXPos(xSpeed);
        }
        System.out.println(inAir);
    }

    private void jump() {
        if (inAir) return;
        inAir = true;
        airSpeed = jumpSpeed;
    }

    private void resetInAir() {
        airSpeed = 0;
        inAir = false;
        isJump = false;
    }

    private void updateXPos(float xSpeed) {
        if (ExtraMethod.isMovingPossible(border.x + xSpeed, border.y, (int) border.width, (int) border.height, type)) {
            border.x += xSpeed;
        } else {
            border.x = updateSpaceBetweenXandWall(border, xSpeed);
        }
    }


    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getTypeMode(player_action)) {
                aniIndex = 0;
            }
        }
    }


    public void setLeft(boolean left) {
        isLeft = left;
    }


    public void setRight(boolean right) {
        isRight = right;
    }


    public void setUp(boolean up) {
        isUp = up;
    }


    public void setDown(boolean down) {
        isDown = down;
    }

    public void setAttackJump2(boolean attackJump2) {
        isAttackJump2 = attackJump2;
    }


    public void setAttackJump1(boolean attackJump1) {
        isAttackJump1 = attackJump1;
    }


    public void setJump(boolean jump) {
        isJump = jump;
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
    }


    public void windowFocusLost() {
        isGround = isMoving = isAttack = isAttackJump1 = isAttackJump2 = isJump = false;
        isLeft = isRight = isUp = isDown = false;
    }

    public void setType(int[][] type) {
        this.type = type;
        if (!isEntityOnTheFloor(border, type)) inAir = true;
    }
}
