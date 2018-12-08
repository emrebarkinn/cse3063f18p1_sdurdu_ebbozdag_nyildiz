abstract class DefaultBlock {
    private int index;
    private String name;



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract void playTurn(Player player);
    public abstract void printBlock(Player player);
}
