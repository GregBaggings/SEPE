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
import com.cw.database.cars.CarDAO;
import com.cw.database.cars.CarRepository;

public class CarDAOTest {
	@Mock
	CarRepository mock;
	CarDAO dao;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
		dao = new CarDAO(mock);
	}

	@Test
	public void deleteCar() {
		// GIVEN
		int dummyId = 1;
		// WHEN
		dao.deleteCar(dummyId);
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
		ArrayList<Car> expList = new ArrayList<Car>();
		Mockito.when(mock.findAllByName(dummy)).thenReturn(expList);
		// WHEN
		List<Car> actList = dao.findByName(dummy);
		// THEN
		Mockito.verify(mock).findAllByName(dummy);
		Assert.assertEquals(actList, expList);
	}

	@Test
	public void saveNewCar() {
		// GIVEN
		Car dummy = new Car();
		// WHEN
		dao.saveNewCar(dummy);
		// THEN
		Mockito.verify(mock).save(dummy);
	}

	@Test
	public void updateCar() {
		// GIVEN
		Car dummy = new Car();
		// WHEN
		dao.updateCar(dummy);
		// THEN
		Mockito.verify(mock).save(dummy);
	}
}
