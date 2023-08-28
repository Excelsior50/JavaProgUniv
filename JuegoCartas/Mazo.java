package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;


public class Mazo {

	private ArrayList <Carta> cartas;
	
	public Mazo() {
		this.cartas = new ArrayList<Carta>();
	}
	
	public void agregarCarta(Carta c) {
		if(this.cartas.isEmpty()) {
			this.cartas.add(c);
		}else {
			Carta Aux = this.cartas.get(0);
			if(Aux.tieneCaracteristicasIguales(c)){
				this.cartas.add(c);
			}else {
				System.out.println("Esta carta no pertenece a este mazo");
			}

		}
	}
	
	public ArrayList<Carta> getCartas() {
		ArrayList<Carta> copiaCartas = new ArrayList<>();
		copiaCartas.addAll(cartas);
		return copiaCartas;
	}
	
	
	public int cantidadCartasEnMazo() {
		return this.cartas.size();
	}
	
	public void eliminarMazo() {
		this.cartas.removeAll(cartas);
	}

	
	public void repartirPocimas(ArrayList<Pocima> pocimas) {
		Collections.shuffle(pocimas);
		for(int i=0; i < pocimas.size();i++) {
			this.cartas.get(i).setPocima(pocimas.get(i));
		}
	}
	public void darCartas(Jugador j1, Jugador j2) {
        for (int i = 0; i < this.getCartas().size(); i++) {
            Carta c = this.getCartas().get(i);
            if (i % 2 == 0) {
                j1.addCarta(c);
            } else {
                j2.addCarta(c);
            }
        }
        this.eliminarMazo();
    }
}
