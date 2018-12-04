import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {


    Board board = new Board();
    Player player = new Player();

    @Test
    public void moveTest(){
        player.setPosition(10);
        assertEquals(board.move(player),true);
    }


}
