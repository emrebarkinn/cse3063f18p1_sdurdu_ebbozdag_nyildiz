public class JailVisit extends Block {



    public JailVisit() {
        super();
    }

    @Override
    public boolean playTurn(Player player){
        super.printBlock(player);

        return true;
    }
}
