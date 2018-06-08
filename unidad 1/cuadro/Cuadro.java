/** Esta clase representa una pintura sencilla. Puede dibujar la pintura
 * usando el método dibujar. Pero espere, siendo una pintura electrónica,
 * se la puede cambiar. Se la puede establecer para que se vea en blanco
 * negro y luego volver a verla en colores (sólo después de haber sido
 * dibujada, por supuesto).
 *
 * Esta clase fué escrita como un ejemplo temprano para enseñar Java con BlueJ.
 *  
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Cuadro
{
    private Cuadrado pared;
    private Cuadrado ventana;
    private Triangulo techo;
    private Circulo sol;
    private Canvas limpiar;
    
    /**
     * Constructor para objetos de la clase Cuadro
     */
    public Cuadro()
    {
        // no hace nada... las variables de instancia son automáticamente
        // establecidas en un valor null.
    }

    /**
     * Dibuja esta pintura.
     */
    public void dibujar()
    {
        pared = new Cuadrado();
        pared.moverVertical(80);
        pared.cambiarTamano(100);
        pared.hacerVisible();
        
        ventana = new Cuadrado();
        ventana.cambiarColor("blue");
        ventana.moverHorizontal(20);
        ventana.moverVertical(100);
        ventana.hacerVisible();

        techo = new Triangulo();  
        techo.cambiarTamano(50, 140);
        techo.moverHorizontal(60);
        techo.moverVertical(70);
        techo.hacerVisible();

        sol = new Circulo();
        sol.cambiarColor("yellow");
        sol.moverHorizontal(180);
        sol.moverVertical(-10);
        sol.cambiarTamano(60);
        sol.hacerVisible();
        
             

    }
    
    /**
     * hace descender el sol lentamente
     */
    public void atardecer()
    {
        sol.moverLentoVertical(300); 
    }
    
    /**
     * Arma el dibujo lentamente.
     */
    public void armardibujo()
    {
        
        pared = new Cuadrado();
        pared.cambiarTamano(100);
        pared.hacerVisible();
        pared.moverLentoVertical(80);
        
        
        
        ventana = new Cuadrado();
        ventana.cambiarColor("blue");
        ventana.hacerVisible();
        ventana.moverLentoHorizontal(20);
        ventana.moverLentoVertical(100);
        

        techo = new Triangulo();  
        techo.cambiarTamano(50, 140);
        techo.hacerVisible();
        techo.moverLentoHorizontal(60);
        techo.moverLentoVertical(70);
       

        sol = new Circulo();
        sol.cambiarColor("yellow");
        sol.cambiarTamano(60);
        sol.hacerVisible();
        sol.moverLentoHorizontal(180);
        sol.moverLentoVertical(-10);
       

    }
   


    /**
     * Cambia esta pintura para ser mostrada en blanco y negro
     */
    public void setBlancoYNegro()
    {
        if(pared != null)   // sólo si ya estaba pintada...
        {
            pared.cambiarColor("black");
            ventana.cambiarColor("white");
            techo.cambiarColor("black");
            sol.cambiarColor("black");
        }
    }

    /**
     * Cambia esta pintura para ser mostrada en colores
     */
    public void setColor()
    {
        if(pared != null)   // sólo si ya estaba pintada...
        {
            pared.cambiarColor("red");
            ventana.cambiarColor("blue");
            techo.cambiarColor("green");
            sol.cambiarColor("yellow");
        }
    }
}
