import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Proporciona algunas operaciones de manejo de archivos sobre
 * la LibretaDeDirecciones.
 * Estos métodos demuestran algunas características básicas del
 * paquete java.io
 * 
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class LibretaManejadorDeArchivos
{
    // Libreta de direcciones sobre la que se realizarán las
    // operaciones de E/S
    private LibretaDeDirecciones libreta;
    // Nombre del archivo que se usa para almacenar los resultados
    // de la busqueda.
    private static final String ARCHIVO_RESULTADOS = "resultados.txt";

    /**
     * Constructor de objetos de la clase LibretaManejadorDeArchivos.
     * @param libreta La libreta de direcciones que se va a usar.
     */
    public LibretaManejadorDeArchivos(LibretaDeDirecciones libreta)
    {
        this.libreta = libreta;
    }
    
    /**
     * Graba los resultados de una busqueda en la libreta en
     * el archivo "resultados.txt" situado en la carpeta del proyecto.
     * @param prefijo El prefijo de la clave a buscar.
     * @throws IOException Si el proceso de escritura falla por cualquier razón.
     */
    public void grabarResultadoDeBusqueda(String prefijo) throws IOException
    {
        File archivoResultados = crearNombreDeArchivoAbsoluto(ARCHIVO_RESULTADOS);
        DatosDelContacto[] resultados = libreta.buscar(prefijo);
        FileWriter escritor = new FileWriter(archivoResultados);
        for(DatosDelContacto contacto : resultados) {
            escritor.write(contacto.toString());
            escritor.write('\n');
            escritor.write('\n');
        }
        escritor.close();
    }
    
    /**
     * Muestra los resultados de la llamada más reciente a
     * grabarResultadoDeBusqueda. La salida es en la consola,
     * se informa cualquier problema directamente desde este metodo.
     */
    public void mostrarResultadoDeBusqueda()
    {
        BufferedReader lector = null;
        try {
            File archivoResultados = crearNombreDeArchivoAbsoluto(ARCHIVO_RESULTADOS);
            lector = new BufferedReader(new FileReader(archivoResultados));
            System.out.println("Resultados ...");
            String linea;
            linea = lector.readLine();
            while(linea != null) {
                System.out.println(linea);
                linea = lector.readLine();
            }
            System.out.println();
        }
        catch(FileNotFoundException e) {
            System.out.println("Imposible encontrar el archivo: " +
                               ARCHIVO_RESULTADOS);
        }
        catch(IOException e) {
            System.out.println("Se encontro un error al leer el archivo: " +
                               ARCHIVO_RESULTADOS);
        }
        finally {
            if(lector != null) {
                // Captura cualquier excepcion pero no se puede
                // hacer nada con ella.
                try {
                    lector.close();
                }
                catch(IOException e) {
                    System.out.println("Error al cerrar: " +
                                       ARCHIVO_RESULTADOS);
                }
            }
        }
    }

    /**
     * Agrega entradas adicionales a la libreta de direcciones desde
     * un archivo de texto. Se asume que el archivo contiene un
     * elemento por línea, más una línea en blanco para cada entrada:
     *     nombre \n teléfono \n dirección \n \n
     * Una línea debería estar en blanco solamente si falta ese dato.
     * @param nombreArchivo El archivo de texto que contiene el contacto.
     * @throws IOException En fallo de salida.
     */
    public void agregarEntradasDesdeArchivo(String nombreArchivo) throws IOException
    {
        // Se asegura que se puede encontrar el archivo.
        URL recurso = getClass().getResource(nombreArchivo);
        if(recurso == null) {
            throw new FileNotFoundException(nombreArchivo);
        }
        nombreArchivo = recurso.getFile();
        BufferedReader lector = new BufferedReader(
                                   new FileReader(nombreArchivo));
        String nombre;
        nombre = lector.readLine();
        while(nombre != null) {
            String telefono = lector.readLine();
            String direccion = lector.readLine();
            // Descarta la línea en blanco de separación.
            lector.readLine();
            libreta.agregarContacto(new DatosDelContacto(nombre, telefono,
                                               direccion));
            nombre = lector.readLine();
        }
        lector.close();
    }
    
    /**
     * Lee la versión binaria de la libreta de direcciones desde un
     * archivo. Si el nombre no es un camino absoluto, se asume
     * relativo al directorio del proyecto.
     * @param archivoFuente El archivo desde el cual leer los contactos.
     * @return El objecto libretaDeDirecciones.
     * @throws IOException Si el proceso de lectura falla por cualquier razón.
     */
    public LibretaDeDirecciones readFromFile(String archivoFuente)
        throws IOException, ClassNotFoundException
    {
        // Se asegura que se puede encontrar el archivo.
        URL recurso = getClass().getResource(archivoFuente);
        if(recurso == null) {
            throw new FileNotFoundException(archivoFuente);
        }
        try {
            File fuente = new File(recurso.toURI());
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fuente));
            LibretaDeDirecciones libretaGuardada = (LibretaDeDirecciones) is.readObject();
            is.close();
            return libretaGuardada;
        }
        catch(URISyntaxException e) {
            throw new IOException("Imposible obtener un nombre válido de archivo para " +
                                  archivoFuente);
        }
    }
    
    /**
     * Graba una versión binaria de la libreta de direcciones en un
     * archivo. Si el nombre no es un camino absoluto, se asume
     * relativo al directorio del proyecto.
     * @param archivoDestino El nombre del archivo para grabar los contactos.
     * @throws IOException Si el proceso de escritura falla por cualquier razón.
     */
    public void saveToFile(String archivoDestino) throws IOException
    {
        File destino = crearNombreDeArchivoAbsoluto(archivoDestino);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(destino));
        os.writeObject(libreta);
        os.close();
    }
    
    /**
     * Crea un nombre de archivo absoluto para el nombre dado.
     * Si el nombre ya es absoluto, entonces se lo utiliza, en caso
     * contrario, se asume que es relativo al directorio del proyecto.
     * @throws IOException Si no se puede crear un nombre de archivo válido.
     */
    private File crearNombreDeArchivoAbsoluto(String nombreArchivo) throws IOException
    {
        try {
            File archivo = new File(nombreArchivo);
            if(!archivo.isAbsolute()) {
                archivo = new File(getDirectorioDelProyecto(), nombreArchivo);
            }
            return archivo;
        }
        catch(URISyntaxException e) {
            throw new IOException("Imposible crear un nombre de archivo válido para " +
                                  nombreArchivo);
        }
    }
    
    /**
     * Se intenta determinar el nombre del directorio del proyecto.
     * Este proceso requiere encontrar el camino del archivo .class
     * para esta clase y luego extraer el nombre del directorio que
     * lo contiene.
     * @throws URISyntaxException Si la URL no está formateada correctamente.
     * @return El directorio del proyecto.
     */
    private File getDirectorioDelProyecto() throws URISyntaxException
    {
         String miArchivoClass = getClass().getName() + ".class";
         URL url = getClass().getResource(miArchivoClass);
         return new File(url.toURI()).getParentFile();
    }
}
