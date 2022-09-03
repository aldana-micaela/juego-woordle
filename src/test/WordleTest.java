package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import Juego.EstadoDeJuego;

public class WordleTest {

	EstadoDeJuego wordleTest;
	
	@Test
	public void sumarPuntajeTest() {
		wordleTest=new EstadoDeJuego(0);
		wordleTest.cambiarPalabra();
		String palabra= wordleTest.getpalabra();
		
		assertTrue(wordleTest.adivinoPalabra(palabra));
	}

	@Test
	public void LimpiarEstadoDeLetrasEnNumerosTest() {
		ArrayList<Integer> p= new ArrayList<Integer>(1);
		wordleTest=new EstadoDeJuego(0);
		wordleTest.cambiarPalabra();
		wordleTest.limpiarArregloDeNumeros();
		p.clear();
		assertEquals(p,wordleTest.getestadoDeLetrasEnNumeros());
	}
	
	@Test
	public void restarIntentos() {
		wordleTest=new EstadoDeJuego(0);
//		String palabra=wordleTest.elegirPalabra();
		wordleTest.jugar("asdfg");
		assertEquals("5", wordleTest.getIntentos());
		}
	
	@Test
	public void sumarPunateje() {
		wordleTest=new EstadoDeJuego(0);
		String palabra=wordleTest.getpalabra();
		wordleTest.jugar(palabra);
		assertEquals("10", wordleTest.getPuntaje());
		}
	
	@Test
	public void restarPuntaje() {
		wordleTest=new EstadoDeJuego(0);
		String palabra=wordleTest.getpalabra();
		wordleTest.jugar("werty");
		assertEquals("-5", wordleTest.getPuntaje());
		}
	
	@Test
	public void ElegirPalabraNoRepetida() {
		wordleTest=new EstadoDeJuego(0);
		String palabra=wordleTest.getpalabra();
		String palabra2=wordleTest.elegirPalabra();
		boolean acum= palabra!=palabra2;
		for(int i=0; i< wordleTest.getPalabrasEspañol().length; i++) {
			acum= acum && palabra!=wordleTest.elegirPalabra();		}
		assertTrue(acum);
		}
}
