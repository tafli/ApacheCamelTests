package ApacheCamelTests;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;


public class CopyFilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());
        assertEquals(2, file.listFiles().length);
    }
}