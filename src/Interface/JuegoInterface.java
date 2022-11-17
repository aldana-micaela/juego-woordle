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

import Interface.MenuInterface.Dificultad;
import Interface.MenuInterface.Idioma;

import java.awt.Font;

public class JuegoInterface {

	private JFrame frame;
	private EstadoDeJuego juego;
	private JButton btnAceptar;
	private JButton btnsig;
	private JButton btnPista;
	private JButton btnPalabraSecreta;
	private JLabel PuntajeCant;
	private JLabel Puntaje;
	private JLabel cantidadDeIntentos;
	private JLabel textIntentos;
	private JLabel palabraERA;
	private JLabel textIngresarPalabra;
	private JTextField textField;
	private JTextPane letra0;
	private JTextPane letra1;
	private JTextPane letra2;
	private JTextPane letra3;
	private JTextPane letra4;
	private JLabel excepcion5Letras;
	private static MenuInterface menu;
	private String palabraUsuario;
	private Timer time;
	private String idioma;
	private String dificultad;
	private JLabel jLabelPista;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {

					menu = new MenuInterface();

					JuegoInterface window = new JuegoInterface(menu.getIdioma(), menu.getDificultad());

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
	public JuegoInterface(Idioma idioma, Dificultad dificultad) {

		juego = new EstadoDeJuego(idioma, dificultad);
		this.idioma = idioma.name();
		this.dificultad = dificultad.name();
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
		boton_Aceptar();
		boton_SiguientePalabra();
		boton_pista();
		boton_palabraSecreta();

	}
	
	private void crearDiseñoJuego() {

		crearFrame();
		crearTextoIngresarPalabra();
		crearCampoDeTexto();
		crearBotonAceptar();
		crearTexto_Intentos();
		cuadradosDeLasLetras();
		crearTexto_Puntaje();
		crearBoton_siguientePalabra();
		crearBotonPista();
		crearBoton_palabraSecreta();
		excepcion5Letras();
		JLabelPista();
		palabraERA();

		if (idioma.equals("Español")) {
			buildIdiomaEspañol();
		} else if (idioma.equals("Inglés")) {
			buildIdiomaIngles();
		}

		if (dificultad.equals("Fácil")) {
			cantidadDeIntentos.setText("8");

		}
		if (dificultad.equals("Normal")) {
			cantidadDeIntentos.setText("6");

		}
		if (dificultad.equals("Difícil")) {
			cantidadDeIntentos.setText("4");

		}

		time = new Timer();

	}

	private void boton_Aceptar() {

		btnAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				palabraUsuario = textField.getText().toLowerCase();
				juego.limpiarArregloDeNumeros();

				if (palabraUsuario.length() != 5) {
					textField.setText(null);
					excepcion5Letras.setVisible(true);
					
				} else {
					verificacionDeLasLetras();
				}

				actualizacionIntefaz_btnAceptar();

			}

		});

	}

	private void actualizacionIntefaz_btnAceptar() {
		textField.setText(null);
		
		if (juego.adivinoPalabra(palabraUsuario)) {
			juego.agregarPalabraAlConjunto();
			sumarPuntaje();
			ganarJuego();
			frenarTiempoDeLosColores();
			
		} else {
			restarIntentos();
		}
		
		if (juego.getIntentos() == 0) {
			perderJuego();
		}
	}

	private void boton_SiguientePalabra() {

		btnsig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (juego.getPuntaje() >= 5) {
					restarPuntaje();
					siguientePalabra();

					if (juego.getPuntaje() < 5)
						btnsig.setEnabled(false);
				}
			}

		});
	}

	private void boton_pista() {

		btnPista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (juego.getIntentosPista() > 0) {

					jLabelPista.setVisible(true);
					juego.restarIntentosPista();
					btnPista.setEnabled(false);

					if (juego.getIntentosPista() == 0)
						btnPista.setEnabled(false);

				}

			}
		});

	}

	private void boton_palabraSecreta() {

		btnPalabraSecreta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (juego.getIntentosAyuda() > 0) {
					actualizacionDeInterfaz_btnPalabraSecreta();
				}

			}

		});

	}
	
	private void actualizacionDeInterfaz_btnPalabraSecreta() {
		
		palabraUsuario = juego.getpalabra();
		verificacionDeLasLetras();
		juego.agregarPalabraAlConjunto();
		juego.sumarPuntajeParaBTNayuda();
		PuntajeCant.setText(Integer.toString(juego.getPuntaje()));
		btnsig.setEnabled(true);
		ganarJuego();
		frenarTiempoDeLosColores();
		juego.restarIntentosAyuda();
		btnPalabraSecreta.setEnabled(false);
	}

	private void verificacionDeLasLetras() {

		char letraQueSeAgrega;
		excepcion5Letras.setVisible(false);
		juego.verificarPalabra(palabraUsuario);

		for (int i = 0; i < 5; i++) {
			letraQueSeAgrega = palabraUsuario.charAt(i);

			if (juego.obtenerEstadoLetras(i).equals(juego.getAcertado())) {
				cambiarColor(i, Color.green, letraQueSeAgrega);
			}

			else if (juego.obtenerEstadoLetras(i).equals(juego.getLetraEnOtraPosicion())) {
				cambiarColor(i, Color.yellow, letraQueSeAgrega);

			} else {
				cambiarColor(i, Color.gray, letraQueSeAgrega);
			}
		}
	}

	private void buildIdiomaEspañol() {
		textIngresarPalabra.setText("Ingrese una palabra:");
		btnAceptar.setText("Aceptar");
		textIntentos.setText("Intentos:");
		Puntaje.setText("Puntaje:");
		excepcion5Letras.setText("Ingrese una palabra de 5 letras!");
		btnsig.setText("Siguiente Palabra");
		jLabelPista.setText(juego.getPista());
		btnPalabraSecreta.setText("Dime la palabra");

	}

	private void buildIdiomaIngles() {
		textIngresarPalabra.setText("Enter word:");
		btnAceptar.setText("Accept");
		textIntentos.setText("Attempts:");
		Puntaje.setText("Score:");
		excepcion5Letras.setText("Enter 5 letter words");
		btnsig.setText("Next word");
		jLabelPista.setText(juego.getPista());
		btnPalabraSecreta.setText("Tell me the word");
	}

	private void palabraERA() {
		palabraERA = new JLabel(juego.getpalabra());
		palabraERA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		palabraERA.setBounds(321, 35, 132, 24);
		frame.getContentPane().add(palabraERA);
		palabraERA.setVisible(false);

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

	private void siguientePalabra() {
		juego.cambiarPalabra();
		cambiarColor();
		jLabelPista.setVisible(false);
		jLabelPista.setText(juego.getPista());

		if (juego.getIntentosPista() > 0)
			btnPista.setEnabled(true);

	}
	
	private void sumarPuntaje() {
		juego.sumarPuntaje();
		PuntajeCant.setText(Integer.toString(juego.getPuntaje()));
		btnsig.setEnabled(true);

	}

	private void restarIntentos() {
		juego.quitarIntentos();
		cantidadDeIntentos.setText(Integer.toString(juego.getIntentos()));
		cambiarColorIntentos();

	}

	private void restarPuntaje() {
		juego.restarPuntaje();
		PuntajeCant.setText(Integer.toString(juego.getPuntaje()));

	}

	private void excepcion5Letras() {
		excepcion5Letras = new JLabel();
		excepcion5Letras.setForeground(Color.RED);
		excepcion5Letras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		excepcion5Letras.setBounds(491, 69, 257, 33);
		frame.getContentPane().add(excepcion5Letras);
		excepcion5Letras.setVisible(false);
	}

	private void JLabelPista() {
		jLabelPista = new JLabel("");
		jLabelPista.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		jLabelPista.setBounds(67, 174, 624, 47);
		frame.getContentPane().add(jLabelPista);
		jLabelPista.setVisible(false);
	}

	private void crearBoton_siguientePalabra() {
		btnsig = new JButton();
		btnsig.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsig.setBackground(Color.WHITE);
		btnsig.setBounds(399, 126, 149, 35);
		frame.getContentPane().add(btnsig);
		btnsig.setVisible(true);
		btnsig.setEnabled(false);
	}

	private void crearBoton_palabraSecreta() {

		btnPalabraSecreta = new JButton();
		btnPalabraSecreta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPalabraSecreta.setBounds(287, 354, 191, 35);
		frame.getContentPane().add(btnPalabraSecreta);

	}

	private void crearTexto_Puntaje() {
		Puntaje = new JLabel();
		Puntaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Puntaje.setBounds(623, 26, 82, 24);
		frame.getContentPane().add(Puntaje);

		PuntajeCant = new JLabel("0");
		PuntajeCant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PuntajeCant.setBounds(715, 31, 33, 19);
		frame.getContentPane().add(PuntajeCant);

	}

	private void cuadradosDeLasLetras() {
		letra0 = new JTextPane();
		letra0.setEditable(false);
		letra0.setBackground(Color.LIGHT_GRAY);
		letra0.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra0.setBounds(67, 249, 82, 72);
		frame.getContentPane().add(letra0);

		letra1 = new JTextPane();
		letra1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra1.setBackground(Color.LIGHT_GRAY);
		letra1.setEditable(false);
		letra1.setBounds(189, 249, 88, 72);
		frame.getContentPane().add(letra1);

		letra2 = new JTextPane();
		letra2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra2.setEditable(false);
		letra2.setBackground(Color.LIGHT_GRAY);
		letra2.setBounds(332, 249, 82, 72);
		frame.getContentPane().add(letra2);

		letra3 = new JTextPane();
		letra3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra3.setEditable(false);
		letra3.setBackground(Color.LIGHT_GRAY);
		letra3.setBounds(466, 249, 82, 72);
		frame.getContentPane().add(letra3);

		letra4 = new JTextPane();
		letra4.setEditable(false);
		letra4.setBackground(Color.LIGHT_GRAY);
		letra4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		letra4.setBounds(588, 249, 82, 72);
		frame.getContentPane().add(letra4);
	}

	private void crearTexto_Intentos() {
		textIntentos = new JLabel();
		textIntentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIntentos.setBounds(50, 26, 99, 24);
		frame.getContentPane().add(textIntentos);

		cantidadDeIntentos = new JLabel("6");
		cantidadDeIntentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cantidadDeIntentos.setBounds(159, 26, 33, 24);
		frame.getContentPane().add(cantidadDeIntentos);
	}

	private void crearBotonAceptar() {
		btnAceptar = new JButton();
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(189, 126, 149, 35);
		frame.getContentPane().add(btnAceptar);
	}

	private void crearBotonPista() {
		btnPista = new JButton("?");
		btnPista.setBackground(Color.ORANGE);
		btnPista.setForeground(Color.RED);
		btnPista.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPista.setBounds(697, 265, 57, 47);
		frame.getContentPane().add(btnPista);
	}

	private void crearCampoDeTexto() {
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(265, 69, 216, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}

	private void crearTextoIngresarPalabra() {
		textIngresarPalabra = new JLabel();
		textIngresarPalabra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIngresarPalabra.setBounds(50, 69, 168, 33);
		frame.getContentPane().add(textIngresarPalabra);
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.setBackground(Color.WHITE);
		frame.setBounds(350, 150, 783, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
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

	private void cambiarColorIntentos() {
		if(juego.getIntentos()<=3) {
			textIntentos.setForeground(Color.RED);
			cantidadDeIntentos.setForeground(Color.RED);
		}
			
		else {
			textIntentos.setForeground(Color.black);
			cantidadDeIntentos.setForeground(Color.black);
			
		}
	}
	
	private void resetearJuegoYDiseño() {
		juego.resetearJuego();
		cantidadDeIntentos.setText(Integer.toString(juego.getIntentos()));
		PuntajeCant.setText(Integer.toString(juego.getPuntaje()));
		excepcion5Letras.setVisible(false);
		cambiarColorIntentos();
	}

	private void ganarJuego() {

		if (juego.getPuntaje() >= 50) {

			int opcion = JOptionPane.showConfirmDialog(frame, "�Ganaste!, �Desea seguir jugando?", "",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

			if (opcion == 0) {
				resetearJuegoYDiseño();
			}

			if (opcion == 1) {
				System.exit(0);
			}
		}
	}

	private void perderJuego() {
		int opcion = JOptionPane.showConfirmDialog(frame, "�Game Over!, �Desea seguir jugando?", "",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);

		if (opcion == 0) {
			cambiarColor();
			resetearJuegoYDiseño();

		}
		if (opcion == 1 || opcion == -1) {
			System.exit(0);
		}
	}
	
	
	
}
