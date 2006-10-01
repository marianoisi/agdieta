package edu.utn.frba.ia.grupo7.ag;

import org.jgap.BaseGene;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.UnsupportedRepresentationException;

public class Dia extends BaseGene implements Gene {

	private static final long serialVersionUID = 1L;
	private static final int MAX_COMIDAS = 4;
	
	private Comida[] comidas;
	

	public Dia(Configuration a_configuration) throws InvalidConfigurationException {
		super(a_configuration);
	}
	
	@Override
	protected Object getInternalValue() {
		return comidas;
	}

	@Override
	protected Gene newGeneInternal() {
		try {
			return new Dia(getConfiguration());
		} catch (InvalidConfigurationException iex) {
			throw new IllegalStateException(iex.getMessage());
		}
	}

	@Override
	public void applyMutation(int indice, double porcentaje) {
	}

	@Override
	public void setToRandomValue(RandomGenerator randomGenerator) {
		// Definir las 4 comidas del dia
		Comida[] comidas = new Comida[MAX_COMIDAS];
		
		// Generar un desayuno
		comidas[0] = Desayuno.getRandom(randomGenerator);
		
		// Generar un almuerzo
		comidas[1] = Almuerzo.getRandom(randomGenerator);
		
		// Generar una merienda
		comidas[2] = Desayuno.getRandom(randomGenerator);
		
		// Generar una cena
		comidas[3] = Almuerzo.getRandom(randomGenerator);
		
		setAllele(comidas);
	}

	@Override
	public void setValueFromPersistentRepresentation(String arg0)
			throws UnsupportedOperationException,
			UnsupportedRepresentationException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPersistentRepresentation()
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAllele(Object comidas) {
		this.comidas = (Comida[]) comidas;
	}

	@Override
	public int compareTo(Object otherGene) {
		Dia otroDia = (Dia) otherGene;
		if (otroDia == null || otroDia.getAllele() == null) {
			return 1;
		} else if (this.comidas == null) {
			return -1;
		}
		return getKcal().compareTo(otroDia.getKcal());
	}
	
	@Override
	public boolean equals(Object otherGene) {
		Dia otroDia = (Dia) otherGene;
		if(otroDia == null) {
			return false;
		} else if (this.comidas == null) {
			return otroDia.getAllele() == null;
		}
		
		// Dos dias son iguales si todas sus comidas son iguales
		Comida[] otrasComidas = (Comida[]) otroDia.getAllele();
		boolean diasIguales = true;
		for(int i = 0; i < MAX_COMIDAS; i++) {
			diasIguales &= this.comidas[i].equals(otrasComidas[i]);
		}
		return diasIguales;
	}
	
	public Integer getKcal() {
		int kcal = 0;
		Comida[] comidas = (Comida[]) getAllele();

		if (comidas == null) {
			return 0;
		}
		
		for (int i = 0; i < comidas.length; i++) {
			kcal += comidas[i].getKcal();
		}
		return kcal;
	}
	
	@Override
	public String toString() {
		if (this.comidas == null) {
			return "";
		}
		
		StringBuffer str = new StringBuffer();
		str.append("Desayuno: " + this.comidas[0].toString() + "\n");
		str.append("Almuerzo: " + this.comidas[1].toString() + "\n");
		str.append("Merienda: " + this.comidas[2].toString() + "\n");
		str.append("Cena: " + this.comidas[3].toString() + "\n");
		return new String(str);
	}
	
}
