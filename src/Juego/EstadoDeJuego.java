package Juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import Interface.MenuInterface.Dificultad;
import Interface.MenuInterface.Idioma;

public class EstadoDeJuego {

	private String[] palabrasEspañol = { "orden", "joven", "botas", "calma", "palma", "jugar", "apodo", "dulce",
			"vocal", "barco", "regla", "letra", "nadar", "torta", "atomo", "boton", "libro", "cielo", "falso", "carne",
			"falta", "fuego", "pluma", "tucan", "gatos", "fruta", "poste", "mesas", "motos", "tecla" };

	private String[] palabrasIngles = { "beach", "hairs", "queen", "apple", "banks", "sleep", "house", "snake", "alive",
			"river", "cards", "tools", "dance" };

	private Map<String, String> palabrasEspañolMap;
	private Map<String, String> palabrasInglesMap;
	private Set<String> palabrasEnJuego = new HashSet<String>(); 
	

	public enum EstadoDeLetras {Acertado, NOacertado, LetraEnOtraPosicion}
	private EstadoDeLetras acertado = EstadoDeLetras.Acertado;
	private EstadoDeLetras noAcertado = EstadoDeLetras.NOacertado;
	private EstadoDeLetras letraEnOtraPosicion = EstadoDeLetras.LetraEnOtraPosicion;
	private ArrayList<EstadoDeLetras> estadoDeLetras;
	
	private Idioma idioma;
	private Dificultad dificultad;
	
	private String pista;
	private String[] palabrasAux;
	private String palabraSecreta;
	
	private int puntaje;
	private int intentos;
	private int intentosDePista;
	private int intentosDeAyuda;

	public EstadoDeJuego(Idioma idioma, Dificultad dificultad) {

		if (idioma.name().equals("Espa�ol")) {
			this.palabrasAux = palabrasEspañol;
			agregarPalabrasEspañol();
			
		} else {
			this.palabrasAux = palabrasIngles;
			agregarPalabrasIngles();

		}

		this.idioma= idioma;
		this.puntaje = 0;
		this.dificultad=dificultad;
		cambiarDificultad(dificultad);
		this.estadoDeLetras = new ArrayList<EstadoDeLetras>();
		this.intentosDePista = 3;
		this.intentosDeAyuda = 1;

	}

	private void agregarPalabrasEspañol() {
		palabrasEspañolMap = new HashMap<String, String>();

		palabrasEspañolMap.put("orden", "A las personas con TOC les gusta el...");
		palabrasEspañolMap.put("joven", "Alguien menor de 50 a�os es...");
		palabrasEspañolMap.put("botas", "Calazado de pies.");
		palabrasEspañolMap.put("calma", "En la playa hay...");
		palabrasEspañolMap.put("palma", "Est� en el centro y tiene 5 dedos.");
		palabrasEspañolMap.put("jugar", "Actividad que a los chicos les encanta.");
		palabrasEspañolMap.put("apodo", "Abreviatura con la que llaman a alguien.");
		palabrasEspañolMap.put("dulce", "El chocolate es...");
		palabrasEspañolMap.put("vocal", "aeiou.");
		palabrasEspañolMap.put("barco", "Pedazo de metal sobre el mar.");
		palabrasEspañolMap.put("regla", "Algo que es recto.");
		palabrasEspañolMap.put("letra", "Algo que se escribe.");
		palabrasEspañolMap.put("nadar", "En lo hondo del mar me cuesta...");
		palabrasEspañolMap.put("torta", "Est� presente en los cumplea�os.");
		palabrasEspañolMap.put("atomo", "Es invisible para el ojo humano.");
		palabrasEspañolMap.put("boton", "Se apreta.");
		palabrasEspañolMap.put("libro", "Se lee un...");
		palabrasEspañolMap.put("cielo", "Tiene nubes.");
		palabrasEspañolMap.put("falso", "Tengo un billete...");
		palabrasEspañolMap.put("carne", "Lo que no comen los vegetarianos.");
		palabrasEspañolMap.put("falta", "Hecho de no haber aquello que se indica.");
		palabrasEspañolMap.put("fuego", "Te lastima si lo tocas.");
		palabrasEspañolMap.put("pluma", "Con lo que vuelan los pist�cidos.");
		palabrasEspañolMap.put("tucan", "Pist�cido con pico muy largo.");
		palabrasEspañolMap.put("gatos", "Animales dom�sticos primos de los leones.");
		palabrasEspañolMap.put("fruta", "Comida que nos proporciona la tierra.");
		palabrasEspañolMap.put("poste", "Palos de luz.");
		palabrasEspañolMap.put("mesas", "Espacios donde se apoya la comida.");
		palabrasEspañolMap.put("motos", "A los motoqueros les gusta las...");
		palabrasEspañolMap.put("tecla", "Elemento de una computadora.");
	
		this.palabraSecreta = elegirPalabra();
		this.pista = palabrasEspañolMap.get(this.palabraSecreta);

	}

