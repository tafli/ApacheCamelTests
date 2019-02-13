package camel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXStreamTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new MarshalUsingXStream();
    }


    @Test
    public void marshalTest() throws InterruptedException {
        String inputValue = "123,Andreas Boss,16.11.1981";
        String expectedValue = "<?xml version='1.0' encoding='UTF-8'?><camel.domain.Employee><id>123</id><name>Andreas Boss</name><joinDate>16.11.1981</joinDate></camel.domain.Employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:csvInput", inputValue);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void marshalTestAlias() throws InterruptedException {
        String inputValue = "123,Andreas Boss,16.11.1981";
        String expectedValue = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Andreas Boss</name><joinDate>16.11.1981</joinDate></employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:csvInput", inputValue);

        assertMockEndpointsSatisfied();
    }
}