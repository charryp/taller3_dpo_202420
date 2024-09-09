package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 600;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
		int COSTO_POR_KM = COSTO_POR_KM_NATURAL;
		String tipoCliente = cliente.getTipoCliente();
		
		if(tipoCliente.equals("Corporativo"))
			COSTO_POR_KM = COSTO_POR_KM_CORPORATIVO - (COSTO_POR_KM_CORPORATIVO * calcularPorcentajeDescuento(cliente));
		
		return COSTO_POR_KM * distancia;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento = 0.0;
		String tipoCliente = cliente.getTipoCliente();
		
		if(tipoCliente.equals("Corporativo"))
			int tamanoEmpresa = cliente.getTamanoEmpresa();
			descuento = DESCUENTO_PEQ;
			
			if(tamanoEmpresa == 2)
				descuento = DESCUENTO_MEDIANAS;
			else if(tamanoEmpresa == 3)
				descuento = DESCUENTO_GRANDES;
			
		return descuento;
	}

}
