package camel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {
        template.sendBody("direct:sampleInput", "1234,Boss,Udemy Course");
        Thread.sleep(2000);

        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}