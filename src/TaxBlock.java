public class TaxBlock extends Block {

    double taxPrice;

    public TaxBlock(int index, String name, double taxPrice){
        super(index, name);
        this.taxPrice =taxPrice;
    }
    @Override
    public void playTurn(Player player){
        printBlock(player);
        player.mandotoryPay(this.taxPrice);
        System.out.println(player.getName() + " has to pay tax: " +this.taxPrice+"\n Now " + player.getName() +
                "has " + player.getMoney() + "money.");
    }
}
