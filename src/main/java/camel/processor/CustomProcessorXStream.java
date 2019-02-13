package camel.processor;

import camel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.StringTokenizer;

public class CustomProcessorXStream implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String newBody = exchange.getIn().getBody(String.class);
        StringTokenizer stringTokenizer = new StringTokenizer(newBody, ",");

        Employee employee = new Employee();

        while(stringTokenizer.hasMoreElements()) {
            employee.setId((String) stringTokenizer.nextElement());
            employee.setName((String) stringTokenizer.nextElement());
            employee.setJoinDate((String) stringTokenizer.nextElement());
        }

        exchange.getIn().setBody(employee);
    }
}
