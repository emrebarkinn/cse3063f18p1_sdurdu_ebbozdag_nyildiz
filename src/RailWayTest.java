import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RailWayTest {
    Player player;
    int size;


    @Before
    public void setUp(){
        size=4;
        player=new Player("Owner",1000,1,true,null);
        for(int i=0;i< size;i++) {
            player.getOwnedBlocks().add(new RailWay(i, "TrainS", 500, 100));
            player.getOwnedBlocks().get(i).setOwner(player);
        }

    }

    @Test
    public void getRentTest(){

        assertEquals(100*size,player.getOwnedBlocks().get(0).getRent(),0);
        player.getOwnedBlocks().remove(size-1);
        assertEquals(100*(size-1),player.getOwnedBlocks().get(0).getRent(),0);
        Block block=new RailWay(0,"TestRailway",500,100);
        assertEquals(100,block.getRent(),0);
    }
}
