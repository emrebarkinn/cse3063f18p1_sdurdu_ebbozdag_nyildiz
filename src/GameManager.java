import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class GameManager {

    private ArrayList<Player> players;
    private Player winner;
    private Board board;
    private Die die1;
    private Die die2;
    private int playerNum;

    public GameManager() {
        this.players = new ArrayList <Player>();
        this.die1 = new Die();
        this.die2 = new Die();
        this.board=new Board();
    }

    public void startGame(){
        //TODO convert this codes into a method
        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter the user name :");
        String userName= scan.nextLine();
        System.out.print("Please enter the total player number between 2 and 8 :");
        playerNum= scan.nextInt();
        scan.nextLine();
        System.out.print("Please enter the initial money :");
        double money= scan.nextDouble();
        //TODO to here
        createPlayers(players,userName,playerNum,money);
        determineOrder(players);
        iteration(players,board);



    }
    public void createPlayers(ArrayList<Player> players, String userName, int size, double money){
        players.add(new Player(""+userName,0+money,0,false));
        for (int i=1; i<size;i++){
            players.add(new Player(""+i,money,0,true));
        }
    }

    public void determineOrder(ArrayList<Player> arr){

        for (int i=0; i<arr.size();i++){
        die1.rollDice();
        die2.rollDice();
        System.out.println("For Player "+arr.get(i).getName()+"Dices are :"+die1.getFace()+"  "+die2.getFace());
        arr.get(i).setInitialDiceValue(die1.getFace()+die2.getFace());
        }
        bubbleSortPlayers(arr);


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

    public void iteration(ArrayList<Player> arr, Board board){
        //TODO code this metod
        //(in a loop)roll dice for every player and calculate the step size
        //call move method from board and move player
        //check if playerlocation + step size is greater than the board size and if it is greater
        //then subtract boardsize and give that player a money
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


}
