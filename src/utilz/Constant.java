package utilz;

public class Constant {
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
