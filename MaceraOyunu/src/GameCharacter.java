

public abstract class GameCharacter {
    private int id;
    private int health;
    private int damage;
    private int money;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public GameCharacter(int id ,String name, int health, int damage, int money) {
        this.health = health;
        this.damage = damage;
        this.money = money;
        this.name = name;
        this.id = id;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}