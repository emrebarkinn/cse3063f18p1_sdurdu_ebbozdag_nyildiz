import java.util.ArrayList;
import java.util.Scanner;

public class Block extends DefaultBlock{

    private int index;
    private String name;
    private double price;
    private double rent;
    private Player owner;
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


    public void playTurn(Player player){ //it is boolean for end the game
        printBlock(player);
        if(this.price==0){
            return;
        }
        if(this.owner==null){
            askToPlayerToPurchase(player);
            return;
        }
        if(this.owner!=player){
            rentBlock(player);
        }else{
            System.out.println(player.getName()+" already owns this block");
        }
    }
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName();
        System.out.println("+-+-+");
        System.out.println( name+" and has "+player.getMoney()+" money  in the "+getName()+" block.");
    }
    public void askToPlayerToPurchase(Player player){
        Scanner scan =new Scanner(System.in);
        String input="y";
        boolean cond=true;
        if(!player.isControlled()) {
            System.out.println("Block "+this.getName()+" price is :" + this.getPrice()+" and rent price:"+this.getRent());
            System.out.println("Do you want to purchase " + this.getName() + " block ? y/n");
            input =scan.next();
        }
        while(cond){

            switch (input){
                case "y":
                case "Y":
                    purchaseBlock(player);
                    cond=false;
                    break;
                case "n":
                case "N":
                    cond=false;
                    break;
                default:
                    System.out.println("Invalid input!! Please enter y/n");
                    cond=true;
                    input =scan.next();
                    break;
            }
        }



    }
    public void purchaseBlock(Player player){
            if(player.getMoney()>=this.getRent()){
                if(player.optionalPay(this.getPrice())){


                player.addOwnedBlock(this);
                this.owner = player;

                System.out.println(player.getName()+" just bought the block "+this.getName()+
                        "\nNow Player "+ player.getName()+" has "+player.getMoney()+" money");
                }
            }else{
                System.out.println("You don't have enough money to buy this block");
            }


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
