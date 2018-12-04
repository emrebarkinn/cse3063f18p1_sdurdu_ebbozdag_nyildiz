import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {


    Board board = new Board();
    Player player = new Player();
    ArrayList<Block> blocks = new ArrayList<Block>();
    Block block = new Block();
    Die die = new Die();

    @Test
    public void moveTest(){ //TODO : it is not working

        player.setPosition(10);
        board.move(player);
        assertEquals(20,player.getPosition());

    }

    @Test
    public void getBlockTest(){

        block.setIndex(5);
        blocks.add(block);
        board.getBlock(5);
        assertTrue(5==block.getIndex());


    }


}
