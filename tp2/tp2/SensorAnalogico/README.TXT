1. Implementar los metodos
	
	public List<Sensor> getSensoresActivos()
	public void activarIndicadores(boolean activo)
	public void activarBaliza()
	public void desarmarAlarma()
	public void dispararAlarma (List<Sensor> sensores)
	public void armarAlarma()
	public void errorAlarma()
	
de la clase Alarma seg�n la documentacion del metodo.

2. Implementar el constructor 
	
	public Sensor(String id)
	
de la clase Sensor seg�n la documentacion de la clase

3. Implementar la clase "SensorAnalogico" que extiende de la clase Sensor, incluyendo adem�s los getters y setters:

	public void setUmbral(int umbral)	
	public void setValorActual(int valor)
	public int getValorActual()
	public int getUmbral ()

El sensor anal�gico es activo cuando el valor lectura actual es MAYOR que el umbral. Ambos valores s�lo pueden estar comprendidos entre
0 y 1023 inclusive. Intentos de setear un valor fuera de rango simplemente son ignorados (no se setea ning�n nuevo valor)	
	
4. Implementar las clases "Sirena" y "Baliza" que implementan la interfaz Indicador.

5. Implementar los siguientes m�todos de la clase RegistroDeEventos de acuerdo a la documentaci�n del m�todo:

	public void agregarEvento(Evento e)
	public void limpiarEventos () 
	public List<Evento> listarEventosPorTipo (TipoDeEvento t)
