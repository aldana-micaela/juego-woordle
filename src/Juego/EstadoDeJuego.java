package Juego;

import java.util.ArrayList;
import java.util.Random;

public class EstadoDeJuego {
	
	private String[] palabras = { "orden", "joven", "botas", "calma", "palma", "jugar", "apodo", "dulce", "vocal",
			"barco", "regla", "taller", "nadar", "torta", "atomo", "boton", "libro", "cielo", "falso",
			"carne", "falta", "fuego", "pluma", "tucan", "gatos", "fruta", "poste", "mesas", "motos", "tecla"};

	private String palabra;
	private char[] palabraSecreta;
	private ArrayList<String> letrasAdivinadasEnPosicionCorrecta;
	private ArrayList<String> letrasEnPosicionIncorrecta;
	private ArrayList<String> palabrasIngresadas;	
	private int puntaje;
	private int intentos;
	public EstadoDeJuego() {

		this.palabra = elegirPalabra();
		this.palabraSecreta = palabraSecreta;
		this.letrasAdivinadasEnPosicionCorrecta = new ArrayList<String>();
		this.letrasEnPosicionIncorrecta = new ArrayList<String>();
		this.palabrasIngresadas = new ArrayList<String>();
		this.puntaje = 0;
		this.intentos = 6;
	}


	private String elegirPalabra() {
		Random random = new Random();
		int elem = random.nextInt(this.palabras.length);
		return this.palabras[elem];
	}
	

}
