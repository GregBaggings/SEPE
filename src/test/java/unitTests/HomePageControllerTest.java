package unitTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cw.database.news.NewsDAO;
import com.cw.database.news.NewsRepository;
import com.cw.page.controllers.HomePageController;

public class HomePageControllerTest {
	@InjectMocks
	private HomePageController homePageController;
	private MockMvc mockMvc;

	@Mock
	NewsRepository mock;
	@Mock
	NewsDAO dao;

	@BeforeTest
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(homePageController).setViewResolvers(viewResolver).build();
	}

	@Test
	public void positiveTest() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}
}
