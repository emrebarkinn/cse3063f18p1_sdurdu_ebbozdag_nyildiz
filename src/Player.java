public class Player {
    private int id;
    private String name;
    private double money;
    private int position;
    private boolean inJail;
    private boolean isControlled; //For auto plays
    int waiting_time;


    public void increaseMoney(int a){

    }

    public void decreaseMoney(int a){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isControlled() {
        return isControlled;
    }

    public void setControlled(boolean controlled) {
        isControlled = controlled;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }



    // TODO die object need to add

}
