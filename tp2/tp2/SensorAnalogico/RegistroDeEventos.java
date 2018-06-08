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
		if (e == null)
		{
		   throw new IllegalArgumentException ("Evento null.");
		  }
		eventos.add(e);
	}
	
	/**
	 * Elimina todos los eventos del Registro
	 */
	public void limpiarEventos () {
		//TODO implementar metodo
		eventos.clear();
	}
	
	/**
	 * Devuelve una lista con los eventos del registro cuyo tipo es el que se pasa por argumento.
	 * Si el Tipo de Evento pasado como argumento es null retorna una lista vacia
	 * Si no hay eventos del tipo de Evento pasado como argumento en el registro retorna una lista vacia
	 *   
	 * 
	 * @param tipo de Evento
	 * @return una lista de eventos
	 */
	public List<Evento> listarEventosPorTipo (TipoDeEvento t){
		//TODO implementar metodo
		List<Evento> e = new ArrayList<Evento>();
		for (Evento ev : eventos)
		{
		  if(ev.getTipoDeEvento().equals(t)) {e.add(ev);}
		  }
		return e;
	}
}
