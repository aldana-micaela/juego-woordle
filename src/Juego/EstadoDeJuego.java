package Juego;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class EstadoDeJuego {
	
	
//	private String[] palabras = { "orden", "joven", "botas"}; 				// lo hice mas corto para probar los casos de ganar!
	
	private String[] palabras = { "orden", "joven", "botas", "calma", "palma", "jugar", "apodo", "dulce", "vocal",
			"barco", "regla", "letra", "nadar", "torta", "atomo", "boton", "libro", "cielo", "falso",
			"carne", "falta", "fuego", "pluma", "tucan", "gatos", "fruta", "poste", "mesas", "motos", "tecla"};
	
	
	private String[] palabrasingles = {"beach", "hairs","queen","apple", "banks", "sleep", "house", "snake","lives", 
			"river", "cards", "tools", "dance" };
	private Set<String> palabrasEnJuego= new HashSet<String>();

	private String palabra;
//	private char[] palabraSecreta;
//	private ArrayList<String> letrasAdivinadasEnPosicionCorrecta;
//	private ArrayList<String> letrasEnPosicionIncorrecta;
//	private ArrayList<String> palabrasIngresadas;	
	
	private ArrayList<Integer> estadoDeLetrasEnNumeros;      // hice un cunjunto de palabras para que no se repitan e ir agregando las palabras que se usaron
	private int puntaje;
	private int intentos;
//	private boolean gano;
	private String dificultad;
	
	
	public EstadoDeJuego() {

		this.palabra = elegirPalabra();
//		this.palabraSecreta = palabraSecreta;
//		this.letrasAdivinadasEnPosicionCorrecta = new ArrayList<String>();
//		this.letrasEnPosicionIncorrecta = new ArrayList<String>();
//		this.palabrasIngresadas = new ArrayList<String>();
		this.puntaje=0;
		this.intentos = 6;
//		this.gano=false;
		this.dificultad= "Normal";
		this.estadoDeLetrasEnNumeros = new ArrayList<Integer>();
	}


	private String elegirPalabra() {
		Random random = new Random();
		int elem = random.nextInt(this.palabras.length);
		
		
		while(palabrasEnJuego.contains(palabras[elem]) && !palabrasEnJuego.isEmpty())   // este while verifica que no se jueguen palabras repetidas
			elem = random.nextInt(this.palabras.length);
		
		//palabrasEnJuego.add(palabras[elem]);
		return this.palabras[elem];
	}
	
	
	public void adivinoPalabra() {
		palabrasEnJuego.add(palabra);
		
	}
	
	
	public void limpiarArregloDeNumeros() {
		estadoDeLetrasEnNumeros.clear();
	}
	
	public int obtenerNumero(int i) {
		return estadoDeLetrasEnNumeros.get(i);
	}
	
	
	public void vaciarConjuntoDePalabras() {
		palabrasEnJuego.clear();
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
					estadoDeLetrasEnNumeros.add(i, 1);
				}
				
				else if(estaLaLetraEnLaPalabra(palabraUSER.charAt(i))) {
					estadoDeLetrasEnNumeros.add(i, 2);
				}
				
				else {
					estadoDeLetrasEnNumeros.add(i, 0);
				}
				
			}
	}
			public void cambiarPalabra() {
//				String viejaPalabra = this.palabra;			//verifique que las palabras no se repitan en el while del metodo elegirPalabra()
//				String nuevaPalabra = elegirPalabra();
//
//				while (nuevaPalabra == viejaPalabra)
//					nuevaPalabra = elegirPalabra();
//				
//				this.palabra = nuevaPalabra;
//				
				this.palabra=elegirPalabra();
			}
	
			public void cambiarASiguientePalabra() {
				cambiarPalabra();
				restablecerIntentos();	
			}

			
			private void restablecerIntentos() {
			
					this.intentos = 6;
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

			public int Puntaje() {
				// TODO Auto-generated method stub
				return this.puntaje;
			}

			public void sumarPuntaje() {
				this.puntaje= this.puntaje + 5;
				
				
			}
			
			public void restarPuntaje() {
				this.puntaje--;
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
			
			
			public boolean ganaste () {
				return palabras.length == palabrasEnJuego.size();
			}
			
			

			public void resetearJuego() {
				vaciarConjuntoDePalabras();
				cambiarPalabra();
				restablecerIntentos();
				puntaje= 0;
				
			}
			
			public  void cambiarDificultad(String dificultad) {
				if (dificultad.equals("Fácil")) {
					this.dificultad = dificultad;
					this.intentos = 8;
				}
				if (dificultad.equals("Difícil")) {
					this.dificultad = dificultad;
					this.intentos = 4;
				}
			}


			public String getDificultad() {
				// TODO Auto-generated method stub
				return this.dificultad;
			}
			
			public void setIdiomaIngles() {
				this.palabras = this.palabrasingles;
				cambiarPalabra();
			}


			public String setIdioma() {
				// TODO Auto-generated method stub
				return this.setIdioma();
			}



}
