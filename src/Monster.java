import java.util.concurrent.ThreadLocalRandom;

public class Monster {
    private String name;
    private int damage;
    private int award;
    private int health;
    private int entNumber;
    private int exp;

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEntNumber() {
        return entNumber;
    }

    public void setEntNumber(int entNumber) {
        this.entNumber = entNumber;
    }

    public Monster(String name, int damage, int award, int health, int entNumber,int exp) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.entNumber = entNumber;
        this.exp= exp;
    }
    public int mnsCount(){
        return ThreadLocalRandom.current().nextInt(1, this.entNumber+1);
    }

    public int rAward(){
        return ThreadLocalRandom.current().nextInt((this.award*50/100), this.award+1);
    }


    public void viewStats(){
        System.out.println(getName() + "\n" +"---------------");
        System.out.println("Can: " + getHealth() + "\n" + "Hasar: " + getDamage()+ "\n");
    }

}
