package main.interfaz.controles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Control {
	
	private static JButton generarBotonConPropiedades(String texto, Dimensiones dimensiones, int fuente, float tamanio) {
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
	
	public static JButton generarBoton(String texto, Dimensiones dimensiones) {
		return generarBotonConPropiedades(texto, dimensiones, Font.BOLD, 20F);
	}
	
	public static JButton generarBoton(String texto, Dimensiones dimensiones, int fuente, float tamanio) {
		return generarBotonConPropiedades(texto, dimensiones, fuente, tamanio);
	}
	
	public static JTextField generarTexto(Dimensiones dimensiones, Color colorFondo, boolean editable) {
		return generarTextoConPropiedades(dimensiones, colorFondo, editable, Font.BOLD, 9f, SwingConstants.RIGHT, 10);
	}
	
	public static JTextField generarTexto(Dimensiones dimensiones, Color colorFondo, boolean editable, int fuente, float tamanio, int alineacion, int columnas) {
		return generarTextoConPropiedades(dimensiones, colorFondo, editable, fuente, tamanio, alineacion, columnas);
	}
}
