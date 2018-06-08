import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un espacio en 2D
 * @author
 *
 */
public class Espacio2D {
	
	List <Figura> figuras = new ArrayList<Figura>(); 
	
	/**
	 * Devuelve la cantidad de figuras de este espacio 2D
	 * @return the figuras
	 */
	public int getCantidadDeFiguras() {
		return figuras.size();
	}
	
	/**
	 * Este método agrega una figura a la lista de figuras de este 
	 * espacio 2D. 
	 *
	 * Si la figura a agregar es nula, lanza una IllegalArgumentException
	 * 
	 * @param f la figura a agregar
	 * 
	 * @throws PosicionInvalidaException si la posición de la figura a
	 * agregar es null o ya existe una figura en el espacio con esa 
	 * misma posicion.
	 */
	public void agregarFigura(Figura f) throws PosicionInvalidaException{
		//TODO Implementar este método de acuerdo la especificacion
	}
	
	
	/**
	 * Este método agrega una figura a la lista de figuras de este 
	 * espacio 2D. Si se produce algún error, el método no arroja 
	 * excepciones pero imprime un mensaje de advertencia y devuleve
	 * el resultado de la operacion.

	 * SUGERENCIA: Invoca al método agregarFigura() de esta la clase
	 * 
	 * @param f
	 * @return true si se pudo agregar la figura, false si no se pudo
	 * agregar la figura debido a algún error. 
	 */
	public boolean agregarFiguraSegura(Figura f){
		//TODO implementar este método de acuerdo a la especificación
		return false;
	}
	
	
	/**
	 * Este método elimina una figura de la posición determinada
	 * 
	 * @param p Es la posición de donde se quiere borrar la Figura
	 *  
	 * @return true si se pudo borrar la imagen, false la posicion es
	 * null o si no existe figura en la posicion solicitada
	 */
	public boolean eliminarFiguraEn(Posicion p){
		//TODO implementar este método de acuerdo a la especificación
		return false;
	}
	
}
