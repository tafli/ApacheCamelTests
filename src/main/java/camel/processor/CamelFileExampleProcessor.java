package camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("--> Exchange in Processor is : " + exchange.getIn().getBody());

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();

        if (file != null) {
            FileReader fileReader = new FileReader(file.getFile());

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            String newValue = "";

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Line is [" + line + "]");
                String oldValue = line;
                newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");
            }

            System.out.println("--> New Content is ["+newValue+"]");
            exchange.getIn().setBody(newValue);
        }
    }
}
