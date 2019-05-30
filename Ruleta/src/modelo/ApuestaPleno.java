package modelo;

public class ApuestaPleno extends TipoApuesta {
	
	boolean gano(int elNumeroQueSalio, Object valorElegido) {
		return elNumeroQueSalio == (int) valorElegido;
	}

	@Override
	int getMontoMinimo() {
		return 10;
	}

	@Override
	Double ganancia() {
		return 35.0;
	}

	@Override
	public String getNombre() {
		return "Pleno";
	}

	@Override
	public Object[] getValores() {
		Integer[] valores = new Integer[36];
		for(int i = 0; i < 36; i++) {
			valores[i] = i+1;
		}
		return valores;
	}
}
