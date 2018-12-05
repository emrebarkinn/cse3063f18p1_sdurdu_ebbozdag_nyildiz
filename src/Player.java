
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
    private boolean bankruptcy;
    private double wealth;
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
        this.bankruptcy=false;
    }
    //TODO add generate random user name function

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isBankruptcy() {
        if ((this.getMoney()<0)) bankruptcy = true;
        else bankruptcy = false;
        return bankruptcy;
    }

    public double getWealth() {
        calculateWealth();
        return wealth;
    }

    public void increaseMoney(double money){
        this.money+=money;

    }

    public void decreaseMoney(double money){
        this.money-=money;
        if(money<0)
            this.bankruptcy=true;

    }
    public void mandotoryPay(double money){
        boolean cond=true;
        while(this.money-money<0&&cond){
            if(getWealth()-money>=0){
                System.out.println("You dont have enough money to pay "+money+" but you can get that money by selling your blocks.");
                cond=this.sellOwnedBlock();
            }else
                cond=false;
        }
        decreaseMoney(money);
    }
    public void optionalPay(double money){

        if(this.money-money>=0){
            decreaseMoney(money);
            return;
        }
        System.out.println("You don't have enough money to pay "+money);
    }
    public void calculateWealth(){
        this.wealth=this.money+sumOfOwnedBlocks();
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
        Scanner scan = new Scanner(System.in);
        int input=1;
        //print owned blocks


        //choose a block to sell or don't sell, if computer plays; sell first owned block

        if(!isControlled){
            System.out.println("0) Don't sell any block!");
            printOwnedBlocks();
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
        if(!isControlled)
            System.out.println("You sell the block \"" + ownedBlocks.get(input).getName() + "\" and you gain money: " + ownedBlocks.get(input).getPrice());
        else
            System.out.println("Player "+this.getName()+" sell the block \"" + ownedBlocks.get(input).getName() + "\" and "+this.getName()+" gain money: " + ownedBlocks.get(input).getPrice());
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
    public double sumOfOwnedBlocks(){
        double sum=0;
        for(Block block:ownedBlocks){
            sum+=block.getPrice();

        }
        return sum;
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
