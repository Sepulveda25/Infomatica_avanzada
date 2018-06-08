/**
 * La clase de prueba DiaTest.
 *
 * @author  David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class DiaTest extends junit.framework.TestCase
{
    /**
     * Constructor por defecto de la clase DiaTest
     */
    public DiaTest()
    {
    }

    /**
     * Establece el fixture para la prueba
     * Se invoca antes de la ejecución de cada método.
     */
    protected void setUp()
    {
    }

    /**
     * Destruye el fixture para la prueba.
     *
     *  Se invoca después de la ejecución de cada método.
     */
    protected void tearDown()
    {
    }

    /**
     * Testea la funcionalidad básica anotando tres citas al principio,
     * final y en medio del día
     */
    public void testAnotarTresCitas()
    {
        Dia dia1 = new Dia(1);
        Cita cita1 = new Cita("Conferencia de Java", 1);
        Cita cita2 = new Cita("Clase de Java", 1);
        Cita cita3 = new Cita("Ver a John", 1);
        assertEquals(true, dia1.anotarCita(9, cita1));
        assertEquals(true, dia1.anotarCita(13, cita2));
        assertEquals(true, dia1.anotarCita(17, cita3));
    }

    /**
     * Verifica que no está permitido anotar dos citas en el mismo horario
     */
    public void testDobleCita()
    {
    	Dia dia1 = new Dia(1);
    	Cita cita1 = new Cita("Conferencia de Java", 1);
        Cita cita2 = new Cita("Error", 1);
        assertEquals(true, dia1.anotarCita(9, cita1));
        assertEquals(false, dia1.anotarCita(9, cita2));
    }
}



