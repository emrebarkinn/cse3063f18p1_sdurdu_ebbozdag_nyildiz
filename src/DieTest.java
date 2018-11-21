import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DieTest {

    @Test
    public void RollDiceTest(){

        Die die1 = new Die();
        Die die2 = new Die();
        die1.rollDice();
        die2.rollDice();
        assertTrue(die1.getFace()+die2.getFace()>0);

    }
}
