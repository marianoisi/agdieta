package edu.utn.frba.ia.grupo7.ag;

import org.jgap.RandomGenerator;

public enum Desayuno implements Comida {

	DESAYUNO_0("Café con leche y medialunas de grasa", 55),
	DESAYUNO_1("Café con leche y tostadas", 40),
	DESAYUNO_2("Café con leche y tostadas con manteca", 55),
	DESAYUNO_3("Café con leche y galletas de salvado", 35),
	DESAYUNO_4("Mate cocido y medialunas de grasa", 55),
	DESAYUNO_5("Mate cocido y tostadas", 40),
	DESAYUNO_6("Mate cocido y tostadas con manteca", 55),
	DESAYUNO_7("Mate cocido y galletas de salvado", 35),
	DESAYUNO_8("Té y medialunas de grasa", 55),
	DESAYUNO_9("Té y tostadas", 40),
	DESAYUNO_10("Té y tostadas con manteca", 55),
	DESAYUNO_11("Té y galletas de salvado", 35),
	DESAYUNO_12("Té con leche y medialunas de grasa", 55),
	DESAYUNO_13("Té con leche y tostadas", 40),
	DESAYUNO_14("Té con leche y tostadas con manteca", 55),
	DESAYUNO_15("Té con leche y galletas de salvado", 35),
	;
	
	private String nombre;
	private int kcal;

	private Desayuno(String nombre, int kcal) {
		this.nombre = nombre;
		this.kcal = kcal;
	}
	
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static Comida getRandom(RandomGenerator randomGenerator) {
		int randomNumber = randomGenerator.nextInt(values().length);
		return valueOf("DESAYUNO_" + randomNumber);
	}
	
	public String toString() {
		return this.getNombre() + " (" + this.getKcal() + ")";
	}
	
}
