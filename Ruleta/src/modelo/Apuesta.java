package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import exception.FechaInvalidaException;
import exception.MontoMenorAlMinimoException;
import exception.MontoNegativoException;

public class Apuesta {
	TipoApuesta tipo = new ApuestaPleno();
	Double monto;
	Date fecha;
	Object valorElegido = 1;
	Date hoy = new Date();
	private Resultado resultado;
	public TipoApuesta getTipo() {
		return tipo;
	}
	public void setTipo(TipoApuesta tipo) {
		this.tipo = tipo;
		this.valorElegido = tipo.getValores()[0];
	}
	public Double getMonto() {
		return monto;
	}
	
	public void setMonto(Double monto) throws MontoNegativoException {
		if (monto > 0) {
			this.monto = monto;
		} else {
			throw new MontoNegativoException("El monto es negativo");	
		}
	}
	
	public Object getValorElegido() {
		return valorElegido;
	}
	public void setValorElegido(Object valorElegido) {
		this.valorElegido = valorElegido;
	}
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) throws FechaInvalidaException {
		if (fecha.before(new Date())) {
			throw new FechaInvalidaException("La fecha es anterior a hoy");
		}
		this.fecha = fecha;
	}
	
	public void jugar() throws MontoMenorAlMinimoException {
		tipo.validarMontoMinimo(monto);
		double valor = Math.random();
		int elNumeroQueSalio = (int) (36 * valor);
		resultado = tipo.comprobar(elNumeroQueSalio, this);
	}
	
	public TipoApuesta[] getTiposDeApuestas() {
		return new TipoApuesta[] {new ApuestaPleno(), new ApuestaDocena()};
	}
	
	public boolean puedeJugar() {
		return fecha != null && fecha.after(hoy) && monto != null && tipo != null && valorElegido != null;
	}
	
	public Object[] getTiposDeValores() {
		return tipo.getValores();
	}
	public String getMensajeResultado() {
		return resultado.getMensaje();
	}
}
