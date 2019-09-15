package main.interfaz;

import javax.swing.JFrame;

import main.interfaz.controles.*;

import java.awt.Color;

public class PantallaPrincipal extends JFrame {

	public PantallaPrincipal() {
		super();
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 525, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		this.getContentPane().add(
				Control.generarTexto(new Dimensiones(10, 11, 494, 176), Color.WHITE, false)
				);

		this.getContentPane().add(
				Control.generarBoton("Borrar", new Dimensiones(10, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("+", new Dimensiones(136, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("7", new Dimensiones(10, 290, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("8", new Dimensiones(136, 290, 116, 76))
				);

		this.getContentPane().add(
				Control.generarBoton("-", new Dimensiones(262, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("*", new Dimensiones(388, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("9", new Dimensiones(262, 290, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("/", new Dimensiones(388, 290, 116, 76))
				);

		this.getContentPane().add(
				Control.generarBoton("=", new Dimensiones(388, 377, 116, 76))
				);

		this.getContentPane().add(
				Control.generarBoton("=", new Dimensiones(388, 377, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("6", new Dimensiones(262, 377, 116, 76))
				);

		this.getContentPane().add(
				Control.generarBoton("5", new Dimensiones(136, 377, 116, 76))
				);

		this.getContentPane().add(
				Control.generarBoton("4", new Dimensiones(10, 377, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("1", new Dimensiones(10, 464, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("2", new Dimensiones(136, 464, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("3", new Dimensiones(262, 464, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("0", new Dimensiones(388, 464, 116, 76))
				);
	}
}
