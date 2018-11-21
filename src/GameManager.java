import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class GameManager {

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
        this.turnMoney = 100;
    }

    public void startGame(){
        //TODO convert this codes into a method and needs error checks
        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter the user name :");
        String userName= scan.nextLine();
        System.out.print("Please enter the total player number between 2 and 8 :");
        playerNum= scan.nextInt();
        scan.nextLine();
        System.out.print("Please enter the initial money :");
        double money= scan.nextDouble();
        System.out.println("Please enter the full turn limit (if any player will reach that fullturn number game will be finished) :");
        fullTurnNumber=scan.nextInt();

        //TODO to here
        createPlayers(players,userName,playerNum,money);
        determineOrder(players);
        boolean condCheck=true;
        while(condCheck){
            condCheck=iteration();

        }

        //TODO add owned blocks prices to final players
        for(int i=0;i<players.size();i++)
            System.out.println("Player name : "+players.get(i).getName()+" Money: "+ players.get(i).getMoney());




    }
    public void createPlayers(ArrayList<Player> players, String userName, int size, double money){
        //TODO restrict the creation (3-8 players)
        players.add(new Player(""+userName,0+money,0,false, board));
        for (int i=1; i<size;i++){
            players.add(new Player(""+i,money,0,true,board));
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
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean iteration(){

        for(Player player: players){
            player.updateInJail();
            if(player.isInJail()){
                player.setWaiting_time(player.getWaiting_time()-1);

                continue;
            }
            player.movePlayer(rollTurnDice());
            if(player.getPosition()>=board.SIZE) {

                player.updateFullTurnCount();
                player.setPosition(player.getPosition() % board.SIZE);

                if(player.getFullTurnCount()<fullTurnNumber) {  //TODO define fullTurnNumber limit instead of using 5
                    player.increaseMoney(getTurnMoney());
                    System.out.println(player.getName() + " gain turn money: " + turnMoney + "\n Now " + player.getName()
                            + " has " + player.getMoney() + " money.");
                }
            }
            System.out.println("\n");
            System.out.println("For " + player.getName() + " dice :" + die1.getFace() + " " + die2.getFace());


            if(!board.move(player)) return false;
        }
        return true;
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

    public int getTurnMoney() {
        return turnMoney;
    }

    public void setTurnMoney(int turnMoney) {
        this.turnMoney = turnMoney;
    }
}
