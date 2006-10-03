package edu.utn.frba.ia.grupo7.ag;

import org.jgap.RandomGenerator;

public enum Almuerzo implements Comida {

	ALMUERZO_0("1/4 de pollo", 350),
	ALMUERZO_1("Costillas de cerdo", 650),
	ALMUERZO_2("Ternera guisada", 343),
	ALMUERZO_3("Ternera asada", 296),
	ALMUERZO_4("Canelones (2)", 264),
	ALMUERZO_5("Spaguettis", 389),
	ALMUERZO_6("Ravioles", 435),
	ALMUERZO_7("Lenguado a la parrilla", 276),
	ALMUERZO_8("Merluza hervida", 361),
	ALMUERZO_9("Salmón ahumado", 204),
	ALMUERZO_10("Creps de verdura", 203),
	ALMUERZO_11("Arroz", 198),
	ALMUERZO_12("Tomates rellenos", 136),
	ALMUERZO_13("Pastel de papa", 354),
	ALMUERZO_14("Sopa de verduras", 176),
	ALMUERZO_15("Lentejas", 368),
	ALMUERZO_16("Hamburguesas de pollo", 378),
	ALMUERZO_17("Hamburguesas de carne", 468),
	ALMUERZO_18("Hamburguesas de tofu", 264),
	ALMUERZO_19("Tarta de verdura", 167),
	ALMUERZO_20("Tarta de pollo", 264),
	ALMUERZO_21("Berenjenas rellenas", 239),
	ALMUERZO_22("Arroz con pollo", 167),
	ALMUERZO_23("Arroz integral con tomates", 97),
	ALMUERZO_24("Lasaña", 468),
	ALMUERZO_25("Pizza", 435),
	ALMUERZO_26("Huevos rellenos", 105),
	ALMUERZO_27("Milanesas de soja con tomate", 267),
	ALMUERZO_28("Milanesas de berenjena", 279)
	;
	
	private String nombre;
	private int kcal;

	private Almuerzo(String nombre, int kcal) {
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
		return valueOf("ALMUERZO_" + randomNumber);
	}
	
	public String toString() {
		return this.getNombre() + " (" + this.getKcal() + ")";
	}
	
}
