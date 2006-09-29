package edu.utn.frba.ia.grupo7.ag;

import org.jgap.BaseGene;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.RandomGenerator;
import org.jgap.UnsupportedRepresentationException;

public class Comida extends BaseGene implements Gene {

	private static final long serialVersionUID = 1L;
	

	public Comida(Configuration a_configuration) throws InvalidConfigurationException {
		super(a_configuration);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object getInternalValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Gene newGeneInternal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyMutation(int arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setToRandomValue(RandomGenerator arg0) {
		// TODO Auto-generated method stub

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
	public void setAllele(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
