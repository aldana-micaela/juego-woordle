package Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Juego.EstadoDeJuego;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.Font;

public class JuegoInterface {

	private JFrame frame;
	private EstadoDeJuego juego;
	private JTextField textField;
	private JButton btnAceptar;
	private JButton btnsig;
	private JLabel textIntentos;
	private JLabel PuntajeCant;
	private JLabel Puntaje;
	private JLabel cantidadDeIntentos;
	private JLabel palabraERA;
	private JLabel textIngresarPalabra;
	private JTextPane letra0;
	private JTextPane letra1;
	private JTextPane letra2;
	private JTextPane letra3;
	private JTextPane letra4;
	private JLabel excepcion5Letras;
	private static MenuInterface menu;
	private String palabraUsuario;
	private Timer time;
	private int idioma;
	

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					menu = new MenuInterface();
					
					JuegoInterface window = new JuegoInterface(menu.getIdioma());
					
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
	public JuegoInterface(int idioma) {
		
		this.idioma= idioma;		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// inicializo
		crearDiseñoJuego();        
        ganarJuego();
        boton_Aceptar();
        boton_SiguientePalabra();
        
		
	}

	private void palabraERA() {
		palabraERA = new JLabel(juego.getpalabra());
		palabraERA.setBounds(369, 98, 57, 14);
		frame.getContentPane().add(palabraERA);
	}

	private void cambiarColor(int n, Color color, char letra) {

		String l = String.valueOf(letra);
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

	public void frenarTiempoDeLosColores() {

		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				siguientePalabra();

			}
		};

