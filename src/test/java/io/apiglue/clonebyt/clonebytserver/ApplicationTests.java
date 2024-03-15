package io.apiglue.clonebyt.clonebytserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")
public class ApplicationTests {

    @Test
    void contextLoads() {
    }

}
