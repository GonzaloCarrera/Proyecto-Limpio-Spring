package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Empleado;
import ar.edu.unlam.tallerweb1.modelo.Empresa;

public class QueUnEmpleadoSeAgregueALaEmpresa extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testQueUnEmpleadoSeAgregueALaEmpresa(){		
		Direccion miDireccion = new Direccion();
		Empresa miEmpresa = new Empresa();
		Empleado miEmpleado = new Empleado();
		miDireccion.setCalle("calle");
		miDireccion.setNumero(123);
		miEmpresa.setDireccion(miDireccion);
		miEmpresa.setNombre("NombreEmpresa");
		miEmpleado.setApellido("apellidoEmpleado");
		miEmpleado.setNombre("nombreEmpleado");
		
		//miEmpresa.getListaDeEmpleados().add(miEmpleado);
		
		//getSession().save(miEmpresa);
		miEmpleado.setEmpresa(miEmpresa);
//		
		getSession().saveOrUpdate(miEmpleado);

//		System.out.println(miEmpresa.getId());
//		System.out.println(miEmpresa.getNombre());
//		System.out.println(miEmpleado.getId());
//		System.out.println(miEmpresa.getDireccion().getCalle());
		System.out.println(miEmpresa.getListaDeEmpleados().size());
		System.out.println(getSession().get(Empresa.class, miEmpresa.getIdEmpresa()).getListaDeEmpleados().contains(miEmpleado));
		//long esperado = getSession().get(Empleado.class, miEmpleado.getId()).getId();
		//long actual = getSession().get(Empresa.class, miEmpresa.getId()).getListaDeEmpleados().get((int) miEmpleado.getId()).getId();
		//assertEquals(esperado,actual);
		//assertThat(miEmpresa.getListaDeEmpleados()).isNull();
		//assertThat(miEmpleado.getApellido()).isNotNull();
		//assertEquals(miEmpleado.getId(), 3);
		assertEquals(miEmpresa.getListaDeEmpleados().size(), 1);
	}
}
