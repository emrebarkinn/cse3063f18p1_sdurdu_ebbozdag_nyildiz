public class StartingBlock extends DefaultBlock {
    public StartingBlock(int index,String name) {
    super.setIndex(index);
    super.setName(name);
    super.setName("Starting Block");
    }

    @Override
    public void playTurn(Player player) {
        printBlock(player);
    }

    @Override
    public void printBlock(Player player){
        String name= (!player.isControlled()) ? player.getName() : "Player "+player.getName();
        System.out.println("+-+-+");
        System.out.println( name+" and has "+player.getMoney()+" money  in the "+getName()+" block.");
    }
}
