import java.util.ArrayList;
import java.util.List;

public class Alarma {

    private List<Sensor> listadoSensores;
    private List<Indicador> listadoIndicadores;
    private EstadoDeAlarma estado;
    private RegistroDeEventos registro;
    private Pulsador reset = new Pulsador();
    private Pulsador armar = new Pulsador();
    private Pulsador encendido= new Pulsador();

    public Alarma(){
        estado=EstadoDeAlarma.DESARMADO;
        listadoSensores = new ArrayList<Sensor>();
        listadoIndicadores = new ArrayList<Indicador>();
        registro = new RegistroDeEventos();
        reset.setActivo(false);
        armar.setActivo(false);
        encendido.setActivo(true);  
    }

    public List<Sensor> getSensores(){
        return listadoSensores;
    }

    public List<Indicador> getIndicadores(){
        return listadoIndicadores;
    }

    public RegistroDeEventos getRegistroDeEventos(){
        return registro;
    }

    public void loop(){
        while (encendido.esActivo()) {
            switch (estado) {
                case ACTIVO:
                if (!getSensoresActivos().isEmpty()){
                    dispararAlarma (getSensoresActivos());
                    break;
                }                   

                if (reset.esActivo()){
                    desarmarAlarma();
                    break;
                }

                break;

                case DISPARO:
                if (reset.esActivo()){
                    desarmarAlarma();
                }
                break;

                case DESARMADO:
                if (armar.esActivo()){
                    try {
                        armarAlarma();
                    } catch (IllegalStateException e){
                        errorAlarma();
                    }
                }
                break;

                case ERROR:
                if (reset.esActivo()){
                    desarmarAlarma();
                }
                break;
            }
        }

    }

    public void setEstado(EstadoDeAlarma e){
        estado=e;
    }

    public EstadoDeAlarma getEstado(){
        return estado;
    }

    
    /**
     * Devuelve una lista con los sensores de la alarma que est�n
     * activos Y habilitados 
     * 
     * @return Lista de Sensores activos
     */
    public List<Sensor> getSensoresActivos(){
        List<Sensor> listadoDeSensoreActivos=new ArrayList<Sensor>();
        for (Sensor sensorActivo: listadoSensores ){
            if(sensorActivo.esHabilitado()&&sensorActivo.esActivo()){
                listadoDeSensoreActivos.add(sensorActivo);
            }
        }
        return listadoDeSensoreActivos;
    }

    /**
     * Activa o desactiva todos los indicadores de la alarma, de acuerdo
     * al valor pasado como argumento
     * @param activo
     */
    public void activarIndicadores(boolean activo){
        for (Indicador ind:listadoIndicadores ){
            ind.activar(activo);
        }
    }

    /**
     * Activa SOLO los indicadores de la alarma que son instancia de la clase 
     * "Baliza". (instanceof)
     *  
     */
    public void activarBaliza(){
        for (Indicador soloBalizas:listadoIndicadores ){
            if(soloBalizas instanceof Baliza){
                soloBalizas.activar(true);
            }
        }
    }

    /**
     * Desarmar alarma.
     * 1. apaga todos los indicadores 
     * 2. agrega un evento del tipo adecuado al registro (con fecha actual, SIN mensaje (no significa mensaje vacio!) )
     * 3. desactiva el pulsador de reset
     * 3. cambia el estado de la alarma a dasarmada
     * 
     */
    public void desarmarAlarma(){
        Fecha fechaActual=new Fecha();
        for (Indicador ind:listadoIndicadores ){
            ind.activar(false);
        }
        Evento nvoEvento = new Evento(TipoDeEvento.APAGADO,fechaActual,null);
        registro.agregarEvento(nvoEvento);
        reset.setActivo(false);
        estado=EstadoDeAlarma.DESARMADO;
    }

    /**
     * Dispara alarma.
     * 1. enciende todos los indicadores 
     * 2. agrega un evento  al registro. El mensaje consiste en la lista de id's
     * de los sensores pasados como argumento, con este formato:  '<id1>;<id2>;<id3>;' 
     *  Ej: "sensor1;sensor2;"
     * 3. cambia el estado de la alarma a disparada
     * 
     * @param Lista con los sensores activos.
     */
    public void dispararAlarma (List<Sensor> sensores){
        String id="";
        Fecha fechaActual=new Fecha();
        for (Indicador ind:listadoIndicadores ){
            ind.activar(true);
        }
        
        for (Sensor idSensores: sensores ){
           id.concat(idSensores.getId()+";");
        }
        Evento nvoEvento = new Evento(TipoDeEvento.DISPARO,fechaActual,id);
        registro.agregarEvento(nvoEvento);
        estado=EstadoDeAlarma.DISPARO;
    }

    /**
     * Armara alarma.
     * 1. desactiva el pulsador armar
     * 2. agrega un evento  al registro (sin mensaje (no significa mensaje vacio!))
     * 3. cambia el estado de la alarma a activa
     * 
     * NO SE PUEDE ARMAR LA ALARMA SI HAY ALGUN SENSOR ACTIVO. En ese caso
     * lanza una excepcion, y no cambia ni estado ni genera evento
     * 
     * @param Lista con los sensores activos.
     * @throws IllegalStateException si alguno de los sensores esta activo al querer armar la 
     * alarma. 
     */
    public void armarAlarma() { 
        for (Sensor sensorActivo: listadoSensores ){
           if(sensorActivo.esActivo()){
               throw new IllegalArgumentException ("Uno/s de lo/s sensores esta activo no se puede activar la alarma");
           }
        }
        armar.setActivo(false);
        Fecha fechaActual=new Fecha();
        Evento nvoEvento = new Evento(TipoDeEvento.ACTIVACION,fechaActual,null);
        registro.agregarEvento(nvoEvento);
        estado=EstadoDeAlarma.ACTIVO;
    }

    /**
     * Armara alarma.
     * 1. activa indicadores luminosos solaemnte (Baliza)
     * 2. agrega un evento  al registro. El mensaje del evento consiste en la lista de id's
     * de los sensores activos de la alarma con este formato:  '<id1>;<id2>;<id3>;' 
     * 3. cambia el estado de la alarma a error
     * 
     */
    public void errorAlarma(){
        activarBaliza();
        String id="";
        Fecha fechaActual=new Fecha();
        for (Sensor idSensores: listadoSensores ){
           if(idSensores.esActivo()){
               id.concat(idSensores.getId()+";");
           }
        }
        Evento nvoEvento = new Evento(TipoDeEvento.ERROR,fechaActual,id);
        registro.agregarEvento(nvoEvento);
        estado=EstadoDeAlarma.ERROR;
    }
}
