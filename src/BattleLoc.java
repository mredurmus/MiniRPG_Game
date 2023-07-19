import java.util.concurrent.ThreadLocalRandom;

public abstract class BattleLoc extends Location{
    protected Monster monster;
    BattleLoc(Player player,String name,Monster monster) {
        super(player);
        this.name = name;
        this.monster = monster;
    }

    public boolean isDead() {
        int mnsCount = monster.mnsCount();
        System.out.println(this.getName() + " bölgesine ışınlandın.");
        if (monster.getDamage() == 0){
            mnsCount = 1;
            System.out.println("Burada " + monster.getName() + " ile karşılaştın.\n");
        }else {
            System.out.println("Burada " + mnsCount + " tane " + monster.getName() + " ile karşılaştın.\n");
        }

        if (combat(mnsCount)) {
            System.out.println("\n" + this.getName()+ " bölgesinden ayrıldın.");
            return false;
        } else {
            return true;
        }
        /*System.out.println("1-Savaş veya 2-Kaç!");
        int actBtlID = scan.nextInt();
        if (actBtlID == 1) {
            if (combat(mnsCount)) {
                System.out.println("\n" + this.getName()+ " bölgesindeki düşmanları temizledin.");
                return false;
            } else {
                return true;
            }
        } return false;*/
    }
    public boolean combat(int mnsCount){
        int a = mnsCount;
        int tourCount = 0;
        for(int i = 0;i < mnsCount ; i++){
            int bMnsHealth = monster.getHealth();
            player.viewStats();
            System.out.println();
            monster.viewStats();
            System.out.println();
            int receivedDamage = monster.getDamage()-player.getTotalDefence();
            if (receivedDamage < 0){
                receivedDamage = 0;
            }
            while(player.getHealth() > 0 && monster.getHealth() > 0){
                int rndmDamage = ThreadLocalRandom.current().nextInt(player.getMinDamage(), player.getMaxDamage()+1);
                System.out.println("Saldırdın! Hasar : "+ rndmDamage);
                monster.setHealth(monster.getHealth()-rndmDamage);
                afterHit();
                if(monster.getDamage() == 0 && tourCount == 15 && monster.getHealth() > 0){
                    System.out.println("Metin ile olan savaşın çok uzun sürdü.");
                    System.out.println("Metin kayboldu.");
                    return true;
                }
                tourCount++;
                for(int j = 1;j <= a ; j++){
                    if(monster.getHealth() > 0 && monster.getDamage() > 0) {
                        if(a == 1) {
                            System.out.println(monster.getName() + " sana saldırdı! Hasar : " + receivedDamage);
                        }else {
                            System.out.println(j + "."+ monster.getName() + " sana saldırdı! Hasar : " + receivedDamage);
                        }
                    player.setHealth(player.getHealth() - (receivedDamage));
                    afterHit();
                    }
                }
            }
            if(monster.getHealth() <= 0 && player.getHealth() > 0){
                System.out.println("Düşmanı yendiniz.");
                int award = monster.rAward();
                player.setBalance(player.getBalance()+award);
                System.out.println(award+ " yang kazandınız.");
                if(player.getLevel()!=99){
                    player.setExp(player.getExp()+monster.getExp());
                    System.out.println(monster.getExp()+ " tecrübe puanı kazandınız.");
                }
                while(player.getLevel() != 99 && player.getExp() >= player.getReqExp()) {
                    player.setLevel(player.getLevel()+1);
                    player.setExp(player.getExp()-player.getReqExp());
                    player.setReqExp(player.getReqExp()+(player.getReqExp()*35/100));
                    player.setbHealth(player.getbHealth()+(player.getbHealth()*7/200));
                    player.setHealth(player.getbHealth());
                    System.out.println("Tebrikler! Seviye atladın");
                    System.out.println("Can yenilendi.");
                    System.out.println("Level "+player.getLevel()+"!");
                    if (player.getLevel() == 99){
                        System.out.println("Tebrikler! Son seviyeye ulaştın.");
                        player.setExp(0);
                        player.setReqExp(1);
                    }
                }
                monster.setHealth(bMnsHealth);
                a -= 1;
            }else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Karakter HP:"+ player.getHealth());
        System.out.println(monster.getName() + " HP: "+ monster.getHealth());
        System.out.println("---------------");
    }
}
