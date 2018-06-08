
/**
 * Write a description of class Baliza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baliza implements Indicador
{
    // instance variables - replace the example below with your own
    private boolean estado;

    /**
     * Constructor for objects of class Baliza
     */
    public Baliza()
    {
        // initialise instance variables
        estado = true;
    }

    /**
	 * activa o desactiva el indicador de acuerdo al parametro pasado como argumento
	 * @param activar true para activar, false para desactivar
	 */
	public void activar (boolean activar)
	{
	   estado = activar;
	   }
	
	/**
	 * indica si este indicador est� activo o desactivo
	 * @return true si est� activo, false si est� desactivado
	 */
	public boolean esActivo()
	{
	   return estado;
	   }
}
