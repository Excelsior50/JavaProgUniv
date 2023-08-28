package JuegoCartas;

import java.util.Scanner;

public class ModoObstinado extends EstrategiaDeJuego {
	private int valor;
	public ModoObstinado(String estrategia) {
		super(estrategia);
	}

	@Override
	public int modoJuego(Carta c) {
	
		return this.valor;
	}
	@SuppressWarnings("unused")
	public void elegirValor(Carta c) {
		String mensaje = "Precionando la opcion:" + "\n";
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elija el VALOR del atributo:" );
		for(int i = 0; i < c.cantCaracteristicasEnPosiciones(); i++) {
			mensaje += i + " esta eligiendo el atributo: " + c.nombreCaracteristica(i) + "\n";
		}
		System.out.println("" +mensaje);
		this.valor = entrada.nextInt();
	}

}
