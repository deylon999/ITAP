public class Main {
    public static void main(String[] args) {
        Sword sword1 = new Sword();
        Sword sword2 = new Sword("Клинок дракона", 80, 4.5, "Мифрил", true);

        Bow bow1 = new Bow();
        Bow bow2 = new Bow("Длинный лук", 35, 2.5, 70, 15);

        sword1.showInfo();
        sword1.attack();
        sword2.showInfo();
        sword2.attack();

        System.out.println("------");

        bow1.showInfo();
        bow1.attack();
        bow1.attack();
        bow1.reload(5);
        bow1.attack();

        System.out.println("Создано мечей: " + Sword.getSwordCount());
    }
}
