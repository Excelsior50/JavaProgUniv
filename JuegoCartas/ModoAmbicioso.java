package JuegoCartas;

import JuegoCartas.Carta;
import JuegoCartas.EstrategiaDeJuego;

public class ModoAmbicioso extends EstrategiaDeJuego {

	public ModoAmbicioso(String estrategia) {
		super(estrategia);
	}

	/*
	 * AMBICIOSO DELEGADO EN CARTA
	 */
	
	@Override
	// Retorna el valor "pos" con el mayor valor de las caracteristicas que tienen
	// las cartas -> Jugador Ambicioso
	public int modoJuego(Carta c) {
		return c.mayorCaracteristica();
	}
}
