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
import javax.swing.JPanel;


public class MenuInterface {

	private JFrame frame;
	JButton btnIniciarJuego;
	JLabel lblNewLabel;
	JLabel Imagen;
	JPanel panel;
	private JComboBox<String> idiomaComboBox;
	private JComboBox<String> difComboBox;
	private int idioma;
	private int dificultad;


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
		
	
	}
	
	private void crearMenu() {
		crearFrame();
		crearTitulo_MenuPrincipal();
		crearBtn_IniciarJuego();
		crearIdiomaComboBox();
	    crearIDificultadComboBox();
		ponerImagenDeFondo();
		
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void ponerImagenDeFondo() {
		Imagen = new JLabel();
		Imagen.setIcon(new ImageIcon(MenuInterface.class.getResource("/Img/wordle-logo2.png")));
		Imagen.setBounds(10, -28, 434, 335);
		frame.getContentPane().add(Imagen);
	}

	private void crearBtn_IniciarJuego() {
		btnIniciarJuego = new JButton("Jugar");
		btnIniciarJuego.setBounds(160, 224, 117, 26);
		btnIniciarJuego.setBackground(Color.GREEN);
		btnIniciarJuego.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().add(btnIniciarJuego);
	}

	private void crearTitulo_MenuPrincipal() {
		lblNewLabel = new JLabel("Men\u00FA Principal");
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 23));
		lblNewLabel.setBounds(126, 0, 206, 30);
		frame.getContentPane().add(lblNewLabel);
	}

	private void eventoBotonIniciarJuego() {
		btnIniciarJuego.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				idioma= idiomaComboBox.getSelectedIndex();
				dificultad = difComboBox.getSelectedIndex();	
				new JuegoInterface(idioma, dificultad);
				
			}
		});
	}
	private void crearIdiomaComboBox() {
	
		idiomaComboBox = new JComboBox<String>();
		idiomaComboBox.setBounds(160, 41, 117, 22);
		frame.getContentPane().add(idiomaComboBox);
		idiomaComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Espa�ol", "Ingles" }));
	}

	
	public int getIdioma() {
		return idioma;
	}

	private void crearIDificultadComboBox() {
		
		difComboBox = new JComboBox<String>();
		difComboBox.setBounds(160, 176, 109, 22);
		frame.getContentPane().add(difComboBox);
		difComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"F�cil", "Normal", "Dif�cil" }));
	}

	
	public int getDificultad() {
		return dificultad;
	}

}
