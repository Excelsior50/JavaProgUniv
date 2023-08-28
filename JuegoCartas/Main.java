package JuegoCartas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese maximo de rondas a jugar:");
		int maximo = entrada.nextInt();

		Jugador j1 = new Jugador("Matias");
		Jugador j2 = new Jugador("Eric");
		Pocima f1 = new PocimaActualizadoraCarta("Fortalecedora20%", 20);
		Pocima f2 = new PocimaActualizadoraCarta("Fortalecedora30%", 30);
		Pocima fp1 = new PocimaActualizadoraCarta("FortalecedoraPlus50%", 50);
		Pocima fp2 = new PocimaActualizadoraCarta("FortalecedoraPlus30%", 30);
		Pocima krip = new PocimaActualizadoraCarta("Kriptonita25%", 25);
		Pocima krip2 = new PocimaActualizadoraCarta("Kriptonita15%", 15);
		Pocima reducdeplomo = new PocimaActualizadoraCarta("Reductor de Plomo 55%", 55);
		Pocima reducdeplomo2 = new PocimaActualizadoraCarta("Reductor de Plomo 65%", 65);
		Pocima qv4 = new PocimaValoresEstaticos("Quiero Vale 4", 4);
		Pocima qv42 = new PocimaValoresEstaticos("Quiero Vale 8", 8);
		Pocima nromagico = new PocimaValoresEstaticos("Numero Magico", 23);
		Pocima nromagico2 = new PocimaValoresEstaticos("Numero Magico", 43);
		Pocima selectfuerza = new PocimaIncrementaAtributoSeleccionado("Pocima Selectiva Fuerza 35%", 35, "fuerza");
		Pocima selectfuerza2 = new PocimaIncrementaAtributoSeleccionado("Pocima Selectiva Fuerza 25%", 25, "fuerza");
		Pocima selectPeso = new PocimaIncrementaAtributoSeleccionado("Pocima Selectiva Peso 43%", 43, "peso");
		Pocima selectPeso2 = new PocimaIncrementaAtributoSeleccionado("Pocima Selectiva Peso 23%", 23, "peso");

		PocimaCocktail cocktail = new PocimaCocktail("PocimaCocktail");
		cocktail.addPocima(f1);
		cocktail.addPocima(fp1);
		
		PocimaCocktail cocktail2 = new PocimaCocktail ("PocimaCocktail2");
		cocktail.addPocima(fp2);
		cocktail.addPocima(fp2);
		cocktail.addPocima(qv4);
		Juego gamecito = new Juego(j1, j2, maximo);
		gamecito.agregarPocima(f1);
		gamecito.agregarPocima(f2);
		gamecito.agregarPocima(fp1);
		gamecito.agregarPocima(fp2);
		gamecito.agregarPocima(krip);
		gamecito.agregarPocima(krip2);
		gamecito.agregarPocima(reducdeplomo);
		gamecito.agregarPocima(reducdeplomo2);
		gamecito.agregarPocima(qv4);
		gamecito.agregarPocima(qv42);
		gamecito.agregarPocima(nromagico);
		gamecito.agregarPocima(nromagico2);
		gamecito.agregarPocima(selectfuerza);
		gamecito.agregarPocima(selectfuerza2);
		gamecito.agregarPocima(selectPeso);
		gamecito.agregarPocima(selectPeso2);
		gamecito.agregarPocima(cocktail);
		gamecito.agregarPocima(cocktail2);
		gamecito.jugar();
		

	}

}
