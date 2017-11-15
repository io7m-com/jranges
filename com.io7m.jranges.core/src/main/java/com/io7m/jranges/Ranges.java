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

import com.io7m.junreachable.UnreachableCodeException;

/**
 * Predefined ranges.
 *
 * @since 2.0.0
 */

public final class Ranges
{
  /**
   * The inclusive range of numbers greater than or equal to {@code 0}, {@code
   * [0, {@link Double#MAX_VALUE}]}.
   *
   * @since 2.0.0
   */

  public static final RangeInclusiveD NATURAL_DOUBLE;

  /**
   * The inclusive range of natural long integers, {@code [0, {@link
   * Long#MAX_VALUE}]}.
   *
   * @since 2.0.0
   */

  public static final RangeInclusiveL NATURAL_LONG;

  /**
   * The inclusive range of natural  integers, {@code [0, {@link
   * Integer#MAX_VALUE}]}.
   *
   * @since 2.0.0
   */

  public static final RangeInclusiveI NATURAL_INTEGER;

  /**
   * The inclusive range of numbers greater than or equal to {@code 1}, {@code
   * [1, {@link Double#MAX_VALUE}]}.
   *
   * @since 2.0.0
   */

  public static final RangeInclusiveD POSITIVE_DOUBLE;

  /**
   * The inclusive range of positive long integers, {@code [1, {@link
   * Long#MAX_VALUE}]}.
   *
   * @since 2.0.0
   */

  public static final RangeInclusiveL POSITIVE_LONG;

  /**
   * The inclusive range of positive  integers, {@code [1, {@link
   * Integer#MAX_VALUE}]}.
   *
   * @since 2.0.0
   */

  public static final RangeInclusiveI POSITIVE_INTEGER;

  static {
    POSITIVE_LONG = RangeInclusiveL.of(1L, Long.MAX_VALUE);
    NATURAL_LONG = RangeInclusiveL.of(0L, Long.MAX_VALUE);
    POSITIVE_INTEGER = RangeInclusiveI.of(1, Integer.MAX_VALUE);
    NATURAL_INTEGER = RangeInclusiveI.of(0, Integer.MAX_VALUE);
    NATURAL_DOUBLE = RangeInclusiveD.of(0.0, Double.MAX_VALUE);
    POSITIVE_DOUBLE = RangeInclusiveD.of(1.0, Double.MAX_VALUE);
  }

  private Ranges()
  {
    throw new UnreachableCodeException();
  }
}
