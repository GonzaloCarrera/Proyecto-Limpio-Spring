package ar.edu.unlam.tallerweb1.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Marca;
import ar.edu.unlam.tallerweb1.modelo.Modelo;

public class TestBuscarTodosLosAutosDeUnaMarca extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testBuscarTodosLosAutosDeUnaMarca(){
	Auto a1 = new Auto();
	Auto a2 = new Auto();
	Auto a3 = new Auto();
	Auto a4 = new Auto();
	Modelo mod1 = new Modelo();
	Modelo mod2 = new Modelo();
	Marca mar1 = new Marca();
	Marca mar2 = new Marca();
	mod1.setModelo("Clio");
	mod2.setModelo("Corsa");
	mar1.setMarca("Renault");
	mar2.setMarca("Wolkswagen");
	mod1.setMarca(mar1);
	mod2.setMarca(mar2);
	a1.setColor("Azul");
	a2.setColor("Rojo");
	a3.setColor("Azul");
	a4.setColor("Verde");
	a1.setPatente("ASD123");
	a2.setPatente("SDF123");
	a3.setPatente("DFG123");
	a4.setPatente("GHJ123");
	a1.setModelo(mod1);
	a2.setModelo(mod2);
	a3.setModelo(mod1);
	a4.setModelo(mod2);
	getSession().save(a1);
	getSession().save(a2);
	getSession().save(a3);
	getSession().save(a4);

	}
}
