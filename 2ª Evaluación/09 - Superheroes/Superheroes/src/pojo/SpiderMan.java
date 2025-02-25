package pojo;

public class SpiderMan extends SuperHero implements SuperAttack {

    public SpiderMan(String name) {
        super(name);
    }

    @Override
    public void attack() {
        performAttack(); // Llama al método de la interfaz
    }

    @Override
    public void defend() {
        System.out.println(name + " defends with spider senses!");
    }

    @Override
    public void performAttack() {
        System.out.println(name + " attacks with web shooters!");
    }
}
