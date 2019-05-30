package modelo;

public class Ganador implements Resultado {

	private double plata;

	public Ganador(int elNumeroQueSalio, double plata) {
		this.plata = plata;
	}
	
	public String getMensaje() {
		return "Ganaste $" + plata;
	}
	
}
