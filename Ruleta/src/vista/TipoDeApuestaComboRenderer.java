package vista;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import modelo.TipoApuesta;

public class TipoDeApuestaComboRenderer extends JLabel implements
		ListCellRenderer<TipoApuesta> {

	@Override
	public Component getListCellRendererComponent(
			JList<? extends TipoApuesta> list, TipoApuesta value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setText(value.getNombre());
		return this;
	}

}
