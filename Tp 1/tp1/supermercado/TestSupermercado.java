import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestSupermercado.
 *
 * @author  Emiliano Daniele
 * @version 1.0
 */
public class TestSupermercado
{
    private Supermercado super1;
    private Gondola gondola1;
    private Gondola gondola2;
    private Gondola gondola3;
    private Producto arroz1;
    private Producto arroz2;
    private Producto fideos1;
    private Producto jabon1;
    private Producto jabon2;  
    
    

    /**
     * Default constructor for test class TestSupermercado
     */
    public TestSupermercado()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        super1 = new Supermercado("Supermercado Vea");
        gondola1 = new Gondola();
        gondola2 = new Gondola();
        gondola3 = new Gondola();
        arroz1 = new Producto(TipoProducto.Arroz, "Vea", 15.5);
        arroz2 = new Producto(TipoProducto.Arroz, "Gallo", 5.75);
        fideos1 = new Producto(TipoProducto.Fideos, "Luchetti", 9.40);
        jabon1 = new Producto(TipoProducto.Jabon, "Rexona", 12.90);
        jabon2 = new Producto(TipoProducto.Jabon, "Lux", 15.5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void prueba()
    {
        gondola1.agregarProductos(jabon2, 5);
        assertEquals(true, gondola1.quitarProductos(jabon2, 2));
        assertEquals(false, gondola1.quitarProductos(jabon2, 5));
    }

    @Test
    public void ArgregarProducto()
    {
        gondola1.agregarProductos(fideos1, 4);
        assertEquals(4, gondola1.verCant(fideos1));
        gondola1.agregarProductos(fideos1, 6);
        assertEquals(10, gondola1.verCant(fideos1));
        gondola1.agregarProductos(fideos1, 1);
        assertEquals(11, gondola1.verCant(fideos1));
    }

    @Test
    public void ejemplo()
    {
        gondola1.agregarProductos(jabon1, 4);
        assertEquals(4, gondola1.verCant(jabon1));
        gondola1.agregarProductos(jabon1, 2);
        assertEquals(6, gondola1.verCant(jabon1));
    }

    @Test
    public void getProductosEnVenta()
    {
        gondola1.agregarProductos(fideos1, 3);
        gondola1.agregarProductos(jabon2, 4);
        gondola2.agregarProductos(arroz2, 12);
        gondola3.agregarProductos(jabon1, 7);
        super1.agregarGondola(gondola1);
        super1.agregarGondola(gondola2);
        super1.agregarGondola(gondola3);
        assertNotNull(super1.getProductosEnVenta());
    }

    @Test
    public void imprimirProductosEnVenta()
    {
        gondola1.agregarProductos(jabon2, 6);
        gondola1.agregarProductos(arroz2, 4);
        gondola2.agregarProductos(fideos1, 34);
        gondola3.agregarProductos(arroz1, 14);
        super1.agregarGondola(gondola3);
        super1.agregarGondola(gondola1);
        super1.agregarGondola(gondola2);
        super1.imprimirProductosEnVenta();
    }
}





