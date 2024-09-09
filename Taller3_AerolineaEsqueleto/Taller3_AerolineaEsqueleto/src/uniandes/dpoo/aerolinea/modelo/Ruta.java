package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    // TODO completar
	private String horaSalida;
	private String horaLlegada;
	private String codigoRuta;
	private Aeropuerto origen;
	private Aeropuerto destino;
	
	

    public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) {
    	this.origen = new Aeropuerto();
    	this.destino = new Aeropuerto();
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.codigoRuta = codigoRuta;
	}
    
    public Ruta() {
		
	}
    
    
	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	public String getHoraLlegada() {
		return horaLlegada;
	}


	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	public String getCodigoRuta() {
		return codigoRuta;
	}


	public void setCodigoRuta(String codigoRuta) {
		this.codigoRuta = codigoRuta;
	}
	
	

	
	public Aeropuerto getOrigen() {
		return origen;
	}


	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}


	public Aeropuerto getDestino() {
		return destino;
	}


	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}
	
	public int getDuracion() {
		int duracion;
		int hLlegada = getHoras(horaLlegada);
		int hSalida = getHoras(horaSalida);
		int mLlegada = getMinutos(horaLlegada);
		int mSalida = getMinutos(horaSalida);
		int llegada = (hLlegada * 60) + mLlegada;
		int salida = (hSalida * 60) + mSalida;
		
		if(llegada > salida)
			duracion = llegada - salida;
		else
			duracion = (24 * 60) - (salida - llegada);		
		
		return duracion;
		
	}


	/**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }

    
}
