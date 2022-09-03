package Juego;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class EstadoDeJuego {
	
//	private String[] palabras = { "orden", "joven", "botas"}; 				// lo hice mas corto para probar los casos de ganar!
	
	private String[] palabrasEspañol = { "orden", "joven", "botas", "calma", "palma", "jugar", "apodo", "dulce", "vocal",
			"barco", "regla", "letra", "nadar", "torta", "atomo", "boton", "libro", "cielo", "falso",
			"carne", "falta", "fuego", "pluma", "tucan", "gatos", "fruta", "poste", "mesas", "motos", "tecla"};
	
	
	private String[] palabrasingles = {"beach", "hairs","queen","apple", "banks", "sleep", "house", "snake","lives", 
			"river", "cards", "tools", "dance" };
	
	private String[] palabrasAux;
	private Set<String> palabrasEnJuego= new HashSet<String>();		// hice un cunjunto de palabras para que no se repitan e ir agregando las palabras que se usaron
	private String palabra;	
	private ArrayList<Integer> estadoDeLetrasEnNumeros;      
	private int puntaje;
	private int intentos;
//	private String dificultad;
	private int intentosDeAyuda;
	
	
	public EstadoDeJuego(int idioma) {

		if(idioma==0) {
			this.palabrasAux= palabrasEspañol;
		}
		else {
			this.palabrasAux = palabrasingles;
		}
		
		this.palabra = elegirPalabra();
		this.puntaje=0;
		this.intentos = 6;
//		this.dificultad= "Normal";
		this.estadoDeLetrasEnNumeros = new ArrayList<Integer>();
		this.intentosDeAyuda=3;
		
			
	}


	private String elegirPalabra() {
		Random random = new Random();
		
		int	elem = random.nextInt(this.palabrasAux.length);
		
		while(palabrasEnJuego.contains(palabrasAux[elem]) && !palabrasEnJuego.isEmpty())   // este while verifica que no se jueguen palabras repetidas
			elem = random.nextInt(this.palabrasAux.length);
		
		return this.palabrasAux[elem];
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
					return p.equals(this.palabra);
			}


			public String getPuntaje() {
				return this.puntaje + "";
			}

			public int Puntaje() {
				return this.puntaje;
			}

			public void sumarPuntaje() {
				this.puntaje += 10;
				
				
			}
			
			public void restarPuntaje() {
				this.puntaje-=5;
			}
			


			public String getpalabra() {
				return palabra;
			}
			
			public void quitarIntentos() {
				if (this.intentos > 0) {
					this.intentos--;
				}
			}


			public String getIntentos() {
				return this.intentos + "";
			}


			public int IntentosCero() {
				return this.intentos;
			}
			
			
			public boolean ganaste () {
				return palabrasAux.length == palabrasEnJuego.size();
			}
			
			

			public void resetearJuego() {
				vaciarConjuntoDePalabras();
				cambiarPalabra();
				restablecerIntentos();
				puntaje= 0;
				
			}
			
//			public  void cambiarDificultad(String dificultad) {
//				if (dificultad.equals("Fácil")) {
//					this.dificultad = dificultad;
//					this.intentos = 8;
//				}
//				if (dificultad.equals("Difícil")) {
//					this.dificultad = dificultad;
//					this.intentos = 4;
//				}
//			}
//
//
//			public String getDificultad() {
//				return this.dificultad;
//			}
//			
			public void restarIntentosAyuda() {
				this.intentosDeAyuda--;
			}
			
			public int getIntentosAyuda() {
				return this.intentosDeAyuda;
			}


			public ArrayList<Integer> getestadoDeLetrasEnNumeros() {
				// TODO Auto-generated method stub
				return estadoDeLetrasEnNumeros;
			}




}
