public class Block {

    private int index;
    private String name;
    private double price;
    private double rent;
    private Player owner;
    private Player visiter;

    public Block() {

    }

    public Block(int index, String name, double price, double rent) {
        this.index = index;
        this.name = name;
        this.price = price;
        this.rent = rent;
    }

    public void playerVisit(Player player){

    }

    public void playTurn(Player player){

    }
}
