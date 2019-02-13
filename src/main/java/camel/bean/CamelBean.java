package camel.bean;

import org.apache.camel.Handler;

public class CamelBean {
    @Handler
    public String map(String input) {
        return input.replace(",", "#");
    }

    public String anotherMapper(String input) {
        return input.replace(",", "|");
    }
}
