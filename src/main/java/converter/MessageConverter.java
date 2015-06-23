package converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Order;

public class MessageConverter {

    final GsonBuilder builder = new GsonBuilder();

    final Gson gson = builder.create();

    public Order convert(String message) {
        return gson.fromJson(message, Order.class);
    }


}
