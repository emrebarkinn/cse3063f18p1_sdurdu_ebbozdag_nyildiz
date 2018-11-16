public class StartingBlock extends Block {
    public StartingBlock() {
    super();
    super.setName("Starting Block");
    }

    @Override
    public boolean playTurn(Player player) {
        printBlock(player);
        return true;
    }
}
