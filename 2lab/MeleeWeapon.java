class MeleeWeapon extends Weapon {
    private String material;
    private boolean twoHanded;

    public MeleeWeapon() {
        super("Меч", 50, 3.0);
        this.material = "Сталь";
        this.twoHanded = false;
    }

    public MeleeWeapon(String name, int damage, double weight, String material, boolean twoHanded) {
        super(name, damage, weight);
        this.material = material;
        this.twoHanded = twoHanded;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " наносит удар мечом!");
    }

    public void swing() {
        System.out.println(getName() + " размахивает мечом!");
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public boolean isTwoHanded() { return twoHanded; }
    public void setTwoHanded(boolean twoHanded) { this.twoHanded = twoHanded; }
}
