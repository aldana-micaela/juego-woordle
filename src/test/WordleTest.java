package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import Interface.MenuInterface.Dificultad;
import Interface.MenuInterface.Idioma;
import Juego.EstadoDeJuego;

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
	public void LimpiarEstadoDeLetrasEnNumerosTest() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		
		ArrayList<Integer> p= new ArrayList<Integer>(1);
		wordleTest=new EstadoDeJuego(id, dif);
		wordleTest.cambiarPalabra();
		wordleTest.limpiarArregloDeNumeros();
		p.clear();
		assertEquals(p,wordleTest.getestadoDeLetrasEnNumeros());
	}
	
	@Test
	public void restarIntentos() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		wordleTest=new EstadoDeJuego(id, dif);
//		String palabra=wordleTest.elegirPalabra();
		wordleTest.jugar("asdfg");
		assertEquals("5", wordleTest.getIntentos());
		}
	
	@Test
	public void sumarPunateje() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		wordleTest=new EstadoDeJuego(id, dif);
		String palabra=wordleTest.getpalabra();
		wordleTest.jugar(palabra);
		assertEquals("10", wordleTest.getPuntaje());
		}
	
	@Test
	public void restarPuntaje() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		wordleTest=new EstadoDeJuego(id, dif);
		wordleTest.jugar("werty");
		assertEquals("-5", wordleTest.getPuntaje());
		}
	
	@Test
	public void ElegirPalabraNoRepetida() {
		Idioma id= Idioma.Español;
		Dificultad dif= Dificultad.Normal;
		wordleTest=new EstadoDeJuego(id, dif);
		String palabra=wordleTest.getpalabra();
		String palabra2=wordleTest.elegirPalabra();
		boolean acum= palabra!=palabra2;
//		for(int i=0; i< wordleTest.getPalabrasEspañol().length; i++) {
//			acum= acum && palabra!=wordleTest.elegirPalabra();		}
		assertTrue(acum);
		}
	
	
}
