package unitTests;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cw.database.news.News;
import com.cw.database.news.NewsDAO;
import com.cw.database.news.NewsRepository;

public class NewsDAOTest {
	@Mock
	NewsRepository mock;
	NewsDAO dao;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		dao = new NewsDAO(mock);
	}

	@Test
	public void createNews() {
		// GIVEN
		News dummy = new News();
		// WHEN
		dao.createNews(dummy);
		// THEN
		Mockito.verify(mock).save(dummy);
	}

	@Test
	public void deleteNews() {
		// GIVEN
		int dummyId = 1;
		// WHEN
		dao.deleteNews(dummyId);
		// THEN
		Mockito.verify(mock).delete(dummyId);
	}

	@Test
	public void findAll() {
		// GIVEN
		// WHEN
		dao.findAll();
		// THEN
		Mockito.verify(mock).findAll();
	}

	@Test
	public void findByTitle() {
		// GIVEN
		String dummyTitle = "test";
		ArrayList<News> expList = new ArrayList<News>();
		Mockito.when(mock.findByTitle(dummyTitle)).thenReturn(expList);
		// WHEN
		List<News> actList = dao.findByTitle(dummyTitle);
		// THEN
		Mockito.verify(mock).findByTitle(dummyTitle);
		Assert.assertEquals(actList, expList);
	}

	@Test
	public void findTop5ByOrderByDateDecs() {
		// GIVEN
		int expItemNumber = 5;
		// WHEN
		List<News> actList = dao.findTop5ByOrderByDateDecs();
		// THEN
		Mockito.verify(mock).findTop5ByOrderByDateDesc();
		Assert.assertEquals(actList.size(), expItemNumber);
	}
}
