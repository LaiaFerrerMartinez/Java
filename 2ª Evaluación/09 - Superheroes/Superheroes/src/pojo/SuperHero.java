package pojo;

public abstract class SuperHero {
    protected String name;

    public SuperHero(String name) {
        this.name = name;
    }

    // Métodos abstractos que deben implementar los héroes
    public abstract void attack();
    public abstract void defend();
}
