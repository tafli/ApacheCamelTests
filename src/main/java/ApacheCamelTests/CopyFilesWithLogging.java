package ApacheCamelTests;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesWithLogging {
    public static void main(String... args) {
        CamelContext ctx = new DefaultCamelContext();

        try {
            ctx.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");
                }
            });

            ctx.start();
            Thread.sleep(5000);
            ctx.stop();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
