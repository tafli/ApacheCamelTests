package camel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:sampleInput")
                .log("Receveid message is ${body} and Headers are ${headers}")
                .to("mock:output");
    }
}
