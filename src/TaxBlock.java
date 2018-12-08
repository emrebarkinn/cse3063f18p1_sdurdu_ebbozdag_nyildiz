public class TaxBlock extends DefaultBlock {

    double taxPrice;

    public TaxBlock(int index, String name, double taxPrice){
        super.setIndex(index);
        super.setName(name);
        this.taxPrice =taxPrice;
    }
    @Override
    public void playTurn(Player player){
        printBlock(player);
        player.mandotoryPay(this.taxPrice);
        System.out.println(player.getName() + " has to pay tax: " +this.taxPrice+"\n Now " + player.getName() +
                "has " + player.getMoney() + "money.");
    }
    @Override
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName();
        System.out.println("+-+-+");
        System.out.println( name+" and has "+player.getMoney()+" money  in the "+getName()+" block.");
    }
}
