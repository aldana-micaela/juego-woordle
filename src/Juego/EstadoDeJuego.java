package Juego;

import java.util.ArrayList;

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


}
