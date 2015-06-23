package converter;

import model.Order;

public class Computer {

    public static double compute(Order order) {
        double result = 0;
        for (int i = 0; i < order.getPrices().length; i++) {
            result += order.getPrices()[i] * order.getQuantities()[i] * 1.22;
        }

        if (result >= 50_000) {
            return result * 0.85;
        } else if (result >= 10_000) {
            return result * 0.9;
        } else if (result >= 7_000) {
            return result * 0.95;
        } else if (result >= 1_000) {
            return result * 0.97;
        }

        return result;
    }

}
