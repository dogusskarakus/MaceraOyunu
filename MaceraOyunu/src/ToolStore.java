
public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Magaza");
    }
    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu){
            System.out.println("Mağazaya Hoş geldiniz!!");
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış Yap");
            System.out.println("Lütfen bir seçim yapınız");
            int selectCase = Location.input.nextInt();
            while(selectCase < 1 || selectCase > 3){
                System.out.print("Lütfen geçerli bir değer giriniz:");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Yine bekleriz");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("*******Silahlar******");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " +
                    w.getName() + "  Para : " +
                    w.getPrice() + " / Hasar : " +
                    w.getDamage() + "/" );
        }
        System.out.println("0 - Cikis yap");

    }
    public void buyWeapon(){
        System.out.println("Bir silah seçiniz");
        int selectWeaponId = input.nextInt();
        while(selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length){
            System.out.print("Lütfen geçerli bir değer giriniz:");
            selectWeaponId = Location.input.nextInt();
        }

        if(selectWeaponId != 0){
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponId);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiye bulunmamaktadır");
                }
                else {
                    System.out.println(selectedWeapon.getName() + " Silahı satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiyeniz : " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
    public void buyArmor(){
        System.out.println("Bir zırh seçiniz");
        int selectArmorId = input.nextInt();
        while(selectArmorId < 0 || selectArmorId > Armor.armors().length){
            System.out.print("Lütfen geçerli bir değer giriniz:");
            selectArmorId = Location.input.nextInt();
        }
        if (selectArmorId != 0){
            Armor selectedArmor = Armor.getArmorById(selectArmorId);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli bakiye bulunmamaktadır");
                }
                else {
                    System.out.println(selectedArmor.getName() + " Zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiyeniz : " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }
    public void printArmor(){
        System.out.println("********Zırhlar*********");
        System.out.println();
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " +
                    a.getName() + "  Para : " +
                    a.getPrice() + "  Zırh : " +
                    a.getBlock() + " " );
        }
        System.out.println("0 - Çıkış yap");
    }

}