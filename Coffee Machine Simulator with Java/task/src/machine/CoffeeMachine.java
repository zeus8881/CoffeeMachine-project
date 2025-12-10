package machine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();

        int water = 200 * cups;
        int milk = 50 * cups;
        int coffeeBeans = 15 * cups;

        System.out.println("For " + cups + " of coffee you will need: \n" + water + " ml of water \n" + milk + " ml of milk \n" + coffeeBeans + " g of coffee beans.");


        var coffee = new Coffee(water, milk, coffeeBeans);
        checkCoffee(
                coffee
        );

    }

    public static void checkCoffee(Coffee coffee) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int grams = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();

        final int WATER = 200;
        final int MILK = 50;
        final int COFFEEBEANS = 15;

        int maxCupsByWater = water / WATER;
        int maxMilkByMilk = milk / MILK;
        int maxCoffeeBeans = grams / COFFEEBEANS;

        int maxCups = Math.min(maxCupsByWater, Math.min(maxMilkByMilk, maxCoffeeBeans));

        if (maxCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        }
    }
}

@Data
@AllArgsConstructor
class Coffee {
    private int water;
    private int milk;
    private int coffeeBeans;

}