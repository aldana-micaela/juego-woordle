package Juego;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.text.StyledDocument;

public class EstadoDeJuego {
	
	private String[] palabras = { "orden", "joven", "botas", "calma", "palma", "jugar", "apodo", "dulce", "vocal",
			"barco", "regla", "letra", "nadar", "torta", "atomo", "boton", "libro", "cielo", "falso",
			"carne", "falta", "fuego", "pluma", "tucan", "gatos", "fruta", "poste", "mesas", "motos", "tecla"};

	public String palabra;
//	private char[] palabraSecreta;
//	private ArrayList<String> letrasAdivinadasEnPosicionCorrecta;
//	private ArrayList<String> letrasEnPosicionIncorrecta;
//	private ArrayList<String> palabrasIngresadas;	
	
	private ArrayList<Integer> letras;
	private int puntaje;
	private int intentos;
//	private boolean gano;
	
	
	public EstadoDeJuego() {

		this.palabra = elegirPalabra();
//		this.palabraSecreta = palabraSecreta;
//		this.letrasAdivinadasEnPosicionCorrecta = new ArrayList<String>();
//		this.letrasEnPosicionIncorrecta = new ArrayList<String>();
//		this.palabrasIngresadas = new ArrayList<String>();
		this.puntaje=0;
		this.intentos = 6;
//		this.gano=false;
//		
		
		this.letras = new ArrayList<Integer>();
	}


	private String elegirPalabra() {
		Random random = new Random();
		int elem = random.nextInt(this.palabras.length);
		return this.palabras[elem];
	}
	
	
	
	public void limpiarArregloDeNumeros() {
		letras.clear();
	}
	
	public int obtenerNumero(int i) {
		return letras.get(i);
	}
	
	
	
	private boolean estaLaLetraEnLaPalabra(char letra) {
		
		for (int i = 0; i <palabra.length();i++) {
			if (palabra.charAt(i) == letra) {
				return true;
			}
		}
		return false;
	}
	
	
	public void verificarPalabra(String palabraUSER) {
				
			for(int i = 0; i<palabra.length(); i++) {
				
				if(palabraUSER.charAt(i) == palabra.charAt(i)) {
					letras.add(i, 1);
				}
				
				else if(estaLaLetraEnLaPalabra(palabraUSER.charAt(i))) {
					letras.add(i, 2);
				}
				
				else {
					letras.add(i, 0);
				}
				
			}
	}
			public void cambiarPalabra() {
				String viejaPalabra = this.palabra;
				String nuevaPalabra = elegirPalabra();

				while (nuevaPalabra == viejaPalabra)
					nuevaPalabra = elegirPalabra();

				
				this.palabra = nuevaPalabra;
				
			}
	
			public void cambiarASiguientePalabra() {
				cambiarPalabra();
				restablecerIntentos();	
			}

			
			private void restablecerIntentos() {
			
					this.intentos = 0;
				}

			public boolean adivinoPalabra(String p) {
				if(p.equals(this.palabra)) {
					sumarPuntaje();
					return true;
				}
				return false;
			}


			public String getPuntaje() {
				// TODO Auto-generated method stub
				return this.puntaje + "";
			}


			public void sumarPuntaje() {
				this.puntaje=+5;
				
			}


			public String getpalabra() {
				// TODO Auto-generated method stub
				return palabra;
			}
			
			public void quitarIntentos() {
				if (this.intentos > 0) {
					this.intentos--;
				}
			}


			public String getIntentos() {
				// TODO Auto-generated method stub
				return this.intentos + "";
			}


			public int IntentosCero() {
				// TODO Auto-generated method stub
				return this.intentos;
			}


}
