import java.util.ArrayList;

public class Board {

    final int SIZE = 40;

    private ArrayList<Block> blocks;

    public Board() {
        blocks=new ArrayList <Block>();
        blocks.add(new StartingBlock());
        for (int i=1;i<SIZE;i++){

            if(i==10){
                blocks.add(new GoToJail());
                continue;
            }
            if(i==20){
                blocks.add(new GoToJail());
                continue;
            }
            if(i==30){
                blocks.add(new GoToJail());
                continue;
            }

            blocks.add(new Block(i,""+i,200,20));//for now we only create 39 blocks and one startingBlock
        }
    }

    public Block getBlock(int index){
        //TODO not finished


        return blocks.get(index);
    }

    public Player moveCalculate(int index){
        Player player = new Player();
        return player;
    }

    public void move(Player player){

        blocks.get(player.getPosition()).playTurn(player);
    }



}
