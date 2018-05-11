package ar.edu.unlam.tallerweb1.persistencia;


import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;

public class TestBuscarAutoPorPatenteUnica extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testBuscarAutoPorPatenteUnica(){
		Auto a1 = new Auto();
		Auto a2 = new Auto();
		Auto a3 = new Auto();
		Auto a4 = new Auto();
		a1.setColor("Azul");
		a2.setColor("Rojo");
		a3.setColor("Azul");
		a4.setColor("Verde");
		a1.setPatente("ASD123");
		a2.setPatente("SDF123");
		a3.setPatente("DFG123");
		a4.setPatente("GHJ123");
		assertThat(
				getSession().createCriteria(Auto.class)
						.add(Restrictions.eq("patente", a1.getPatente()))
						.uniqueResult()
				);
		
	}
}
