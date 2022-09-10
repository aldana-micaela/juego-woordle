package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.*;

import Interface.MenuInterface.Dificultad;
import Interface.MenuInterface.Idioma;
import Juego.EstadoDeJuego;
import Juego.EstadoDeJuego.EstadoDeLetras;

public class WordleTest {

	EstadoDeJuego wordleTest;
	
	@Test
	public void sumarPuntajeTest() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		wordleTest=new EstadoDeJuego(id, dif);
		
		wordleTest.cambiarPalabra();
		String palabra= wordleTest.getpalabra();
		
		assertTrue(wordleTest.adivinoPalabra(palabra));
	}

	@Test
	public void LimpiarEstadoDeLetrasTest() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		
		ArrayList<Integer> p= new ArrayList<Integer>(1);
		wordleTest=new EstadoDeJuego(id, dif);
		wordleTest.cambiarPalabra();
		wordleTest.limpiarArregloDeNumeros();
		p.clear();
		assertEquals(p,wordleTest.getestadoDeLetras());
	}
	
	
	@Test 
	public void verDificultadFacil() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Fácil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		wordleTest.cambiarDificultad(dif);
		assertEquals(8, wordleTest.getIntentos());
		
	}
	
	@Test 
	public void verDificultadNormal() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		wordleTest= new EstadoDeJuego(id, dif);
		
		wordleTest.cambiarDificultad(dif);
		assertEquals(6, wordleTest.getIntentos());
		
	}

	@Test 
	public void verDificultadDificil() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		wordleTest.cambiarDificultad(dif);
		assertEquals(4, wordleTest.getIntentos());
		
	}
	
	
	@Test
	public void verSiNoSeRepitenPalabrasEnElConjunto() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		Set<String> conjuntoDePalabrasUsadas= wordleTest.getPalabrasEnJuego();
		String palabra= wordleTest.elegirPalabra();
		
		assertFalse(conjuntoDePalabrasUsadas.contains(palabra));
		
	}
	
	  @Test 
	  public void verIdiomaIngles() {
			Idioma id= Idioma.Inglés;
			Dificultad dif= Dificultad.Difícil;
			wordleTest= new EstadoDeJuego(id, dif);
			
			assertNull(wordleTest.getPalabrasEspañolMap());
			assertFalse(wordleTest.getPalabrasInglesMap().isEmpty());
		  
	  }
	
	  @Test 
	  public void verIdiomaEspañol() {
		  Idioma id= Idioma.Español;
		  Dificultad dif= Dificultad.Difícil;
		  wordleTest= new EstadoDeJuego(id, dif);
		  
		  assertNull(wordleTest.getPalabrasInglesMap());
		  assertFalse(wordleTest.getPalabrasEspañolMap().isEmpty());
		  
	  }
	
	@Test
	public void ver_Si_Se_Agrega_La_Palabra () {
		Idioma id = Idioma.Español;
		Dificultad dif = Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		String palabra = wordleTest.getpalabra();
		wordleTest.agregarPalabraAlConjunto();
		Set<String> conjuntoDePalabrasUsadas= wordleTest.getPalabrasEnJuego();
		
		assertTrue(conjuntoDePalabrasUsadas.contains(palabra));
	}
	
	
	@Test
	public void ver_si_verifica_bien_las_letras() {
		Idioma id = Idioma.Español;
		Dificultad dif = Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		String palabraUser= wordleTest.getpalabra();
		
		ArrayList <EstadoDeLetras> estLetras= new ArrayList <EstadoDeLetras>();
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		
		wordleTest.verificarPalabra(palabraUser);
		
		assertEquals(wordleTest.getestadoDeLetras(), estLetras);
		
	}
	
	
	public void ver_si_verifica_bien_las_letra() {
		Idioma id = Idioma.Español;
		Dificultad dif = Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		String palabraUser= "aaaaa";
		
		ArrayList <EstadoDeLetras> estLetras= new ArrayList <EstadoDeLetras>();
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		estLetras.add(EstadoDeLetras.Acertado);
		
		wordleTest.verificarPalabra(palabraUser);
		
		assertNotEquals(wordleTest.getestadoDeLetras(), estLetras);
		
	}
	
	
	@Test
	public void ver_si_se_obtiene_el_estado_correcto_de_la_letra() {
		Idioma id = Idioma.Español;
		Dificultad dif = Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		String palabraUser= "12345";
		wordleTest.verificarPalabra(palabraUser);
		assertEquals(EstadoDeLetras.NOacertado.name(), wordleTest.obtenerEstadoLetras(4));
		
	}
	
	@Test
	public void ver_si_se_obtiene_el_estado_INcorrecto_de_la_letra() {
		Idioma id = Idioma.Español;
		Dificultad dif = Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		String palabraUser= wordleTest.getpalabra();
		wordleTest.verificarPalabra(palabraUser);
		assertEquals(EstadoDeLetras.Acertado.name(), wordleTest.obtenerEstadoLetras(4));
		
	}
	
	
	@Test
	public void ver_la_verificacion_de_si_esta_la_letra_en_la_palabra() {
		Idioma id = Idioma.Español;
		Dificultad dif = Dificultad.Difícil;
		wordleTest= new EstadoDeJuego(id, dif);
		
		assertFalse(wordleTest.estaLaLetraEnLaPalabra('1'));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
