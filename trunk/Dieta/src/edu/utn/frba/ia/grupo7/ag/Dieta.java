package edu.utn.frba.ia.grupo7.ag;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;

/**
 *
 */
public class Dieta {

	/*
	 * Cantidad de veces que evoluciona la poblacion
	 */
	private static int MAX_GENERACIONES = 100;
	
	/*
	 * Cantidad de individuos en la poblacion
	 */
	private static int POBLACION = 500;
	
	/*
	 * Cantidad de dias que tiene la dieta
	 */
	private static int DIAS_DIETA = 7;
	
	
	
	/**
	 * Programa principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration conf = new DefaultConfiguration();
		
		// Inicializar la funcion de aptitud
		FuncionAptitud funcionAptitud = new FuncionAptitud();
		
		// Generar poblacion inicial
		Genotype population = null;
		try {
			population = generarPoblacionInicial(conf, funcionAptitud);
		} catch (InvalidConfigurationException e) {
			System.out.println("Error inicializando");
		}
		
		// Operar geneticamente mediante seleccion, cruzamiento y
		// mutacion a lo largo de MAX_GENERACIONES generaciones
		population.evolve(MAX_GENERACIONES);

		for(Object cromo : population.getFittestChromosomes(2)) {
			IChromosome cromosoma = (IChromosome) cromo;
			System.out.println(cromosoma.getFitnessValue());
			mostrarDieta(cromosoma);
		}
		
/*		// Obtener el mejor individuo de la generacion actual
		IChromosome solucion = population.getFittestChromosome();

		// Imprimir solucion obtenida
		mostrarDieta(solucion, funcionAptitud);*/
		
	}

	/**
	 * Configura la funcion de aptitud, el cromosoma,
	 * el tamano de la poblacion, y luego genera la poblacion
	 * inicial.
	 * 
	 * @param conf
	 * @param funcionAptitud
	 * @return
	 * @throws InvalidConfigurationException
	 */
	private static Genotype generarPoblacionInicial(Configuration conf,
			FuncionAptitud funcionAptitud) throws InvalidConfigurationException {
		
		// Configurar la funcion de aptitud
		conf.setFitnessFunction(funcionAptitud);

		// Configurar el cromosoma en base a un cromosoma de ejemplo
		Gene[] ejemplo = new Gene[DIAS_DIETA];
		for (int i=0; i< DIAS_DIETA; i++) {
			ejemplo[i] = new Dia(conf);
		}
		Chromosome cromosoma = new Chromosome(conf, ejemplo);
		conf.setSampleChromosome(cromosoma);
		
		// Configurar el tamano de la poblacion
		conf.setPopulationSize(POBLACION);
		
		// Generar poblacion inicial
		Genotype population = Genotype.randomInitialGenotype(conf);
		
		return population;
	}

	/**
	 * Imprime la solucion en la consola
	 * 
	 * @param solucion
	 * @param funcionAptitud
	 */
	private static void mostrarDieta(IChromosome solucion) {
		
		for (int i=0; i < DIAS_DIETA; i++) {
			System.out.println("Dia " + (i+1) + ": " + 
					((Comida)solucion.getGene(i).getAllele()).getNombre());
		}
	}

}
