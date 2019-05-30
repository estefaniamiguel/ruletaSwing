package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JButton;

import modelo.TipoApuesta;
import controller.RuletaController;
import exception.MontoMenorAlMinimoException;
import exception.MontoNegativoException;

public class Ruleta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFecha;
	private JTextField textFieldMonto;
	private RuletaController controller = new RuletaController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ruleta frame = new Ruleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ruleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDialog problema = new JDialog(this, "Ocurrió un problema", true);
		problema.setBounds(100, 100, 450, 300);

		JLabel textoProblema = new JLabel("");
		problema.getContentPane().add(textoProblema);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelFecha = new JLabel("Fecha");
		panel.add(labelFecha);
		
		textFieldFecha = new JTextField();
		panel.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel labelMonto = new JLabel("Monto");
		panel.add(labelMonto);
		
		textFieldMonto = new JTextField();
		panel.add(textFieldMonto);
		textFieldMonto.setColumns(10);
		textFieldMonto.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.setMonto(textFieldMonto.getText());
				} catch (NumberFormatException e1) {
					textoProblema.setText(e1.getMessage());
					problema.setVisible(true);
				} catch (MontoNegativoException e1) {
					textoProblema.setText(e1.getMessage());
					problema.setVisible(true);
				}

			}
		});
		
		JLabel labelTipoApuesta = new JLabel("Tipo de apuesta");
		panel.add(labelTipoApuesta);
		
		JComboBox<TipoApuesta> comboBoxTipo = new JComboBox<TipoApuesta>();
		comboBoxTipo.setModel(new DefaultComboBoxModel<TipoApuesta>(controller.getTiposDeApuesta()));
		comboBoxTipo.setSelectedIndex(0);
		comboBoxTipo.setRenderer(new TipoDeApuestaComboRenderer());

		panel.add(comboBoxTipo);
		
		JLabel labelValorApostado = new JLabel("A que queres apostar");
		panel.add(labelValorApostado);
		
		JComboBox comboBoxValorApostado = new JComboBox();
		comboBoxValorApostado.setModel(new DefaultComboBoxModel<Object>(controller.getTiposDeValores()));
		panel.add(comboBoxValorApostado);
		
		JButton botonJugar = new JButton("Jugar");
		panel.add(botonJugar);
		
		comboBoxTipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setTipoApuesta((TipoApuesta)comboBoxTipo.getSelectedItem());
				comboBoxValorApostado.setModel(new DefaultComboBoxModel<Object>(controller.getTiposDeValores()));
			}
		});
		
		JDialog resultado = new JDialog(this, "Resultado de la jugada", true);
		resultado.setBounds(100, 100, 450, 300);

		JLabel textoResultado = new JLabel("");
		resultado.getContentPane().add(textoResultado);
		
		botonJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.seApretoJugar();
					textoResultado.setText(controller.getMensajeResultado());
					resultado.setVisible(true);
				} catch (MontoMenorAlMinimoException e1) {
					textoProblema.setText(e1.getMessage());
					problema.setVisible(true);
				}
				
			}
		});
	}

}
