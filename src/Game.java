import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);
    Monster monster;

    public void login() {
        System.out.println("MiniMt2 Dünyasına Hoşgeldin !");
        System.out.println("Yüce kahramanımızın adı nedir ?");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }

    public void start(){
        while(true) {
            /*System.out.println();
            System.out.println("================");
            System.out.println();
            System.out.println("Ne yapmak istersin ?");
            System.out.println("1 - Birinci Köy --> Burada düşman yok, canını doldurabilirsin");
            System.out.println("2 - İkinci Köy --> Biraz tecrübeye sahip kahramanlar burada savaşabilir.");
            System.out.println("3 - Seungryong Vadisi --> Görkemli ve yüce orkların başkenti.");
            System.out.println("4 - Sohan Dağı --> Hastalıklı yaratıkların bulunduğu ve buz tutmuş bir ürkütücü dağ.");
            System.out.println("5 - Satıcı --> Buradan kahramanını daha da güçlendirecek ekipmanlar satın alabilirsin.");
            System.out.println("6 - Kahraman Statüsü");
            System.out.print("Gitmek istediğin yer : ");
            int actID = 0;
            do {
                try {
                    actID = scan.nextInt();
                    if (actID < 1 || actID > 6) {
                        System.out.print("Gitmek istediğin yerin numarasini girmelisin : ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Gitmek istediğin yerin numarasini girmelisin : ");
                    scan.next();
                }
            }while(actID < 1 || actID > 6);


            switch (actID){
                case 1 -> location = new FirstVillage(player);
                case 2 -> location = new SecondVillage(player, monster);
                case 3 -> location = new Valley(player, monster);
                case 4 -> location = new Mountain(player, monster);
                case 5 -> location = new Shop(player);
                case 6 -> player.viewStats();
                default -> location = new FirstVillage(player);
            }
            if(actID != 6 && location.isDead()){
                System.out.println("Canınız 0'a indi ve öldünüz.");
                break;
            }*/
            String act = "";
            act = scan.nextLine();
            Location location = new Location() {
                @Override
                public boolean isDead() {
                    return false;
                }
            };
            switch (act) {
                case "m1" -> location = new FirstVillage(player);
                case "m2" -> location = new SecondVillage(player,monster);
                case "m3" -> location = new Valley(player, monster);
                case "m4" -> location = new Mountain(player, monster);
                case "mshop" -> location = new Shop(player);
                case "mstats" -> player.viewStats();
                case "mhelp" -> {
                    System.out.println("1 - Birinci Köy --> Burada düşman yok, canını doldurabilirsin");
                    System.out.println("2 - İkinci Köy --> Biraz tecrübeye sahip kahramanlar burada savaşabilir.");
                    System.out.println("3 - Seungryong Vadisi --> Görkemli ve yüce orkların başkenti.");
                    System.out.println("4 - Sohan Dağı --> Hastalıklı yaratıkların bulunduğu ve buz tutmuş bir ürkütücü dağ.");
                    System.out.println("shop - Satıcı --> Buradan kahramanını daha da güçlendirecek ekipmanlar satın alabilirsin.");
                    System.out.println("stats - Kahraman Statüsü");
                    System.out.println("Örneğin İkinci Köy'e gitmek için m2 yazabilirsin.");
                }
                default -> location = new FirstVillage(player);
            }
            if (location.isDead()) {
                int yangPenalty = ThreadLocalRandom.current().nextInt(player.getBalance()*20/100, (player.getBalance()*50/100)+1);
                player.setBalance(player.getBalance()-yangPenalty);
                player.setExp(player.getExp()*70/100);
                player.setHealth(player.getbHealth());
                System.out.println("Canınız 0'a indi ve öldünüz.");
                System.out.println("Exp'nizin bir kısmını kaybettiniz.");
                System.out.println(yangPenalty + " yang kaybettiniz.");
                start();
            }
        }
    }
}
