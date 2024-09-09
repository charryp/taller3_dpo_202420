package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
	public final String NATURAL ="Natural";
	private String nombre;
	
	
	
	public ClienteNatural(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return NATURAL + nombre;
	}

	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return NATURAL;
	}

}
