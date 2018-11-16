import java.util.ArrayList;
import java.util.Scanner;

public class Block {

    private int index;
    private String name;
    private double price;
    private double rent;

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
        this.owner=null;
    }

    public void playerVisit(Player player){
        visiter.add(player);
    }

    public boolean playTurn(Player player){ //it is boolean for end the game

        boolean bankruptcy=false;
        printBlock(player);
        if(this.owner==null && player.getMoney()>=this.getPrice()){
            purchaseBlock(player);
        }else if(this.owner==null){
            System.out.println(player.getName()+" has not enough money to buy "+this.getName()+" block");
        }else if(this.owner!=player){
            rentBlock(player);

        }
        if(player.getMoney()<0)
            bankruptcy=true;


        return !bankruptcy;

    }
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName()+" and has "+player.getMoney()+" money";
        System.out.println( name+" in the "+getName()+" block.");
    }
    public void purchaseBlock(Player player){

        Scanner scan =new Scanner(System.in);
        String input="y"; //TODO error check

        if(!player.isControlled()) {
            System.out.println("Block "+this.getName()+" price is :" + this.getPrice()+" and rent price:"+this.getRent());
            System.out.println("Do you want to purchase " + this.getName() + " block ? y/n");
            input =scan.next();
        }
        if(input.equals("y") || input.equals("Y")) {
            player.addOwnedBlock(this);
            this.owner = player;
            player.decreaseMoney(this.getPrice());
            System.out.println(player.getName()+" just bought the block "+this.getName()+
                    "\nNow Player"+ player.getName()+" has "+player.getMoney()+" money");

        }
    }
    public void rentBlock(Player player){

        System.out.println("Block "+this.getName()+" has already an owner and owner name is :"+this.owner.getName());
        System.out.println("Player "+ player.getName()+" have to pay "+this.getRent()+" to player "+this.owner.getName());


        player.decreaseMoney(this.rent);
        this.owner.increaseMoney(this.rent);
        System.out.println(player.getName()+" just pay a rent ("+this.getRent()+") for block "+this.getName()+
                "\nNow Player"+ player.getName()+" has "+player.getMoney()+" money");

    }

}