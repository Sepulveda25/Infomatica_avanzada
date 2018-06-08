
public abstract class Sensor {
	private String id;
	private boolean habilitado=true;
	
	
	/**
	 * Constructor  
	 * crea un objeto Sensor, cuyo id es pasado como argumento
	 * 
	 * El id siempre se guarda en mayúsculas y sin espacios al inicio ni al final de la cadena.
	 * 
	 * @param id el id de este Sensor
	 * @throws IllegalArgumentException si el id es null o vacio.
	 */
	public Sensor(String id){
		//TODO implementar metodo
	}
	
	public void setHabilitar(boolean valor){
		habilitado=valor;		
	}
	
	public boolean esHabilitado() {
		return habilitado;
	}
	
	public String getId(){
		return id;
	}
	
	abstract public boolean esActivo();
	
}
