import pojo.Factory;
import pojo.SuperHero;

public class Main {
    public static void main(String[] args) {
        SuperHero ironMan = Factory.createHero("IronMan", "Tony Stark");
        ironMan.attack();
        ironMan.defend();
        System.out.println();

        SuperHero spiderMan = Factory.createHero("SpiderMan", "Peter Parker");
        spiderMan.attack();
        spiderMan.defend();
        System.out.println();

        SuperHero hulk = Factory.createHero("Hulk", "Bruce Banner");
        hulk.attack();
        hulk.defend();
        System.out.println();
    }
}