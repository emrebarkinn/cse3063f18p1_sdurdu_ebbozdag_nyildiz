import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private double money;
    private int position;
    private boolean inJail;
    private boolean isControlled; //For auto plays
    private int initialDiceValue;
    private int waiting_time;
    private int fullTurnCount;
    //
    private Board board;
    private ArrayList<Block> ownedBlocks;



    public Player() {

    }

    public Player(String name, double money, int position, boolean isControlled, Board board) {
        this.name = name;
        this.money = money;
        this.position = position;
        this.inJail = false;
        this.isControlled = isControlled;
        this.waiting_time = 0;
        this.ownedBlocks=new ArrayList <Block>();
        this.fullTurnCount=0;
        this.board = board;
    }
    //TODO add generate random user name function

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void increaseMoney(double money){
        this.money+=money;
    }

    public void decreaseMoney(double money){
        this.money-=money;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void updateInJail() {
        this.inJail = (this.waiting_time!=0);
    }

    public boolean isControlled() {
        return isControlled;
    }

    public void setControlled(boolean controlled) {
        isControlled = controlled;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }


    public void addOwnedBlock(Block owned){
        ownedBlocks.add(owned);

    }
    public boolean sellOwnedBlock(){    //return type boolean because in "playTurn" work "purchaseBlock" after succesful selling
        if(ownedBlocks.size()==0){      //blockless players can't sell anything
            return false;
        }

        //print owned blocks
        System.out.println("0) Dont sell any block!");
        printOwnedBlocks();

        //choose a block to sell or don't sell, if computer plays; sell first owned block
        Scanner scan = new Scanner(System.in);
        int input=2;
        if(!isControlled){
            System.out.println("Choose block number to SELL in above list");
            input = scan.nextInt();
        }
        else{
            return false;
        }

        if(input==0){  //"don't sell" option
            return false;
        }
        input--;  //set true index for arraylist
        System.out.println("You sell the block \"" + ownedBlocks.get(input).getName() + "\" and you gain money: " + ownedBlocks.get(input).getPrice());
        increaseMoney(ownedBlocks.get(input).getPrice());
        ownedBlocks.get(input).setOwner(null);
        ownedBlocks.remove(input);
        return true;

        //TODO not finished, isControlled sell islemlerine gozden gecir.
    }

    public void printOwnedBlocks(){
        for(int i = 0; i<ownedBlocks.size(); i++){
            System.out.print( (i+1) + ") owned block is: " + ownedBlocks.get(i).getName());
            System.out.println(" price is: " + ownedBlocks.get(i).getPrice() + " and rent is: " + ownedBlocks.get(i).getRent());
        }
    }
    public void movePlayer(int stepSize){
        this.position+= stepSize;
    }


    public int getFullTurnCount() {
        return fullTurnCount;
    }

    public void updateFullTurnCount() {
        this.fullTurnCount++;
    }
    public int getInitialDiceValue() {
        return initialDiceValue;
    }

    public void setInitialDiceValue(int initialDiceValue) {
        this.initialDiceValue = initialDiceValue;
    }




}
