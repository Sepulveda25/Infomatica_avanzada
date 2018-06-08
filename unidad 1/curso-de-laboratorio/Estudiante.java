
/**
 * La clase Estudiante representa un estudiane en un sistema de administración
 * de estudiantes. Mantiene los detalles relevantes del estudiante en el contexto
 * de la institucón.
 * 
 * @author Michael Kolling and David Barnes
 * @version 2006.03.30
 * Traducción Carlos A. Bartó
 */
public class Estudiante
{
    // el nombre completo del estudiante.
    private String nombre;
    // la matrícula del estudiante.
    private String matricula;
    // la cantidad de créditos por estudios realizados por el estudiante
    // hasta el momento.
    private int creditos;

    /**
     * Crea un nuevo estudiante con un nombre y una matrícula dados.
     */
    public Estudiante(String nombreCompleto, String matriculaEstudiante)
    {
        nombre = nombreCompleto;
        matricula = matriculaEstudiante;
        creditos = 0;
    }

    /**
     * Retorna el nombre completo de este estudiante.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * establece un nuevo nombre para este estudiante.
     */
    public void cambiaNombre(String nombreReemplazo)
    {
        nombre = nombreReemplazo;
    }

    /**
     * Retorna la matrícula de este estudiante.
     */
    public String getMatriculaEstudiante()
    {
        return matricula;
    }

    /**
     * Agrega algunos puntos de crédito al acumulado del estudiante.
     */
    public void agregaCreditos(int puntosAditionales)
    {
        creditos += puntosAditionales;
    }

    /**
     * Retorna el número de puntos de crédito que el estudiante ha acumulado.
     */
    public int getCreditos()
    {
        return creditos;
    }

    /**
     * Retorna el nombre de usuario de este estudiante. El nombre de usuario es
     * una combinación de los primeros cuatro caracteres del nombre del estudiante
     * y los tres primeros caracteres de su matrícula.
     */
    public String getNombreUsuario()
    {
        return nombre.substring(0,4) + matricula.substring(0,3);
    }
    
    /**
     * Imprime en la pantalla el nombre y la matrícula de este estudiante.
     */
    public void print()
    {
        System.out.println(nombre + " (" + matricula + ")");
    }
}
