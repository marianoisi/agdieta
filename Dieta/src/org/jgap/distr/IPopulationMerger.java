/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licencing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package org.jgap.distr;

import org.jgap.*;

/**
 * Interface for implementations allowing to merge two or more independent
 * Population's to be merged together into one Population.
 *
 * @author Klaus Meffert
 * @since 2.0
 */
public interface IPopulationMerger {
  /** String containing the CVS revision. Read out via reflection!*/
  final static String CVS_REVISION = "$Revision: 1.3 $";

  /**
   * Merges two Population's into one that has the given size.
   * @param a_population1 Population first Population
   * @param a_population2 Population second Population
   * @param a_new_population_size int size of merged Population
   * @return Population the resulting Population
   *
   * @author Klaus Meffert
   * @since 2.0
   */
  Population mergePopulations(Population a_population1,
                              Population a_population2,
                              int a_new_population_size);
}
