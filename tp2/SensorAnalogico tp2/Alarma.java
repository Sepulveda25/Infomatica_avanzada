import java.util.ArrayList;
import java.util.List;

public class Alarma {

	private List<Sensor> listadoSensores;
	private List<Indicador> listadoIndicadores;
	private EstadoDeAlarma estado;
	private RegistroDeEventos registro;
	private Pulsador reset = new Pulsador();
	private Pulsador armar = new Pulsador();
	private Pulsador encendido= new Pulsador();

	public Alarma(){
		estado=EstadoDeAlarma.DESARMADO;
		listadoSensores = new ArrayList<Sensor>();
		listadoIndicadores = new ArrayList<Indicador>();
		registro = new RegistroDeEventos();
		reset.setActivo(false);
		armar.setActivo(false);
		encendido.setActivo(true);	
	}
	
	public List<Sensor> getSensores(){
		return listadoSensores;
	}
	
	public List<Indicador> getIndicadores(){
		return listadoIndicadores;
	}
	
	public RegistroDeEventos getRegistroDeEventos(){
		return registro;
	}
	
	
	public void loop(){
		while (encendido.esActivo()) {
			switch (estado) {
				case ACTIVO:
					if (!getSensoresActivos().isEmpty()){
						dispararAlarma (getSensoresActivos());
						break;
					} 					
					
					if (reset.esActivo()){
						desarmarAlarma();
						break;
					}
					
					break;
			
				case DISPARO:
					if (reset.esActivo()){
						desarmarAlarma();
					}
					break;
				
				case DESARMADO:
					if (armar.esActivo()){
						try {
							armarAlarma();
						} catch (IllegalStateException e){
							errorAlarma();
						}
					}
					break;
					
				case ERROR:
					if (reset.esActivo()){
						desarmarAlarma();
					}
					break;
			}
		}
		
	}
	
	public void setEstado(EstadoDeAlarma e){
		estado=e;
	}
	
	public EstadoDeAlarma getEstado(){
		return estado;
	}
	
	
	
	
	/**
	 * Devuelve una lista con los sensores de la alarma que están
	 * activos Y habilitados 
	 * 
	 * @return Lista de Sensores activos
	 */
	public List<Sensor> getSensoresActivos(){
		//TODO implementar metodo
		return null;
	}
	
	
	/**
	 * Activa o desactiva todos los indicadores de la alarma, de acuerdo
	 * al valor pasado como argumento
	 * @param activo
	 */
	public void activarIndicadores(boolean activo){
		//TODO implementar metodo
	}
	
	/**
	 * Activa SOLO los indicadores de la alarma que son instancia de la clase 
	 * "Baliza". (instanceof)
	 *  
	 */
	public void activarBaliza(){
		//TODO implementar metodo
	}
	
	
	/**
	 * Desarmar alarma.
	 * 1. apaga todos los indicadores 
	 * 2. agrega un evento del tipo adecuado al registro (con fecha actual, SIN mensaje (no significa mensaje vacio!) )
	 * 3. desactiva el pulsador de reset
	 * 3. cambia el estado de la alarma a dasarmada
	 * 
	 */
	public void desarmarAlarma(){
		//TODO implementar metodo
	}
	
	/**
	 * Dispara alarma.
	 * 1. enciende todos los indicadores 
	 * 2. agrega un evento  al registro. El mensaje consiste en la lista de id's
	 * de los sensores pasados como argumento, con este formato:  '<id1>;<id2>;<id3>;' 
	 * 	Ej: "sensor1;sensor2;"
	 * 3. cambia el estado de la alarma a disparada
	 * 
	 * @param Lista con los sensores activos.
	 */
	public void dispararAlarma (List<Sensor> sensores){
		//TODO implementar metodo
	}
	
	/**
	 * Armara alarma.
	 * 1. desactiva el pulsador armar
	 * 2. agrega un evento  al registro (sin mensaje (no significa mensaje vacio!))
	 * 3. cambia el estado de la alarma a activa
	 * 
	 * NO SE PUEDE ARMAR LA ALARMA SI HAY ALGÚN SENSOR ACTIVO. En ese caso
	 * lanza una excepcion, y no cambia ni estado ni genera evento
	 * 
	 * @param Lista con los sensores activos.
	 * @throws IllegalStateException si alguno de los sensores está activo al querer armar la 
	 * alarma. 
	 */
	public void armarAlarma() {	
		//TODO implementar metodo
	}
	
	/**
	 * Armara alarma.
	 * 1. activa indicadores luminosos solaemnte (Baliza)
	 * 2. agrega un evento  al registro. El mensaje del evento consiste en la lista de id's
	 * de los sensores activos de la alarma con este formato:  '<id1>;<id2>;<id3>;' 
	 * 3. cambia el estado de la alarma a error
	 * 
	 */
	public void errorAlarma(){
		//TODO implementar metodo
	}
}
