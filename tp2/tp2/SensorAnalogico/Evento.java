
public class Evento {
	private TipoDeEvento tipo;
	private Fecha fecha;
	private String mensaje;
	
	
	public Evento (TipoDeEvento tipo, Fecha fecha, String mensaje){
		if (tipo==null || fecha == null)
			throw new IllegalArgumentException();
		this.tipo=tipo;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}
	
	public TipoDeEvento getTipoDeEvento(){
		return tipo;
	}
	
	public Fecha getFecha(){
		return fecha;
	}
	
	public String getMensaje(){
		return mensaje;
	}
}
