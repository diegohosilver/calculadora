package main.interfaz;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.interfaz.controles.*;

import java.awt.Color;

public class PantallaPrincipal extends JFrame {

	private JTextField textField;

	public PantallaPrincipal() {
		super();
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 525, 640);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getStyle() | Font.BOLD, textField.getFont().getSize() + 9f));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 494, 176);
		this.getContentPane().add(textField);
		textField.setColumns(10);


		this.getContentPane().add(
				Boton.generarBoton("Borrar", new BotonDimensiones(10, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("+", new BotonDimensiones(136, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("7", new BotonDimensiones(10, 290, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("8", new BotonDimensiones(136, 290, 116, 76))
				);

		this.getContentPane().add(
				Boton.generarBoton("-", new BotonDimensiones(262, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("*", new BotonDimensiones(388, 198, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("9", new BotonDimensiones(262, 290, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("/", new BotonDimensiones(388, 290, 116, 76))
				);

		this.getContentPane().add(
				Boton.generarBoton("=", new BotonDimensiones(388, 377, 116, 76))
				);

		this.getContentPane().add(
				Boton.generarBoton("=", new BotonDimensiones(388, 377, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("6", new BotonDimensiones(262, 377, 116, 76))
				);

		this.getContentPane().add(
				Boton.generarBoton("5", new BotonDimensiones(136, 377, 116, 76))
				);

		this.getContentPane().add(
				Boton.generarBoton("4", new BotonDimensiones(10, 377, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("1", new BotonDimensiones(10, 464, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("2", new BotonDimensiones(136, 464, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("3", new BotonDimensiones(262, 464, 116, 76))
				);
		
		this.getContentPane().add(
				Boton.generarBoton("0", new BotonDimensiones(388, 464, 116, 76))
				);
	}
}
