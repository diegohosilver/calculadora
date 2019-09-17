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
	
	// Flags
	private boolean primerTerminoLleno;
	private boolean segundoTerminoLleno;
	private boolean operacionFinalizada;
	
	// Terminos para guardar resultados de operaciones
	private double primerTermino = 0;
	private double segundoTermino = 0;
	
	// Inicializar instancia de calculo
	private Calculo calculo = new Calculo(Operacion.SUMA);

	public PantallaPrincipal() {
		super();
		inicializarMarco();
		inicializarTexto();
		inicializarOperadores();
		inicializarNumeros();
		inicializarExtras();
	}
	
	// <-- Metodos auxiliares -->
	
	// Si ya existe un primer termino y el ingreso es un punto decimal, agregarlo al buffer
	private void validarEntradaAlBuffer(String n) {
		if ((n == "." && buffer.length() == 0) && primerTerminoLleno) {
			buffer = Util.ParsearNumeroComoTexto(primerTermino) + ".";
		}
	}
	
	// Agregar numero al buffer
	private void agregarAlBuffer(String n) {	
		validarEntradaAlBuffer(n);
		
		if (buffer.length() == 0 && operacionFinalizada) {
			texto.setText("");
			operacionFinalizada = false;
		}
		
		buffer += n;
		texto.setText(texto.getText() + n);
	}
	
	// Agregar operador al cuadro de texto
	private void agregarOperador(String o) {
		operacionFinalizada = false;
		
		texto.setText(Util.reemplazarOperador(texto.getText(), " " + o.trim() + " "));
	}
	
	// Vaciar buffer a alguno de los terminos y luego intentar calcular si ambos estan llenos
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
	
	// Limpiar valores
	private void borrar() {
		primerTerminoLleno = false;
		segundoTerminoLleno = false;
		operacionFinalizada = false;
		buffer = "";
		texto.setText("");
	}
	
	// <-- Metodos auxiliares -->

	private void inicializarMarco() {
		this.setBounds(100, 100, 525, 673);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}
	
	private void inicializarTexto() {		
		texto = Control.generarTexto(new Dimensiones(10, 11, 494, 176), Color.WHITE, false);
		this.getContentPane().add(texto);
	}

	private void inicializarOperadores() {
		this.getContentPane().add(
				Control.generarBoton("+", new Dimensiones(136, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarOperador("+");
							calculo.cambiarOperador(Operacion.SUMA);
							vaciarBufferEIntentarCalcular();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("-", new Dimensiones(262, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarOperador("-");
							calculo.cambiarOperador(Operacion.RESTA);
							vaciarBufferEIntentarCalcular();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("*", new Dimensiones(388, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarOperador("*");
							calculo.cambiarOperador(Operacion.PRODUCTO);
							vaciarBufferEIntentarCalcular();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("/", new Dimensiones(388, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarOperador("/");
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
							operacionFinalizada = true;
							texto.setText(Util.ParsearNumeroComoTexto(primerTermino));					
						}
					})
				);
	}
	
	private void inicializarNumeros() {
		this.getContentPane().add(
				Control.generarBoton(".", new Dimensiones(262, 203, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer(".");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("9", new Dimensiones(262, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("9");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("8", new Dimensiones(136, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("8");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("7", new Dimensiones(10, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("7");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("6", new Dimensiones(262, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("6");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("5", new Dimensiones(136, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("5");
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("4", new Dimensiones(10, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("4");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("3", new Dimensiones(262, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("3");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("2", new Dimensiones(136, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("2");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("1", new Dimensiones(10, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("1");
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("0", new Dimensiones(388, 551, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							agregarAlBuffer("0");
						}
					})
				);
	}
	
	private void inicializarExtras() {
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
							borrar();
						}
					})
				);	
	}
	
}
