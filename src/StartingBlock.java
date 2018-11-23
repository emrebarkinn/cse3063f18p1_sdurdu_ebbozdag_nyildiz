public class StartingBlock extends Block {
    public StartingBlock(int index,String name) {
    super(index, name);
    super.setName("Starting Block");
    }

    @Override
    public boolean playTurn(Player player) {
        printBlock(player);
        return true;
    }
}
