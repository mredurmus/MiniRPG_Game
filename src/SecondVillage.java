import java.util.concurrent.ThreadLocalRandom;

public class SecondVillage extends BattleLoc{
    SecondVillage(Player player,Monster monster) {
        super(player, "İkinci Köy", monster);
        this.monster = slcVillageMonster();
    }

    public Monster slcVillageMonster(){
        int mns = ThreadLocalRandom.current().nextInt(1, 10+1);
        switch(mns){
            case 1,2 -> {
                return new MetinofBattle();
            }
            case 3,4,5,6,7 -> {
                return new AlphaBlueWolf();
            }
            case 8,9,10 -> {
                return new RedWildBear();
            }
            default -> {
                return new AlphaBlueWolf();
            }
        }
    }
}
