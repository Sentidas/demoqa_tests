package guru.qa.properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests  {

    @Test
    @Tag("property")
    void systemProperty(){
        String browser = System.getProperty("browser", "mozilla");

        System.out.println(browser);
    }
}
