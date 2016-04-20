package unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cw.page.controllers.ContactPageController;

@WebAppConfiguration
public class ContactPageControllerTest {

	@InjectMocks
	private ContactPageController contactPageController;
	private MockMvc mockMvc;

	@BeforeTest
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(contactPageController).setViewResolvers(viewResolver).build();
	}

	@Test
	public void positiveTest() throws Exception {
		this.mockMvc.perform(get("/contact")).andExpect(status().isOk());
	}
	
	@Test
	public void negativeTestWithInvalidUrl() throws Exception {
		this.mockMvc.perform(get("/contact/something")).andExpect(status().is4xxClientError());
	}
	@Test
	public void negativeTestWithWrongUrl() throws Exception {
		this.mockMvc.perform(get("/contac")).andExpect(status().is4xxClientError());
	}
}
