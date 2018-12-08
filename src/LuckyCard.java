import java.util.Random;

public class LuckyCard extends Block{

    private int type;
    private Random random;
    private String description;


    public LuckyCard(int index,String name) {
        super(index, name);
    }


    @Override
    public void playTurn(Player player){
        super.printBlock(player);
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
                System.out.println(description);
                player.increaseJailCardCount();
        }
    }
}
