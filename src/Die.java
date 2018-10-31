import java.util.Random;

public class Die {
    private int face;
    private Random random;

    public Die rollDice(){
        Die die = new Die();
        return die;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
