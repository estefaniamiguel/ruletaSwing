package modelo;

import java.util.Arrays;
import java.util.List;


public class ApuestaDocena extends TipoApuesta {
	List<String> docenas = Arrays.asList("Primera", "Segunda", "Tercera");

	boolean gano(int elNumeroQueSalio, Object valorElegido) {
		int numeroDeDocena = docenas.indexOf(valorElegido);
		int min = numeroDeDocena * 12 + 1;
		int max = min + 12 - 1;
		return min <= elNumeroQueSalio && max >= elNumeroQueSalio;
	}

	@Override
	int getMontoMinimo() {
		return 50;
	}

	@Override
	Double ganancia() {
		return 11.0;
	}

	@Override
	public String getNombre() {
		return "Docena";
	}
	
	@Override
	public Object[] getValores() {
		Integer[] valores = new Integer[36];
		for(int i = 0; i < 36; i++) {
			valores[i] = i+1;
		}
		return docenas.toArray();
	}
	
}
