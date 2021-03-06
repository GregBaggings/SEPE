package unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cw.page.controllers.RemoveServiceController;

public class RemoveServiceControllerTest {
	@InjectMocks
	private RemoveServiceController removeServiceController;
	private MockMvc mockMvc;

	@BeforeTest
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(removeServiceController).setViewResolvers(viewResolver).build();
	}

	@Test
	public void negativeFlowTest() throws Exception {
		this.mockMvc.perform(get("/admin/removeService")).andExpect(status().is3xxRedirection());
	}
}
