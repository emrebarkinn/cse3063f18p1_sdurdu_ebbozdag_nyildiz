public class JailVisit extends Block {



    public JailVisit(int index,String name) {
        super(index,name);

    }

    @Override
    public void playTurn(Player player){
        printBlock(player);

    }
}
