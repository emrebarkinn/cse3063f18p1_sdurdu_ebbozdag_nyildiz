import org.junit.Test;
import static org.junit.Assert.*;

public class BlockTest {

    Block block = new Block();
    Player player = new Player();
    Player owner = new Player();

    @Test
    public void purchaseBlockTest(){ //TODO : This method give null pointer exception

        player.setMoney(100);
        block.setPrice(50);

        block.purchaseBlock(player);

        assertTrue(player.getMoney()==50);
        assertTrue(block.getOwner()==player);




    }

    @Test
    public void rentBlockTest(){

        player.setMoney(100);
        owner.setMoney(200);
        block.setOwner(owner);

        block.setRent(50);
        block.rentBlock(player);

        assertTrue(player.getMoney()==50);
        assertTrue(owner.getMoney()==250);


    }
}
