package testingexample.com.demote.controllerjava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.spec.internal.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import testingexample.com.demote.servicejava.ServiceMain;

@RunWith(SpringRunner.class)
@WebMvcTest(MainContro.class)
class MainControTest {

	@Autowired
	private MockMvc mockmvc;
	@Autowired
	MainContro contro;
	
	
	@Test
	public void controTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request)
			//	.andExpect(status().isOk())
				.andReturn();
		assertEquals("hello world", result.getResponse().getContentAsString());
	}
	
	@MockBean
	ServiceMain service;
	
	@Test
	public void calculatorTest()  {
	/*	
		RequestBuilder request = MockMvcRequestBuilders
				.get("/calcu")
				.accept(MediaTypes.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request)
				//.andExpect(status().isOk())
				.andReturn();
	*/
		assertEquals(10, contro.caluclator(4, 6));
	}
	
	@Test
	public void entityTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/entity")
				.accept(MediaTypes.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request)
				.andExpect(status().isOk()).andExpect(content().json("{\"id\":2,\"name\":\"ana\",\"mail\":\"ana@gmail.com\"}"))
				.andReturn();
	//	String expected = "{\"id\":2,\"name\":\"ana\",\"mail\":\"ana@gmail.com\"}";
		assertEquals("{\"id\":2,\"name\":\"ana\",\"mail\":\"ana@gmail.com\"}", result.getResponse().getContentAsString());
	}

}
