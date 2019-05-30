package modelo;

public class Perdedor implements Resultado {

	private int numeroQueSalio;

	public Perdedor(int elNumeroQueSalio) {
		this.numeroQueSalio = elNumeroQueSalio;
	}
	
	public String getMensaje() {
		return "Perdiste, salió el " + numeroQueSalio;
	}

}
