/**
 * Clase que representa una Figura
 * @author 
 *
 */
public abstract class Figura {

	protected int color;
	protected Posicion posicion;
	protected boolean visible = false;
	public static final int MAX_COLOR = 15;
	public static final int COLOR_CIRCULO = 2;
	public static final int COLOR_RECTANGULO = 3;
	public static final int COLOR_LINEA = 4;
	
	/**
	 * Setea el color apropiado de la forma (COLOR_CIRCULO, COLOR_LINEA, COLOR_RECTANGULO),
	 * Setea el flag visible en true,
	 * Lanza una IllegalStateException si la posicion de la figura es null
	 * 
	 */
	public abstract void mostrar();
	
	/**
	 * Setea el flag visible en false
	 */
    public abstract void ocultar();
    
    /**
     * Constructor con parametros
     * @param color
     */
    public Figura (int color) {
    	if (color<0 || color>MAX_COLOR)
    		throw new IllegalArgumentException("Color no valido");
        this.color = color;
    }
	
    /**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		if (color>=0 && color<=MAX_COLOR)
			this.color = color;
	}
	/**
	 * @return the posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}
	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}

