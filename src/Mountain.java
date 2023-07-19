import java.util.concurrent.ThreadLocalRandom;

public class Mountain extends BattleLoc{
    Mountain(Player player,Monster monster) {
        super(player, "Sohan Dağı", monster);
        this.monster = slcMountainMonster();
    }

    public Monster slcMountainMonster(){
        int mns = ThreadLocalRandom.current().nextInt(1, 10+1);
        switch(mns){
            case 1,2,3,4 -> {
                return new GrizzlyBear();
            }
            case 5,6,7 -> {
                return new RedWildBear();
            }
            case 8,9,10 -> {
                return new AlphaBlueWolf();
            }
            default -> {
                return new GrizzlyBear();
            }
        }
    }
}
