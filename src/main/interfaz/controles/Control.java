package main.interfaz.controles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Control {
	
	// Arrojar excepcion por texto vacio
	private static void validarTextoVacio(String texto) {
		if (texto == null || texto.length() == 0) {
			throw new IllegalArgumentException("Texto no puede estar vacio");
		}
	}

	private static JButton generarBotonConPropiedades(String texto, Dimensiones dimensiones, int fuente, float tamanio) {
		validarTextoVacio(texto);
		
		JButton boton = new JButton(texto);
		
		boton.setFont(boton.getFont().deriveFont(boton.getFont().getStyle() | fuente, tamanio));
		boton.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return boton;
	}
	
	private static JTextField generarTextoConPropiedades(Dimensiones dimensiones, Color colorFondo, boolean editable, int fuente, float tamanio, int alineacion, int columnas) {
		JTextField texto = new JTextField();
		
		texto.setBackground(colorFondo);
		texto.setEditable(false);
		texto.setFont(texto.getFont().deriveFont(texto.getFont().getStyle() | fuente, texto.getFont().getSize() + tamanio));
		texto.setHorizontalAlignment(alineacion);
		texto.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		texto.setColumns(columnas);
		
		return texto;
	}
	
	private static JLabel generarEtiquetaConPropiedades(String texto, Dimensiones dimensiones) {
		validarTextoVacio(texto);
		
		JLabel etiqueta = new JLabel(texto);
		
		etiqueta.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return etiqueta;
	}
	
	private static void validarEvento(ActionListener evento) {
		if (evento == null) {
			throw new IllegalArgumentException("Evento no puede estar vacio");
		}
	}
	
	public static JButton generarBoton(String texto, Dimensiones dimensiones) {
		return generarBotonConPropiedades(texto, dimensiones, Font.BOLD, 20F);
	}
	
	public static JButton generarBoton(String texto, Dimensiones dimensiones, ActionListener evento) {
		validarEvento(evento);
		
		JButton boton = generarBotonConPropiedades(texto, dimensiones, Font.BOLD, 20F);
		boton.addActionListener(evento);
		return boton;
	}
	
	public static JTextField generarTexto(Dimensiones dimensiones, Color colorFondo, boolean editable) {
		return generarTextoConPropiedades(dimensiones, colorFondo, editable, Font.BOLD, 9f, SwingConstants.RIGHT, 10);
	}
	
	public static JTextField generarTexto(Dimensiones dimensiones, Color colorFondo, boolean editable, ActionListener evento) {
		validarEvento(evento);
		
		JTextField texto = generarTextoConPropiedades(dimensiones, colorFondo, editable, Font.BOLD, 9f, SwingConstants.RIGHT, 10);
		texto.addActionListener(evento);
		return texto;
	}
	
	public static JLabel generarEtiqueta(String texto, Dimensiones dimensiones) {
		return generarEtiquetaConPropiedades(texto, dimensiones);
	}
}
