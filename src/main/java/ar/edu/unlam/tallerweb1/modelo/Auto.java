package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Auto {
	@Id
	@GeneratedValue
	private long idAuto;
	private String color;
	private String patente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Modelo modelo;
	
	public long getIdAuto() {
		return idAuto;
	}
	public void setIdAuto(long idAuto) {
		this.idAuto = idAuto;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
}
