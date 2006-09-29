package edu.utn.frba.ia.grupo7.ag;

import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;

public class Dieta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration conf = new DefaultConfiguration();
		
		FitnessFunction funcionAptitud =
		    new FuncionAptitud();
		
		try {
			conf.setFitnessFunction(funcionAptitud);
		} catch (InvalidConfigurationException e) {
			System.out.println("Error inicializando");
		}
		
		
	}

}
