package JuegoCartas;

import JuegoCartas.Caracteristica;
import JuegoCartas.Pocima;

public class PocimaValoresEstaticos extends Pocima {
	private double valorRetorno;
	public PocimaValoresEstaticos(String nombre, double valorRetorno) {
		super(nombre);
		this.valorRetorno = valorRetorno;
	}

	// Funciona para la pocima "QUIERO VALE 4" y "Numero Magico"
	@Override
	public double getValorPocima(Caracteristica caracteristica) {
		Caracteristica caracteristica1 =  new Caracteristica (caracteristica.getNombre(), caracteristica.getValor());
		caracteristica1.setValor(this.valorRetorno);
		return caracteristica1.getValor();
	}

}
