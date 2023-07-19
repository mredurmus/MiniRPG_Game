public class FirstVillage extends NormalLoc {
    FirstVillage(Player player) {
        super(player,"Güvenli Ev");
    }

    @Override
    public boolean isDead() {
        player.setHealth(player.getbHealth());
        System.out.println("Birinci Köydesiniz.");
        System.out.println("İyileştiniz.HP'niz tamamen doldu.");
        System.out.println("HP'niz : " + player.getHealth() + "/" + player.getbHealth());
        return false;
    }
}
