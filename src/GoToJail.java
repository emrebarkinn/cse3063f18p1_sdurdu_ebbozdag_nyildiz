public class GoToJail extends Block{
    private int jail_visit_index;
    private int waiting_time;
    private int penaltyMoney;

    public GoToJail(int index, String name) {
        super(index, name);
        this.waiting_time=3;
        this.penaltyMoney=100;
    }

    @Override
    public void playTurn(Player player){
        super.printBlock(player);
        if(player.getJailCardCount()>0){
            System.out.println("Player "+player.getName()+" use jail free card. So " +player.getName()+" won't go to jail.");
            player.decreaseJailCardCount();
            return;
        }
        player.setWaiting_time(waiting_time);
        player.mandotoryPay(penaltyMoney);
        System.out.println(player.getName() + " have to pay penalty money: " + penaltyMoney + "\n Now " + player.getName()
                + " has " + player.getMoney() + " money.");
        System.out.println("player's position: " +player.getPosition());
        //send player to mapushane
        player.setPosition(10);

    }

    public int getJail_visit_index() {
        return jail_visit_index;
    }

    public void setJail_visit_index(int jail_visit_index) {
        this.jail_visit_index = jail_visit_index;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }
}
