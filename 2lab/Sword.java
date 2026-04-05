class Sword extends MeleeWeapon {
    private static int swordCount = 0;

    public Sword() {
        super();
        swordCount++;
    }

    public Sword(String name, int damage, double weight, String material, boolean twoHanded) {
        super(name, damage, weight, material, twoHanded);
        swordCount++;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " рубит врага!");
    }

    public static int getSwordCount() {
        return swordCount;
    }
}
