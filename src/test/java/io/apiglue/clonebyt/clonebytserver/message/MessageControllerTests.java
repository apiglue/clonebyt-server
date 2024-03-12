package io.apiglue.clonebyt.clonebytserver.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)

public class MessageControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private MessageController controller;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	@DisplayName("Test sayHello - Default params")
	public void testSayHelloDefault()  throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello");

		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("Hello World!"));
	}
	@Test
	@DisplayName("Test sayHello - Custom params")
	public void testSayHello()  throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello?myName=Clonebyt");

		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("Hello Clonebyt!"));
	}


}
