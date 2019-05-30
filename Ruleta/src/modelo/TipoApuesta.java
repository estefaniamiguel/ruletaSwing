package modelo;

import exception.MontoMenorAlMinimoException;

public abstract class TipoApuesta {
	public Resultado comprobar(int elNumeroQueSalio, Apuesta apuesta) {
		if (gano(elNumeroQueSalio, apuesta.getValorElegido())) {
			return new Ganador(elNumeroQueSalio, apuesta.getMonto() * this.ganancia());
		} else {
			return new Perdedor(elNumeroQueSalio);
		}
	}
	
	public void validarMontoMinimo(Double monto) throws MontoMenorAlMinimoException {
		if (monto == null || monto < this.getMontoMinimo()) {
			throw new MontoMenorAlMinimoException("El monto minimo para una apuesta " + this.getNombre() + " es " + this.getMontoMinimo());
		}
		
	}
	
	abstract Double ganancia();
	abstract boolean gano(int elNumeroQueSalio, Object valorElegido);
	public abstract String getNombre();
	abstract int getMontoMinimo();
	public abstract Object[] getValores();
}
