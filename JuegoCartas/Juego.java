package JuegoCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Juego {

	private Jugador j1;
	private Jugador j2;
	private Mazo baraja;
	private int contadorJ1; // contadores estaticos o en metodos???
	private int contadorJ2;
	private int maxRondas;
	private ArrayList<Pocima> pocimas;

	public Juego(Jugador j1, Jugador j2, int maxRondas) {
		this.baraja = new Mazo();
		this.j1 = j1;
		this.j2 = j2;
		this.contadorJ1 = 0;
		this.contadorJ2 = 0;
		this.maxRondas = maxRondas;
		this.pocimas = new ArrayList<>();
		this.j1.setGanoJugador(true);
	}

	public void agregarMazo() {
		File jsonInputFile = new File("./superheroes.json");
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			JsonReader reader = Json.createReader(is);
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				Carta cartita = new Carta(nombreCarta);
				JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
				for (String nombreAtributo : atributos.keySet()) {
					Caracteristica atributo = new Caracteristica(nombreAtributo, atributos.getInt(nombreAtributo));
					cartita.addAtributo(atributo);
				}
				this.baraja.agregarCarta(cartita);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Mazo getBaraja() {
		return baraja;
	}

	public int getContadorJ1() {
		return contadorJ1;
	}

	public void setContadorJ1(int contadorJ1) {
		this.contadorJ1 = contadorJ1;
	}

	public int getContadorJ2() {
		return contadorJ2;
	}

	public void setContadorJ2(int contadorJ2) {
		this.contadorJ2 = contadorJ2;
	}


	// CHECK JUGADORES TIENEN CARTAS
	public boolean jugadoresConCartas() {
		boolean j1 = this.j1.tengoCartas();
		boolean j2 = this.j2.tengoCartas();
		return j1 && j2;
	}

	// cada jugador tirarCarta y segun el atributo que se controle indica QUIEN GANO
	// LA RONDA.
	// Devuelve int para posible option case, posible cambio de nombre
	public int atributoGanador(Jugador j1, Jugador j2, int atributo) {
		int valor = j1.primerCarta().caracteristicaSeleccionada(atributo).compareTo(j2.primerCarta().caracteristicaSeleccionada(atributo));
		if(valor > 0) {
			return 1;
		} else if(valor < 0) {
				return 2;
			} else {
				return 0;
			}
	}

	// contador de rondas ganadas por jugador++ y modifica ganador de ronda para
	// eleccion de atributo

	public void contadorGanadas(int atributo, Jugador ganador) {
		int winner = atributoGanador(j1, j2, atributo);

		// REDEFINIR EN TO STRING PASANDO J POR PARAMETRO PARA IMPRIMIR LOS DOS
		// JUGADORES O ALGO ASI

		String nombre1 = j1.getNombre();
		System.out.println(j1.informacionJugadorRonda(atributo));

		String nombre2 = j2.getNombre();
		System.out.println(j2.informacionJugadorRonda(atributo));
		if (winner == 1) {
			this.contadorJ1++;
			ganador = j1;
			j1.setGanoJugador(true);
			j2.setGanoJugador(false);
			System.out.println("El JUGADOR " + nombre1 + "  es el ganador de esta ronda");
		} else {
			if (winner == 2) {
				this.contadorJ2++;
				ganador = j2;
				j2.setGanoJugador(true);
				j1.setGanoJugador(false);
				System.out.println("El JUGADOR " + nombre2 + "  es el ganador de esta ronda");
			} else {
				System.out.println("ESTA RONDA ES UN EMPATE");
			}
		}
	}

	// empate carta c/jugador pasa a final de su arreglo. Ganador se queda con ambas
	// cartas
	public void cartasRonda(Jugador j1, Jugador j2, int atributo) {
		int ganador = atributoGanador(j1, j2, atributo);
		Carta cartaJ1 = j1.primerCarta();
		Carta cartaJ2 = j2.primerCarta();
		if (ganador == 1) {
			j1.sumaCartas(cartaJ1, cartaJ2);// AGREGA LAS CARTAS GANADAS AL FINAL DEL ARR
			j2.borraCarta();
		} else {
			if (ganador == 2) {
				j2.sumaCartas(cartaJ1, cartaJ2);
				j1.borraCarta();
			} else {
				// CASE EMPATE CADA UNO PASA SU CARTA AL FINAL DEL ARREGLO
				j1.cartaEmpate(cartaJ1);
				j2.cartaEmpate(cartaJ2);
			}
		}
	}

	// JUGAR.... MIENTRAS EL CONT RONDAS NO SEA CANT RONDAS ELEGIDAS O JUGADOR SIN
	// CARTAS...JUGAR

	public void jugar() {
		agregarMazo();
		if (!this.pocimas.isEmpty()) {
			this.baraja.repartirPocimas(pocimas);
		}
		this.baraja.darCartas(j1, j2);
		int rondas = this.maxRondas;
		int round = 1;
		j1.modoDeJuego();
		j2.modoDeJuego();
		int atributo = 0;
		while ((round <= rondas) && jugadoresConCartas()) {
			Jugador ganador = ganador(j1, j2);
			System.out.println("		Ronda =	" + round);
			atributo = ganador.getPosicion();
			contadorGanadas(atributo, ganador);
			round++;
			cartasRonda(j1, j2, atributo);
		}
		if (contadorJ1 < contadorJ2) {
			System.out.println("Gano Jugador " +j2.getNombre());
		} else if(contadorJ1 > contadorJ2) {
			System.out.println("Gano Jugador " +j1.getNombre());
		}else {
			System.out.println("La partida termino en empate");
		}
	}

	public void agregarPocima(Pocima p) {
		this.pocimas.add(p);
	}

	// Si el ganador j1 esta en true devuelve como ganador el j1 sino el j2 y sino
	// en null --> por este metodo se inicializa el constructor como
	// Ganador j1 en true y Ganador j2 en false
	public Jugador ganador(Jugador j1, Jugador j2) {
		if (j1.isGanoJugador()) {
			return j1;
		}
			return j2;
		
	}
}
