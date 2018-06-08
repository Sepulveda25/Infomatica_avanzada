
/**
 * El sensor analogico es activo cuando el valor lectura actual es MAYOR que el umbral. 
 * Ambos valores solo pueden estar comprendidos entre 0 y 1023 inclusive. 
 * Intentos de setear un valor fuera de rango simplemente son ignorados (no se setea ningun nuevo valor)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SensorAnalogico extends Sensor
{
    private int umbral;
    private int valor;

    /**
     * Constructor for objects of class SensorAnalogico
     */
    public SensorAnalogico(String id)
    {
        super (id);
    }
    
    /**
     * El valor de umbral solo puede estar comprendido entre 0 y 1023 inclusive. 
     *
     * @param umbral A parameter
     */
    public void setUmbral(int umbral)
    {
        if ((0<=umbral)&&(umbral<=1023))
        {
            this.umbral=umbral;
        }
    }
    
    /**
     * valor solo puede estar comprendido entre 0 y 1023 inclusive.
     *
     * @param valor A parameter
     */
    public void setValorActual(int valor)
    {
        if ((0<=valor)&&(valor<=1023))
        {
            this.valor=valor;
        }
    }
    
    /**
     * Method getValorActual
     *
     * @return The return value
     */
    public int getValorActual()
    {
        return valor;
    }
    
    /**
      * Method getUmbral
      *
      * @return The return value
      */
    public int getUmbral ()
	{
	    return umbral;
	}
	
	/**
	* Es activo cuando el valor lectura actual es MAYOR que el umbral.
	*
	* @return The return value
    */
    public boolean esActivo()
    {
        if (valor>umbral)
        {
            return true;
        }else
        {
            return false;
        }
    }
}
