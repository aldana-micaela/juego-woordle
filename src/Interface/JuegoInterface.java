package Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Juego.EstadoDeJuego;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;

public class JuegoInterface {

	private JFrame frame;
	private EstadoDeJuego juego;
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
	private static MenuInterface menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					JuegoInterface window = new JuegoInterface();
//					window.frame.setVisible(true);

					menu = new MenuInterface();

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

		juego = new EstadoDeJuego();			

		// inicializo

		JLabel palabraERA = new JLabel(juego.palabra);
		palabraERA.setBounds(315, 67, 57, 14);
		frame.getContentPane().add(palabraERA);
		

		btnAceptar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				String palabraUsuario = textField.getText().toLowerCase();
				juego.limpiarArregloDeNumeros();

				if (palabraUsuario.length() != 5) {
					textField.setText(null);
					excepcion5Letras.setVisible(true);

				}

				else {

					char letraQueSeAgrega;
					excepcion5Letras.setVisible(false);
					juego.verificarPalabra(palabraUsuario);

					
					for (int i = 0; i < 5; i++) {						
						letraQueSeAgrega = palabraUsuario.charAt(i);

						if (juego.obtenerNumero(i) == 1) {

							cambiarColor(i, Color.green, letraQueSeAgrega);
						}

						else if (juego.obtenerNumero(i) == 2) {
							cambiarColor(i, Color.yellow, letraQueSeAgrega);
						}
						else {
							cambiarColor(i, Color.gray, letraQueSeAgrega);
						}
					}
				}
				textField.setText(null);
				
			}

		});
	}

	private void cambiarColor(int n, Color color, char letra) {

		String l= String.valueOf(letra);
		if (n == 0) {
			letra0.setBackground(color);
			letra0.setText(l);
			
		} else if (n == 1) {
			letra1.setBackground(color);
			letra1.setText(l);
		} else if (n == 2) {
			letra2.setBackground(color);
			letra2.setText(l);
		} else if (n == 3) {
			letra3.setBackground(color);
			letra3.setText(l);
		} else if (n == 4) {
			letra4.setBackground(color);
			letra4.setText(l);
		}
		
	}

	private void crearDiseñoJuego() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

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
