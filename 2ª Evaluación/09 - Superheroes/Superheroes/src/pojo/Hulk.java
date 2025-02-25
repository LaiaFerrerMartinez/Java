package pojo;

public class Hulk extends SuperHero implements SuperAttack {

    public Hulk(String name) {
        super(name);
    }

    @Override
    public void attack() {
        performAttack(); // Llama al método de la interfaz
    }

    @Override
    public void defend() {
        System.out.println(name + " defends by smashing everything!");
    }

    @Override
    public void performAttack() {
        System.out.println(name + " attacks with a mighty punch!");
    }
}