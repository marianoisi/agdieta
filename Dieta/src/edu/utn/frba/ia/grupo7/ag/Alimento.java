package edu.utn.frba.ia.grupo7.ag;

public enum Alimento {

	POLLO1("Muslo de pollo asado", 110),
	POLLO2("Muslo de pollo hervido", 98),
	CORDERO1("Costillas de cordero", 352),
	TERNERA1("Ternera guisada", 256),
	TERNERA2("Ternera asada", 231)
	;
	
	private String nombre;
	private int kcal;
	
	private Alimento(String nombre, int kcal) {
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

}
