package converter;

import model.Order;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MessageConverterTest {

    private MessageConverter messageConverter = new MessageConverter();

    @Test
    public void should_convert_message() {
        // Given
        final String json = "{\n" +
                "    \"prices\": [65.6,27.26,32.68],\n" +
                "    \"quantities\": [6,8,10],\n" +
                "    \"country\": \"IE\",\n" +
                "    \"reduction\":\"STANDARD\"\n" +
                "}";

        // When
        Order order = messageConverter.convert(json);

        // Then
        assertThat(order.getPrices()).isEqualTo(new double[]{65.6, 27.26, 32.68});
        assertThat(order.getQuantities()).isEqualTo(new int[]{6,8,10});
        assertThat(order.getCountry()).isEqualTo("IE");
        assertThat(order.getReduction()).isEqualTo("STANDARD");
    }

}