import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int health;
    private int magic;
    private int strength;
    private int dexterity;
    private int balance;
    private int exp;
    private int reqExp;
    private int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getReqExp() {
        return reqExp;
    }

    public void setReqExp(int reqExp) {
        this.reqExp = reqExp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;

    public int getbHealth() {
        return bHealth;
    }

    public void setbHealth(int bHealth) {
        this.bHealth = bHealth;
    }

    private int bHealth;
    private String name, cName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public int getMinDamage(){
        return (this.getDamage()+ this.getInv().getMinDamage());
    }
    public int getMaxDamage(){
        return (this.getDamage()+ this.getInv().getMaxDamage());
    }
    public int getTotalDefence(){
        return (this.getDexterity() + this.getInv().getDefence());
    }

    public void initPlayer(String cName, int hp, int sp, int str, int dex, int blnc) {
        setcName(cName);
        setHealth(hp);
        setMagic(sp);
        setStrength(str);
        setDexterity(dex);
        setBalance(blnc);
        setbHealth(hp);
        setExp(0);
        setLevel(1);
        setReqExp(300);
        setDamage((str*112/65));
    }
    public String StringDamage(){
        if (getMinDamage() == getMaxDamage()){
            return "Hasar : " + getMinDamage()+"\n";
        }else {
            return "Hasar : " + getMinDamage()+ "-"+ getMaxDamage() +"\n";
        }
    }

    public void selectChar() {
        switch (charMenu()) {
            case 1 -> initPlayer("Savaşçı", 760, 260, 10, 4, 1000);
            case 2 -> initPlayer("Ninja", 770, 260, 9, 3, 1000);
            case 3 -> initPlayer("Sura", 770, 300, 9, 3, 1000);
            case 4 -> initPlayer("Şaman", 860, 320, 9, 4, 1000);
            default -> initPlayer("Savaşçı", 760, 260, 10, 4, 1000);
        }
        viewStats();
        System.out.println("Yardım için 'm help' yazabilirsin.");
    }

    public void viewStats(){
        System.out.println("Karakter : " + getName() + "\n" +
                "---------------" + "\n" +
                "Sınıf : " + getcName() + "\n" +
                "Level : " + getLevel() + "\n" +
                "Exp : " + getExp() + "/"+ getReqExp() + "\n" +
                "HP : " + getHealth() + "\t" +
                "SP : " + getMagic() + "\n" +
                "STR : " + getStrength() +"\t" +
                StringDamage()+
                "DEX : " + getTotalDefence() + "\t " +
                " Para : " + getBalance() + " Yang") ;

        if(getInv().getMinDamage() > 0) {
            System.out.println("Silah: " + getInv().getwName());
        }
        if(getInv().getDefence() > 0) {
            System.out.println("Zırh: " + getInv().getaName());
        }
    }
    public int charMenu() {
        System.out.println("Yüce kahramanımızın sınıfını seç");
        System.out.println("1) Savaşçı \t HP: 760 SP: 260 STR: 10 DEX: 4");
        System.out.println("2) Ninja \t HP: 770 SP: 260 STR: 9 DEX: 3");
        System.out.println("3) Sura \t HP: 770 SP: 300 STR: 9 DEX: 3");
        System.out.println("4) Şaman \t HP: 860 SP: 320 STR: 9 DEX: 4");
        System.out.print("Sınıf seçiniz : ");
        int charID = 0;
        do {
            try {
                charID = scan.nextInt();
                if (charID < 1 || charID > 4) {
                    System.out.print("Hayır hayır! İstediğin sınıfın numarasını girmelisin. : ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Hayır hayır! İstediğin sınıfın numarasını girmelisin. : ");
                scan.next();
            }
        }while(charID < 1 || charID > 4);
        System.out.println();
        return charID;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

}
