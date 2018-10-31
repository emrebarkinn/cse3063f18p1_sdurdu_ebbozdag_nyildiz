import java.util.Random;

public class Die {
    private int face;
    private Random random;

    public Die() {
        random=new Random();
        face=0;
    }

    public void rollDice(){

        face = random.nextInt(6)+1;

    }

    public int getFace() {
        return face;
    }
}
