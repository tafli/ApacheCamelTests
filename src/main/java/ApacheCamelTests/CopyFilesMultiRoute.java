package ApacheCamelTests;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesMultiRoute {
    public static void main(String... args) {
        CamelContext ctx = new DefaultCamelContext();

        try {
            ctx.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("file:data/input?noop=true")
                            .to("file:data/output")
                            .to("file:data/output/backup");

                    from("file:data/input2?noop=true")
                            .to("file:data/output2");
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
