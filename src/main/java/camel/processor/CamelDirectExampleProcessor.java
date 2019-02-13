package camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelDirectExampleProcessor implements Processor {
    @Override
    public void process(Exchange exchange) {
        try {
            String oldValue = (String) exchange.getIn().getBody();

            String newValue = oldValue.replace(",",":");

            exchange.getIn().setBody(newValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
