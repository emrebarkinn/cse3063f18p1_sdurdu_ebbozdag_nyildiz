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

    public void takeACard(Player player){ //TODO unit test

        random = new Random();
        type=random.nextInt(3)+1;

        switch (type){ //TODO jail free card

            case 1 : description=" You took Jail Card.. You have to going to jail";
                System.out.println(description);
                player.setPosition(30);
                player.getBoard().move(player);
                break;

            case 2 : description="Happy Birthday! All players must pay to you 200";
                System.out.println(description);
                //TODO para ekleme islemlerini yap
                break;
            case 3 : description="Dept Card! You must pay 100 for traffic dept.";
                System.out.println(description);
                player.decreaseMoney(100);
                break;
        }
    }
}
