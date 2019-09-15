package main.interfaz;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
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

		JButton button = new JButton("Borrar");
		button.setFont(button.getFont().deriveFont(button.getFont().getStyle() | Font.BOLD, 20f));
		button.setBounds(10, 198, 116, 76);
		this.getContentPane().add(button);

		JButton button_1 = new JButton("+");
		button_1.setFont(button_1.getFont().deriveFont(button_1.getFont().getStyle() | Font.BOLD, 20f));
		button_1.setBounds(136, 198, 116, 76);
		this.getContentPane().add(button_1);

		JButton button_2 = new JButton("7");
		button_2.setFont(button_2.getFont().deriveFont(button_2.getFont().getStyle() | Font.BOLD, 20f));
		button_2.setBounds(10, 290, 116, 76);
		this.getContentPane().add(button_2);

		JButton button_3 = new JButton("8");
		button_3.setFont(button_3.getFont().deriveFont(button_3.getFont().getStyle() | Font.BOLD, 20f));
		button_3.setBounds(136, 290, 116, 76);
		this.getContentPane().add(button_3);

		JButton button_4 = new JButton("-");
		button_4.setFont(button_4.getFont().deriveFont(button_4.getFont().getStyle() | Font.BOLD, 20f));
		button_4.setBounds(262, 198, 116, 76);
		this.getContentPane().add(button_4);

		JButton button_5 = new JButton("*");
		button_5.setFont(button_5.getFont().deriveFont(button_5.getFont().getStyle() | Font.BOLD, 20f));
		button_5.setBounds(388, 198, 116, 76);
		this.getContentPane().add(button_5);

		JButton button_6 = new JButton("9");
		button_6.setFont(button_6.getFont().deriveFont(button_6.getFont().getStyle() | Font.BOLD, 20f));
		button_6.setBounds(262, 290, 116, 76);
		this.getContentPane().add(button_6);

		JButton button_7 = new JButton("/");
		button_7.setFont(button_7.getFont().deriveFont(button_7.getFont().getStyle() | Font.BOLD, 20f));
		button_7.setBounds(388, 290, 116, 76);
		this.getContentPane().add(button_7);

		JButton button_8 = new JButton("INTRO");
		button_8.setFont(button_8.getFont().deriveFont(button_8.getFont().getStyle() | Font.BOLD, 20f));
		button_8.setBounds(388, 377, 116, 76);
		this.getContentPane().add(button_8);

		JButton button_9 = new JButton("6");
		button_9.setFont(button_9.getFont().deriveFont(button_9.getFont().getStyle() | Font.BOLD, 20f));
		button_9.setBounds(262, 377, 116, 76);
		this.getContentPane().add(button_9);

		JButton button_10 = new JButton("5");
		button_10.setFont(button_10.getFont().deriveFont(button_10.getFont().getStyle() | Font.BOLD, 20f));
		button_10.setBounds(136, 377, 116, 76);
		this.getContentPane().add(button_10);

		JButton button_11 = new JButton("4");
		button_11.setFont(button_11.getFont().deriveFont(button_11.getFont().getStyle() | Font.BOLD, 20f));
		button_11.setBounds(10, 377, 116, 76);
		this.getContentPane().add(button_11);

		JButton button_12 = new JButton("1");
		button_12.setFont(button_12.getFont().deriveFont(button_12.getFont().getStyle() | Font.BOLD, 20f));
		button_12.setBounds(10, 464, 116, 76);
		this.getContentPane().add(button_12);

		JButton button_13 = new JButton("2");
		button_13.setFont(button_13.getFont().deriveFont(button_13.getFont().getStyle() | Font.BOLD, 20f));
		button_13.setBounds(136, 464, 116, 76);
		this.getContentPane().add(button_13);

		JButton button_14 = new JButton("3");
		button_14.setFont(button_14.getFont().deriveFont(button_14.getFont().getStyle() | Font.BOLD, 20f));
		button_14.setBounds(262, 464, 116, 76);
		this.getContentPane().add(button_14);

		JButton button_15 = new JButton("0");
		button_15.setFont(button_15.getFont().deriveFont(button_15.getFont().getStyle() | Font.BOLD, 20f));
		button_15.setBounds(388, 464, 116, 76);
		this.getContentPane().add(button_15);
	}
}
