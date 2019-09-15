package main.interfaz.controles;

import java.awt.Font;

import javax.swing.JButton;

public class Boton {
	
	private static JButton generarBotonConPropiedades(String texto, BotonDimensiones dimensiones, int fuente, float tamanio) {
		JButton boton = new JButton(texto);
		
		boton.setFont(boton.getFont().deriveFont(boton.getFont().getStyle() | fuente, tamanio));
		boton.setBounds(dimensiones.obtenerX(), dimensiones.obtenerY(), dimensiones.obtenerAncho(), dimensiones.obtenerAlto());
		
		return boton;
	}
	
	public static JButton generarBoton(String texto, BotonDimensiones dimensiones) {
		return generarBotonConPropiedades(texto, dimensiones, Font.BOLD, 20F);
	}
	
	public static JButton generarBoton(String texto, BotonDimensiones dimensiones, int fuente, float tamanio) {
		return generarBotonConPropiedades(texto, dimensiones, fuente, tamanio);
	}

}
