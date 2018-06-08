/**
 * Clase que representa una posición en 2D
 * @author 
 *
 */
public class Posicion {
	private int xPos;
	private int yPos;
	
	/**
	 * Constructor con parametros
	 * @param x
	 * @param y
	 */
	public Posicion (int x, int y){
		this.xPos=x;
		this.yPos=y;
	}
	
	/**
	 * @return the xPos
	 */
	public int getXPos() {
		return xPos;
	}
	
	/**
	 * @param pos the xPos to set
	 */
	public void setXPos(int pos) {
		xPos = pos;
	}
	
	/**
	 * @return the yPos
	 */
	public int getYPos() {
		return yPos;
	}
	/**
	 * @param pos the yPos to set
	 */
	public void setYPos(int pos) {
		yPos = pos;
	}
	
	@Override
	public boolean equals(Object p){
		if ((p != null) && (p instanceof Posicion)) {
			return (((Posicion) p).getXPos() == this.xPos && ((Posicion) p)
					.getYPos() == this.yPos);
		}
		return false;
	}
	
	@Override
	public String toString (){
		return "Posicion [" + xPos + ":" + yPos +"]";
	}
	
	
}
