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

import java.math.BigInteger;

import com.io7m.jequality.annotations.EqualityReference;
import com.io7m.jnull.NullCheck;
import com.io7m.junreachable.UnreachableCodeException;

/**
 * <p>
 * Functions for enforcing range constraints at run time.
 * </p>
 * <p>
 * The functions are intended for use in the manner of assertions. That is,
 * the program should behave identically if all of the checks are removed. The
 * functions raise {@link RangeCheckException} upon failure. Exceptions of
 * this type are <i>not</i> intended to be caught and handled; they indicate
 * program bugs.
 * </p>
 * 
 * @see RangeCheckException
 */

@EqualityReference public final class RangeCheck
{
  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is greater than
   * <code>in_lower</code> (named <code>lower_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_lower
   *          The lower bound
   * @param x_name
   *          The name of the checked value
   * @param lower_name
   *          The name of the lower bound
   * @return x
   */

  public static long checkGreater(
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
      String.format(
        "%s (%d) > %s (%d) == false",
        x_name,
        x,
        lower_name,
        in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is greater than
   * <code>in_lower</code> (named <code>lower_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_lower
   *          The lower bound
   * @param x_name
   *          The name of the checked value
   * @param lower_name
   *          The name of the lower bound
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
      String.format(
        "%s (%s) > %s (%s) == false",
        x_name,
        x,
        lower_name,
        in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is greater than or
   * equal to <code>in_lower</code> (named <code>lower_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_lower
   *          The lower bound
   * @param x_name
   *          The name of x
   * @param lower_name
   *          The name of the lower bound
   * @return x
   */

  public static long checkGreaterEqual(
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
      String.format(
        "%s (%d) >= %s (%d) == false",
        x_name,
        x,
        lower_name,
        in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is greater than or
   * equal to <code>in_lower</code> (named <code>lower_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_lower
   *          The lower bound
   * @param x_name
   *          The name of the checked value
   * @param lower_name
   *          The name of the lower bound
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
      String.format(
        "%s (%s) >= %s (%s) == false",
        x_name,
        x,
        lower_name,
        in_lower);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is included in the
   * given range <code>range</code> (named <code>range_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param x_name
   *          The name of the checked value
   * @param range
   *          The inclusive range
   * @param range_name
   *          The name of the inclusive range
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

    final String message =
      String.format(
        "%s >= %s (%s) <= %s (%s) == false",
        range.getLower(),
        x_name,
        x,
        range.getUpper(),
        range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is included in the
   * given range <code>range</code> (named <code>range_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param x_name
   *          The name of the checked value
   * @param range
   *          The inclusive range
   * @param range_name
   *          The name of the inclusive range
   * @return x
   */

  public static long checkIncludedIn(
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

    final String message =
      String.format(
        "%s >= %s (%s) <= %s (%s) == false",
        Long.valueOf(range.getLower()),
        x_name,
        Long.valueOf(x),
        Long.valueOf(range.getUpper()),
        range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is less than
   * <code>in_upper</code> (named <code>upper_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_upper
   *          The upper bound
   * @param x_name
   *          The name of the checked value
   * @param upper_name
   *          The name of the upper bound
   * @return x
   */

  public static long checkLess(
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
      String.format(
        "%s (%d) < %s (%d) == false",
        x_name,
        x,
        upper_name,
        in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is less than
   * <code>in_upper</code> (named <code>upper_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_upper
   *          The upper bound
   * @param x_name
   *          The name of the checked value
   * @param upper_name
   *          The name of the upper bound
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
      String.format(
        "%s (%s) < %s (%s) == false",
        x_name,
        x,
        upper_name,
        in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is less than or
   * equal to <code>in_upper</code> (named <code>upper_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_upper
   *          The upper bound
   * @param x_name
   *          The name of x
   * @param upper_name
   *          The name of the upper bound
   * @return x
   */

  public static long checkLessEqual(
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
      String.format(
        "%s (%d) <= %s (%d) == false",
        x_name,
        x,
        upper_name,
        in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>
   * Assert that <code>x</code> (named <code>x_name</code>) is less than or
   * equal to <code>in_upper</code> (named <code>upper_name</code>).
   * </p>
   * 
   * @param x
   *          The checked value
   * @param in_upper
   *          The upper bound
   * @param x_name
   *          The name of the checked value
   * @param upper_name
   *          The name of the upper bound
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
      String.format(
        "%s (%s) <= %s (%s) == false",
        x_name,
        x,
        upper_name,
        in_upper);
    assert message != null;
    throw new RangeCheckException(message);
  }

  private RangeCheck()
  {
    throw new UnreachableCodeException();
  }
}
