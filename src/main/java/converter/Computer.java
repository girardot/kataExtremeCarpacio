package converter;

import model.Order;

import java.util.HashMap;
import java.util.Map;

public class Computer {

    private final static Map<String, Double> TAX_PER_COUNTRY = new HashMap<String, Double>() {{
        put("DE", 1.2);
        put("UK", 1.21);
        put("FR", 1.20);
        put("IT", 1.25);
        put("ES", 1.19);
        put("PL", 1.21);
        put("RO", 1.2);
        put("NL", 1.2);
        put("BE", 1.24);
        put("EL", 1.2);
        put("CZ", 1.19);
        put("PT", 1.23);
        put("HU", 1.27);
        put("SE", 1.23);
        put("AT", 1.22);
        put("BG", 1.21);
        put("DK", 1.21);
        put("FI", 1.17);
        put("SK", 1.18);
        put("IE", 1.21);
        put("HR", 1.23);
        put("LT", 1.23);
        put("SI", 1.24);
        put("LV", 1.2);
        put("EE", 1.22);
        put("CY", 1.21);
        put("LU", 1.25);
        put("MT", 1.2);
    }};

    public static double compute(Order order) {
        double result = 0;
        for (int i = 0; i < order.getPrices().length; i++) {
            result += order.getPrices()[i] * order.getQuantities()[i] * TAX_PER_COUNTRY.get(order.getCountry());
        }

        if (order.getReduction().equals("STANDARD")) {

            if (result >= 50_000) {
                return result * 0.85;
            } else if (result >= 10_000) {
                return result * 0.9;
            } else if (result >= 7_000) {
                return result * 0.95;
            } else if (result >= 1_000) {
                return result * 0.97;
            }
        }
        else if (order.getReduction().equals("HALF PRICE")) {
            return result * 0.5;
        }
        return result;
    }

}
