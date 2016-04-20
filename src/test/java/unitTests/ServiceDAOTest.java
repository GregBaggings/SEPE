package unitTests;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cw.database.cars.Car;
import com.cw.database.services.Service;
import com.cw.database.services.ServiceDAO;
import com.cw.database.services.ServiceRepository;

public class ServiceDAOTest {

	@Mock
	ServiceRepository mock;
	ServiceDAO dao;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		dao = new ServiceDAO(mock);
	}

	@Test
	public void deleteService() {
		// GIVEN
		int dummyId = 1;
		// WHEN
		dao.deleteService(dummyId);
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
	public void findByName() {
		// GIVEN
		String dummy = "Audi";
		ArrayList<Service> expList = new ArrayList<Service>();
		Mockito.when(mock.findAllByName(dummy)).thenReturn(expList);
		// WHEN
		List<Service> actList = dao.findByName(dummy);
		// THEN
		Mockito.verify(mock).findAllByName(dummy);
		Assert.assertEquals(actList, expList);
	}

	@Test
	public void saveNewService() {
		// GIVEN
		Service dummy = new Service();
		// WHEN
		dao.saveNewService(dummy);
		// THEN
		Mockito.verify(mock).save(dummy);
	}

	@Test
	public void updateService() {
		// GIVEN
		Service dummy = new Service();
		// WHEN
		dao.updateService(dummy);
		// THEN
		Mockito.verify(mock).save(dummy);
	}
}
