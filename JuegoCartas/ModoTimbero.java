package JuegoCartas;

import JuegoCartas.Carta;
import JuegoCartas.EstrategiaDeJuego;

public class ModoTimbero extends EstrategiaDeJuego {

	public ModoTimbero(String estrategia) {
		super(estrategia);
	}

	@Override
	// Retorna el valor "pos" de manera random -> Jugador Timbero
	public int modoJuego(Carta c) {
		int pos = 0;
		pos = (int) (Math.random() * c.cantCaracteristicasEnPosiciones() + 0);
		return pos;
	}
}
