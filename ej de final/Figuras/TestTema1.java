import junit.framework.TestCase;

public class TestTema1 extends TestCase {
	
	public static final int VALOR_PARTE_PRACTICA = 52;
	public static final int MAX_PUNTAJE = 140;
	private static int puntaje = 0;
		
	public void testCirculo_constructorConParametros_OK(){
		puntaje = 0;
       Circulo c = new Circulo (1,5);
		assertEquals("COLOR",1,c.getColor());
		assertEquals("RADIO",5,c.getRadio());
		c = new Circulo(2);
		assertEquals("COLOR",2,c.getColor());
		
		puntaje+=10;
	}
	
	public void testCirculo_constructorConParametros_Invalido()
	{
		Circulo c = null;
		try {
			c = new Circulo (1,-1);
			fail("No genero excepcion con parametros invalidos");
		} catch (IllegalArgumentException e) {
			assertNull (c);
		}
		
		puntaje+=10;
	}
	
	public void testCirculo_getSuperficie(){
		Circulo c = new Circulo (1,5);
		assertEquals("SUPERFICIE", Area.PI*25, c.getSuperficie());
		
		puntaje+=10;
	}
	
	public void testCirculo_mostrar_OK(){
		Circulo c = new Circulo (1,5);
		c.setPosicion(new Posicion (1,1));
		c.mostrar();
		assertTrue(c.isVisible());
		assertEquals("COLOR VISIBLE", Figura.COLOR_CIRCULO,c.getColor());
		
		puntaje+=10;
	}
	
	public void testCirculo_mostrar_IllegalState(){
		Circulo c = new Circulo (1,5);
		try {
			c.mostrar();
			fail("No genero excepcion en estado invalido");
		} catch (IllegalStateException e){
			assertFalse(c.isVisible());
			assertEquals("COLOR VISIBLE", 1,c.getColor());
		}
		
		puntaje+=10;
	}

	public void testCirculo_ocultar_OK(){
		Circulo c = new Circulo (1,5);
		c.setVisible(true);
		assertTrue(c.isVisible());
		c.ocultar();
		assertFalse("NO OCULTO",c.isVisible());
		
		puntaje+=5;
	}
	
	public void testCirculo_setters(){
		Circulo c = new Circulo (1);
		assertEquals(0, c.getRadio());
		c.setRadio(-1);
		assertEquals(0, c.getRadio());
		c.setRadio(5);
		assertEquals(5, c.getRadio());
	
		puntaje+=10;
	}

	public void testEspacio2D_agregarFigura_OK(){
		Figura f1 = new Circulo(1);
		Figura f2 = new Circulo(1);
		f1.setPosicion(new Posicion(1,2));
		f2.setPosicion(new Posicion(2,1));
		Espacio2D e2D = new Espacio2D();
		try {
			e2D.agregarFigura(f1);
			assertEquals(1,e2D.getCantidadDeFiguras());
			e2D.agregarFigura(f2);
			assertEquals(2,e2D.getCantidadDeFiguras());
		} catch (PosicionInvalidaException e1) {
			fail ("No debería haber lanzado excepcion " + e1.getMessage() );
		}
		
		puntaje+=10;
	}
	
	public void testEspacio2D_agregarFigura_Null(){
		Espacio2D e2D = new Espacio2D();
		try {
			e2D.agregarFigura(null);
			fail("No lanza excepcion con Figura nula");
		} catch (Exception e1) {
			assertTrue(e1 instanceof IllegalArgumentException);
			assertEquals(0,e2D.getCantidadDeFiguras());
		}	
		
		puntaje+=5;
	}
	
	public void testEspacio2D_agregarFigura_SinPosicion(){
		Figura f = new Circulo(1);
		Espacio2D e2D = new Espacio2D();
		try {
			e2D.agregarFigura(f);
			fail("No lanza excepcion con Figura sin posicion");
		} catch (PosicionInvalidaException e1) {
			assertEquals(0,e2D.getCantidadDeFiguras());	
		}
		
		puntaje+=10;
	}
	
	public void testEspacio2D_agregarFigura_PosicionOcupada(){
		Figura f1 = new Circulo(1);
		f1.setPosicion(new Posicion(2,2));
		Figura f2 = new Circulo(1);
		f2.setPosicion(new Posicion(2,2));
		Espacio2D e2D = new Espacio2D();
		try {
			e2D.agregarFigura(f1);
			assertEquals(1,e2D.getCantidadDeFiguras());
		} catch (PosicionInvalidaException e1) {
			fail ("No debería haber lanzado excepcion " + e1.getMessage() );
		}
		
		try {
			e2D.agregarFigura(f2);
			fail("No lanza excepcion con Figura sin posicion");
		} catch (PosicionInvalidaException e1) {
			assertEquals(1,e2D.getCantidadDeFiguras());
		}
		
		puntaje+=15;
	}
	
	public void testEspacio2D_agregarFiguraSegura(){
		Figura f1 = new Circulo(1);
		f1.setPosicion(new Posicion(2,2));
		Figura f2 = new Circulo(1);
		f2.setPosicion(new Posicion(2,2));
		Espacio2D e2D = new Espacio2D();
		assertTrue(e2D.agregarFiguraSegura(f1));
		assertEquals(1,e2D.getCantidadDeFiguras());
		assertFalse(e2D.agregarFiguraSegura(f2));
		assertEquals(1,e2D.getCantidadDeFiguras());
		f2.setPosicion(new Posicion(1,2));
		assertTrue(e2D.agregarFiguraSegura(f2));
		assertEquals(2,e2D.getCantidadDeFiguras());
		
		puntaje+=10;
	}
	
	public void testEspacio2D_eliminarFiguraEn_SinPosicion(){
		Espacio2D e2D = new Espacio2D();
		assertFalse(e2D.eliminarFiguraEn(null));
		
		puntaje+=5;
	}
	
	public void testEspacio2D_eliminarFiguraEn_PosicionVacia(){
		Espacio2D e2D = new Espacio2D();
		Figura f1 = new Circulo(1);
		Posicion p1 = new Posicion(1,1);
		f1.setPosicion(p1);
		assertTrue(e2D.agregarFiguraSegura(f1));
		assertEquals(1,e2D.getCantidadDeFiguras());
		assertFalse(e2D.eliminarFiguraEn(new Posicion(2,2)));
		assertEquals(1,e2D.getCantidadDeFiguras());
		
		puntaje+=10;
	}
	
	public void testEspacio2D_eliminarFiguraEn_OK(){
		Espacio2D e2D = new Espacio2D();
		Figura f1 = new Circulo(1);
		Posicion p1 = new Posicion(1,1);
		f1.setPosicion(p1);
		Figura f2 = new Circulo(1);
		Posicion p2 = new Posicion(2,2);
		f2.setPosicion(p2);
		assertTrue(e2D.agregarFiguraSegura(f1));
		assertTrue(e2D.agregarFiguraSegura(f2));
		assertEquals(2,e2D.getCantidadDeFiguras());
		assertTrue(e2D.eliminarFiguraEn(new Posicion(2,2)));
		assertEquals(1,e2D.getCantidadDeFiguras());
		assertTrue(e2D.eliminarFiguraEn(p1));
		assertEquals(0,e2D.getCantidadDeFiguras());
		
		puntaje+=10;
		
	}
	
	public void testZZZ(){
	   	System.out.println("Nota parte practica Tema 1: ("+puntaje+"/"+MAX_PUNTAJE+") " + (puntaje * VALOR_PARTE_PRACTICA) / MAX_PUNTAJE );
	}

}
