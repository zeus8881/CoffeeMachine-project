package machine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@Data
@AllArgsConstructor
public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private double money;
    private int cupsSinceLastClean;

    public static void getStateOfCoffee(CoffeeMachine coffeeMachine) {
        System.out.println("The coffee machine has: ");
        System.out.println(coffeeMachine.getWater() + " ml of water\n");
        System.out.println(coffeeMachine.getMilk() + " ml of milk    \n");
        System.out.println(coffeeMachine.getCoffeeBeans() + " g of coffee beans\n");
        System.out.println(coffeeMachine.getCups() + " disposable cups\n");
        System.out.println(coffeeMachine.getMoney() + "$ of money\n");
    }

    public  void buy(CoffeeMachine coffeeMachines) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = sc.next();

        switch (choice) {

            case "1":
                if (coffeeMachines.getWater() >= 250 && coffeeMachines.getCoffeeBeans() >= 16) {
                    coffeeMachines.water -= 250;
                    coffeeMachines.cups -= 1;
                    coffeeMachines.money += 4.0;
                    coffeeMachines.setCupsSinceLastClean(coffeeMachines.getCupsSinceLastClean() + 1);

                    getStateOfCoffee(coffeeMachines);
                    break;
                }

            case "2":
                if (coffeeMachines.getWater() >= 350 && coffeeMachines.getMilk() >= 75 && coffeeMachines.getCoffeeBeans() >= 20) {
                    coffeeMachines.water -= 350;
                    coffeeMachines.milk -= 75;
                    coffeeMachines.coffeeBeans -= 20;
                    coffeeMachines.cups -= 1;
                    coffeeMachines.money += 7.0;
                    coffeeMachines.setCupsSinceLastClean(coffeeMachines.getCupsSinceLastClean() + 1);

                    getStateOfCoffee(coffeeMachines);
                    break;
                }

            case "3":
                if (coffeeMachines.getWater() >= 200 && coffeeMachines.getMilk() >= 100 && coffeeMachines.getCoffeeBeans() >= 12) {
                    coffeeMachines.water -= 200;
                    coffeeMachines.milk -= 100;
                    coffeeMachines.coffeeBeans -= 12;
                    coffeeMachines.cups -= 1;
                    coffeeMachines.money += 6.0;
                    coffeeMachines.setCupsSinceLastClean(coffeeMachines.getCupsSinceLastClean() + 1);

                    getStateOfCoffee(coffeeMachines);
                    break;
                }
        }
    }

    public  void fill(CoffeeMachine coffeeMachines) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add: ");
        coffeeMachines.water += sc.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        coffeeMachines.milk += sc.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeMachines.coffeeBeans += sc.nextInt();

        System.out.println("Write how many disposable cups you want to add: ");
        coffeeMachines.cups += sc.nextInt();

        getStateOfCoffee(coffeeMachines);
    }

    public  void take(CoffeeMachine coffeeMachine) {
        System.out.println("I gave you $" + coffeeMachine.money);
        coffeeMachine.money = 0.0;

        getStateOfCoffee(coffeeMachine);
    }

    public  void remaining(CoffeeMachine coffeeMachine) {
        getStateOfCoffee(coffeeMachine);
    }

    public  void clean(CoffeeMachine coffeeMachine) {
        if (coffeeMachine.cupsSinceLastClean == 0) {
            coffeeMachine.setCupsSinceLastClean(0);
        } else {
            coffeeMachine.setCupsSinceLastClean(coffeeMachine.getCupsSinceLastClean() + 1);
        }
    }

    public  void startMakeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public  void resourceCalculation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();

        int water = 200 * cups;
        int milk = 50 * cups;
        int coffeeBeans = 15 * cups;

        System.out.println("For " + cups + " of coffee you will need: \n" + water + " ml of water \n" + milk + " ml of milk \n" + coffeeBeans + " g of coffee beans.");
    }
}


