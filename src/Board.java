import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    final int SIZE = 40;

    private ArrayList<Block> blocks;

    public Board() {
        blocks=new ArrayList <Block>();

        //TODO kamu fonu tren vs. karar ver
        blocks.add(new StartingBlock(0,"StartingBlock"));
        blocks.add(new Block(1, "Antalya",60,20));    //brown

        blocks.add(new LuckyCard(2, "Lucky Card"));
        //blocks.add(new Block(2, "Kamu fonu yazıyo"));  //??
        blocks.add(new Block(3, "Bursa",60,40));      //brown

        //blocks.add(new LuckyCard(4, "Lucky Card"));
        blocks.add(new TaxBlock(4, "Income Tax", 100));

        //blocks.add(new LuckyCard(5, "Lucky Card"));
        blocks.add(new Block(5, "Train", 200, 150));               //olusturulmadı

        blocks.add(new Block(6, "Adana",100, 60));      //light blue
        blocks.add(new LuckyCard(7, "Lucky Card"));
        blocks.add(new Block(8, "Kocaeli",100, 60));    //light blue
        blocks.add(new Block(9, "Gaziantep",120, 80));  //light blue
        blocks.add(new JailVisit(10, "JailVisit"));
        blocks.add(new Block(11, "Kastamonu",140,100));  //pink

        blocks.add(new LuckyCard(12, "Lucky Card"));
        // blocks.add(new Block(12, "Telekom"));           //?

        blocks.add(new Block(13, "Çanakkale",140,100));  //pink
        blocks.add(new Block(14, "Çorum",160,120));      //pink

        //blocks.add(new LuckyCard(15, "Lucky Card"));
        blocks.add(new Block(15, "Airport", 300, 200));         //olusturulmadı

        blocks.add(new Block(16, "Mersin",180,140));     //orange

        //blocks.add(new LuckyCard(17, "Lucky Card"));
        blocks.add(new TaxBlock(17, "Income Tax", 100));         //??

        blocks.add(new Block(18, "Samsun",180,140));     //orange
        blocks.add(new Block(19, "Erzurum",200,160));    //orange

        //blocks.add(new LuckyCard(20, "Lucky Card"));
        blocks.add(new Block(20, "Free Parking", 0 ,0));

        blocks.add(new Block(21, "Kütahya",220,180));     //red
        blocks.add(new LuckyCard(22, "Lucky Card"));
        blocks.add(new Block(23, "Muş",220,180));       //red
        blocks.add(new Block(24, "Trabzon",240,200));   //red

        //blocks.add(new LuckyCard(25, "Lucky Card"));
        blocks.add(new Block(25, "Metrobus",250,150));              //olusturulmadı

        blocks.add(new Block(26, "Malatya",260,220));   //yellow
        blocks.add(new Block(27, "Elazığ",260,220));    //yellow

        blocks.add(new LuckyCard(28, "Lucky Card"));
        //blocks.add(new Block(28, "Doğalgaz"));          //??

        blocks.add(new Block(29, "Ankara",280,240));    //yellow
        blocks.add(new GoToJail(30, "Go To Jail"));
        blocks.add(new Block(31, "Eskişehir",300,260));     //green
        blocks.add(new Block(32, "Sivas",300,260));         //green

        blocks.add(new LuckyCard(33, "Lucky Card"));
        //blocks.add(new Block(33, "Kamu Fonu"));         //??

        blocks.add(new Block(34, "İzmir",320,280));         //green

        //blocks.add(new LuckyCard(35, "Lucky Card"));
        blocks.add(new Block(35, "Subway", 270, 180));               //??

        blocks.add(new LuckyCard(36, "Lucky Card"));
        blocks.add(new Block(37, "İstanbul",350,300));      //blue

        blocks.add(new TaxBlock(38, "Luxury Tax", 300));
        //blocks.add(new LuckyCard(38, "Lucky Card"));

        blocks.add(new Block(39, "Giresun",400,350));       //blue

        /*
        for (int i=1;i<SIZE;i++){

            if(i==5) {
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            if(i==10){
                blocks.add(new JailVisit(i,"JailVisit"));
                continue;
            }
            if(i==15){
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            if(i==25) {
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            if(i==30){
                blocks.add(new GoToJail(i ,"Go To Jail"));
                continue;
            }
            if(i==35) {
                blocks.add(new LuckyCard(i,"LuckyCard"));
                continue;
            }
            blocks.add(new Block(i,""+i,300,200));
        }
        */
    }

    public Block getBlock(int index){
        return blocks.get(index);
    }

    public void move(Player player){
        if(!player.isControlled()){
            Scanner scan =new Scanner(System.in);
            scan.nextLine();  //for debugging
        }

        getBlock(player.getPosition()).playTurn(player);
    }



}