		time.schedule(tarea, 1000);
	}

	private void crearDiseñoJuego() {

		juego = new EstadoDeJuego(this.idioma);

		crearFrame();
		crearTextoIngresarPalabra();
		crearCampoDeTexto();
		crearBotonAceptar();
		crearTexto_Intentos();
		cuadradosDeLasLetras();
		crearTexto_Puntaje();
		crearBoton_siguientePalabra();
		excepcion5Letras();
		palabraERA();
		
		if(idioma==0) {
			buildIdiomaEspañol();
		}
		else if(idioma==1) {
			buildIdiomaIngles();
		}
		

		time = new Timer();
		
		
	}

	private void excepcion5Letras() {
		excepcion5Letras = new JLabel();
		excepcion5Letras.setForeground(Color.RED);
		excepcion5Letras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		excepcion5Letras.setBounds(93, 121, 230, 24);
		frame.getContentPane().add(excepcion5Letras);
		excepcion5Letras.setVisible(false);
	}

	private void crearBoton_siguientePalabra() {
		btnsig = new JButton();
		btnsig.setBackground(Color.WHITE);
		btnsig.setBounds(205, 58, 145, 30);
		frame.getContentPane().add(btnsig);
		btnsig.setVisible(true);
	}


	private void crearTexto_Puntaje() {
		Puntaje = new JLabel();
		Puntaje.setBounds(329, 26, 46, 14);
		frame.getContentPane().add(Puntaje);
		
		PuntajeCant = new JLabel("0");
		PuntajeCant.setBounds(385, 26, 17, 14);
		frame.getContentPane().add(PuntajeCant);
		
		
	}

	private void cuadradosDeLasLetras() {
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
	}



	private void crearTexto_Intentos() {
		textIntentos = new JLabel();
		textIntentos.setBounds(329, 0, 57, 14);
		frame.getContentPane().add(textIntentos);
		
		cantidadDeIntentos = new JLabel("6");
		cantidadDeIntentos.setBounds(385, 0, 17, 14);
		frame.getContentPane().add(cantidadDeIntentos);
	}

	private void crearBotonAceptar() {
		btnAceptar = new JButton();
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(93, 60, 102, 28);
		frame.getContentPane().add(btnAceptar);
	}

	private void crearCampoDeTexto() {
		textField = new JTextField();
		textField.setBounds(156, 29, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	private void crearTextoIngresarPalabra() {
		textIngresarPalabra = new JLabel();
		textIngresarPalabra.setBounds(30, 26, 97, 24);
		frame.getContentPane().add(textIngresarPalabra);
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}

	private void cambiarColor() {
		letra0.setBackground(Color.gray);
		letra0.setContentType("");
		letra1.setBackground(Color.gray);
		letra1.setContentType("");
		letra2.setBackground(Color.gray);
		letra2.setContentType("");
		letra3.setBackground(Color.gray);
		letra3.setContentType("");
		letra4.setBackground(Color.gray);
		letra4.setContentType("");

		juego.cambiarPalabra();
		palabraERA.setText(juego.getpalabra());

	}

	private void ganarJuego() {

		if (juego.Puntaje()>50) {

			int opcion = JOptionPane.showConfirmDialog(frame, "¡Ganaste!, ¿Desea seguir jugando en el siguiente nivel en Ingles?", "",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

			if (opcion == 0) {
				resetearJuegoYDiseño();
			}

			if (opcion == 1) {
				System.exit(0);
			}
		}
	}

	private void resetearJuegoYDiseño() {
		juego.resetearJuego();
		cantidadDeIntentos.setText(juego.getIntentos());
		PuntajeCant.setText(juego.getPuntaje());
		excepcion5Letras.setVisible(false);
	}

	private void perderJuego() {
		int opcion = JOptionPane.showConfirmDialog(frame, "¡Game Over!, ¿Desea seguir jugando?", "",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

		if (opcion == 0) {
			cambiarColor();
			resetearJuegoYDiseño();

		}
		if (opcion == 1 || opcion == -1) {
			System.exit(0);
		}
	}

	private void sumarPuntaje() {
		juego.sumarPuntaje();
		PuntajeCant.setText(juego.getPuntaje());

	}

	private void restarIntentos() {
		juego.quitarIntentos();
		cantidadDeIntentos.setText(juego.getIntentos());
	}

	private void restarPuntaje() {
		juego.restarPuntaje();
		PuntajeCant.setText(juego.getPuntaje());
	}

	private void siguientePalabra() {
		juego.cambiarPalabra();
		cambiarColor();

	}
	 
//	private void cambiarIdioma() {
////		String idioma = menu.getIdioma();
////		if (idioma.equals("English")) {
//			juego.setIdiomaIngles();
//			buildIdiomaIngles();
////			botones();
////		} else {
////			buildIdiomaEspañol();
////		}
//	}

	private void buildIdiomaEspañol() {
		textIngresarPalabra.setText("Ingrese palabra:");
		btnAceptar.setText("Aceptar");
		textIntentos.setText("Intentos");
		Puntaje.setText("Puntaje");
		excepcion5Letras.setText("Ingrese una palabra de 5 letras!");
		btnsig.setText("Siguiente Palabra");
		
	}

	private void buildIdiomaIngles() {
		textIngresarPalabra.setText("Enter word:");
		btnAceptar.setText("Accept");
		textIntentos.setText("Attempts");
		Puntaje.setText("Score");
		excepcion5Letras.setText("Enter 5 letter words");
		btnsig.setText("Next word");
	}

	private void boton_Aceptar() {
	
	btnAceptar.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			palabraUsuario = textField.getText().toLowerCase();
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
					} else {
						cambiarColor(i, Color.gray, letraQueSeAgrega);
					}
				}
			}
			textField.setText(null);

			if (juego.adivinoPalabra(palabraUsuario)) {
				juego.adivinoPalabra();
				sumarPuntaje();
				ganarJuego();
				frenarTiempoDeLosColores();

			} else {
				restarIntentos();
			}

			if (juego.IntentosCero() == 0) {
				perderJuego();
			}

		}

	});

	
	}

	private void boton_SiguientePalabra() {
		btnsig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				siguientePalabra();
				restarPuntaje();
			}

		});
	}


}
