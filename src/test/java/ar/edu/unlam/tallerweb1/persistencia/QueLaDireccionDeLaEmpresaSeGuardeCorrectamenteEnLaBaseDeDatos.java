package ar.edu.unlam.tallerweb1.persistencia;


	import static org.junit.Assert.*;

	import org.junit.Test;
	import org.springframework.test.annotation.Rollback;
	import org.springframework.transaction.annotation.Transactional;
	import static org.assertj.core.api.Assertions.*;
	import ar.edu.unlam.tallerweb1.SpringTest;
	import ar.edu.unlam.tallerweb1.modelo.Direccion;
	import ar.edu.unlam.tallerweb1.modelo.Empresa;


	public class QueLaDireccionDeLaEmpresaSeGuardeCorrectamenteEnLaBaseDeDatos extends SpringTest{

	    @Test
	    @Transactional @Rollback(true)
	    public void TestQueAUnaEmpresaSeLeAsigneLaDireccionTest(){
	    	Empresa miEmpresa = new Empresa();
	    	Direccion miDireccion = new Direccion();
	    	miDireccion.setCalle("Calle");
	    	miDireccion.setNumero(123);
	    	miEmpresa.setNombre("NombreEmpresa");

	    	miEmpresa.setDireccion(miDireccion);

	    	getSession().save(miEmpresa);
	    	
	    	Empresa empresaBaseDatos = getSession().get(Empresa.class, miEmpresa.getIdEmpresa());

//	    	assertThat(empresaBaseDatos).isNotNull();
//	    	assertThat(empresaBaseDatos.getDireccion()).isNotNull();
//	    	assertEquals(empresaBaseDatos.getDireccion().getId(),1);
	   	assertEquals(miEmpresa.getDireccion().getId(),1L);
	 // 	assertEquals(miEmpresa.getDireccion().getId(),empresaBaseDatos.getDireccion().getId());
		//assertEquals(miEmpresa,empresaBaseDatos);
	    }

	}
