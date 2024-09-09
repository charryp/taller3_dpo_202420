package uniandes.dpoo.aerolinea.modelo.cliente;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class Cliente {
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		this.tiquetesSinUsar = new LinkedList<Tiquete>();
		this.tiquetesSinUsar = new LinkedList<Tiquete>();
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int valor = 0;
		Tiquete tiquete = null;
		Iterator<Tiquete> iteradorSinUsar = tiquetesSinUsar.iterator();
		Iterator<Tiquete> iteradorUsados = tiquetesUsados.iterator();
		
		while(iteradorSinUsar.hasNext())
			tiquete = iteradorSinUsar.next();
			valor += tiquete.getTarifa();
			
		while(iteradorUsados.hasNext())
			tiquete = iteradorUsados.next();
			valor += tiquete.getTarifa();
			
		return valor; 
	}
	
	public abstract String getIdentificador();
	
	public abstract String getTipoCliente();
	
	public void usarTiquetes(Vuelo vuelo) {
		Tiquete tiquete = null;
		LinkedList<Tiquete> tiquetes = new LinkedList<>(vuelo.getTiquetes());
		Iterator<Tiquete> iteradorTiquetes = tiquetes.iterator();
		
		while(iteradorTiquetes.hasNext())
			tiquete = iteradorTiquetes.next();
			tiquete.marcarComoUsado();
			
			if(tiquetesSinUsar.contains(tiquete))
				tiquetesSinUsar.remove(tiquete);
				tiquetesUsados.add(tiquete);
			
	}
	
	
	
	
}
