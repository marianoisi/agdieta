/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licencing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package org.jgap.gp.impl;


import org.jgap.gp.*;

/**
 * A default implementation of a fitness evaluator. This implementation is
 * straight forward: a higher fitness value is seen as fitter.
 *
 * @author Klaus Meffert
 * @since 3.0
 */
public class DefaultGPFitnessEvaluator
    implements IGPFitnessEvaluator {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.2 $";

  /**
   * Compares the first given fitness value with the second and returns true
   * if the first one is greater than the second one. Otherwise returns false
   * @param a_fitness_value1 first fitness value
   * @param a_fitness_value2 second fitness value
   * @return true: first fitness value greater than second
   *
   * @author Klaus Meffert
   * @since 2.0 (until 1.1: input types int)
   */
  public boolean isFitter(final double a_fitness_value1,
                          final double a_fitness_value2) {
    return a_fitness_value1 > a_fitness_value2;
  }

  public boolean isFitter(IGPProgram a_prog1, IGPProgram a_prog2) {
    return isFitter(a_prog1.getFitnessValue(), a_prog2.getFitnessValue());
  }
}
