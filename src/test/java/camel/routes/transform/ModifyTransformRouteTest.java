package camel.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ModifyTransformRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new ModifyTransformRoute();
    }


    @Test
    public void transformTest() throws InterruptedException {
        String inputValue = "123,456,789";
        String expectedValue = "123*456*789";

        String result = (String) template.requestBody("direct:transformInput", inputValue);

        assertEquals(expectedValue, result);
    }

    @Test
    public void transformDirectMockTest() throws InterruptedException {
        String inputValue = "123,456,789";
        String expectedValue = "123*456*789";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:transformInput", inputValue);

        assertMockEndpointsSatisfied();
    }
}