package main.interfaz;

import javax.swing.JFrame;
import javax.swing.JTextField;

import main.interfaz.controles.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
	
	private JTextField texto;

	public PantallaPrincipal() {
		super();
		initialize();
	}

	private void initialize() {
		this.setBounds(100, 100, 525, 673);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		texto = Control.generarTexto(new Dimensiones(10, 11, 494, 176), Color.WHITE, false);
		this.getContentPane().add(texto);
		
		this.getContentPane().add(
				Control.generarBoton("M", new Dimensiones(10, 203, 116, 76))
				);
		
		this.getContentPane().add(
				Control.generarBoton("Historial", new Dimensiones(136, 203, 116, 76))
				);

		this.getContentPane().add(
				Control.generarBoton("Borrar", new Dimensiones(10, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText("");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("+", new Dimensiones(136, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + " + ");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("-", new Dimensiones(262, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + " - ");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("*", new Dimensiones(388, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + " * ");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("/", new Dimensiones(388, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + " / ");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("=", new Dimensiones(388, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + " = ");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("9", new Dimensiones(262, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "9");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("8", new Dimensiones(136, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "8");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("7", new Dimensiones(10, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "7");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("6", new Dimensiones(262, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "6");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("5", new Dimensiones(136, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "5");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("4", new Dimensiones(10, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "4");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("3", new Dimensiones(262, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "3");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("2", new Dimensiones(136, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "2");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("1", new Dimensiones(10, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "1");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("0", new Dimensiones(388, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "0");
						}
					})
				);
	}
}
