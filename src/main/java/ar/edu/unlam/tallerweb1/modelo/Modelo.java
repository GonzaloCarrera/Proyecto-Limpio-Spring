package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modelo {
	@Id
	@GeneratedValue
	private long id;
	private String modelo;
	
	@OneToMany
	private List<Auto> listaDeAutos = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Marca marca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Auto> getListaDeAutos() {
		return listaDeAutos;
	}

	public void setListaDeAutos(List<Auto> listaDeAutos) {
		this.listaDeAutos = listaDeAutos;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
