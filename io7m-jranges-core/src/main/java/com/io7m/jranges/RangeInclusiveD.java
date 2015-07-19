/*
 * Copyright © 2015 <code@io7m.com> http://io7m.com
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jranges;

import com.io7m.jnull.NullCheck;
import com.io7m.jnull.Nullable;
import net.jcip.annotations.Immutable;

/**
 * <p> Immutable type representing an inclusive range with <code>double</code>
 * components. </p>
 */

@Immutable public final class RangeInclusiveD
{
  private final double interval;
  private final double lower;
  private final double upper;

  /**
   * Construct an inclusive range. The constructor enforces the invariant
   * <code>lower &lt;= upper</code>.
   *
   * @param in_lower The lower bound
   * @param in_upper The upper bound
   */

  public RangeInclusiveD(
    final double in_lower,
    final double in_upper)
  {
    RangeCheck.checkLessEqualDouble(in_lower, "lower", in_upper, "upper");
    this.lower = in_lower;
    this.upper = in_upper;
    this.interval = this.upper - this.lower;
  }

  @Override public boolean equals(
    final @Nullable Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final RangeInclusiveD other = (RangeInclusiveD) obj;
    return (Double.doubleToLongBits(this.lower)
            == Double.doubleToLongBits(other.lower))
           && (Double.doubleToLongBits(
      this.upper) == Double.doubleToLongBits(other.upper));
  }

  /**
   * @return The difference between the <code>upper</code> and
   * <code>lower</code> bound, literally <code>upper - lower</code>.
   */

  public double getInterval()
  {
    return this.interval;
  }

  /**
   * @return The lower bound of the inclusive range.
   */

  public double getLower()
  {
    return this.lower;
  }

  /**
   * @return The upper bound of the inclusive range.
   */

  public double getUpper()
  {
    return this.upper;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(this.lower);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(this.upper);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    return result;
  }

  /**
   * <p> Determine if the given value is included in this range. </p>
   *
   * @param value The given value
   *
   * @return <code>true</code> iff <code>value &gt;= this.getLower() &amp;&amp;
   * value &lt;= this.getUpper()</code> .
   */

  public boolean includesValue(
    final double value)
  {
    return (value >= this.lower) && (value <= this.upper);
  }

  /**
   * <p> Determine if the given range is included in this range. </p>
   *
   * @param other The given range
   *
   * @return <code>true</code> iff <code>this.getLower() &gt;= other.getLower()
   * &amp;&amp; this.getUpper() &lt;= other.getUpper()</code> .
   */

  public boolean isIncludedIn(
    final RangeInclusiveD other)
  {
    NullCheck.notNull(other, "Other range");
    return (this.lower >= other.lower) && (this.upper <= other.upper);
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder(32);
    builder.append("[RangeInclusiveD ");
    builder.append(this.lower);
    builder.append(" ");
    builder.append(this.upper);
    builder.append("]");
    return NullCheck.notNull(builder.toString());
  }
}
