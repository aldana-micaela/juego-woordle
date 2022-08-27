package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuInterface {

	private JFrame frame;

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
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBackground(new Color(139, 0, 139));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Juego
		crearBotonIniciarJuego();
		
		JLabel lblNewLabel = new JLabel("Men\u00FA Principal");
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 23));
		lblNewLabel.setBounds(126, 0, 206, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Imagen = new JLabel("");
		Imagen.setIcon(new ImageIcon(MenuInterface.class.getResource("/Img/wordle-logo2.png")));
		Imagen.setBounds(10, -34, 434, 335);
		frame.getContentPane().add(Imagen);

	}
	
	private void crearBotonIniciarJuego() {
		JButton btnIniciarJuego = new JButton("Jugar");
		btnIniciarJuego.setBackground(Color.GREEN);
		btnIniciarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JuegoInterface();
				frame.setVisible(false);
			}
		});
		btnIniciarJuego.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnIniciarJuego.setBounds(160, 224, 117, 26);
		frame.getContentPane().add(btnIniciarJuego);
	}
}
