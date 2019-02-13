package camel.routes.process;

import camel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class ModifyFileProcessorRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("file:data/input/process?noop=true")
                .log("Read file is ${body} and Headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output/process?fileName=output.txt")
                .to("mock:output");
    }
}
