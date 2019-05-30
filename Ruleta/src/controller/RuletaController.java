package controller;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import exception.MontoMenorAlMinimoException;
import exception.MontoNegativoException;
import modelo.Apuesta;
import modelo.Resultado;
import modelo.TipoApuesta;

public class RuletaController {
	Apuesta apuesta = new Apuesta();
	Resultado resultado;
	public void seApretoJugar() throws MontoMenorAlMinimoException {
		resultado = apuesta.jugar();
	}

	public void setTipoApuesta(TipoApuesta tipoApuesta) {
		apuesta.setTipo(tipoApuesta);
	}

	public TipoApuesta[] getTiposDeApuesta() {
		return apuesta.getTiposDeApuestas();
	}

	public Object[] getTiposDeValores() {
		return apuesta.getTiposDeValores();
	}

	public String getMensajeResultado() {
		return resultado.getMensaje();
	}

	public void setMonto(String montoString) throws NumberFormatException, MontoNegativoException {
		apuesta.setMonto(Double.parseDouble(montoString));
		
	}

}
