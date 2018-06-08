import java.util.Calendar;
import java.util.Date;


public class Fecha {
	private int anio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	
	/**
	 * Nueva feacha actual
	 */
	public Fecha (){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		anio=cal.get(Calendar.YEAR);
		mes=cal.get(Calendar.MONTH+1);
		dia=cal.get(Calendar.DAY_OF_MONTH);
		hora=cal.get(Calendar.HOUR_OF_DAY);
		minuto=cal.get(Calendar.MINUTE);
		segundo=cal.get(Calendar.SECOND);
	}
	

	public int getAnio() {
		return anio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(anio);
		sb.append("/");
		if (mes<10)
			sb.append("0");
		sb.append(mes);
		sb.append("/");
		if (dia<10)
			sb.append("0");
		sb.append(dia);
		sb.append(" ");
		if (hora<10)
			sb.append("0");
		sb.append(hora);
		sb.append(":");
		if (minuto<10)
			sb.append("0");
		sb.append(minuto);
		if (segundo<10)
			sb.append("0");
		sb.append(segundo);
		return sb.toString();
	}
}
