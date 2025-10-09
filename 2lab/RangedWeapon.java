class RangedWeapon extends Weapon {
    private int range;
    private int ammo;

    public RangedWeapon() {
        super("Лук", 30, 2.0);
        this.range = 50;
        this.ammo = 10;
    }

    public RangedWeapon(String name, int damage, double weight, int range, int ammo) {
        super(name, damage, weight);
        this.range = range;
        this.ammo = ammo;
    }

    @Override
    public void attack() {
        if (ammo > 0) {
            ammo--;
            System.out.println(getName() + " стреляет! Осталось стрел: " + ammo);
        } else {
            System.out.println(getName() + " не может стрелять — нет стрел!");
        }
    }

    public void reload(int arrows) {
        ammo += arrows;
        System.out.println(getName() + " пополнил колчан. Теперь стрел: " + ammo);
    }

    public int getRange() { return range; }
    public void setRange(int range) { this.range = range; }

    public int getAmmo() { return ammo; }
    public void setAmmo(int ammo) { this.ammo = ammo; }
}
