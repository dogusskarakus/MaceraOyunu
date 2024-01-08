
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("******...Macera Oyununa Hos Geldiniz...******");
        System.out.println();
        System.out.print("Bir İsim Giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + "Hoş Geldiniz");
        System.out.println("Lütfen Karakter Seçiniz: ");
        System.out.println("****************************");
        player.selectChar();
        Location location = null;

        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("********  BÖLGELER  ********");
            System.out.println();
            System.out.println("1 - Guvenli Ev -- Burası guvenlidir. ");
            System.out.println("2 - Mağaza -- Silah ve zırh satın alabilirsiniz");
            System.out.println("3 - Magara -- Ödül :  *yemek* /  dikkat Zombie Çıkabilir!!");
            System.out.println("4 - Nehir --  Ödül :  *su*    /  dikkat Ayı Cikabilir!!");
            System.out.println("5 - Orman --  Ödül :  *odun*  /  dikkat Vampir Çıkabilir!!");
            System.out.println("6 - Maden --  Ödül :  *silah,zırh,para* / dikkat Yılan Çıkabilir!!");
            System.out.println("0 - Cikis yap ve oyunu sonlandir");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3: if(!player.getInventory().isFood()){
                    System.out.println("Mağaraya giriyorsun");
                    location = new Cave(player);
                }
                else {
                    System.out.println("Daha önce bu ödülü kazandığın için bu haritaya giremezsin");
                    location = new SafeHouse(player);
                }
                    break;
                case 4: if(!player.getInventory().isWater()){
                    System.out.println("Nehire giriyorsun");
                    location = new River(player);
                }
                else {
                    System.out.println("Daha önce bu ödülü kazandığın için bu haritaya giremezsin");
                    location = new SafeHouse(player);
                }
                    break;
                case 5:if (!player.getInventory().isFireWood()){
                    location = new Forest(player);
                }
                else {
                    System.out.println("Daha önce bu ödülü kazandığın için bu haritaya giremezsin");
                    location = new SafeHouse(player);
                }
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bölge girin");
                    break;
            }
            if (location == null){
                System.out.println("Oyun bitti..");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Öldünüz !! Game Over");
                break;
            }
        }
    }

}