import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    final int SIZE = 40;

    private ArrayList<Block> blocks;

    public Board() {
        blocks=new ArrayList <Block>();
        blocks.add(new StartingBlock(0,"StartingBlock"));
        for (int i=1;i<SIZE;i++){

            if(i==5) {
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            if(i==10){
                blocks.add(new JailVisit(i,"JailVisit"));
                continue;
            }
            if(i==15){
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            if(i==25) {
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            if(i==30){
                blocks.add(new GoToJail(i ,"Go To Jail"));
                continue;
            }
            if(i==35) {
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            blocks.add(new Block(i,""+i,300,200));
        }
    }

    public Block getBlock(int index){
        return blocks.get(index);
    }

    public boolean move(Player player){
        if(!player.isControlled()){
            Scanner scan =new Scanner(System.in);
            scan.nextLine();  //for debugging
        }

        return getBlock(player.getPosition()).playTurn(player);
    }



}
