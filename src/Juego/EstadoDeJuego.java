package Juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class EstadoDeJuego {

//	private String[] palabras = { "orden", "joven", "botas"}; 				// lo hice mas corto para probar los casos de ganar!

	private String[] palabrasEspañol = { "orden", "joven", "botas", "calma", "palma", "jugar", "apodo", "dulce",
			"vocal", "barco", "regla", "letra", "nadar", "torta", "atomo", "boton", "libro", "cielo", "falso", "carne",
			"falta", "fuego", "pluma", "tucan", "gatos", "fruta", "poste", "mesas", "motos", "tecla" };

	private String[] palabrasIngles = { "beach", "hairs", "queen", "apple", "banks", "sleep", "house", "snake", "lives",
			"river", "cards", "tools", "dance" };

	private Map<String, String> palabrasEspañolMap;
	private Map<String, String> palabrasInglesMap;
	private Set<String> palabrasEnJuego = new HashSet<String>(); // hice un cunjunto de palabras para que no se repitan
																	// e ir agregando las palabras que se usaron
	private String valor;
	private String[] palabrasAux;
	private String palabra;
	private ArrayList<Integer> estadoDeLetrasEnNumeros;
	private int puntaje;
	private int intentos;
	private String dificultad;
	private int intentosDePista;
	private int intentosDeAyuda;
	private int idioma;

	public EstadoDeJuego(int idioma, int dificultad) {

		if (idioma == 0) {
			this.palabrasAux = palabrasEspañol;
			agregarPalabrasEspañol();
			
		} else {
			this.palabrasAux = palabrasIngles;
			agregarPalabrasIngles();

		}

		this.idioma= idioma;
		this.puntaje = 0;
		this.intentos = 6;
		this.dificultad = cambiarDificultad(dificultad);
		this.estadoDeLetrasEnNumeros = new ArrayList<Integer>();
		this.intentosDePista = 3;
		this.intentosDeAyuda = 1;

	}

	private void agregarPalabrasEspañol() {
		palabrasEspañolMap = new HashMap<String, String>();

		palabrasEspañolMap.put("orden", "A las personas con TOC les gusta el...");
		palabrasEspañolMap.put("joven", "Alguien menor de 50 años.");
		palabrasEspañolMap.put("botas", "Calazado de pies.");
		palabrasEspañolMap.put("calma", "En la playa hay...");
		palabrasEspañolMap.put("palma", "Está en el centro y tiene 5 dedos.");
		palabrasEspañolMap.put("jugar", "Actividad que a los chicos les encanta.");
		palabrasEspañolMap.put("apodo", "Abreviatura con la que llaman a alguien.");
		palabrasEspañolMap.put("dulce", "El chocolate es...");
		palabrasEspañolMap.put("vocal", "aeiou.");
		palabrasEspañolMap.put("barco", "Pedazo de metal sobre el mar.");
		palabrasEspañolMap.put("regla", "Algo que es recto.");
		palabrasEspañolMap.put("letra", "Algo que se escribe.");
		palabrasEspañolMap.put("nadar", "En lo hondo del mar me cuesta...");
		palabrasEspañolMap.put("torta", "Está presente en los cumpleaños.");
		palabrasEspañolMap.put("atomo", "Es invisible para el ojo humano.");
		palabrasEspañolMap.put("boton", "Se apreta.");
		palabrasEspañolMap.put("libro", "Se lee un...");
		palabrasEspañolMap.put("cielo", "Tiene nubes.");
		palabrasEspañolMap.put("falso", "Tengo un billete...");
		palabrasEspañolMap.put("carne", "Lo que no comen los vegetarianos.");
		palabrasEspañolMap.put("falta", "Hecho de no haber aquello que se indica.");
		palabrasEspañolMap.put("fuego", "Te lastima si lo tocas.");
		palabrasEspañolMap.put("pluma", "Con lo que vuelan los pistácidos.");
		palabrasEspañolMap.put("tucan", "Pistácido con pico muy largo.");
		palabrasEspañolMap.put("gatos", "Animales domésticos primos de los leones.");
		palabrasEspañolMap.put("fruta", "Comida que nos proporciona la tierra.");
		palabrasEspañolMap.put("poste", "Palos de luz.");
		palabrasEspañolMap.put("mesas", "Espacios donde se apoya la comida.");
		palabrasEspañolMap.put("motos", "A los motoqueros les gusta las...");
		palabrasEspañolMap.put("tecla", "Elemento de una computadora.");
		
		this.palabra = elegirPalabra();
		this.valor = palabrasEspañolMap.get(this.palabra);

	}

	private void agregarPalabrasIngles() {
		palabrasInglesMap = new HashMap<String, String>();

		palabrasInglesMap.put("beach", "...");
		palabrasInglesMap.put("hairs", "...");
		palabrasInglesMap.put("queen", "...");
		palabrasInglesMap.put("apple", "...");
		palabrasInglesMap.put("banks", "...");
		palabrasInglesMap.put("sleep", "...");
		palabrasInglesMap.put("house", "...");
		palabrasInglesMap.put("snake", "...");
		palabrasInglesMap.put("lives", "...");
		palabrasInglesMap.put("river", "...");
		palabrasInglesMap.put("cards", "...");
		palabrasInglesMap.put("tools", "...");
		palabrasInglesMap.put("dance", "...");
		
		this.palabra = elegirPalabra();
		this.valor = palabrasInglesMap.get(this.palabra);

	}

	public String getValor() {
		return this.valor;

	}

	private String cambiarDificultad(int dif) {
		String d = "";
		if (dif == 0) {
			this.intentos = 8;
			d = "Fácil";
		}
		if (dif == 1) {
			this.intentos = 6;
			d = "Normal";
		}
		if (dif == 2) {
			this.intentos = 4;
			d = "Difícil";
		}
		return d;
	}

	public String elegirPalabra() {
		Random random = new Random();

		int elem = random.nextInt(this.palabrasAux.length);

		while (palabrasEnJuego.contains(palabrasAux[elem]) && !palabrasEnJuego.isEmpty())
			elem = random.nextInt(this.palabrasAux.length);

		return this.palabrasAux[elem];
	}

	public void agregarPalabraAlConjunto() {
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

		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == letra) {
				return true;
			}
		}
		return false;
	}

	public void verificarPalabra(String palabraUSER) {

		for (int i = 0; i < palabra.length(); i++) {

			if (palabraUSER.charAt(i) == palabra.charAt(i)) {
				estadoDeLetrasEnNumeros.add(i, 1);
			}

			else if (estaLaLetraEnLaPalabra(palabraUSER.charAt(i))) {
				estadoDeLetrasEnNumeros.add(i, 2);
			}

			else {
				estadoDeLetrasEnNumeros.add(i, 0);
			}

		}
	}

	public void cambiarPalabra() {
		this.palabra = elegirPalabra();
		
		if(this.idioma==0)
			this.valor = palabrasEspañolMap.get(this.palabra);
		else
			this.valor = palabrasInglesMap.get(this.palabra);
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
		this.puntaje -= 5;
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

	public boolean ganaste() {
		return palabrasAux.length == palabrasEnJuego.size();
	}

	public void resetearJuego() {
		vaciarConjuntoDePalabras();
		cambiarPalabra();
		restablecerIntentos();
		puntaje = 0;

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
	public void restarIntentosPista() {
		this.intentosDePista--;
	}

	public int getIntentosAyuda() {
		return this.intentosDeAyuda;
	}
	public int getIntentosPista() {
		return this.intentosDePista;
	}

	public void jugar(String palabra) {
		if (adivinoPalabra(palabra)) {
			sumarPuntaje();
			agregarPalabraAlConjunto();
			elegirPalabra();

		} else {
			restarPuntaje();
			quitarIntentos();
		}

	}

	public ArrayList<Integer> getestadoDeLetrasEnNumeros() {

		return estadoDeLetrasEnNumeros;
	}

	public String[] getPalabrasEspañol() {
		return palabrasEspañol;
	}

	public String getDificultad() {
		return this.dificultad;
	}

}
