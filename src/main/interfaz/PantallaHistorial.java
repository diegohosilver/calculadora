package main.interfaz;

import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.interfaz.controles.Control;
import main.interfaz.controles.Dimensiones;
import main.negocio.Historial;
import main.negocio.Registro;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class PantallaHistorial extends JFrame {

	private JPanel panel;
	
	// Referencia de historial
	private Historial historial = Historial.obtenerInstancia();
	
	public PantallaHistorial() {
		super();
		inicializarMarco();
		inicializarContenido();
		inicializarHistorial();
	}
	
	private void inicializarMarco() {
		this.setBounds(100, 100, 342, 229);
		this.getContentPane().setLayout(null);
	}
	
	private void inicializarContenido() {	
		panel = new JPanel();
		panel.setBounds(112, 36, 96, 143);
		getContentPane().add(panel);

		getContentPane().add(Control.generarEtiqueta("Historial:", new Dimensiones(10, 11, 198, 48)));
	}
	
	private void inicializarHistorial() {
		Vector<Item> items = new Vector<>();
	    for (Map.Entry<String, Registro> entry : historial.listar().entrySet()) {
	      items.add(new Item(entry.getKey(), entry.getValue()));
	    }
				
		JList list = new JList(items);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(list);
	}
}
