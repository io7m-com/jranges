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

import java.math.BigInteger;

/**
 * <p> Immutable type representing an inclusive range with {@link BigInteger}
 * components. </p>
 */

@Immutable public final class RangeInclusiveB
{
  private final BigInteger interval;
  private final BigInteger lower;
  private final BigInteger upper;

  /**
   * Construct an inclusive range. The constructor enforces the invariant
   * <code>lower &lt;= upper</code>.
   *
   * @param in_lower The lower bound
   * @param in_upper The upper bound
   */

  public RangeInclusiveB(
    final BigInteger in_lower,
    final BigInteger in_upper)
  {
    NullCheck.notNull(in_lower, "Lower");
    NullCheck.notNull(in_upper, "Upper");
    RangeCheck.checkLessEqualBig(in_lower, "lower", in_upper, "upper");

    this.lower = in_lower;
    this.upper = in_upper;
    final BigInteger i = this.upper.subtract(this.lower).add(BigInteger.ONE);
    assert i != null;
    this.interval = i;
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
    final RangeInclusiveB other = (RangeInclusiveB) obj;
    return this.interval.equals(other.interval)
           && this.lower.equals(other.lower)
           && this.upper.equals(other.upper);
  }

  /**
   * <p> Retrieve the number of values in the range <code>[lower, upper]</code>.
   * That is, <code>(upper - lower) + 1</code>. <p>
   *
   * @return The number of values in the range
   */

  public BigInteger getInterval()
  {
    return this.interval;
  }

  /**
   * @return The lower bound of the inclusive range.
   */

  public BigInteger getLower()
  {
    return this.lower;
  }

  /**
   * @return The upper bound of the inclusive range.
   */

  public BigInteger getUpper()
  {
    return this.upper;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + this.interval.hashCode();
    result = (prime * result) + this.lower.hashCode();
    result = (prime * result) + this.upper.hashCode();
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
    final BigInteger value)
  {
    NullCheck.notNull(value, "Value");
    return (value.compareTo(this.lower) >= 0) && (value.compareTo(this.upper)
                                                  <= 0);
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
    final RangeInclusiveB other)
  {
    NullCheck.notNull(other, "Other range");
    return (this.lower.compareTo(other.lower) >= 0) && (this.upper.compareTo(
      other.upper) <= 0);
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder(32);
    builder.append("[RangeInclusive ");
    builder.append(this.lower);
    builder.append(" ");
    builder.append(this.upper);
    builder.append("]");
    return NullCheck.notNull(builder.toString());
  }
}
