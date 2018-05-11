package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class CreaUsuarioTest extends SpringTest{

    @Test
    @Transactional @Rollback(true)
    public void probarQueUnUsuarioSeGuardaCorrectamenteEnLaBaseDeDatos(){
    	Usuario miUsuario = new Usuario();
    	miUsuario.setEmail("email");
    	miUsuario.setPassword("Passwd");
    	miUsuario.setRol("Rol");
    	getSession().save(miUsuario);
    	Usuario esperado = miUsuario;
    	Usuario obtenido = (Usuario) getSession().get(Usuario.class, miUsuario.getId());
    	System.out.println(miUsuario.getId());
    	assertEquals(esperado, obtenido);
    }
}
