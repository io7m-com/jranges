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

import com.io7m.jequality.annotations.EqualityReference;
import com.io7m.jnull.NullCheck;
import com.io7m.junreachable.UnreachableCodeException;
import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;

/**
 * <p> Functions for enforcing range constraints at run time. </p> <p> The
 * functions are intended for use in the manner of assertions. That is, the
 * program should behave identically if all of the checks are removed. The
 * functions raise {@link RangeCheckException} upon failure. Exceptions of this
 * type are <i>not</i> intended to be caught and handled; they indicate program
 * bugs. </p>
 *
 * @see RangeCheckException
 */

@EqualityReference @ThreadSafe public final class RangeCheck
{
  private RangeCheck()
  {
    throw new UnreachableCodeException();
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static long checkGreaterLong(
    final long x,
    final String x_name,
    final long in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x > in_lower) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) <= %s (%d)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static int checkGreaterInteger(
    final int x,
    final String x_name,
    final int in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x > in_lower) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) <= %s (%d)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static BigInteger checkGreaterBig(
    final BigInteger x,
    final String x_name,
    final BigInteger in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x, "Value");
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(in_lower, "Lower");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x.compareTo(in_lower) > 0) {
      return x;
    }

    final String message =
      String.format("%s (%s) <= %s (%s)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static double checkGreaterDouble(
    final double x,
    final String x_name,
    final double in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x > in_lower) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%f) <= %s (%f)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * or equal to {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of x
   * @param lower_name The name of the lower bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static long checkGreaterEqualLong(
    final long x,
    final String x_name,
    final long in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x >= in_lower) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) < %s (%d)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * or equal to {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of x
   * @param lower_name The name of the lower bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static int checkGreaterEqualInteger(
    final int x,
    final String x_name,
    final int in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x >= in_lower) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) < %s (%d)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * or equal to {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static BigInteger checkGreaterEqualBig(
    final BigInteger x,
    final String x_name,
    final BigInteger in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x, "Value");
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(in_lower, "Lower");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x.compareTo(in_lower) >= 0) {
      return x;
    }

    final String message =
      String.format("%s (%s) < %s (%s)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is greater than
   * or equal to {@code in_lower} (named {@code lower_name}). </p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of x
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static double checkGreaterEqualDouble(
    final double x,
    final String x_name,
    final double in_lower,
    final String lower_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(lower_name, "Lower bound name");

    if (x >= in_lower) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%f) < %s (%f)", x_name, x, lower_name, in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in
   * the given range {@code range} (named {@code range_name}). </p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static long checkIncludedInLong(
    final long x,
    final String x_name,
    final RangeInclusiveL range,
    final String range_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(range, "Range");
    NullCheck.notNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final String message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      Long.valueOf(range.getLower()),
      x_name,
      Long.valueOf(x),
      Long.valueOf(range.getUpper()),
      range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in
   * the given range {@code range} (named {@code range_name}). </p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static int checkIncludedInInteger(
    final int x,
    final String x_name,
    final RangeInclusiveI range,
    final String range_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(range, "Range");
    NullCheck.notNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final String message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      Integer.valueOf(range.getLower()),
      x_name,
      Integer.valueOf(x),
      Integer.valueOf(range.getUpper()),
      range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in
   * the given range {@code range} (named {@code range_name}). </p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   */

  public static BigInteger checkIncludedInBig(
    final BigInteger x,
    final String x_name,
    final RangeInclusiveB range,
    final String range_name)
  {
    NullCheck.notNull(x, "Value");
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(range, "Range");
    NullCheck.notNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final String message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      range.getLower(),
      x_name,
      x,
      range.getUpper(),
      range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than
   * {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static long checkLessLong(
    final long x,
    final String x_name,
    final long in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x < in_upper) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) >= %s (%d)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than
   * {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static int checkLessInteger(
    final int x,
    final String x_name,
    final int in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x < in_upper) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) >= %s (%d)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than
   * {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static BigInteger checkLessBig(
    final BigInteger x,
    final String x_name,
    final BigInteger in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x, "Value");
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(in_upper, "Upper");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x.compareTo(in_upper) < 0) {
      return x;
    }

    final String message =
      String.format("%s (%s) >= %s (%s)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than
   * {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static double checkLessDouble(
    final double x,
    final String x_name,
    final double in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x < in_upper) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%f) >= %s (%f)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than or
   * equal to {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of x
   * @param upper_name The name of the upper bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static long checkLessEqualLong(
    final long x,
    final String x_name,
    final long in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x <= in_upper) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) > %s (%d)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than or
   * equal to {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of x
   * @param upper_name The name of the upper bound
   *
   * @return x
   *
   * @since 2.0.0
   */

  public static int checkLessEqualInteger(
    final int x,
    final String x_name,
    final int in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x <= in_upper) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%d) > %s (%d)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than or
   * equal to {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static BigInteger checkLessEqualBig(
    final BigInteger x,
    final String x_name,
    final BigInteger in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x, "Value");
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(in_upper, "Upper");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x.compareTo(in_upper) <= 0) {
      return x;
    }

    final String message =
      String.format("%s (%s) > %s (%s)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is less than or
   * equal to {@code in_upper} (named {@code upper_name}). </p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of x
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static double checkLessEqualDouble(
    final double x,
    final String x_name,
    final double in_upper,
    final String upper_name)
  {
    NullCheck.notNull(x_name, "Value name");
    NullCheck.notNull(upper_name, "Upper bound name");

    if (x <= in_upper) {
      return x;
    }

    @SuppressWarnings("boxing") final String message =
      String.format("%s (%f) > %s (%f)", x_name, x, upper_name, in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is
   * included in the given range {@code outer} (named
   * {@code outer_name}). </p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   *
   * @since 2.0.0
   */

  public static RangeInclusiveL checkRangeIncludedInLong(
    final RangeInclusiveL inner,
    final String inner_name,
    final RangeInclusiveL outer,
    final String outer_name)
  {
    NullCheck.notNull(inner, "Inner range");
    NullCheck.notNull(inner_name, "Inner range name");
    NullCheck.notNull(outer, "Outer range");
    NullCheck.notNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final String message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is
   * included in the given range {@code outer} (named
   * {@code outer_name}). </p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   *
   * @since 2.0.0
   */

  public static RangeInclusiveI checkRangeIncludedInInteger(
    final RangeInclusiveI inner,
    final String inner_name,
    final RangeInclusiveI outer,
    final String outer_name)
  {
    NullCheck.notNull(inner, "Inner range");
    NullCheck.notNull(inner_name, "Inner range name");
    NullCheck.notNull(outer, "Outer range");
    NullCheck.notNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final String message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is
   * included in the given range {@code outer} (named
   * {@code outer_name}). </p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   */

  public static RangeInclusiveB checkRangeIncludedInBig(
    final RangeInclusiveB inner,
    final String inner_name,
    final RangeInclusiveB outer,
    final String outer_name)
  {
    NullCheck.notNull(inner, "Inner range");
    NullCheck.notNull(inner_name, "Inner range name");
    NullCheck.notNull(outer, "Outer range");
    NullCheck.notNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final String message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);
    assert message != null;
    throw new RangeCheckException(message);
  }
}
