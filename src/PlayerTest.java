import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {

    Player player ;
    public double money;
    Block block1;
    Block block2;
    Block block3;


    @Before
    public void setUp(){
        player=new Player("eee",200,10,true,null);
        block1=new Block(15,"aaa",200,0);
        block2=new Block(12,"bbb",100,0);
        block3=new Block(5,"ccc",150,0);
        player.addOwnedBlock(block1);
        player.addOwnedBlock(block2);
        player.addOwnedBlock(block3);

    }

    @Test
    public void decreaseMoneyTest(){

        double initialMoney = player.getMoney();
        player.decreaseMoney(money);
        assertTrue(initialMoney - money == player.getMoney());
    }
    @Test
    public void increaseMoneyTest(){

        double initialMoney = player.getMoney();
        player.increaseMoney(money);
        assertTrue(initialMoney + money== player.getMoney());
    }

    @Test
    public void isInJailTest(){

        boolean inJail=true;
        assertTrue(String.valueOf(player.isInJail()),inJail);

    }
    @Test
    public void movePlayerTest(){

        player.setPosition(12);
        player.movePlayer(5);
        assertTrue(player.getPosition()==17);

    }
    @Test
    public void sellOwnedBlockTest(){



        player.sellOwnedBlock();
        assertEquals(player.getMoney(),400,0);

    }

    @Test
    public void isBankruptcyTest(){
        player.setMoney(-200);
        player.isBankruptcy();
        assertTrue(true);
    }

    @Test
    public void calculateWealthTest(){
        player.printOwnedBlocks();
        player.calculateWealth();
        //System.out.println("Player's wealth is:  "+player.getWealth());
        assertTrue(player.getWealth()==650);
    }

    @Test
    public void mandatoryPayTest(){

        player.mandotoryPay(200);
        System.out.println(player.getMoney());
        assertTrue(player.getMoney()==0);

    }
    @Test
    public void optionalPayTest(){
        player.optionalPay(300);
        System.out.println(player.getMoney());
        assertTrue(player.getMoney()==100);

    }
    @Test
    public void sumOfOwnedBlocksTest(){
        player.sumOfOwnedBlocks();
        System.out.println(player.sumOfOwnedBlocks());
        assertEquals(block1.getPrice()+block2.getPrice()+block3.getPrice(),450,0);


    }

}



