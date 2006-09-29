/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licencing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package org.jgap.gp.function;

import org.jgap.*;
import org.jgap.gp.*;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.jgap.gp.impl.*;

/**
 * The for-loop.
 *
 * @author Klaus Meffert
 * @since 3.0
 */
public class ForLoop
    extends CommandGene {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.9 $";

  private Class m_typeVar;

  private int m_startIndex;

  private int m_maxLoop;

  /**
   * Constructor.
   *
   * @param a_conf the configuration to use
   * @param a_typeVar Class of the loop counter terminakl (e.g. IntegerClass)
   * @param a_maxLoop the maximum number of loops to perform
   * @throws InvalidConfigurationException
   *
   * @author Klaus Meffert
   * @since 3.0
   */
  public ForLoop(final GPConfiguration a_conf, Class a_typeVar, int a_maxLoop)
      throws InvalidConfigurationException {
    this(a_conf, a_typeVar, 0, a_maxLoop);
  }

  /**
   * Constructor allowing to preset the starting index of the loop.
   *
   * @param a_conf the configuration to use
   * @param a_typeVar Class of the loop counter terminakl (e.g. IntegerClass)
   * @param a_startIndex index to start the loop with (normally 0)
   * @param a_maxLoop the maximum number of loops to perform
   * @throws InvalidConfigurationException
   *
   * @author Klaus Meffert
   * @since 3.0
   */
  public ForLoop(final GPConfiguration a_conf, Class a_typeVar,
                 int a_startIndex, int a_maxLoop)
      throws InvalidConfigurationException {
    super(a_conf, 2, CommandGene.VoidClass);
    m_typeVar = a_typeVar;
    m_maxLoop = a_maxLoop;
    m_startIndex = a_startIndex;
  }

  public String toString() {
    return "for(int i=" + m_startIndex + ";i<&1;i++) { &2 }";
  }

  public void execute_void(ProgramChromosome c, int n, Object[] args) {
    // Determine the end index of the loop (child at index 0).
    // -------------------------------------------------------
    int x;
    if (m_typeVar == CommandGene.IntegerClass) {
      x = c.execute_int(n, 0, args);
    }
    else if (m_typeVar == CommandGene.LongClass) {
      x = (int) c.execute_long(n, 0, args);
    }
    else if (m_typeVar == CommandGene.DoubleClass) {
      x = (int) Math.round(c.execute_double(n, 0, args));
    }
    else if (m_typeVar == CommandGene.FloatClass) {
      x = (int) Math.round(c.execute_float(n, 0, args));
    }
    else {
      throw new RuntimeException("Type " + m_typeVar +
                                 " not supported by ForLoop");
    }
    if (x > m_maxLoop) {
      x = m_maxLoop;
    }
    // Repeatedly execute the second child (index = 1).
    // ------------------------------------------------
    for (int i = m_startIndex; i < x; i++) {
      c.execute_void(n, 1, args);
    }
  }

  public boolean isValid(ProgramChromosome a_program) {
    return true;
  }

  public Class getChildType(IGPProgram a_ind, int a_chromNum) {
    if (a_chromNum == 0) {
      // Loop counter variable
      return m_typeVar;
    }
    else {
      // Subprogram
      return CommandGene.VoidClass;
    }
  }

  /**
   * The compareTo-method.
   * @param a_other the other object to compare
   * @return -1, 0, 1
   *
   * @author Klaus Meffert
   * @since 3.0
   */
  public int compareTo(Object a_other) {
    if (a_other == null) {
      return 1;
    }
    else {
      ForLoop other = (ForLoop) a_other;
      return new CompareToBuilder()
          .append(m_typeVar, other.m_typeVar)
          .append(m_maxLoop, other.m_maxLoop)
          .toComparison();
    }
  }

  /**
   * The equals-method.
   * @param a_other the other object to compare
   * @return true if the objects are seen as equal
   *
   * @author Klaus Meffert
   * @since 3.0
   */
  public boolean equals(Object a_other) {
    if (a_other == null) {
      return false;
    }
    else {
      try {
        ForLoop other = (ForLoop) a_other;
        return new EqualsBuilder()
            .append(m_typeVar, other.m_typeVar)
            .append(m_maxLoop, other.m_maxLoop)
            .isEquals();
      } catch (ClassCastException cex) {
        return false;
      }
    }
  }
}
