package edu.utn.frba.ia.grupo7.ag;


public enum Comida {
	
	COMIDA1(0),
	COMIDA2(1),
	COMIDA3(2),
	COMIDA4(3),
	COMIDA5(4),
	COMIDA6(5),
	COMIDA7(6),
	COMIDA8(7),
	COMIDA9(8),
	COMIDA10(9),
	COMIDA11(10),
	COMIDA12(11),
	COMIDA13(12),
	COMIDA14(13),
	COMIDA15(14),
	COMIDA16(15)
	;
	
	private int id;
	//private String nombre;
	
	private Comida(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}
