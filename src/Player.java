import java.util.ArrayList;

public class Player {

    private String name;
    private double money;
    private int position;
    private boolean inJail;
    private boolean isControlled; //For auto plays
    private int initialDiceValue;
    //
    private ArrayList<Block> ownedBlocks;
    public int getInitialDiceValue() {
        return initialDiceValue;
    }

    public void setInitialDiceValue(int initialDiceValue) {
        this.initialDiceValue = initialDiceValue;
    }

    int waiting_time;

    public Player() {

    }

    public Player(String name, double money, int position, boolean isControlled) {
        this.name = name;
        this.money = money;
        this.position = position;
        this.inJail = false;
        this.isControlled = isControlled;
        this.waiting_time = 0;
    }
    //TODO add generate random user name function
    public void increaseMoney(int a){

    }

    public void decreaseMoney(int a){

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

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
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
    public void sellOwnedBlock(int index){
        //TODO not finished
    }
    public void movePlayer(int stepSize){
        this.position+= stepSize;
    }



}
