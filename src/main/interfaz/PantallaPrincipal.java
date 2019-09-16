package main.interfaz;

import main.negocio.calculo.Calculo;
import main.negocio.calculo.Operacion;

import javax.swing.JFrame;
import javax.swing.JTextField;

import main.interfaz.controles.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
	
	private JTextField texto;
	private String buffer = "";
	
	private boolean primerTerminoLleno;
	private boolean segundoTerminoLleno;
	private double primerTermino = 0;
	private double segundoTermino = 0;
	
	private Calculo calculo = new Calculo(Operacion.SUMA);

	public PantallaPrincipal() {
		super();
		initialize();
	}
	
	private void agregarAlBuffer(String n) {
		buffer += n;
	}
	
	private void vaciarBufferEIntentarCalcular() {
		// Validar cual termino esta vacio
		if (!primerTerminoLleno) {
			primerTerminoLleno = true;
			primerTermino = Util.ParsearADouble(buffer);
			buffer = "";
		}
		else if (!segundoTerminoLleno) {
			segundoTerminoLleno = true;
			segundoTermino = Util.ParsearADouble(buffer);
			buffer = "";
		}
		
		if (puedoCalcular()) {
			primerTermino = calculo.calcular(primerTermino, segundoTermino);
			segundoTerminoLleno = false;
		}
	}
	
	private boolean puedoCalcular() {
		return primerTerminoLleno && segundoTerminoLleno;
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
							texto.setText(Util.reemplazarOperador(texto.getText(), " + "));
							calculo.cambiarOperador(Operacion.SUMA);
							vaciarBufferEIntentarCalcular();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("-", new Dimensiones(262, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(Util.reemplazarOperador(texto.getText(), " - "));
							calculo.cambiarOperador(Operacion.RESTA);
							vaciarBufferEIntentarCalcular();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("*", new Dimensiones(388, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(Util.reemplazarOperador(texto.getText(), " * "));
							calculo.cambiarOperador(Operacion.PRODUCTO);
							vaciarBufferEIntentarCalcular();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("/", new Dimensiones(388, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(Util.reemplazarOperador(texto.getText(), " / "));
							calculo.cambiarOperador(Operacion.DIVISION);
							vaciarBufferEIntentarCalcular();
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("=", new Dimensiones(388, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							vaciarBufferEIntentarCalcular();
							texto.setText(Double.toString(primerTermino));					
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("9", new Dimensiones(262, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "9");
							agregarAlBuffer("9");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("8", new Dimensiones(136, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "8");
							agregarAlBuffer("8");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("7", new Dimensiones(10, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "7");
							agregarAlBuffer("7");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("6", new Dimensiones(262, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "6");
							agregarAlBuffer("6");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("5", new Dimensiones(136, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "5");
							agregarAlBuffer("5");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("4", new Dimensiones(10, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "4");
							agregarAlBuffer("4");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("3", new Dimensiones(262, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "3");
							agregarAlBuffer("3");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("2", new Dimensiones(136, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "2");
							agregarAlBuffer("2");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("1", new Dimensiones(10, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "1");
							agregarAlBuffer("1");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("0", new Dimensiones(388, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							texto.setText(texto.getText() + "0");
							agregarAlBuffer("0");
						}
					})
				);
	}
}
