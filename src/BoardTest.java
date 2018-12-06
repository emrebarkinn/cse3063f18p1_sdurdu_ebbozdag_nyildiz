import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {

    @Before
    public void setUp(){
        player=new Player("eee",200,10,true,null);
        board = new Board();
    }
    Board board;
    Player player;




}
