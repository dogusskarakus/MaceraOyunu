
import java.util.Scanner;

public class Player  {
    private int damage;
    private int health;
    private int originalHealth;
    private int money ;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void printInfo(){
        System.out.println("Silahınız : " + this.getInventory().getWeapon().getName() +
                ", Zırhınız : " + this.getInventory().getArmor().getName() +
                ", Engelleme: " + this.getInventory().getArmor().getBlock() +
                ", Hasar : "+ this.getTotalDamage() +
                ", Sağlık : " + this.getHealth() +
                ", Para : " + this.getMoney());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 )
            health = 0;
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void selectChar(){
        GameCharacter[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler");
        for (GameCharacter gameCharacter:charList) {
            System.out.println("ID:" + gameCharacter.getId() +
                    "\tKarakter:" + gameCharacter.getName() +
                    "\tHasar:" + gameCharacter.getDamage() +
                    "\tSağlık:" + gameCharacter.getHealth() +
                    "\tPara:"+ gameCharacter.getMoney());
        }
        System.out.println();
        System.out.print("Lütfen bir Karakter Seçiniz: ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: " + this.getCharName() +
                "\tHasar:"+ this.getDamage() +
                "\tSaglik:" + this.getHealth() +
                "\tPara:" + this.getMoney());

    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());

    }
}