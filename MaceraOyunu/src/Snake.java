
import java.util.Random;

public class Snake extends Obstacle{
    Random rnd = new Random();
    public Snake() {
        super(3, "Yılan", 4, 12, 0);
        int randomDamage = rnd.nextInt(4) + 3;
        this.setDamage(randomDamage);
    }
}