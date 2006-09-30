/**
 * 
 */
package edu.utn.frba.ia.grupo7.ag;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

/**
 *
 */
public class FuncionAptitud extends FitnessFunction {

	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.jgap.FitnessFunction#evaluate(org.jgap.IChromosome)
	 */
	@Override
	protected double evaluate(IChromosome individuo) {
		double sumaIds = 0;
		for(Gene dia : individuo.getGenes()) {
			sumaIds += ((Comida) dia.getAllele()).getId();
		}
		return sumaIds;
	}

}
