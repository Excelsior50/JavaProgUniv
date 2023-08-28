package JuegoCartas;

import java.util.ArrayList;


public class PocimaCocktail extends Pocima {
	private ArrayList<Pocima> pocimas;

	public PocimaCocktail(String nombre) {
		super(nombre);
		this.pocimas = new ArrayList<>();
	}

	public void addPocima(Pocima p) {
		pocimas.add(p);
	}

	@Override
	public double getValorPocima(Caracteristica caracteristica) {
		Caracteristica caracteristica1 =  new Caracteristica (caracteristica.getNombre(), caracteristica.getValor());		
		for (Pocima pocim : pocimas) {
			caracteristica1.setValor(pocim.getValorPocima(caracteristica1));
		}
		return caracteristica1.getValor();
	}

}
