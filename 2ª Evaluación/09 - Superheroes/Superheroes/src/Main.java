import pojo.Factory;
import pojo.SuperHero;

public class Main {
    public static void main(String[] args) {
        SuperHero ironMan = Factory.createHero("IronMan", "Tony Stark");
        ironMan.attack();  // Calls IronMan's specific attack
        ironMan.defend();  // Calls IronMan's specific defense
        System.out.println();

        SuperHero spiderMan = Factory.createHero("SpiderMan", "Peter Parker");
        spiderMan.attack();  // Calls SpiderMan's specific attack
        spiderMan.defend();  // Calls SpiderMan's specific defense
        System.out.println();

        SuperHero hulk = Factory.createHero("Hulk", "Bruce Banner");
        hulk.attack();  // Calls Hulk's specific attack
        hulk.defend();  // Calls Hulk's specific defense
        System.out.println();
    }
}