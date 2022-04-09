/*
 * Copyright © 2019 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

import com.io7m.immutables.styles.ImmutablesStyleType;
import org.immutables.value.Value;

import java.util.Objects;

/**
 * A half open (inclusive lower, exclusive upper) range with {@code int} components.
 *
 * @since 4.0.0
 */

@ImmutablesStyleType
@Value.Immutable
public interface RangeHalfOpenIType
{
  /**
   * @return The lower bound of the inclusive range.
   */

  @Value.Parameter
  int lower();

  /**
   * @return The upper bound of the inclusive range.
   */

  @Value.Parameter
  int upper();

  /**
   * <p>Retrieve the number of values in the range {@code [lower, upper)}. That
   * is, {@code (upper - lower)}.<p>
   *
   * @return The number of values in the range
   */

  default int interval()
  {
    return this.upper() - this.lower();
  }

  /**
   * <p> Determine if the given value is included in this range. </p>
   *
   * @param value The given value
   *
   * @return {@code true} iff {@code value &gt;= this.getLower() &amp;&amp; value &lt;
   * this.getUpper()} .
   */

  default boolean includesValue(
    final int value)
  {
    return (value >= this.lower()) && (value < this.upper());
  }

  /**
   * <p> Determine if the given range is included in this range. </p>
   *
   * @param other The given range
   *
   * @return {@code true} iff {@code this.getLower() &gt;= other.getLower() &amp;&amp;
   * this.getUpper() &lt;= other.getUpper()} .
   */

  default boolean isIncludedIn(
    final RangeHalfOpenI other)
  {
    Objects.requireNonNull(other, "Other range");
    return (this.lower() >= other.lower()) && (this.upper() <= other.upper());
  }

  /**
   * <p> Determine if the given range is included in this range. </p>
   *
   * @param other The given range
   *
   * @return {@code true} iff {@code this.getLower() &gt;= other.getLower() &amp;&amp;
   * this.getUpper() &lt;= other.getUpper()} .
   */

  default boolean isIncludedIn(
    final RangeInclusiveI other)
  {
    Objects.requireNonNull(other, "Other range");
    return (this.lower() >= other.lower()) && (this.upper() <= other.upper());
  }

  /**
   * Check preconditions for the type.
   */

  @Value.Check
  default void checkPreconditions()
  {
    RangeCheck.checkLessEqualInteger(
      this.lower(), "lower", this.upper(), "upper");
  }
}
