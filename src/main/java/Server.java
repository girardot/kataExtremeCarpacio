import converter.Computer;
import converter.MessageConverter;

import static spark.Spark.get;
import static spark.Spark.post;

public class Server {

    public static void main(String[] args) {

        MessageConverter messageConverter = new MessageConverter();

        post("/orders", (req, res) -> Computer.compute(messageConverter.convert()));


    }

}
