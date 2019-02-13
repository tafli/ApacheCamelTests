package camel.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new ModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expectedValue =
                "test1:test2:test3\n" +
                "andreas:boss:BaS\n";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);

        File file = new File("data/output/process");
        assertTrue(file.isDirectory());

        assertMockEndpointsSatisfied();

    }

}