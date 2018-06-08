
/**
 * Write a description of class Sirena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sirena implements Indicador
{
    private boolean activar;

    /**
     * Constructor for objects of class Sirena
     */
    public Sirena()
    {
       activar=false;
    }
    
    /**
	 * activa o desactiva el indicador de acuerdo al parametro pasado como argumento
	 * @param activar true para activar, false para desactivar
	 */
	public void activar (boolean activar)
	{
	    this.activar=activar;
	}
	
    /**
     * indica si este indicador esta activo o desactivo
     * @return true si esta activo, false si esta desactivado
     */
    public boolean esActivo()
    {
        if (activar)
        {
            return true;
        }else
        {
            return false;
        }    
    }
}
