
public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz!");
        this.getPlayer().setHealth(getPlayer().getOriginalHealth());
        System.out.println("Caniniz Fullendi");
        gameCheck();
        return true;
    }
    public void gameCheck(){
        if (getPlayer().getInventory().isFireWood() &&
                getPlayer().getInventory().isWater()&&
                getPlayer().getInventory().isFood()){
            System.out.println("Tebrikler Bütün Ödülleri Kazanıp Oyunu Bitirdiniz.");
            System.out.println("Bundan Sonra Sadece Maden Bölgesinde Savaşabilirsiniz.");
        }
    }
}
