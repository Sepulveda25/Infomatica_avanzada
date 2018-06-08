1. Implementar los metodos
	
	public List<Sensor> getSensoresActivos()
	public void activarIndicadores(boolean activo)
	public void activarBaliza()
	public void desarmarAlarma()
	public void dispararAlarma (List<Sensor> sensores)
	public void armarAlarma()
	public void errorAlarma()
	
de la clase Alarma según la documentacion del metodo.

2. Implementar el constructor 
	
	public Sensor(String id)
	
de la clase Sensor según la documentacion de la clase

3. Implementar la clase "SensorAnalogico" que extiende de la clase Sensor, incluyendo además los getters y setters:

	public void setUmbral(int umbral)	
	public void setValorActual(int valor)
	public int getValorActual()
	public int getUmbral ()

El sensor analógico es activo cuando el valor lectura actual es MAYOR que el umbral. Ambos valores sólo pueden estar comprendidos entre
0 y 1023 inclusive. Intentos de setear un valor fuera de rango simplemente son ignorados (no se setea ningún nuevo valor)	
	
4. Implementar las clases "Sirena" y "Baliza" que implementan la interfaz Indicador.

5. Implementar los siguientes métodos de la clase RegistroDeEventos de acuerdo a la documentación del método:

	public void agregarEvento(Evento e)
	public void limpiarEventos () 
	public List<Evento> listarEventosPorTipo (TipoDeEvento t)
