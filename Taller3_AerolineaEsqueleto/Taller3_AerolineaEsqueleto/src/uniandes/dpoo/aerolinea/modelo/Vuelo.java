package uniandes.dpoo.aerolinea.modelo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.LinkedList;

public class Vuelo {
	private String fecha;
	private Ruta ruta = new Ruta();
	private Avion avion = new Avion();
	private Map<String, Tiquete> tiquetes = new HashMap<>();
	
	public Vuelo(String fecha, Ruta ruta, Avion avion) {
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	
	public Vuelo() {
		
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	public Collection<Tiquete> getTiquetes(){
		LinkedList<Tiquete> listTiquetes = new LinkedList<>(tiquetes.values());
		
		return listTiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		
		return cantidad;
		
	}
	
	public boolean equals(Object object) {
		return false;
	}
}
