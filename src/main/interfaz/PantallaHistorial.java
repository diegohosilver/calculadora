package main.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class PantallaHistorial extends JFrame {

	public PantallaHistorial() {
		super();
		inicializarMarco();
	}
	
	private void inicializarMarco() {
		this.setBounds(100, 100, 342, 229);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(112, 36, 96, 143);
		getContentPane().add(panel);
		
		String week[]= { "Monday","Tuesday","Wednesday", 
                "Thursday","Friday","Saturday","Sunday"};
		
		JList list = new JList(week);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(list);
		
		JLabel lblNmerosEnMemoria = new JLabel("N\u00FAmeros en memoria:");
		lblNmerosEnMemoria.setBounds(10, 11, 198, 14);
		getContentPane().add(lblNmerosEnMemoria);
	}
}
