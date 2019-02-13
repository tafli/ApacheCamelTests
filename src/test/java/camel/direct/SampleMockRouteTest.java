package camel.direct;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() {
        return new SampleMockRoute();
    }

    @Test
    public void sampleMockRouteTest() throws InterruptedException {
        String input = "Hello";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(input);

        template.sendBody("direct:sampleInput", input);
        assertMockEndpointsSatisfied();
    }
}