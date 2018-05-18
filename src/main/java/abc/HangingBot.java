package abc;

import com.lineate.xonix.mind.model.Bot;
import com.lineate.xonix.mind.model.GameStateView;
import com.lineate.xonix.mind.model.Move;

public class HangingBot implements Bot {

    public String getName() {
        return "I calculate \u03c0";
    }

    public Move move(GameStateView gs) {
        try {
            // pi/4 = 1 - 1/3 + 1/5 - 1/7 + ...
            double pi4 = -1;
            for (double i = 0; i < 1e9; i++) {
                if (i % 2 == 0)
                    pi4 += -1 / (2 * i - 1);
                else
                    pi4 += 1 / (2 * i - 1);
            }
            System.out.println("pi ~ " + (pi4 * 4));
            return Math.abs(pi4 * 4 - Math.PI) < 1e-10 ? Move.LEFT : Move.RIGHT;
        } catch (Exception e) {
            // ignored
        }
        return Move.STOP;
    }

    public static void main(String[] args) {
        Move m = new HangingBot().move(null);
        System.out.println("m = " + m);
    }
}