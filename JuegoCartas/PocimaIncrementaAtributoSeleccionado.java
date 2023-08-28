package JuegoCartas;

import JuegoCartas.Caracteristica;
import JuegoCartas.PocimaActualizadoraCarta;

public class PocimaIncrementaAtributoSeleccionado extends PocimaActualizadoraCarta {
	private String atributo;
	private double valor;
	public PocimaIncrementaAtributoSeleccionado(String nombre, double valor, String atributo) {
		super(nombre, valor);
		this.atributo = atributo;
	}

	// Funciona para la pocima "SELECTIVA FUERZA" y "SELECTIVA PESO"
	@Override
	public double getValorPocima(Caracteristica caracteristica) {
		Caracteristica caracteristica1 =  new Caracteristica (caracteristica.getNombre(), caracteristica.getValor());
		if(caracteristica1.getNombre().equals(atributo)) {
			caracteristica1.setValor(caracteristica1.getValor() * (this.valor / 100 + 1));
		}
			
		return caracteristica1.getValor();
	}

}
