import java.util.ArrayList;

public class GameManager {

    private ArrayList<Player> players;
    private Player winner;
    private Board board;
    private Die die1;
    private Die die2;

    public void startGame(){

    }

    public void determineOrder(ArrayList<Player> arr){

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void iteration(ArrayList<Player> arr, Board board){

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
