
/**
 * Write a description of class SensorAnalogico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SensorAnalogico extends Sensor
{
    // instance variables - replace the example below with your own
    private int umbral, valor;

    /**
     * Constructor for objects of class SensorAnalogico
     */
    public SensorAnalogico(String id)
    {
        super(id);
        umbral = 0;
        valor = 0;
    }

    public void setUmbral(int umbral)
    {
       if (umbral >= 0 && umbral <= 1023)  {this.umbral = umbral;}
    }
    
    public int getUmbral ()
    {
       return umbral;
    }

    public void setValorActual(int valor)
    {
       if (valor >= 0 && valor <= 1023)  {this.valor = valor;}
    }
    
    public int getValorActual ()
    {
       return valor;
    }
    
    public boolean esActivo()
    {
        if (getValorActual() > getUmbral())  {return true;}
        return false;
    }
}
