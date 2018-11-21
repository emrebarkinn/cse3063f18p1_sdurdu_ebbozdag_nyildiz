import java.util.Random;

public class LuckyCard extends Block{

    private int type;
    private Random random;
    private String description;


    public LuckyCard() {
        super();
        super.setName("Lucky Card");

    }

    @Override
    public boolean playTurn(Player player){
        super.printBlock(player);
        takeACard(player);
        return true;
    }

    public void takeACard(Player player){

        random = new Random();
        type=random.nextInt(3)+1;

        switch (type){

            case 1 : description=" You took Jail Card.. You have to going to jail";
                player.setPosition(30);
                player.getBoard().move(player);

            case 2 : description="type2";

            case 3 : description="type3";
        }
        System.out.println(description);
    }
}
