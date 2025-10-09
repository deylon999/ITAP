abstract class Weapon {
    private String name;
    private int damage;
    private double weight;

    public Weapon() {
        this.name = "Неизвестное оружие";
        this.damage = 0;
        this.weight = 0.0;
    }

    public Weapon(String name, int damage, double weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }

    public abstract void attack();

    public void showInfo() {
        System.out.println(name + " | Урон: " + damage + " | Вес: " + weight);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}
