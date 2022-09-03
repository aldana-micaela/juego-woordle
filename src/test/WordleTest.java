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
}
