import java.util.ArrayList;

public class Board {

    final int SIZE = 40;

    private ArrayList<Block> blocks;

    public Board() {
        blocks=new ArrayList <Block>();
        blocks.add(new StartingBlock());
        for (int i=1;i<SIZE;i++){

            if(i==5) {
                blocks.add(new LuckyCard());
                continue;
            }
            if(i==10){
                blocks.add(new JailVisit());
                continue;
            }
            if(i==15){
                blocks.add(new LuckyCard());
                continue;
            }
            if(i==25) {
                blocks.add(new LuckyCard());
                continue;
            }
            if(i==30){
                blocks.add(new GoToJail());
                continue;
            }
            if(i==35) {
                blocks.add(new LuckyCard());
                continue;
            }
            blocks.add(new Block(i,""+i,300,200));//for now we only create 36 blocks,3 gotojail block  and one startingBlock
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

    public boolean move(Player player){

        return blocks.get(player.getPosition()).playTurn(player);
    }



}
