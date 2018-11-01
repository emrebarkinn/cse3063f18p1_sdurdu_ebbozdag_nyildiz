public class StartingBlock extends Block {
    public StartingBlock() {
    super();
    super.setName("Starting Block");
    }

    @Override
    public void playTurn(Player player) {
        printBlock(player);
    }
}
