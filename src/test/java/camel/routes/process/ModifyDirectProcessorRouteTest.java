package camel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ModifyDirectProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new ModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest() throws InterruptedException {
        String inputValue = "123,456,789";
        String expectedValue = "123:456:789";

        String output = (String) template.requestBody("direct:processorInput", inputValue);
        Thread.sleep(2000);

        assertEquals(expectedValue, output);
    }

    @Test
    public void processorDirectMockTest() throws InterruptedException {
        String inputValue = "123,456,789";
        String expectedValue = "123:456:789";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:processorInput", inputValue);

        assertMockEndpointsSatisfied();
    }
}