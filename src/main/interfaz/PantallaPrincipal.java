package main.interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaPrincipal {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 512, 176);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 198, 116, 76);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button.setBounds(136, 198, 116, 76);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_1.setBounds(262, 198, 116, 76);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_2.setBounds(10, 290, 116, 76);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_3.setBounds(136, 290, 116, 76);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_4.setBounds(262, 290, 116, 76);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_5.setBounds(10, 377, 116, 76);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_6.setBounds(136, 377, 116, 76);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_7.setBounds(262, 377, 116, 76);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(10, 464, 116, 76);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		button_9.setBounds(136, 464, 116, 76);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(262, 464, 116, 76);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(388, 198, 116, 76);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("New button");
		button_12.setBounds(388, 290, 116, 76);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(388, 377, 116, 76);
		frame.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("New button");
		button_14.setBounds(388, 464, 116, 76);
		frame.getContentPane().add(button_14);
	}
}
