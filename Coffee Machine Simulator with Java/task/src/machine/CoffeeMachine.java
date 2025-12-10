package machine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        // 1 //
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        // 2 //
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();

        int water = 200 * cups;
        int milk = 50 * cups;
        int coffeeBeans = 15 * cups;

        System.out.println("For " + cups + " of coffee you will need: \n" + water + " ml of water \n" + milk + " ml of milk \n" + coffeeBeans + " g of coffee beans.");


        // 3 //
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

// 4 //

@Data
class CoffeeMachines {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int plasticCups;
    private double money;


    public CoffeeMachines() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.plasticCups = 9;
        this.money = 550.0;
    }

    public void getStateCoffeeMachines(int water, int milk, int coffeeBeans, int plasticCups, double money) {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water\n");
        System.out.println(milk + " ml of milk\n");
        System.out.println(coffeeBeans + " g of coffee beans\n");
        System.out.println(plasticCups + " disposable cups");
        System.out.println(money + "$ of money");

    }

    public void whatWillTheBuyerChoose(CoffeeMachines coffeeMachines) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take): ");
        String action = sc.next();
        switch (action) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (coffeeMachines.water >= 250 && coffeeMachines.coffeeBeans >= 16) {
                            int waterInMachine = coffeeMachines.water -= 250;
                            int milkInMachine = coffeeMachines.milk;
                            int plasticCups = coffeeMachines.plasticCups -= 1;
                            double money = coffeeMachines.money += 4.0;
                            getStateCoffeeMachines(waterInMachine, milkInMachine, plasticCups, coffeeMachines.getCoffeeBeans(), money);
                        }
                        return;
                    case 2:
                        if (coffeeMachines.getWater() >= 350 && coffeeMachines.getMilk() >= 75 && coffeeMachines.getCoffeeBeans() >= 20) {
                            int waterInMachine = coffeeMachines.water -= 350;
                            int milkInMachine = coffeeMachines.milk -= 75;
                            int coffeeBeans = coffeeMachines.coffeeBeans -= 20;
                            int plasticCups = coffeeMachines.plasticCups -= 1;
                            double money = coffeeMachines.money += 7.0;
                            getStateCoffeeMachines(waterInMachine, milkInMachine, coffeeBeans, plasticCups, money);
                        }
                        return;

                    case 3:
                        if (coffeeMachines.getWater() >= 200 && coffeeMachines.getMilk() >= 100 && coffeeMachines.getCoffeeBeans() >= 12) {
                            int waterInMachine = coffeeMachines.water -= 200;
                            int milkInMachine = coffeeMachines.milk -= 100;
                            int coffeeBeans = coffeeMachines.coffeeBeans -= 12;
                            int plasticCups = coffeeMachines.plasticCups -= 1;
                            double money = coffeeMachines.money += 6.0;
                            getStateCoffeeMachines(waterInMachine, milkInMachine, coffeeBeans, plasticCups, money);
                        }
                        return;
                }
            }
            case "fill" -> {
                System.out.println("Write how many ml of water you want to add: ");
                int ml = sc.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                int milk = sc.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                int coffeeBeans = sc.nextInt();
                System.out.println("Write how many disposable cups you want to add: ");
                int plasticCups = sc.nextInt();
                this.water += ml;
                this.milk += milk;
                this.coffeeBeans += coffeeBeans;
                this.plasticCups += plasticCups;
                getStateCoffeeMachines(ml, milk, coffeeBeans, plasticCups, this.money);
            }
            case "take" -> {
                System.out.println("I gave you $" + money);
                money = 0;
                getStateCoffeeMachines(water, milk, coffeeBeans, plasticCups, money);
            }
        }
    }

    public static void main(String[] args) {


    }
}
