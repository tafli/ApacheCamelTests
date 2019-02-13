package camel.routes.process;

import camel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class ModifyDirectProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Received message BEFORE process is ${body} and Headers are ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Received message AFTER process is ${body} and Headers are ${headers}")
//                .to("file:data/output/process?fileName=outputDirect.txt")
                .to("mock:output");
    }
}
