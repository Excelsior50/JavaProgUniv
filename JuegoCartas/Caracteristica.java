package JuegoCartas;

import JuegoCartas.Caracteristica;

public class Caracteristica implements Comparable <Caracteristica> {
    private String nombre;
    private double valor;

    public Caracteristica(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
	public boolean equals (Object o) {
		Caracteristica c = (Caracteristica) o;
		try {
			return this.getNombre().equals(c.getNombre());
		}catch (Exception exc) {
			return false;
		}
	}

	@Override
	public int compareTo(Caracteristica o) {	
		return (int) (this.valor - o.getValor());
	}
}
