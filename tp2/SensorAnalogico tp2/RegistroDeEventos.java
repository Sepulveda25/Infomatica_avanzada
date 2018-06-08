import java.util.ArrayList;
import java.util.List;


public class RegistroDeEventos {
	private List<Evento> eventos;
	
	public RegistroDeEventos(){
		eventos = new ArrayList<Evento>();
	}
	
	public List<Evento> getEventos(){
		return eventos;
	}
	
	
	/**
	 * Agrega un evento al Registro
	 * Lanza IllegalArgumentException si el evento es null
	 * @param e
	 */
	public void agregarEvento(Evento e){
		//TODO implementar metodo
	}
	
	/**
	 * Elimina todos los eventos del Registro
	 */
	public void limpiarEventos () {
		//TODO implementar metodo
	}
	
	/**
	 * Devuelve una lista con los eventos del registro cuyo tipo es el que se pasa por argumento.
	 * Si el Tipo de Evento pasado como argumento es null retorna una lista vacia
	 * Si no hay eventos del tipo de Evento pasado como argumento en el registro retorna una lista vacia
	 *   
	 * 
	 * @param tipo de Eventp
	 * @return una lista de eventos
	 */
	public List<Evento> listarEventosPorTipo (TipoDeEvento t){
		//TODO implementar metodo
		return null;
	}
}
