import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * La clase Contestador represante un objeto generador de respuestas.
 * Se lo usa para generar una respuesta automática por azar seleccionando 
 * una frase de una lista predefinida de respuestas.
 * 
 * @version    1.0
 * @author     Michael Kolling and David J. Barnes
 */
public class Contestador
{
    // Usado para mapear palabras clave con respuestas.
    private HashMap<String, String> mapaDeRespuestas;
    // Respuesta por defecto usada cuando no reconocemos una palabra
    private ArrayList<String> respuestaPorDefecto;
    private Random generadorDeAzar;

    /**
     * Crea un Contestador
     */
    public Contestador()
    {
        mapaDeRespuestas = new HashMap<String, String>();
        respuestaPorDefecto = new ArrayList<String>();
        rellenarRespuestas();
        rellenarRespuestaPorDefecto();
        generadorDeAzar = new Random();
    }

    /**
     * Genera una respuesta desde un set de palabras de entrada dado
     * 
     * @param palabras  Un set de palabras ingresado por el usuario
     * @return       Una cadena que se podría mostrar como respuesta
     */
    public String generarRespuesta(HashSet<String> palabras)
    {
        Iterator<String> it = palabras.iterator();
        while(it.hasNext()) {
            String palabra = it.next();
            String respuesta = mapaDeRespuestas.get(palabra);
            if(respuesta != null) {
                return respuesta;
            }
        }
        // si llegamos aquí, ninguna de las palabras ingresadas fue reconocida
        // en este caso, elegimos una de nuestras respuestas por defecto (lo que
        // respondemos cuando no podemos pensar otra cosa que decir...)
        
        return elegirRespuestaPorDefecto();
    }

    /**
     * Ingresar todas las palabras clave conocidas y sus respuesta asociadas
     * en nuestro mapa de respuestas.
     */
    private void rellenarRespuestas()
    {
        mapaDeRespuestas.put("lento", 
                        "Me parece que esto tiene qu ver con su hardware.\n" +
                        "Actualizar su procesador pordría resolver todos \n" +
                        "estos problemas. ¿Ha tenidao algún inconveniente \n" +
                        "con nuestro software?");
        mapaDeRespuestas.put("problema", 
                        "Bueno, Ud. sabe, todos los programas tienen algún \n" +
                        "defecto. Pero nuestros ingenieros están trabajando \n" +
                        "duro para solucionarlos. ¿Puede describir el problema\n" +
                        "más detalladamente?");
        mapaDeRespuestas.put("caro", 
                        "El costo de nuesto producto es muy competitivo. \n" +
                        "Realmente, ¿ha visto y comparado todas nuestras \n" +
                        "características?");
       
    }

    /**
     * Construye una lista de respuestas por defecto desde donde se tomará
     * una cuando no sepamso más qué decir.
     */
    private void rellenarRespuestaPorDefecto()
    {
        respuestaPorDefecto.add("Parece complicado. ¿Podría describir \n" +
        		"el problema más detalladamente?");
        respuestaPorDefecto.add("Hasta ahora, ningún cliente informó \n" +
        		"sobre este problema. ¿Cuál es la configuración de su equipo?");
        respuestaPorDefecto.add("Lo que dice parece interesante, " +
        		"cuénteme un poco más");
        respuestaPorDefecto.add("Necesito un poco más de información.");
        respuestaPorDefecto.add("¿Verificó si tienen algún conflicto con una dll?");
        respuestaPorDefecto.add("Ese problema está explicado en el manual.\n" +
        		"¿Leyó el manual?");
        respuestaPorDefecto.add("Su descripción es un poco confusa.\n" +
        		"¿Cuenta con algún experto que lo ayude a \n" +
        		"describir el problma de manera más precisa?");
        respuestaPorDefecto.add("Eso no es una falla, es una característica\n" +
        		"del programa!");
        respuestaPorDefecto.add("¿Ha podido elaborar esto?");
    }

    /**
     * Selecciona una respuesta por defecto al azar.
     * @return     Una respuesta al azar
     */
    private String elegirRespuestaPorDefecto()
    {
        // Elige un número aleatorio al azar par el index en la lista de 
    	// de respuestas por defecto
        // El número será entre 0 (inclusive) y el tamaño de la lista (excluye)
        int index = generadorDeAzar.nextInt(respuestaPorDefecto.size());
        return respuestaPorDefecto.get(index);
    }
}
