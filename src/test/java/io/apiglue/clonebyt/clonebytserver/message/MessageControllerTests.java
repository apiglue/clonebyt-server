package io.apiglue.clonebyt.clonebytserver.message;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class MessageControllerTests {

    private MockMvc mvc;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

//    @Test
//    @Description("Test for getMessage method")
//    public void testGetMessage() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/messages");
//        mvc.perform(requestBuilder).andExpect(status().isOk());
//    }
}
