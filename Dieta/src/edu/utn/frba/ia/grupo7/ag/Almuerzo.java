package edu.utn.frba.ia.grupo7.ag;

import org.jgap.RandomGenerator;

public enum Almuerzo implements Comida {

	ALMUERZO_0("Muslo de pollo asado", 110),
	ALMUERZO_1("Muslo de pollo hervido", 98),
	ALMUERZO_2("Costillas de cordero", 352),
	ALMUERZO_3("Ternera guisada", 256),
	ALMUERZO_4("Ternera asada", 231),
	ALMUERZO_5("Canelones (1)", 133),
	ALMUERZO_6("Spaguettis", 233),
	ALMUERZO_7("Ravioles de carne", 288),
	ALMUERZO_8("Ravioles de ricota", 300),
	ALMUERZO_9("Lenguado a la parrilla", 90),
	ALMUERZO_10("Merluza hervida", 97),
	ALMUERZO_11("Salmón ahumado", 204),
	ALMUERZO_12("Trucha al vapor", 133),
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
