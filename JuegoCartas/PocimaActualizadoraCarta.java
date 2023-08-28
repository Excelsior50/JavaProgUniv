package JuegoCartas;

import JuegoCartas.Caracteristica;
import JuegoCartas.Pocima;

public class PocimaActualizadoraCarta extends Pocima {
	private double valor;
	public PocimaActualizadoraCarta(String nombre, double valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public double getValorPocima(Caracteristica caracteristica) {
		Caracteristica caracteristica1 =  new Caracteristica (caracteristica.getNombre(), caracteristica.getValor());
		caracteristica1.setValor(caracteristica.getValor() * (this.valor / 100 + 1));
		return caracteristica1.getValor();
	}

}
