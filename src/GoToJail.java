public class GoToJail extends Block{
    int jail_visit_index;
    int waiting_time;


    public GoToJail() {
        super();

    }

    @Override
    public void playTurn(Player player){

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
