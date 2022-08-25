package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Juego.EstadoDeJuego;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.Box;

public class JuegoInterface {

	private JFrame frame;
	private JTextField textPalabraIngresada;
	private EstadoDeJuego juego;
	private JTable table;
	private JTextField textField;
	private JButton btnAceptar;
	private JLabel textIntentos;
	JLabel cantidadDeIntentos;
	private JTextPane letra0;
	private JTextPane letra1;
	private JTextPane letra2;
	private JTextPane letra3;
	private JTextPane letra4;
	private JLabel excepcion5Letras;

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

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		crearDiseñoJuego();

		// inicializo
		juego = new EstadoDeJuego();
		
		JLabel palabraERA = new JLabel(juego.palabra);
		palabraERA.setBounds(315, 67, 57, 14);
		frame.getContentPane().add(palabraERA);
		
		


		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				StringBuilder letraQueSeVerifica = new StringBuilder();
				String palabraUsuario = textField.getText();
				//char letra;

				if (palabraUsuario.length() != 5) {
					textField.setText(null);
					excepcion5Letras.setVisible(true);

				}

				else {

					excepcion5Letras.setVisible(false);
					juego.getPalabra(palabraUsuario);
					juego.verificarPalabra();

					for (int i = 0; i < juego.letras.size(); i++) {

						//letra = palabraUsuario.charAt(i);

						if (juego.letras.get(i) == 1) {

							//letraQueSeVerifica.append(letra);
							cambiarColor(i, Color.green, letraQueSeVerifica.toString());
							//letraQueSeVerifica.deleteCharAt(letra);
							

						}

						else {
						//	letraQueSeVerifica.append(letra);
							cambiarColor(i, Color.red, letraQueSeVerifica.toString());
							//letraQueSeVerifica.deleteCharAt(0);
							

						}

					}
				}
				textField.setText(null);
			}
			
			
		});



	}

	private void cambiarColor(int n, Color color, String letra) {

		if (n == 0) {
			letra0.setBackground(color);
			letra0.setText(letra.toString());
		} else if (n == 1) {
			letra1.setBackground(color);
			letra1.setText(letra.toString());
		} else if (n == 2) {
			letra2.setBackground(color);
			letra2.setText(letra.toString());
		} else if (n == 3) {
			letra3.setBackground(color);
			letra3.setText(letra.toString());
		} else if (n==4) {
			letra4.setBackground(color);
			letra4.setText(letra.toString());
		}
	}

	private void crearDiseñoJuego() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel textIngresarPalabra = new JLabel("Ingresar palabra:");
		textIngresarPalabra.setBounds(30, 26, 97, 24);
		frame.getContentPane().add(textIngresarPalabra);

		textField = new JTextField();
		textField.setBounds(156, 29, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(163, 63, 89, 23);
		frame.getContentPane().add(btnAceptar);

		textIntentos = new JLabel("Intentos:");
		textIntentos.setBounds(297, 11, 57, 14);
		frame.getContentPane().add(textIntentos);
		
		
		cantidadDeIntentos = new JLabel("0");
		cantidadDeIntentos.setBounds(348, 11, 17, 14);
		frame.getContentPane().add(cantidadDeIntentos);
		
		
		letra0 = new JTextPane();
		letra0.setEditable(false);
		letra0.setBackground(Color.LIGHT_GRAY);
		letra0.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra0.setBounds(30, 165, 62, 47);
		frame.getContentPane().add(letra0);

		letra1 = new JTextPane();
		letra1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra1.setBackground(Color.LIGHT_GRAY);
		letra1.setEditable(false);
		letra1.setBounds(102, 165, 62, 47);
		frame.getContentPane().add(letra1);

		letra2 = new JTextPane();
		letra2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra2.setEditable(false);
		letra2.setBackground(Color.LIGHT_GRAY);
		letra2.setBounds(174, 165, 62, 47);
		frame.getContentPane().add(letra2);

		letra3 = new JTextPane();
		letra3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra3.setEditable(false);
		letra3.setBackground(Color.LIGHT_GRAY);
		letra3.setBounds(246, 165, 62, 47);
		frame.getContentPane().add(letra3);

		letra4 = new JTextPane();
		letra4.setEditable(false);
		letra4.setBackground(Color.LIGHT_GRAY);
		letra4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra4.setBounds(318, 165, 62, 47);
		frame.getContentPane().add(letra4);

		excepcion5Letras = new JLabel("Ingrese una palabra de 5 letras!");
		excepcion5Letras.setForeground(Color.RED);
		excepcion5Letras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		excepcion5Letras.setBounds(93, 121, 230, 24);
		frame.getContentPane().add(excepcion5Letras);
		excepcion5Letras.setVisible(false);
	}

}
