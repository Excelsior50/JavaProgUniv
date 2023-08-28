package JuegoCartas;

import java.util.ArrayList;

public class Carta {

	private String nombre;
	private ArrayList<Caracteristica> caracteristicas;
	private Pocima pocima;

	public Carta(String nombre) {
		this.nombre = nombre;
		this.caracteristicas = new ArrayList<Caracteristica>();
		this.pocima = null;
	}

	public Pocima getPocima() {
		return pocima;
	}

	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addAtributo(Caracteristica a) {
		this.caracteristicas.add(a);
	}



	// RETORNA EL VALOR DEL ATRIBUTO EN LA POSICION INDICADA DE CARACTERISTICA
	public Caracteristica caracteristicaSeleccionada(int pos) {
		return this.caracteristicas.get(pos);
	}

	// RETORNA LA CARACTERISTICA EN LA POSICION
	public String nombreCaracteristica(int pos) {
		return this.caracteristicas.get(pos).getNombre();
	}


	// Retorna el valor "pos" de manera random -> Jugador Timbero
	public int elegirPosAtributo() {
		int pos = 0;
		pos = (int) (Math.random() * this.caracteristicas.size() + 0);
		return pos;
	}

	// Retorna el valor "pos" con el mayor valor de las caracteristicas que tienen
	// las cartas -> Jugador Ambicioso
	public int elegirPosAtributoAmbicioso() {
		int pos = 0;
		for (int i = 0; i < this.caracteristicas.size(); i++) {
				if(this.caracteristicaSeleccionada(pos).compareTo(this.caracteristicaSeleccionada(i)) < 0) {
				pos = i;
			}
		}

		return pos;
	}

	public Caracteristica caracteristica(String nombre) {
		Caracteristica valorCaract = null;
		for (Caracteristica caract : caracteristicas) {
			if (caract.getNombre().equals(nombre)) {
				valorCaract = caract;
			}
		}
		return valorCaract;
	}



	public boolean tieneCaracteristicasIguales(Carta c) {
		for (Caracteristica caract : caracteristicas) {
			if (!caract.getNombre().equals(c.caracteristicaPorNombre(caract.getNombre()))) {
				return false;
			}
		}
		return true;
	}

	public String caracteristicaPorNombre(String nombre) {
		for (Caracteristica caract : caracteristicas) {
			if (caract.getNombre().equals(nombre)) {
				return caract.getNombre();
			}
		}
		return null;
	}
	
	public int mayorCaracteristica() {
        int pos = 0;
        for (int i = 0; i < this.caracteristicas.size(); i++) {
            if (this.caracteristicas.get(pos).getValor() < this.caracteristicas.get(i).getValor()) {
                pos = i;
            }
        }
        return pos;
    }
	public int cantCaracteristicasEnPosiciones() {
		return this.caracteristicas.size();
	}
	
}
