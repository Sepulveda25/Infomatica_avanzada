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
	 * Este m�todo agrega una figura a la lista de figuras de este 
	 * espacio 2D. 
	 *
	 * Si la figura a agregar es nula, lanza una IllegalArgumentException
	 * 
	 * @param f la figura a agregar
	 * 
	 * @throws PosicionInvalidaException si la posici�n de la figura a
	 * agregar es null o ya existe una figura en el espacio con esa 
	 * misma posicion.
	 */
	public void agregarFigura(Figura f) throws PosicionInvalidaException{
		//TODO Implementar este m�todo de acuerdo la especificacion
	}
	
	
	/**
	 * Este m�todo agrega una figura a la lista de figuras de este 
	 * espacio 2D. Si se produce alg�n error, el m�todo no arroja 
	 * excepciones pero imprime un mensaje de advertencia y devuleve
	 * el resultado de la operacion.

	 * SUGERENCIA: Invoca al m�todo agregarFigura() de esta la clase
	 * 
	 * @param f
	 * @return true si se pudo agregar la figura, false si no se pudo
	 * agregar la figura debido a alg�n error. 
	 */
	public boolean agregarFiguraSegura(Figura f){
		//TODO implementar este m�todo de acuerdo a la especificaci�n
		return false;
	}
	
	
	/**
	 * Este m�todo elimina una figura de la posici�n determinada
	 * 
	 * @param p Es la posici�n de donde se quiere borrar la Figura
	 *  
	 * @return true si se pudo borrar la imagen, false la posicion es
	 * null o si no existe figura en la posicion solicitada
	 */
	public boolean eliminarFiguraEn(Posicion p){
		//TODO implementar este m�todo de acuerdo a la especificaci�n
		return false;
	}
	
}
