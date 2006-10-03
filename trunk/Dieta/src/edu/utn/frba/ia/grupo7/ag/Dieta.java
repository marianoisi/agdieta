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
	private static final int MAX_GENERACIONES = 100;
	
	/*
	 * Cantidad de individuos en la poblacion
	 */
	private static final int POBLACION = 500;
	
	/*
	 * Cantidad de dias que tiene la dieta
	 */
	private static final int DIAS_DIETA = 7;
	
	/*
	 * Maximo de calorias diarias
	 */
	private static final int MAX_CALORIAS_DIARIAS = 1300;

	
	/**
	 * Programa principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int calorias = leerCalorias(args);
		
		Configuration conf = new DefaultConfiguration();
		
		// Inicializar la funcion de aptitud
		FuncionAptitud funcionAptitud = new FuncionAptitud();
		funcionAptitud.setMaxCaloriasDiarias(calorias);
		
		// Generar poblacion inicial
		Genotype poblacion = null;
		try {
			poblacion = generarPoblacionInicial(conf, funcionAptitud);
		} catch (InvalidConfigurationException e) {
			System.out.println("Error inicializando");
		}
		
		// Operar geneticamente mediante seleccion, cruzamiento y
		// mutacion a lo largo de MAX_GENERACIONES generaciones
		poblacion.evolve(MAX_GENERACIONES);

		// Obtener el mejor individuo de la generacion actual
		IChromosome solucion = poblacion.getFittestChromosome();

		// Imprimir solucion obtenida
		mostrarDieta(solucion);
		
	}

	private static int leerCalorias(String[] args) {
		Integer calorias = null;
		try {
			calorias = new Integer(args[0]);
		} catch (Exception e) {
			// No se interpreto el resultado - utilizar maximo default
			calorias = MAX_CALORIAS_DIARIAS;
		}
		System.out.println("Generando dieta de " + calorias + " kcal diarias...\n");
		return calorias;
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
		Genotype poblacion = Genotype.randomInitialGenotype(conf);
		
		return poblacion;
	}

	/**
	 * Imprime la solucion en la consola
	 * 
	 * @param solucion
	 * @param funcionAptitud
	 */
	private static void mostrarDieta(IChromosome solucion) {
		
		int kcalDia = 0;
		int kcalSuma = 0;
		
		for (int i=0; i < DIAS_DIETA; i++) {
			
			kcalDia = ((Dia)solucion.getGene(i)).getKcal();
			kcalSuma = kcalSuma + kcalDia;
			
			System.out.println("Dia " + (i+1) + " (" + kcalDia + "): \n" + 
					solucion.getGene(i).toString());
		}
		
		System.out.println("Promedio Kcal. diario: " + kcalSuma / DIAS_DIETA + "\n");
	}

}
