package io.apiglue.clonebyt.clonebytserver.message;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MessageControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

    @Test
    @Description("Test for getMessage method")
    public void testGetMessage() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello?myName=test");
        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("Hello test"));
    }
}
