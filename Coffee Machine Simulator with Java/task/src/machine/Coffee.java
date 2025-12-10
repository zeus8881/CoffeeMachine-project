package machine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coffee {
    private CoffeeType coffeeType;
    private int neededWater;
    private int neededMilk;
    private int neededCoffeeBeans;
    private double price;

    public Coffee(CoffeeType coffeeType) {
        switch (coffeeType) {
            case ESPRESSO -> {
                this.neededWater = 250;
                this.neededCoffeeBeans = 16;
                this.price = 4.0;
            }
            case LATTE -> {
                this.neededWater = 350;
                this.neededMilk = 75;
                this.neededCoffeeBeans = 20;
                this.price = 7.0;
            }
            case CAPPUCCINO -> {
                this.neededWater = 200;
                this.neededMilk = 100;
                this.neededCoffeeBeans = 12;
            }
            default -> throw new IllegalArgumentException("Invalid coffeeType");
        }
    }
}
