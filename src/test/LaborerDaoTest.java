package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.my.java.dao.LaborerDao;
import com.my.java.dao.LaborerDaoImpl;
import com.my.java.domain.Laborer;

public class LaborerDaoTest {
	public static void main(String[] args) {
		List<Laborer> laborers = new ArrayList<>();
		laborers.add(new Laborer(11, "최한석", LocalDate.now()));
		laborers.add(new Laborer(12, "한아름", LocalDate.now()));
		
		LaborerDao laborerDao = new LaborerDaoImpl(laborers);
		
		//seelct test
		System.out.println(laborerDao.selectLaborers());
		System.out.println(laborerDao.selectLaborer(11));
		
		//insert test
		laborerDao.insertLaborer("양승일", LocalDate.now());
		laborerDao.insertLaborer("김필진", LocalDate.now());
		
		System.out.println(laborerDao.selectLaborers());
		
		
		//update test
		laborerDao.updateLaborer(new Laborer(11, "소리섭", LocalDate.of(2025, 5, 5)));
		System.out.println(laborerDao.selectLaborers());
		
		//delete test
		laborerDao.deleteLaborer(11);
		System.out.println(laborerDao.selectLaborers());
	}
}
