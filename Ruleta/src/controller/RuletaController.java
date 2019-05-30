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
	
	public void seApretoJugar() throws MontoMenorAlMinimoException {
		apuesta.jugar();
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
		return apuesta.getMensajeResultado();
	}

	public void setMonto(String montoString) throws NumberFormatException, MontoNegativoException {
		if (!montoString.isEmpty()) {
			apuesta.setMonto(Double.parseDouble(montoString));
		}
		
	}

}
