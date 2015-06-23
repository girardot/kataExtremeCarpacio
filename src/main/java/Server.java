import converter.Computer;
import converter.MessageConverter;

import static spark.Spark.post;
import static spark.SparkBase.setPort;

public class Server {

    public static void main(String[] args) {

        MessageConverter messageConverter = new MessageConverter();

        setPort(1234);

        post("/order", (req, res) -> {
            System.out.println(req.body());
            return "{\"total\":" + Computer.compute(messageConverter.convert(req.body())) + "}";
        });

        post("/feedback", (req, res) -> {
            System.out.println(req.body());
            return "";
        });




    }

}
