package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marca {
	@Id
	@GeneratedValue
	private long id;
	private String marca;
	
	@OneToMany
	private List<Modelo> listaDeModelos = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<Modelo> getListaDeModelos() {
		return listaDeModelos;
	}

	public void setListaDeModelos(List<Modelo> listaDeModelos) {
		this.listaDeModelos = listaDeModelos;
	}
	
}