	private void agregarPalabrasIngles() {
		palabrasInglesMap = new HashMap<String, String>();

		palabrasInglesMap.put("beach", "stretch of sand with sea water.");
		palabrasInglesMap.put("hairs", "Flexible filament that develops in the skin of humans and animals.");
		palabrasInglesMap.put("queen", "Woman with a real power.");
		palabrasInglesMap.put("apple", "Fruit, can be red or green");
		palabrasInglesMap.put("banks", "Save people's money");
		palabrasInglesMap.put("sleep", "Rest with eyes closed.");
		palabrasInglesMap.put("house", "A place that belongs to me.");
		palabrasInglesMap.put("snake", "The bite of this reptile can kill you.");
		palabrasInglesMap.put("alive", "Something that is not dead");
		palabrasInglesMap.put("river", "Natural current of water.");
		palabrasInglesMap.put("cards", "A table Games.");
		palabrasInglesMap.put("tools", "Instrument, used to make or repair something.");
		palabrasInglesMap.put("dance", "Move the body and limbs rhythmically following the beat of a piece of music.");
		
		this.palabraSecreta = elegirPalabra();
		this.pista = palabrasInglesMap.get(this.palabraSecreta);

	}

	public void cambiarDificultad(Dificultad dif) {
		
		if (dif.name().equals("F�cil")) {
			this.intentos = 8;
		}
		if (dif.name().equals("Normal")) {
			this.intentos = 6;
		}
		if (dif.name().equals("Dif�cil")) {
			this.intentos = 4;
		}
	}

	public String elegirPalabra() {
		Random random = new Random();

		int elem = random.nextInt(this.palabrasAux.length);

		while (palabrasEnJuego.contains(palabrasAux[elem]) && !palabrasEnJuego.isEmpty())
			elem = random.nextInt(this.palabrasAux.length);

		return this.palabrasAux[elem];
	}

	public void agregarPalabraAlConjunto() {
		palabrasEnJuego.add(palabraSecreta);

	}

	public void limpiarArregloDeNumeros() {
		estadoDeLetras.clear();
	}

	public String obtenerEstadoLetras(int i) {
		return estadoDeLetras.get(i).name();
	}

	public void vaciarConjuntoDePalabras() {
		palabrasEnJuego.clear();
	}

	public boolean estaLaLetraEnLaPalabra(char letra) {

		for (int i = 0; i < palabraSecreta.length(); i++) {
			if (palabraSecreta.charAt(i) == letra) {
				return true;
			}
		}
		return false;
	}

	public void verificarPalabra(String palabraUSER) {

		for (int i = 0; i < palabraSecreta.length(); i++) {

			if (palabraUSER.charAt(i) == palabraSecreta.charAt(i)) {
				estadoDeLetras.add(i, acertado);
			}

			else if (estaLaLetraEnLaPalabra(palabraUSER.charAt(i))) {
				estadoDeLetras.add(i, letraEnOtraPosicion);
			}

			else {
				estadoDeLetras.add(i, noAcertado);
			}

		}
	}

	public void cambiarPalabra() {
		this.palabraSecreta = elegirPalabra();
		
		if(this.idioma.name().equals("Espa�ol"))
			this.pista = palabrasEspañolMap.get(this.palabraSecreta);
		else
			this.pista = palabrasInglesMap.get(this.palabraSecreta);
	}
	
	public boolean adivinoPalabra(String p) {
		return p.equals(this.palabraSecreta);
	}

	public void sumarPuntaje() {
		this.puntaje += 10;

	}
	
	public void sumarPuntajeParaBTNayuda() {
		this.puntaje += 5;
	}

	public void restarPuntaje() {
		this.puntaje -= 5;
	}

	public boolean ganaste() {
		return palabrasAux.length == palabrasEnJuego.size();
	}

	public void resetearJuego() {
		vaciarConjuntoDePalabras();
		cambiarPalabra();
		cambiarDificultad(dificultad);
		puntaje = 0;

	}

	public void restarIntentosAyuda() {
		this.intentosDeAyuda--;
	}
	
	public void restarIntentosPista() {
		this.intentosDePista--;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public int getIntentos() {
		return this.intentos;
	}
	
	public int getIntentosAyuda() {
		return this.intentosDeAyuda;
	}
	
	public int getIntentosPista() {
		return this.intentosDePista;
	}

	public ArrayList<EstadoDeLetras> getestadoDeLetras() {

		return estadoDeLetras;
	}

	public String getDificultad() {
		return this.dificultad.name();
	}
	
	public String getpalabra() {
		return palabraSecreta;
	}
	
	public String getPista() {
		return this.pista;

	}
		
	public void quitarIntentos() {
		if (this.intentos > 0) {
			this.intentos--;
		}
	}
	
	public String getAcertado() {
		return acertado.name();
	}

	public String getNoAcertado() {
		return noAcertado.name();
	}

	public String getLetraEnOtraPosicion() {
		return letraEnOtraPosicion.name();
	}

	public Set<String> getPalabrasEnJuego() {
		return palabrasEnJuego;
	}
	
	public Map<String, String> getPalabrasEspañolMap() {
		return palabrasEspañolMap;
	}

	public Map<String, String> getPalabrasInglesMap() {
		return palabrasInglesMap;
	}
	
	
}
