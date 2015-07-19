/*
 * Copyright © 2014 <code@io7m.com> http://io7m.com
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

/**
 * <p> Immutable type representing an inclusive range with <code>long</code>
 * components. </p>
 */

public final class RangeInclusiveL
{
  private final long interval;
  private final long lower;
  private final long upper;

  /**
   * Construct an inclusive range. The constructor enforces the invariant
   * <code>lower &lt;= upper</code>.
   *
   * @param in_lower The lower bound
   * @param in_upper The upper bound
   */

  public RangeInclusiveL(
    final long in_lower,
    final long in_upper)
  {
    RangeCheck.checkLessEqualLong(in_lower, "lower", in_upper, "upper");
    this.lower = in_lower;
    this.upper = in_upper;
    this.interval = (this.upper - this.lower) + 1;
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
    final RangeInclusiveL other = (RangeInclusiveL) obj;
    return this.lower == other.lower && this.upper == other.upper;
  }

  /**
   * <p> Retrieve the number of values in the range <code>[lower, upper]</code>.
   * That is, <code>(upper - lower) + 1</code>. <p>
   *
   * @return The number of values in the range
   */

  public long getInterval()
  {
    return this.interval;
  }

  /**
   * @return The lower bound of the inclusive range.
   */

  public long getLower()
  {
    return this.lower;
  }

  /**
   * @return The upper bound of the inclusive range.
   */

  public long getUpper()
  {
    return this.upper;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + (int) (this.lower ^ (this.lower >>> 32));
    result = (prime * result) + (int) (this.upper ^ (this.upper >>> 32));
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
    final long value)
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
    final RangeInclusiveL other)
  {
    NullCheck.notNull(other, "Other range");
    return (this.lower >= other.lower) && (this.upper <= other.upper);
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder();
    builder.append("[RangeInclusive ");
    builder.append(this.lower);
    builder.append(" ");
    builder.append(this.upper);
    builder.append("]");
    final String message = builder.toString();
    assert message != null;
    return message;
  }
}
