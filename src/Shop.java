import java.util.InputMismatchException;

public class Shop extends NormalLoc{
    String cName = player.getcName();
    Shop(Player player) {
        super(player, "Satıcı");
    }
    public boolean isDead() {
        System.out.println("Para : "+ player.getBalance() + " Yang");
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");
        System.out.print("Seçimin : ");
        int shopActID = 0;
        do {
            try {
                shopActID = scan.nextInt();
                if (shopActID < 1 || shopActID > 4) {
                    System.out.print("Geçerli bir numara girmelisin : ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Geçerli bir numara girmelisin : ");
                scan.next();
            }
        }while(shopActID < 1 || shopActID > 4);
        int slcItemID;
        switch (shopActID) {
            case 1 -> {
                slcItemID = weaponMenu();
                buyWeapon(slcItemID);
            }
            case 2 -> {
                slcItemID = armorMenu();
                buyArmor(slcItemID);
            }
            case 3 -> {
                return false;
            }
        }
        return false;
    }

    public int weaponMenu() {
        switch (cName) {
            case "Savaşçı", "Sura" -> {
                System.out.println("1. Kılıç +0\t <Hasar: 13-15 Fiyat: 200 Yang>");
                System.out.println("2. Uzun Kılıç +0\t <Hasar: 15-19 Fiyat: 500 Yang>");
                System.out.println("3. Hilal Kılıç +0\t <Hasar: 20-24 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Silah seçimin : ");
            }
            case "Ninja" -> {
                System.out.println("1. Hançer +0\t <Hasar: 8 Fiyat: 200 Yang>");
                System.out.println("2. Amija  +0\t <Hasar: 12 Fiyat: 500 Yang>");
                System.out.println("3. Dokuz Pala +0\t <Hasar: 14 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Silah seçimin : ");
            }
            case "Şaman" -> {
                System.out.println("1. Bakır Çan +0\t <Hasar: 13 Fiyat: 200 Yang>");
                System.out.println("2. Gümüş Çan +0\t <Hasar: 20 Fiyat: 500 Yang>");
                System.out.println("3. Altın Çan +0\t <Hasar: 25 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Silah seçimin : ");
            }
        }
        int value = 0;
        do {
            try {
                value = scan.nextInt();
                if (value < 1 || value > 4) {
                    System.out.print("Geçerli bir numara girmelisin : ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Geçerli bir numara girmelisin : ");
                scan.next();
            }
        }while(value < 1 || value > 4);
            return value;
    }

    public void buyWeapon(int itemID){
        int minDamage=0,maxDamage=0,price=0;
        String wName=null;
        if(cName.equals("Savaşçı") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    wName = "Kılıç +0";
                    minDamage = 13;
                    maxDamage = 15;
                    price = 200;
                }
                case 2 -> {
                    wName = "Uzun Kılıç +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 500;
                }
                case 3 -> {
                    wName = "Hilal Kılıç +0";
                    minDamage = 20;
                    maxDamage = 24;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setMinDamage(minDamage);
                player.getInv().setMaxDamage(maxDamage);
                player.getInv().setwName(wName);
                player.setBalance(player.getBalance()-price);
                System.out.println(wName + " satın aldınız! Yeni hasarınız : " + player.getInv().getMinDamage() + "-" + player.getInv().getMaxDamage());
                System.out.println("Kalan Paranız : "+ player.getBalance());
            } else {
                System.out.println("Yetersiz yang!");
            }
        }else if(cName.equals("Ninja") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    wName = "Hançer +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 200;
                }
                case 2 -> {
                    wName = "Amija  +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 500;
                }
                case 3 -> {
                    wName = "Dokuz Pala +0";
                    minDamage = 20;
                    maxDamage = 25;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setMinDamage(minDamage);
                player.getInv().setMaxDamage(maxDamage);
                player.getInv().setwName(wName);
                player.setBalance(player.getBalance()-price);
                System.out.println(wName + " satın aldınız! Yeni hasarınız : " + player.getInv().getMinDamage() + "-" + player.getInv().getMaxDamage());
                System.out.println("Kalan Paranız : "+ player.getBalance());
            } else {
                System.out.println("Yetersiz yang!");
            }
        }else if(cName.equals("Sura") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    wName = "Kılıç +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 200;
                }
                case 2 -> {
                    wName = "Uzun Kılıç +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 500;
                }
                case 3 -> {
                    wName = "Hilal Kılıç +0";
                    minDamage = 20;
                    maxDamage = 24;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setMinDamage(minDamage);
                player.getInv().setMaxDamage(maxDamage);
                player.getInv().setwName(wName);
                player.setBalance(player.getBalance()-price);
                System.out.println(wName + " satın aldınız! Yeni hasarınız : " + player.getInv().getMinDamage() + "-" + player.getInv().getMaxDamage());
                System.out.println("Kalan Paranız : "+ player.getBalance());
            } else {
                System.out.println("Yetersiz yang!");
            }
        }else if(cName.equals("Şaman") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    wName = "Bakır Çan +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 200;
                }
                case 2 -> {
                    wName = "Gümüş Çan +0";
                    minDamage = 15;
                    maxDamage = 19;
                    price = 500;
                }
                case 3 -> {
                    wName = "Altın Çan +0";
                    minDamage = 20;
                    maxDamage = 25;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setMinDamage(minDamage);
                player.getInv().setMaxDamage(maxDamage);
                player.getInv().setwName(wName);
                player.setBalance(player.getBalance()-price);
                System.out.println(wName + " satın aldınız! Yeni hasarınız : " + player.getInv().getMinDamage() + "-" + player.getInv().getMaxDamage());
                System.out.println("Kalan Paranız : "+ player.getBalance());
            } else {
                System.out.println("Yetersiz yang!");
            }
        }
        else if (itemID == 4) {
            System.out.println("Ah... birşey istemiyorsun demek");
        }else{
            System.out.println("Geçersiz seçim");
        }
    }
    public int armorMenu() {
        switch (cName) {
            case "Savaşçı" -> {
                System.out.println("1. Keşiş Plaka Zırh +0\t <Defans: 12 Fiyat: 200 Yang>");
                System.out.println("2. Demir Plaka Zırh +0\t <Defans: 21 Fiyat: 500 Yang>");
                System.out.println("3. Kaplan Plaka Zırh +0\t <Defans: 29 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Zırh seçimin : ");
            }
            case "Ninja" -> {
                System.out.println("1. Gök Mavisi Takım +0\t <Defans: 12 Fiyat: 200 Yang>");
                System.out.println("2. Fil Dişi Takım +0\t <Defans: 21 Fiyat: 500 Yang>");
                System.out.println("3. Koyu Kırmızı Takım +0\t <Defans: 29 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Zırh seçimin : ");
            }
            case "Sura" -> {
                System.out.println("1. Ağıt Plaka Zırh +0\t <Defans: 12 Fiyat: 200 Yang>");
                System.out.println("2. Büyücü Plaka Zırh +0\t <Defans: 21 Fiyat: 500 Yang>");
                System.out.println("3. Kötü Şans Zırhı +0\t <Defans: 29 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Zırh seçimin : ");
            }
            case "Şaman" -> {
                System.out.println("1. Gök Mavisi Elbise +0\t <Defans: 12 Fiyat: 200 Yang>");
                System.out.println("2. Turkuaz Elbise +0\t <Defans: 21 Fiyat: 500 Yang>");
                System.out.println("3. Pembe Elbise +0\t <Defans: 29 Fiyat: 1200 Yang>");
                System.out.println("4. Birşey almayacağım.");
                System.out.print("Zırh seçimin : ");
            }
        }
        int value = 0;
        do {
            try {
                value = scan.nextInt();
                if (value < 1 || value > 4) {
                    System.out.print("Geçerli bir numara girmelisin : ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Geçerli bir numara girmelisin : ");
                scan.next();
            }
        }while(value < 1 || value > 4);
        return value;
    }
    public void buyArmor(int itemID){
        int defence=0,price=0;
        String aName=null;
        if(cName.equals("Savaşçı") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    aName = "Keşiş Plaka Zırh +0";
                    defence = 12;
                    price = 200;
                }
                case 2 -> {
                    aName = "Demir Plaka Zırh +0";
                    defence = 21;
                    price = 500;
                }
                case 3 -> {
                    aName = "Kaplan Plaka Zırh +0";
                    defence = 29;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setDefence(defence);
                player.getInv().setaName(aName);
                player.setBalance(player.getBalance()-price);
                System.out.println(aName + " satın aldınız! Yeni savunmanız : " + (player.getDexterity()+ player.getInv().getDefence()));
                System.out.println("Kalan Paranız : "+ player.getBalance());
            }else {
                System.out.println("Yetersiz yang!");
            }
        }else if(cName.equals("Ninja") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    aName = "Gök Mavisi Takım +0";
                    defence = 12;
                    price = 200;
                }
                case 2 -> {
                    aName = "Fil Dişi Takım +0";
                    defence = 21;
                    price = 500;
                }
                case 3 -> {
                    aName = "Koyu Kırmızı Takım +0";
                    defence = 29;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setDefence(defence);
                player.getInv().setaName(aName);
                player.setBalance(player.getBalance()-price);
                System.out.println(aName + " satın aldınız! Yeni savunmanız : " + (player.getDexterity()+ player.getInv().getDefence()));
                System.out.println("Kalan Paranız : "+ player.getBalance());
            }else {
                System.out.println("Yetersiz yang!");
            }
        }else if(cName.equals("Sura") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    aName = "Ağıt Plaka Zırh +0";
                    defence = 12;
                    price = 200;
                }
                case 2 -> {
                    aName = "Büyücü Plaka Zırh +0";
                    defence = 21;
                    price = 500;
                }
                case 3 -> {
                    aName = "Kötü Şans Zırhı +0";
                    defence = 29;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setDefence(defence);
                player.getInv().setaName(aName);
                player.setBalance(player.getBalance()-price);
                System.out.println(aName + " satın aldınız! Yeni savunmanız : " + (player.getDexterity()+ player.getInv().getDefence()));
                System.out.println("Kalan Paranız : "+ player.getBalance());
            }else {
                System.out.println("Yetersiz yang!");
            }
        }else if(cName.equals("Şaman") && itemID > 0 && itemID < 4 ) {
            switch (itemID) {
                case 1 -> {
                    aName = "Gök Mavisi Elbise +0";
                    defence = 12;
                    price = 200;
                }
                case 2 -> {
                    aName = "Turkuaz Elbise +0";
                    defence = 21;
                    price = 500;
                }
                case 3 -> {
                    aName = "Pembe Elbise +0";
                    defence = 29;
                    price = 1200;
                }
                default -> System.out.println("Geçersiz seçim");
            }
            if(player.getBalance() >= price) {
                player.getInv().setDefence(defence);
                player.getInv().setaName(aName);
                player.setBalance(player.getBalance()-price);
                System.out.println(aName + " satın aldınız! Yeni savunmanız : " + (player.getDexterity()+ player.getInv().getDefence()));
                System.out.println("Kalan Paranız : "+ player.getBalance());
            }else {
                System.out.println("Yetersiz yang!");
            }
        }
        else if (itemID == 4) {
            System.out.println("Ah... birşey istemiyorsun demek");
        } else{
            System.out.println("Geçersiz seçim");
        }
    }

}
