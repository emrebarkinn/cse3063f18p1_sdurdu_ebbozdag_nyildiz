import java.util.*;

import java.util.concurrent.TimeUnit;

public class GameManager {
    private String[] names={"George","Kazım","Stacy","Gwen","Slevin","Michael","Stephan","Jean","Christina","Müslüm"};
    private ArrayList<Player> players;
    private Player winner;
    private Board board;
    private Die die1;
    private Die die2;
    private int playerNum;
    private int turnMoney;
    private int fullTurnNumber;


    public GameManager() {
        this.players = new ArrayList <Player>();
        this.die1 = new Die();
        this.die2 = new Die();
        this.board=new Board();
        this.turnMoney = 150;
    }

    public boolean startGame(){
        boolean condCheck=true;
        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter the user name :");
        String userName= scan.nextLine();

        System.out.print("Please enter the total player number between 2 and 8 :");
        while(condCheck){           //check the input is an integer and between 2 and 8
            try{
                playerNum= scan.nextInt();
                if(playerNum<2 || playerNum>8)
                    throw new InputMismatchException();
                else
                    condCheck=false;

            }catch(InputMismatchException e){
                System.out.print("Invalid input! Please enter the total player number between 2 and 8 :");
                scan.nextLine();
            }
        }

        double money = 0;
        System.out.print("Please enter the initial money :");
        condCheck=true;
        while(condCheck){       //check the money input is a double number
            try{
                money= scan.nextDouble();
                condCheck=false;

            }catch(InputMismatchException e){
                System.out.print("Invalid input! Please enter the initial money: ");
                scan.nextLine();

            }
        }
        condCheck = true;
        System.out.println("Please enter the full turn limit (if any player will reach that fullturn number game will be finished) :");
        while(condCheck){       //check the full turn limit input is a double number
            try{
                fullTurnNumber= scan.nextInt();
                condCheck=false;

            }catch(InputMismatchException e){
                System.out.print("Invalid input! Please enter the full turn limit: ");
                scan.nextLine();

            }
        }

        condCheck = true;
        createPlayers(players,userName,playerNum,money);
        determineOrder(players);
        while(condCheck){
            condCheck=iteration();

        }
        bubbleSortPlayersWealth(players);
        int i=1;
        for(Player player: players){

            System.out.println(i+". Player name : "+player.getName()+" Money: "+ player.getMoney());
            player.printOwnedBlocks();
            System.out.println("Wealth:"+(player.sumOfOwnedBlocks()+player.getMoney()));
            i++;
        }




        return true;
    }
    public void createPlayers(ArrayList<Player> players, String userName, int size, double money){

        players.add(new Player(""+userName,0+money,0,false, board));
        for (int i=1; i<size;i++){
            players.add(new Player(""+getRandomName(),0+money,0,true,board));
        }
    }

    public void determineOrder(ArrayList<Player> arr){

        for (int i=0; i<arr.size();i++){
        die1.rollDice();
        die2.rollDice();
        System.out.println("For Player "+arr.get(i).getName()+" Dices are :"+die1.getFace()+"  "+die2.getFace());
        arr.get(i).setInitialDiceValue(die1.getFace()+die2.getFace());
        }
        bubbleSortPlayers(arr);
        System.out.println("Player " + arr.get(0).getName() + " plays first..");

    }
    public void bubbleSortPlayers(ArrayList<Player> arr){
        boolean swap=true;
        while(swap){
            swap=false;
            for(int i=0; i<arr.size()-1; i++){
                if(arr.get(i).getInitialDiceValue()<arr.get(i+1).getInitialDiceValue()) {
                    Collections.swap(arr, i, i + 1);
                    swap = true;
                }
            }
        }

    }
    public void bubbleSortPlayersWealth(ArrayList<Player> arr){  //to determine final winner list
        boolean swap=true;
        while(swap){
            swap=false;
            for(int i=0; i<arr.size()-1; i++){
                if(arr.get(i).sumOfOwnedBlocks()+arr.get(i).getMoney()<arr.get(i+1).sumOfOwnedBlocks()+arr.get(i+1).getMoney()) {
                    Collections.swap(arr, i, i + 1);
                    swap = true;
                }
            }
        }

    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean iteration(){

        for(Player player: players){
            try {                           //creating game flow
                TimeUnit.MILLISECONDS.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            player.updateInJail();
            if(player.isInJail()){
                player.setWaiting_time(player.getWaiting_time()-1);
                System.out.println("Player:"+player.getName()+" is in jail. Remaining jail time is :"+player.getWaiting_time());
                continue;
            }
            if(player.isBankruptcy()){
                System.out.println("Game over :((");
                return false;
            }

            player.movePlayer(rollTurnDice());
            System.out.println("\nFor " + player.getName() + " dice :" + die1.getFace() + " " + die2.getFace());
            if(player.getPosition()>=board.SIZE) {

                player.updateFullTurnCount();
                player.setPosition(player.getPosition() % board.SIZE);

                if(player.getFullTurnCount()<fullTurnNumber) {  // define fullTurnNumber limit
                    player.increaseMoney(getTurnMoney());       //give all players the Full Turn Prize (starting block prize)
                    System.out.println(player.getName() + " gain turn money: " + turnMoney + "\n Now " + player.getName()
                            + " has " + player.getMoney() + " money.");
                }else{
                    System.out.println("Full turn number is "+this.fullTurnNumber+". turn is over so Game Over!");
                    return false;
                }
            }
            System.out.println();
            board.move(player);
        }
        return true;
    }
    public String getRandomName(){
        Random r = new Random();
        boolean cond=true;
        String returnName;
        int i=0;
        while(cond){
            i=r.nextInt(10);
            if(!names[i].equals(""))
                cond=false;

        }
        returnName=names[i];
        names[i]="";
        return returnName;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int rollTurnDice(){
        die1.rollDice();
        die2.rollDice();
        return die1.getFace()+die2.getFace();
    }

    public int getTurnMoney() {     //get starting block or full turn prize
        return turnMoney;
    }

    public void setTurnMoney(int turnMoney) {
        this.turnMoney = turnMoney;
    }
}
