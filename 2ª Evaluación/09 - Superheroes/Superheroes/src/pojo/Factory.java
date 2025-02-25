package pojo;

public class Factory {

    public static SuperHero createHero(String heroType, String name) {
        switch (heroType) {
            case "IronMan":
                return new IronMan(name);
            case "SpiderMan":
                return new SpiderMan(name);
            case "Hulk":
                return new Hulk(name);
            default:
                throw new IllegalArgumentException("Unknown hero type");
        }
    }
}