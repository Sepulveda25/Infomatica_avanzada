
/**
 * Write a description of class Movimientos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movimientos
{
    // instance variables - replace the example below with your own
    private int a;
    private Circulo c;
    /**
     * Constructor for objects of class Movimientos
     */
    public Movimientos()
    {
        c = new Circulo();
        c.hacerVisible();
    }

    /**
     * Mueve en diagonal el circulo
     * 
     * @param  distancia
     *  
     */
    public void moverDiagonal(int distancia)
    {
        a=1;
        while (distancia >a )
      {
        c.moverLentoHorizontal(a);
        c.moverLentoVertical(a);
        a++;
     }
    }
    
    
}
    