package camel.routes.bean;

import camel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class ModifyBeanRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:beanInput")
                .bean(new CamelBean())
                .bean(new CamelBean(), "anotherMapper")
                .to("mock:output");
    }
}
