package JuegoCartas;

import JuegoCartas.Carta;

public abstract class EstrategiaDeJuego {
	private String estrategia;
	
	public EstrategiaDeJuego(String estrategia) {
		this.estrategia = estrategia;
	}
	
	public String getEstrategia() {
		return estrategia;
	}
	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}

	//ArrayList <Caracteristica> caracteristicas;
	public abstract int modoJuego(Carta c);
	
}
