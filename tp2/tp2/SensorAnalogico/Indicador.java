
public interface Indicador {
	
	/**
	 * activa o desactiva el indicador de acuerdo al parametro pasado como argumento
	 * @param activar true para activar, false para desactivar
	 */
	public void activar (boolean activar);
	
	/**
	 * indica si este indicador est� activo o desactivo
	 * @return true si est� activo, false si est� desactivado
	 */
	public boolean esActivo();
}
