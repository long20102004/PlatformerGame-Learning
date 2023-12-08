package utilz;

import static main.Game.SCALE;

public class Constant {
    public static class UI{
        public static class MenuButton{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * SCALE);
        }
        public static class MenuBackground{
            public static final int BACK_HEIGHT = (int) (336 * SCALE);
            public static final int BACK_WIDTH = (int) (282 * SCALE);
        }
        public static class SOUNDS_BUTTON{
            public static final int SOUND_SIZE_DEFAULT = 42;
            public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * SCALE);
        }
        public static class URM_BUTTONS{
            public static final int URM_DEFAULT_SIZE = 56;
            public static final int URM_SIZE = (int) (56 * SCALE);
        }
        public static class VOLUME_BUTTONS{
            public static final int VOLUME_DEFAULT_WIDTH = 28;
            public static final int VOLUME_DEFAULT_HEIGHT = 44;
            public static final int SLIDER_DEFAULT_WIDTH = 215;
            public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * SCALE);
            public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * SCALE);
            public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * SCALE);
        }
    }
    public static class Direction{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int DOWN = 2;
        public static final int RIGHT = 3;
    }
    public static class PlayerConstant{
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_1_JUMP = 7;
        public static final int ATTACK_2_JUMP = 8;
        public static int getTypeMode(int play_action){
            switch (play_action){
                case IDLE:
                    return 5;
                case RUNNING:
                    return 6;
                case JUMP:
                    return 3;
                case FALLING:
                    return 1;
                case GROUND:
                    return 2;
                case HIT:
                    return 4;
                case ATTACK_1:
                    return 3;
                case ATTACK_1_JUMP:
                    return 3;
                case ATTACK_2_JUMP:
                    return 3;
            }
            return 1;
        }
    }
}
