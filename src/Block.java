import java.util.ArrayList;

public class Block {

    private int index;
    private String name;
    private double price;
    private double rent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Player owner;
    private ArrayList<Player> visiter;

    public Block() {

    }

    public Block(int index, String name, double price, double rent) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.rent = rent;
    }

    public void playerVisit(Player player){
        visiter.add(player);
    }

    public void playTurn(Player player){
        //TODO
        printBlock(player);
    }
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName();
        System.out.println( name+" in the "+getName()+" block.");
    }
}
