package converter;

import model.Order;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    public void should_compute_order() {
        // Given
        Order order = new Order();
        order.setCountry("IE");
        order.setPrices(new double[]{4.1,8.03,86.83,65.62,44.82});
        order.setQuantities(new int[]{10,3,5,4,5});
        order.setReduction("STANDARD");

        // When
        double compute = Computer.compute(order);

        // Then
        assertThat(compute).isEqualTo(1166.62);
    }

}