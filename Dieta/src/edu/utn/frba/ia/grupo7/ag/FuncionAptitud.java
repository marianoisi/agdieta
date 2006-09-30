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
		double calorias = 10000;
		for(Gene dia : individuo.getGenes()) {
			calorias -= ((Comida) dia.getAllele()).getCalorias();
		}
		return calorias;
	}

}
