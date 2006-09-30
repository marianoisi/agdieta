package edu.utn.frba.ia.grupo7.ag;

import org.jgap.BaseGene;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.UnsupportedRepresentationException;

public class Dia extends BaseGene implements Gene {

	private static final long serialVersionUID = 1L;
	
	private Comida comida;
	

	public Dia(Configuration a_configuration) throws InvalidConfigurationException {
		super(a_configuration);
	}
	
	@Override
	protected Object getInternalValue() {
		return comida;
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
		// TODO Auto-generated method stub
	}

	@Override
	public void setToRandomValue(RandomGenerator randomGenerator) {
		Comida comida = Comida.getFromId(
				randomGenerator.nextInt(Comida.values().length));
		setAllele(comida);
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
	public void setAllele(Object comida) {
		this.comida = (Comida) comida;
	}

	@Override
	public int compareTo(Object otherGene) {
		Dia otroDia = (Dia) otherGene;
		if (otroDia == null || otroDia.getAllele() == null) {
			return 1;
		} else if (this.comida == null) {
			return -1;
		}
		Integer id = this.comida.getId();
		Integer otroId = ((Comida)otroDia.getAllele()).getId();
		return id.compareTo(otroId);
	}
	
	@Override
	public boolean equals(Object otherGene) {
		Dia otroDia = (Dia) otherGene;
		if(otroDia == null) {
			return false;
		} else if (this.comida == null) {
			return otroDia.getAllele() == null;
		}
		return this.comida.equals(otroDia.getAllele());
	}
	
}
