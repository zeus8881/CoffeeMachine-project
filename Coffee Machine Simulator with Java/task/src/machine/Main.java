package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550.0, 0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit");
            String action = scanner.next();
            switch (action) {
                case "buy" -> {
                    coffeeMachine.buy(coffeeMachine);
                    coffeeMachine.resourceCalculation();
                    coffeeMachine.startMakeCoffee();

                }
                case "fill" -> coffeeMachine.fill(coffeeMachine);
                case "take" -> coffeeMachine.take(coffeeMachine);
                case "clean" -> coffeeMachine.clean(coffeeMachine);
                case "remaining" -> coffeeMachine.remaining(coffeeMachine);
                case "exit" -> System.out.println("Bye!");
            }
        }
    }
}
