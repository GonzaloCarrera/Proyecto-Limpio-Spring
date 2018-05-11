package ar.edu.unlam.tallerweb1.persistencia;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Empresa;


import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Modelo;

public class TestBuscarAutosPorNombreDelModelo extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testBuscarAutosPorNombreDelModelo(){
		Auto a1 = new Auto();
		Auto a2 = new Auto();
		Auto a3 = new Auto();
		Auto a4 = new Auto();
		Modelo m1 = new Modelo();
		Modelo m2 = new Modelo();
		m1.setModelo("Clio");
		m2.setModelo("Corsa");
		a1.setColor("Azul");
		a2.setColor("Rojo");
		a3.setColor("Azul");
		a4.setColor("Verde");
		a1.setPatente("ASD123");
		a2.setPatente("SDF123");
		a3.setPatente("DFG123");
		a4.setPatente("GHJ123");
		a1.setModelo(m1);
		a2.setModelo(m2);
		a3.setModelo(m1);
		a4.setModelo(m2);
		getSession().save(a1);
		getSession().save(a2);
		getSession().save(a3);
		getSession().save(a4);
		List<Auto> listaDeAutos = new ArrayList<Auto>();
		listaDeAutos = getSession().createCriteria(Auto.class)
							.add(Restrictions.eq("modelo", m1))
							.list();
		assertEquals(listaDeAutos.size(),2);
		
	}
}
