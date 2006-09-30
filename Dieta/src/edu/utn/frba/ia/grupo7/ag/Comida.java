package edu.utn.frba.ia.grupo7.ag;


public enum Comida {
	
	COMIDA0(0, "comida a", 20),
	COMIDA1(1, "comida b", 40),
	COMIDA2(2, "comida c", 60),
	COMIDA3(3, "comida d", 80),
	COMIDA4(4, "comida e", 100),
	COMIDA5(5, "comida f", 120),
	COMIDA6(6, "comida g", 140),
	COMIDA7(7, "comida h", 160),
	COMIDA8(8, "comida i", 180),
	COMIDA9(9, "comida j", 200),
	COMIDA10(10, "comida k", 220),
	COMIDA11(11, "comida l", 240),
	COMIDA12(12, "comida m", 260),
	COMIDA13(13, "comida n", 280),
	COMIDA14(14, "comida o", 300),
	COMIDA15(15, "comida p", 320)
	;
	
	private int id;
	private String nombre;
	private int calorias;
	
	private Comida(int id, String nombre, int calorias) {
		this.id = id;
		this.nombre = nombre;
		this.calorias = calorias;
	}
	
	/**
	 * Devuelve una comida con el id indicado
	 * 
	 * @param id
	 * @return
	 */
	public static Comida getFromId(int id) {
		for(Comida comida : values()) {
			if(comida.getId() == id) {
				return comida;
			}
		}
		return null;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
