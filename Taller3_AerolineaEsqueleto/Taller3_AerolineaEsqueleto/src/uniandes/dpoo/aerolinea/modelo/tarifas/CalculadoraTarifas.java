package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public final double IMPUESTO = 0.28;
	private Cliente cliente;
	private Vuelo vuelo;
	
	public CalculadoraTarifas(Cliente cliente, Vuelo vuelo) {
		this.cliente = cliente;
		this.vuelo = vuelo;
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		// This method is implemented using the haversine formula...
		double latitudDestino = ruta.getDestino().getLatitud();
		double latitudOrigen = ruta.getOrigen().getLatitud();
		double longitudDestino = ruta.getDestino().getLongitud();
		double longitudOrigen = ruta.getOrigen().getLongitud();
		
		latitudDestino = degreesToRadians(latitudDestino);
		latitudOrigen = degreesToRadians(latitudOrigen);
		longitudDestino = degreesToRadians(longitudDestino);
		longitudOrigen = degreesToRadians(longitudOrigen);
		
		double restLat = latitudDestino - latitudOrigen;
		double restLon = longitudDestino - longitudOrigen;
		
		double sinLat = Math.sin(restLat / 2);
		double sinLon = Math.sin(restLon / 2);
		
		double a = (sinLat * sinLat) + Math.cos(latitudOrigen)*Math.cos(latitudDestino)*(sinLon*sinLon);
		double c = 2 * Math.asin (Math.min(1.0, Math.sqrt(a)));
		
		return (int) (6371 * c * 1000);
	}
	
	protected double degreesToRadians(double degrees) {
		return Math.toRadians(degrees);
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		return (int) (IMPUESTO / costoBase);
	}
}
