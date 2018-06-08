import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Modela las gondolas o estantes de un supermercado
 * 
 * @author Emiliano Daniele 
 * @version 1.0
 */
public class Gondola
{
    private HashMap<Producto, Integer> productos;

    /**
     * Constructor de la clase Gondola
     */
    public Gondola()
    {
        // TODO - Codifique lo que falta
        

    }

    
    /**
     * Agrega productos a la gondola. 
     * 
     * Si el producto esta en la gondola, la cantidad
     * se suma a la cantidad que poseia anteriormente. 
     * 
     * Si el producto no esta en la gondola, lo agrega.
     * 
     * @param   producto    El producto a agregar
     * @param   cantidad    La cantidad a agregar
     */
    public void agregarProductos(Producto producto, Integer cantidad)
    {
        // TODO - Codifique lo que falta
        
    }
    
    
    /**
     * Quita productos de la gondola
     * 
     * Cuando la cantidad de un producto sea cero,
     * se debe quitar el producto de la gondola.
     * 
     * @param   producto    El producto a quitar
     * @param   cantidad    La cantidad del producto a quitar
     * @return  true en caso de exito y false ante 
     *          cualquier error (No existe el producto,
     *          la cantidad indicada es mayor al stock,
     *          cantidad negativa)
     */
    public boolean quitarProductos(Producto producto, Integer cantidad)
    {
        // TODO - Codifique lo que falta
        return true;
        
    }
    
    
    /**
     * Devuelve un conjunto con los productos existentes
     * en la gondola
     * 
     * @return El conjunto con los productos de la gondola
     */
    public Set<Producto> getProductos()
    {
        return productos.keyset();
    }
    
    
     /**
     * Devuelve el mapa de los productos existentes
     * en la gondola
     * 
     * @return El mapa de los productos de la gondola
     */
    public HashMap<Producto,Integer> getMapa(){
        // TODO - Codifique lo que falta        
        return null;
    }
}
