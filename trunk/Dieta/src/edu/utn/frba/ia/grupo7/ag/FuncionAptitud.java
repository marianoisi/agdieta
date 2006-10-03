/**
 * 
 */
package edu.utn.frba.ia.grupo7.ag;

import java.util.HashMap;
import java.util.Map;

import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.IChromosome;

/**
 *
 */
public class FuncionAptitud extends FitnessFunction {

	private static final long serialVersionUID = 1L;
	
	private Integer maxCaloriasDiarias = 1500;

	/* (non-Javadoc)
	 * @see org.jgap.FitnessFunction#evaluate(org.jgap.IChromosome)
	 */
	@Override
	protected double evaluate(IChromosome individuo) {
		double factorRepeticion = 0;
		double factorCalorias = 0;
		Map<Comida, Integer> contador = new HashMap<Comida, Integer>();
		
		int calorias = 0;
		int cantDiasExceso = 0;
		for (Gene gen : individuo.getGenes()) {
			
			// Acumular las calorias
			Dia dia = (Dia) gen;
			calorias += dia.getKcal();
			
			// Registrar si es un dia con exceso de calorias
			cantDiasExceso += (dia.getKcal() > this.maxCaloriasDiarias) ? 1 : 0;
			
			// Registrar la repeticion de comidas
			Comida[] comidas = (Comida[]) dia.getAllele();
			for (Comida comida : comidas) {
				if (contador.containsKey(comida)) {
					contador.put(comida, contador.get(comida) + 1);
				} else {
					contador.put(comida, 1);
				}
			}
		}

		// --------- Calcular puntos por calorias ---------
		// Si tengo dias con exceso de calorias, restar puntos por dia
		factorCalorias -= (200 * cantDiasExceso);
		
		// Si las calorias de la dieta estan dentro de lo
		// esperado, sumar puntos a la aptitud
		if (this.maxCaloriasDiarias * 7 <= calorias) {
			factorCalorias +=  100;
			
		// En otro caso, restar puntos
		} else {
			factorCalorias -= 100;
		}

		
		// ----- Calcular puntos por repeticion de comidas -------
		// El que tiene mas comidas es el que menos repite
		factorRepeticion = contador.size() * 200;

		// ----- Calcular la puntuacion final -------
		double puntuacion = factorCalorias + factorRepeticion;
		
		// Si la puntuacion final es negativa, devolver cero
		return (puntuacion >= 0) ? puntuacion : 0;
	}

	public Integer getMaxCaloriasDiarias() {
		return maxCaloriasDiarias;
	}

	public void setMaxCaloriasDiarias(Integer maxCaloriasDiarias) {
		this.maxCaloriasDiarias = maxCaloriasDiarias;
	}

}
