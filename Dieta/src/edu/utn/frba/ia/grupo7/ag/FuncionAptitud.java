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
	private static final int MAX_CALORIAS_DIARIAS = 1000;

	/* (non-Javadoc)
	 * @see org.jgap.FitnessFunction#evaluate(org.jgap.IChromosome)
	 */
	@Override
	protected double evaluate(IChromosome individuo) {
		double factorCalorias = 0;
		double factorRepeticion = 0;
		
		int calorias = 0;
		for (Gene dia : individuo.getGenes()) {
			calorias += ((Dia)dia).getKcal(); 
		}
		// Si las calorias de la dieta estan dentro de lo
		// esperado, sumar 1000 puntos a la aptitud
		factorCalorias = MAX_CALORIAS_DIARIAS * 7 < calorias ? 1000 : 0;
				
		return factorCalorias + factorRepeticion;
	}

}
