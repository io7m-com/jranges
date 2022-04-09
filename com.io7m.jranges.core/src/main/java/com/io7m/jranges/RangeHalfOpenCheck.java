/*
 * Copyright © 2015 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

import com.io7m.junreachable.UnreachableCodeException;

import java.math.BigInteger;
import java.util.Objects;

/**
 * <p> Functions for enforcing range constraints at run time. </p> <p> The
 * functions are intended for use in the manner of assertions. That is, the program should behave
 * identically if all of the checks are removed. The functions raise {@link RangeCheckException}
 * upon failure. Exceptions of this type are <i>not</i> intended to be caught and handled; they
 * indicate program bugs. </p>
 *
 * @see RangeCheckException
 * @since 4.0.0
 */

public final class RangeHalfOpenCheck
{
  private RangeHalfOpenCheck()
  {
    throw new UnreachableCodeException();
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in the given
   * range {@code range} (named {@code range_name}). </p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   *
   * @since 4.0.0
   */

  public static long checkIncludedInLong(
    final long x,
    final String x_name,
    final RangeHalfOpenL range,
    final String range_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(range, "Range");
    Objects.requireNonNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final var message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      Long.valueOf(range.lower()),
      x_name,
      Long.valueOf(x),
      Long.valueOf(range.upper()),
      range_name);

    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in the given
   * range {@code range} (named {@code range_name}). </p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   *
   * @since 4.0.0
   */

  public static int checkIncludedInInteger(
    final int x,
    final String x_name,
    final RangeHalfOpenI range,
    final String range_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(range, "Range");
    Objects.requireNonNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final var message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      Integer.valueOf(range.lower()),
      x_name,
      Integer.valueOf(x),
      Integer.valueOf(range.upper()),
      range_name);

    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in the given
   * range {@code range} (named {@code range_name}). </p>
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
    final RangeHalfOpenB range,
    final String range_name)
  {
    Objects.requireNonNull(x, "Value");
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(range, "Range");
    Objects.requireNonNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final var message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      range.lower(),
      x_name,
      x,
      range.upper(),
      range_name);

    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is included in the
   * given range {@code outer} (named {@code outer_name}). </p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   *
   * @since 4.0.0
   */

  public static RangeHalfOpenL checkRangeIncludedInLong(
    final RangeHalfOpenL inner,
    final String inner_name,
    final RangeHalfOpenL outer,
    final String outer_name)
  {
    Objects.requireNonNull(inner, "Inner range");
    Objects.requireNonNull(inner_name, "Inner range name");
    Objects.requireNonNull(outer, "Outer range");
    Objects.requireNonNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final var message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);

    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is included in the
   * given range {@code outer} (named {@code outer_name}). </p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   *
   * @since 4.0.0
   */

  public static RangeHalfOpenI checkRangeIncludedInInteger(
    final RangeHalfOpenI inner,
    final String inner_name,
    final RangeHalfOpenI outer,
    final String outer_name)
  {
    Objects.requireNonNull(inner, "Inner range");
    Objects.requireNonNull(inner_name, "Inner range name");
    Objects.requireNonNull(outer, "Outer range");
    Objects.requireNonNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final var message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);

    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is included in the
   * given range {@code outer} (named {@code outer_name}). </p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   */

  public static RangeHalfOpenB checkRangeIncludedInBig(
    final RangeHalfOpenB inner,
    final String inner_name,
    final RangeHalfOpenB outer,
    final String outer_name)
  {
    Objects.requireNonNull(inner, "Inner range");
    Objects.requireNonNull(inner_name, "Inner range name");
    Objects.requireNonNull(outer, "Outer range");
    Objects.requireNonNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final var message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);

    throw new RangeCheckException(message);
  }
}
