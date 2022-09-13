package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuInterface {

	private JFrame frame;
	private JButton btnIniciarJuego;
	private JButton btnReglas;
	private JLabel lblNewLabel;
	private JLabel Imagen;
	private JComboBox<String> idiomaComboBox;
	private JComboBox<String> difComboBox;
	
	public enum Idioma{Español, Inglés}
	public enum Dificultad {Fácil, Normal, Difícil}
	private Idioma idiomaSeleccionado=Idioma.Español;
	private Dificultad dificultadSeleccionada=Dificultad.Normal;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MenuInterface window = new MenuInterface();
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
	public MenuInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crearMenu();
		eventoBotonIniciarJuego();
		eventoBotonReglas();

	}

	private void crearMenu() {
		crearFrame();
		crearTitulo_MenuPrincipal();
		crearBtn_IniciarJuego();
		crearBtn_Reglas();
		crearIdiomaComboBox();
		crearIDificultadComboBox();
		ponerImagenDeFondo();

	}

	private void crearFrame() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(500, 200, 941, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
	}

	private void ponerImagenDeFondo() {
		Imagen = new JLabel();
		Imagen.setIcon(new ImageIcon(MenuInterface.class.getResource("/Img/wordle-word-27-may-2022-1024x576.jpg")));
		Imagen.setBounds(-67, -46, 1108, 530);
		frame.getContentPane().add(Imagen);

	}

	private void crearBtn_IniciarJuego() {
		btnIniciarJuego = new JButton("Jugar");
		btnIniciarJuego.setBounds(205, 389, 139, 37);
		btnIniciarJuego.setBackground(Color.GREEN);
		btnIniciarJuego.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().add(btnIniciarJuego);
	}

	private void crearBtn_Reglas() {
		btnReglas = new JButton("Reglas");
		btnReglas.setBounds(590, 389, 127, 37);
		btnReglas.setBackground(Color.GREEN);
		btnReglas.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().add(btnReglas);

	}

	private void crearTitulo_MenuPrincipal() {
		lblNewLabel = new JLabel("Men\u00FA Principal");
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 23));
		lblNewLabel.setBounds(371, 24, 206, 30);
		frame.getContentPane().add(lblNewLabel);
	}

	private void eventoBotonIniciarJuego() {
		btnIniciarJuego.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String id =(String) idiomaComboBox.getSelectedItem();
				String dif = (String) difComboBox.getSelectedItem();
				
				idiomaSeleccionado= Enum.valueOf(Idioma.class, id);
				dificultadSeleccionada= Enum.valueOf(Dificultad.class, dif);
				
				new JuegoInterface(idiomaSeleccionado, dificultadSeleccionada);

			}
		});
	}

	private void eventoBotonReglas() {
		btnReglas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(frame, "Reglas del juego:\n-Se debe adivinar la palabra en un lapso limitado de intentos.\n"
						+ "-El jugador cuenta con la opcion de usar el boton de pistas <?> 3 veces.\n"
						+ "-El jugador cuenta con una unica ayuda para adivinar la palabra.\n"
						+ "-El juego se podrá ganar despues de igualar o superar los 50 puntos");

			}
		});
	}

	private void crearIdiomaComboBox() {

		idiomaComboBox = new JComboBox<String>();
		idiomaComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idiomaComboBox.setBounds(405, 79, 117, 30);
		frame.getContentPane().add(idiomaComboBox);
		idiomaComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Español", "Inglés" }));
	}

	public Idioma getIdioma() {
		return idiomaSeleccionado;
	}

	private void crearIDificultadComboBox() {

		difComboBox = new JComboBox<String>();
		difComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		difComboBox.setBounds(387, 322, 139, 35);
		frame.getContentPane().add(difComboBox);
		difComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Fácil", "Normal", "Difícil" }));
	}

	public Dificultad getDificultad() {
		return dificultadSeleccionada;
	}

}
