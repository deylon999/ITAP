class Bow extends RangedWeapon {
    public Bow() {
        super();
    }

    public Bow(String name, int damage, double weight, int range, int ammo) {
        super(name, damage, weight, range, ammo);
    }

    @Override
    public void attack() {
        super.attack();
    }
}
