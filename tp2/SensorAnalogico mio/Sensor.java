
public abstract class Sensor {
    private String id;
    private boolean habilitado=true;
    
    
    /**
     * Constructor  
     * crea un objeto Sensor, cuyo id es pasado como argumento
     * 
     * El id siempre se guarda en may�sculas y sin espacios al inicio ni al final de la cadena.
     * 
     * @param id el id de este Sensor
     * @throws IllegalArgumentException si el id es null o vacio.
     */
    public Sensor(String id){
        if (id==null||id.trim().length()==0){
            throw new IllegalArgumentException ("El id es null o vacio");
        }else{
          id.replaceAll("\\s","");
          id.toUpperCase();
          this.id=id;
        }
        
    }
    
    public void setHabilitar(boolean valor){
        habilitado=valor;       
    }
    
    public boolean esHabilitado() {
        return habilitado;
    }
    
    public String getId(){
        return id;
    }
    
    abstract public boolean esActivo();
    
}
