package JuegoCartas;

import JuegoCartas.Caracteristica;
import JuegoCartas.Pocima;

public abstract class Pocima  implements Comparable <Pocima>{
	    protected String nombre;


	    public Pocima(String nombre) {
	        this.nombre = nombre;

	    }
	    public String getNombre() {
			return nombre;
		}
		
	    public abstract double getValorPocima(Caracteristica caracteristica);
		
		@Override
		public int compareTo(Pocima p) {
			return this.nombre.compareTo(p.getNombre());
		}

	}

