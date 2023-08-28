package JuegoCartas;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> cartas;
	private EstrategiaDeJuego modoJuego;
	private boolean ganoJugador;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new ArrayList<Carta>();
		this.modoJuego = new ModoTimbero("Timbero");
		this.ganoJugador = false;
	}

	public boolean isGanoJugador() {
		return ganoJugador;
	}

	public void setGanoJugador(boolean ganoJugador) {
		this.ganoJugador = ganoJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstrategiaDeJuego getModoJuego() {
		return modoJuego;
	}

	public void setModoJuego(EstrategiaDeJuego modoJuego) {
		this.modoJuego = modoJuego;
	}

	public void addCarta(Carta c) {
		this.cartas.add(c);
	}

	public int cantidadCartas() {
		return this.cartas.size();
	}

	public void borraCarta() {
		this.cartas.remove(0);
	}

	public void sumaCartas(Carta c, Carta cartaGanada) {
		this.cartas.add(c);
		this.cartas.add(cartaGanada);
		this.borraCarta();
	}

	public void cartaEmpate(Carta c) {
		this.cartas.add(c);
		this.borraCarta();
	}

	public Carta primerCarta() {
		return this.cartas.get(0);
	}

	// CHECK TENGO CARTAS
	public boolean tengoCartas() {
		return !this.cartas.isEmpty();
	}

	// IMPRIME DATOS DE JUGADOR X RONDA
	public String informacionJugadorRonda(int atributo) {
		Caracteristica caracteristica =  this.primerCarta().caracteristicaSeleccionada(atributo);
		String nombre1 = this.getNombre();
		String personaje = this.primerCarta().getNombre();
		String atribRonda = this.primerCarta().nombreCaracteristica(atributo); 
		if (this.primerCarta().getPocima() != null) {
			double valorResultante = this.primerCarta().getPocima().getValorPocima(caracteristica);
			String nombrePocima = this.primerCarta().getPocima().getNombre();
			return "El jugador " + nombre1 + "  es  " + personaje + "  con  " + atribRonda + "  " + (int) caracteristica.getValor()
					+ ".  se aplica Pocima  " + nombrePocima + "  dando un valor resultante de  " + (int) valorResultante;
		} else {

			return "El jugador " + nombre1 + "  es  " + personaje + "  con  " + atribRonda + "  " + caracteristica.getValor();
		}
	}


	// maximoCartas
	public void modoDeJuego() {
		System.out.println(this.getNombre()
				+ " elija su estilo de juego, los estilos son: timbero (1), ambicioso (2) u obstinado (3)");
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		int entrada = entradaEscaner.nextInt();
		if (entrada == 1) {
			EstrategiaDeJuego Timbero = new ModoTimbero("Timbero");
			this.setModoJuego(Timbero);
		} else if (entrada == 2) {
			EstrategiaDeJuego Ambicioso = new ModoAmbicioso("Ambicioso");
			this.setModoJuego(Ambicioso);
		} else if (entrada == 3) {
			ModoObstinado Obstinado = new ModoObstinado("Obstinado");
			Obstinado.elegirValor(this.primerCarta());
			this.setModoJuego(Obstinado);

		}

	}
	public int getPosicion() {
		return this.getModoJuego().modoJuego(this.primerCarta());
	}

}
