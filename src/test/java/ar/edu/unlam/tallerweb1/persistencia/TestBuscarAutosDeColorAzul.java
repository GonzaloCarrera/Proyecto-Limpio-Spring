package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;

public class TestBuscarAutosDeColorAzul extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testBuscarAutosDeColorAzul(){
		Auto a1 = new Auto();
		Auto a2 = new Auto();
		Auto a3 = new Auto();
		Auto a4 = new Auto();
		a1.setColor("Azul");
		a2.setColor("Rojo");
		a3.setColor("Azul");
		a4.setColor("Verde");
		getSession().save(a1);
		getSession().save(a2);
		getSession().save(a3);
		getSession().save(a4);
		assertEquals(
				getSession().createCriteria(Auto.class)
					.add(Restrictions.eq("color", "Azul"))
					.list().size(), 2
				);
	}
}
