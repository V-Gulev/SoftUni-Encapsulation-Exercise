package PizzaCalories_04;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") || toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingCoefficient = switch (this.toppingType) {
            case "Meat" -> 1.2;
            case "Veggies" -> 0.8;
            case "Cheese" -> 1.1;
            case "Sauce" -> 0.9;
            default -> 0;
        };

        return 2 * this.weight * toppingCoefficient;
    }
}
