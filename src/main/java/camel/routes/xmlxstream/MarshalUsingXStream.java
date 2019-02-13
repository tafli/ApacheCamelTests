package camel.routes.xmlxstream;

import camel.domain.Employee;
import camel.processor.CustomProcessorXStream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXStream extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:csvInput")
                .process(new CustomProcessorXStream())
//                .marshal().xstream()
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateStreamDef() {
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();

        Map<String,String> aliases = new HashMap<>();
        aliases.put("employee", Employee.class.getName());

        xStreamDataFormat.setAliases(aliases);

        return xStreamDataFormat;
    }
}
