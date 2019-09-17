package main.interfaz;

import main.negocio.calculo.Calculo;
import main.negocio.calculo.Operacion;

import javax.swing.JFrame;
import javax.swing.JTextField;

import main.interfaz.controles.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PantallaPrincipal extends JFrame implements KeyListener {
	
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
			buffer = Util.ParsearNumeroComoTexto(primerTermino);
			primerTerminoLleno = false;
		}
	}
	
	// Si el usuario esta ingresando un numero luego de una operacion finalizada, reiniciar datos
	private void validarReinicioBuffer() {
		if (buffer.length() == 0 && operacionFinalizada) {
			borrar();
		}
	}
	
	// Agregar numero al buffer
	private void agregarAlBuffer(String n) {	
		validarEntradaAlBuffer(n);
		validarReinicioBuffer();
		
		buffer += n;
		texto.setText(texto.getText() + n);
		
		texto.requestFocus();
	}
	
	// Agregar operador al cuadro de texto
	private void agregarOperador(String o) {
		operacionFinalizada = false;
		
		texto.setText(Util.reemplazarOperador(texto.getText(), " " + o.trim() + " "));
		
		texto.requestFocus();
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
		texto.requestFocus();
	}
	
	// <-- Metodos con operadores -->
	
	private void sumar() {
		agregarOperador("+");
		calculo.cambiarOperador(Operacion.SUMA);
		vaciarBufferEIntentarCalcular();
	}
	
	private void restar() {
		agregarOperador("-");
		calculo.cambiarOperador(Operacion.RESTA);
		vaciarBufferEIntentarCalcular();
	}
	
	private void multiplicar() {
		agregarOperador("*");
		calculo.cambiarOperador(Operacion.PRODUCTO);
		vaciarBufferEIntentarCalcular();
	}
	
	private void dividir() {
		agregarOperador("/");
		calculo.cambiarOperador(Operacion.DIVISION);
		vaciarBufferEIntentarCalcular();
	}
	
	private void calcular() {
		vaciarBufferEIntentarCalcular();
		operacionFinalizada = true;
		texto.setText(Util.ParsearNumeroComoTexto(primerTermino));
	}
	
	// <-- Metodos con operadores -->
	
	// <-- Metodos auxiliares -->

	private void inicializarMarco() {
		this.setBounds(100, 100, 525, 673);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}
	
	private void inicializarTexto() {		
		texto = Control.generarTexto(new Dimensiones(10, 11, 494, 176), Color.WHITE, false);
		texto.addKeyListener(this);
		this.getContentPane().add(texto);
	}

	private void inicializarOperadores() {
		this.getContentPane().add(
				Control.generarBoton("+", new Dimensiones(136, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							sumar();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("-", new Dimensiones(262, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							restar();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("*", new Dimensiones(388, 290, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							multiplicar();
						}
					})
				);
		
		this.getContentPane().add(
				Control.generarBoton("/", new Dimensiones(388, 377, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dividir();
						}
					})
				);

		this.getContentPane().add(
				Control.generarBoton("=", new Dimensiones(388, 464, 116, 76), new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							calcular();			
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (!Util.esTeclaValida(e)) return;
		
		int codigo = e.getKeyCode();
		String numero = Util.obtenerTextoAPartirDeCodigo(codigo);
		
		if (numero.length() > 0) {
			agregarAlBuffer(numero);
		}
		else {
			switch(codigo) {
				case KeyEvent.VK_ADD:
					sumar();
					break;
				case KeyEvent.VK_SUBTRACT:
					restar();
					break;
				case KeyEvent.VK_DIVIDE:
					dividir();
					break;
				case KeyEvent.VK_MULTIPLY:
					multiplicar();
					break;
				case KeyEvent.VK_ENTER:
					calcular();
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
}
