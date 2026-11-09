package com.betacom.ju;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@Rollback (value = false)
public class EmployeeRepositoryTest {
	
	@Autowired
	private IEmployeeRepositoy repE;
	
	@Order(1)
	@Test
	public void saveEmployee() {
		Employee e = new Employee();
		e.setCognome("Verde");
		e.setNome("Fluvio");
		e.setEmail("f.verde@gmail.com");
		int id = repE.save(e).getId();
		
		Assertions.assertThat(id).isEqualTo(1);
		

	}
	
	@Order(2)
	@Test
	public void saveEmployee2() {
		Employee e = new Employee();
		e.setCognome("Giallo");
		e.setNome("Anna");
		e.setEmail("a.giallo@gmail.com");
		int id = repE.save(e).getId();
		
		Assertions.assertThat(id).isEqualTo(2);
		
	}

	@Order(3)
	@Test
	public void getEmployee() {
		Employee e = repE.findById(1).get();
		
		Assertions.assertThat(e.getCognome()).isEqualTo("Verde");
	}
}
