package machine;

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

        //example 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();

        int water = 200 * cups;
        int milk = 50 * cups;
        int coffeeBeans = 15 * cups;

        System.out.println("For " + cups + " of coffee you will need: \n" + water + " ml of water \n"  + milk + " ml of milk \n" + coffeeBeans + " g of coffee beans.");

        //example2


    }
}