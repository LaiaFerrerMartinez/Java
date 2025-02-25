package pojo;

public class IronMan extends SuperHero implements SuperAttack {

    public IronMan(String name) {
        super(name);
    }

    @Override
    public void attack() {
        performAttack(); // Llama al método de la interfaz
    }

    @Override
    public void defend() {
        System.out.println(name + " defends with the Iron Shield!");
    }

    @Override
    public void performAttack() {
        System.out.println(name + " attacks with repulsor beams!");
    }
}
