import java.util.Random;

public class LuckyCard extends DefaultBlock{

    private int type;
    private Random random;
    private String description;


    public LuckyCard(int index,String name) {
        super.setIndex(index);
        super.setName(name);
    }


    @Override
    public void playTurn(Player player){
        printBlock(player);
        takeACard(player);

    }

    public void takeACard(Player player){ 

        random = new Random();
        type=random.nextInt(4)+1;

        switch (type){

            case 1 : description=" You took Jail Card.. You have to going to jail";
                System.out.println(description);
                player.setPosition(30);
                player.getBoard().move(player);
                break;

            case 2 : description="Happy Birthday! We just give you 200";
                System.out.println(description);
                player.increaseMoney(200);

                break;
            case 3 : description="Dept Card! You must pay 100 for traffic dept.";
                System.out.println(description);
                player.decreaseMoney(100);
                break;

            case 4 : description="You won a jail free card. If you have this card you can pass the jail penalties.";
                player.increaseJailCardCount();
                System.out.println(description+"\nNow you have "+player.getJailCardCount()+" jail free card.");
                break;

        }
    }
    @Override
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName();
        System.out.println("+-+-+");
        System.out.println( name+" and has "+player.getMoney()+" money  in the "+getName()+" block.");
    }
}
