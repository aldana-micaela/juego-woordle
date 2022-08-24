package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JuegoInterface {

	private JFrame frame;
	private JTextField textPalabraIngresada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoInterface window = new JuegoInterface();
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
	public JuegoInterface() {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel textIngresarPalabra = new JLabel("Ingresar palabra:");
		textIngresarPalabra.setBounds(30, 26, 97, 24);
		frame.getContentPane().add(textIngresarPalabra);
		
		textPalabraIngresada = new JTextField();
		textPalabraIngresada.setBounds(153, 28, 109, 20);
		frame.getContentPane().add(textPalabraIngresada);
		textPalabraIngresada.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAceptar.setBounds(163, 63, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JLabel textIntentos = new JLabel("Intentos:");
		textIntentos.setBounds(295, 11, 57, 14);
		frame.getContentPane().add(textIntentos);
		
		JLabel cantidadDeIntentos = new JLabel("0");
		cantidadDeIntentos.setBounds(348, 11, 17, 14);
		frame.getContentPane().add(cantidadDeIntentos);
	}

}
