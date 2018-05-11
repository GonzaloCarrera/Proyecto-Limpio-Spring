package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empresa {
	@Id
	@GeneratedValue
	private long idEmpresa;
	private String nombre;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Direccion direccion;	
	
	@OneToMany
	private List<Empleado> listaDeEmpleados = new ArrayList<>();

	public long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}

	public void setListaDeEmpleados(List<Empleado> listaDeEmpleados) {
		this.listaDeEmpleados = listaDeEmpleados;
	}
	
}
