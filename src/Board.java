import java.util.ArrayList;

public class Board {

    final int SIZE = 40;

    private ArrayList<Block> blocks;

    public Board() {
        blocks=new ArrayList <Block>();
        blocks.add(new StartingBlock());
        for (int i=1;i<SIZE;i++){
            /*
            if(i==10){
                blocks.add(new JailVisit());
                continue;
            }
            if(i==30){
                blocks.add(new GoToJail());
                continue;
            }
            */
            blocks.add(new Block(i,""+i,200,20));
        }
    }

    public Block getBlock(int index){
        //TODO not finished

        Block block = new Block();
        return block;
    }

    public Player moveCalculate(int index){
        Player player = new Player();
        return player;
    }

    public void move(Board board, Player player, int step){

    }



}
