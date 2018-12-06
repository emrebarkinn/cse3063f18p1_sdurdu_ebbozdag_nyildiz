import java.util.ArrayList;
import java.util.Scanner;

public class Block {

    private int index;
    private String name;
    private double price;
    private double rent;
    private Player owner;
    private ArrayList<Player> visiter;
    public Block(){

    }

    public Block(int index,String name) {
        this.index = index;
        this.name = name;
    }

    public Block(int index, String name, double price, double rent) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.owner=null;
    }

    public Block(int index) {
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

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

    public void playerVisit(Player player){
        visiter.add(player);
    }

    public void playTurn(Player player){ //it is boolean for end the game
        printBlock(player);
        if(this.price==0){
            return;
        }
        if(this.owner==null){
            askToPlayerToPurchase(player);
        }
        if(this.owner!=player && this.owner!=null){
            rentBlock(player);
        }
    }
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName();
        System.out.println( name+" and has "+player.getMoney()+" money  in the "+getName()+" block.");
    }
    public void askToPlayerToPurchase(Player player){
        Scanner scan =new Scanner(System.in);
        String input="y"; //TODO error check

        if(!player.isControlled()) {
            System.out.println("Block "+this.getName()+" price is :" + this.getPrice()+" and rent price:"+this.getRent());
            System.out.println("Do you want to purchase " + this.getName() + " block ? y/n");
            input =scan.next();
        }
        if(input.equals("y") || input.equals("Y")){
            purchaseBlock(player);
        }

    }
    public void purchaseBlock(Player player){

            player.addOwnedBlock(this);
            this.owner = player;
            player.optionalPay(this.getPrice());
            System.out.println(player.getName()+" just bought the block "+this.getName()+
                    "\nNow Player "+ player.getName()+" has "+player.getMoney()+" money");

    }
    public void rentBlock(Player player){

        System.out.println("Block "+this.getName()+" has already an owner and owner name is :"+this.owner.getName());
        System.out.println("Player "+ player.getName()+" have to pay "+this.getRent()+" to player "+this.owner.getName());


        player.mandotoryPay(this.getRent());
        this.owner.increaseMoney(this.rent);
        System.out.println(player.getName()+" just pay a rent ("+this.getRent()+") for block "+this.getName()+
                "\nNow Player"+ player.getName()+" has "+player.getMoney()+" money");

    }



}
