package camel.routes.transform;

import org.apache.camel.builder.RouteBuilder;

public class ModifyTransformRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:transformInput")
                .log("Received message BEFORE transform is ${body} and Headers are ${headers}")
                .transform(body().regexReplaceAll(",","*"))
                .log("Received message AFTER transform is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
