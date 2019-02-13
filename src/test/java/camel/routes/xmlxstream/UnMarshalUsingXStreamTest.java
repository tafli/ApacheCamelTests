package camel.routes.xmlxstream;

import camel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXStreamTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new UnMarshalUsingXStream();
    }

    @Test
    public void unmarshalExchangeTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Andreas Boss");
        employee.setJoinDate("16.11.1981");

        String xmlInput = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Andreas Boss</name><joinDate>16.11.1981</joinDate></employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(employee.toString());

        template.sendBody("direct:xmlInput", xmlInput);
        assertMockEndpointsSatisfied();
    }
}