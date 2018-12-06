public class RailWay extends Block {

    public RailWay(int index, String name, double price, double rent) {
        super(index,name,price,rent);
    }
    @Override
    public double getRent(){
        int count=0;
        if(getOwner()!=null)
        for(Block block : getOwner().getOwnedBlocks()){
            if(block.getClass().getName().compareTo("RailWay")==0)
                count++;
        }
        return (count==0) ? super.getRent():super.getRent()*count;
    }
}
