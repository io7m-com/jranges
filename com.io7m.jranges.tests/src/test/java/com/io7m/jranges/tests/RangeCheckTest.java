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

package com.io7m.jranges.tests;

import com.io7m.jranges.RangeCheck;
import com.io7m.jranges.RangeCheckException;
import com.io7m.jranges.RangeInclusiveB;
import com.io7m.jranges.RangeInclusiveI;
import com.io7m.jranges.RangeInclusiveL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class RangeCheckTest
{
  @Test
  public void testGreaterLong_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterLong(0L, "x", 0L, "lower");
    });
  }

  @Test
  public void testGreaterLong_1()
  {
    Assertions.assertEquals(2L, RangeCheck.checkGreaterLong(2L, "x", 1L, "lower"));
  }

  @Test
  public void testGreaterInteger_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterInteger(0, "x", 0, "lower");
    });
  }

  @Test
  public void testGreaterInteger_1()
  {
    Assertions.assertEquals(2L, RangeCheck.checkGreaterInteger(2, "x", 1, "lower"));
  }

  @Test
  public void testGreaterBig_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterBig(BigInteger.ZERO, "x", BigInteger.ZERO, "lower");
    });
  }

  @Test
  public void testGreaterBig_1()
  {
    Assertions.assertEquals(
      BigInteger.ONE, RangeCheck.checkGreaterBig(
        BigInteger.ONE, "x", BigInteger.ZERO, "lower"));
  }

  @Test
  public void testGreaterDouble_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterDouble(0L, "x", 0L, "lower");
    });
  }

  @Test
  public void testGreaterDouble_1()
  {
    Assertions.assertEquals(
      2L, RangeCheck.checkGreaterDouble(2L, "x", 1L, "lower"), 0.0);
  }

  @Test
  public void testGreaterEqualLong_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterEqualLong(0L, "x", 1L, "lower");
    });
  }

  @Test
  public void testGreaterEqualLong_1()
  {
    Assertions.assertEquals(
      1L, RangeCheck.checkGreaterEqualLong(1L, "x", 1L, "lower"));
  }

  @Test
  public void testGreaterEqualInteger_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterEqualInteger(0, "x", 1, "lower");
    });
  }

  @Test
  public void testGreaterEqualInteger_1()
  {
    Assertions.assertEquals(
      1L, RangeCheck.checkGreaterEqualInteger(1, "x", 1, "lower"));
  }

  @Test
  public void testGreaterEqualBig_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterEqualBig(
        BigInteger.ZERO, "x", BigInteger.ONE, "lower");
    });
  }

  @Test
  public void testGreaterEqualBig_1()
  {
    Assertions.assertEquals(
      BigInteger.ONE, RangeCheck.checkGreaterEqualBig(
        BigInteger.ONE, "x", BigInteger.ONE, "lower"));
  }

  @Test
  public void testGreaterEqualDouble_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkGreaterEqualDouble(0.0, "x", 1.0, "lower");
    });
  }

  @Test
  public void testGreaterEqualDouble_1()
  {
    Assertions.assertEquals(
      1L, RangeCheck.checkGreaterEqualDouble(1.0, "x", 1.0, "lower"), 0.0);
  }

  @Test
  public void testGreaterEqualNullDouble_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualDouble(
        0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
    });
  }

  @Test
  public void testGreaterEqualNullDouble_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualDouble(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterEqualNullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualLong(
        0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
    });
  }

  @Test
  public void testGreaterEqualNullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualLong(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterEqualNullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualInteger(
        0, (String) TestUtilities.actuallyNull(), 1, "lower");
    });
  }

  @Test
  public void testGreaterEqualNullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualInteger(
        0, "x", 1, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterEqualNullBig_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualBig(
        (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "lower");
    });
  }

  @Test
  public void testGreaterEqualNullBig_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualBig(
        BigInteger.ZERO,
        (String) TestUtilities.actuallyNull(),
        BigInteger.ONE,
        "lower");
    });
  }

  @Test
  public void testGreaterEqualNullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualBig(
        BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "lower");
    });
  }

  @Test
  public void testGreaterEqualNullBig_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterEqualBig(
        BigInteger.ZERO,
        "x",
        BigInteger.ONE,
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterNullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterLong(
        0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
    });
  }

  @Test
  public void testGreaterNullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterLong(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterNullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterInteger(
        0, (String) TestUtilities.actuallyNull(), 1, "lower");
    });
  }

  @Test
  public void testGreaterNullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterInteger(
        0, "x", 1, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterNullBig_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterBig(
        (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "lower");
    });
  }

  @Test
  public void testGreaterNullBig_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterBig(
        BigInteger.ZERO,
        (String) TestUtilities.actuallyNull(),
        BigInteger.ONE,
        "lower");
    });
  }

  @Test
  public void testGreaterNullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterBig(
        BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "lower");
    });
  }

  @Test
  public void testGreaterNullBig_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterBig(
        BigInteger.ZERO,
        "x",
        BigInteger.ONE,
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testGreaterNullDouble_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterDouble(
        0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
    });
  }

  @Test
  public void testGreaterNullDouble_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkGreaterDouble(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedNullBig_0()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInBig(
        (BigInteger) TestUtilities.actuallyNull(), "value", range, "range");
    });
  }

  @Test
  public void testIncludedNullBig_1()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInBig(
        BigInteger.ZERO, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedNullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInBig(
        BigInteger.ZERO,
        "name",
        (RangeInclusiveB) TestUtilities.actuallyNull(),
        "range");
    });
  }

  @Test
  public void testIncludedNullBig_3()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInBig(
        BigInteger.ZERO, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedBigRange_0()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInBig(
        BigInteger.valueOf(-1), "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedBigRange_1()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInBig(BigInteger.TEN, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedBigRange_2()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertEquals(
      BigInteger.ZERO, RangeCheck.checkIncludedInBig(
        BigInteger.ZERO, "Value", range, "Range"));
  }

  @Test
  public void testIncludedBigRange_3()
  {
    final var range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertEquals(
      BigInteger.valueOf(9), RangeCheck.checkIncludedInBig(
        BigInteger.valueOf(9), "Value", range, "Range"));
  }

  @Test
  public void testIncludedNullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeInclusiveL.of(0, 9);
      RangeCheck.checkIncludedInLong(
        0L, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedNullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInLong(
        0L, "name", (RangeInclusiveL) TestUtilities.actuallyNull(), "range");
    });
  }

  @Test
  public void testIncludedNullLong_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeInclusiveL.of(0, 9);
      RangeCheck.checkIncludedInLong(
        0L, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedNullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeInclusiveI.of(0, 9);
      RangeCheck.checkIncludedInInteger(
        0, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedNullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInInteger(
        0, "name", (RangeInclusiveI) TestUtilities.actuallyNull(), "range");
    });
  }

  @Test
  public void testIncludedNullInteger_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeInclusiveI.of(0, 9);
      RangeCheck.checkIncludedInInteger(
        0, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedRangeLong_0()
  {
    final var range = RangeInclusiveL.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInLong(-1, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeLong_1()
  {
    final var range = RangeInclusiveL.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInLong(10, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeLong_2()
  {
    final var range = RangeInclusiveL.of(0, 9);
    Assertions.assertEquals(
      0, RangeCheck.checkIncludedInLong(0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeLong_3()
  {
    final var range = RangeInclusiveL.of(0, 9);
    Assertions.assertEquals(
      9, RangeCheck.checkIncludedInLong(9, "Value", range, "Range"));
  }

  @Test
  public void testLessLong_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessLong(0L, "x", 0L, "upper");
    });
  }

  @Test
  public void testLessLong_1()
  {
    Assertions.assertEquals(0L, RangeCheck.checkLessLong(0L, "x", 1L, "upper"));
  }

  @Test
  public void testIncludedRangeInteger_0()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInInteger(-1, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeInteger_1()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInInteger(10, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeInteger_2()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertEquals(
      0, RangeCheck.checkIncludedInInteger(0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeInteger_3()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertEquals(
      9, RangeCheck.checkIncludedInInteger(9, "Value", range, "Range"));
  }

  @Test
  public void testLessInteger_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessInteger(0, "x", 0, "upper");
    });
  }

  @Test
  public void testLessInteger_1()
  {
    Assertions.assertEquals(0L, RangeCheck.checkLessInteger(0, "x", 1, "upper"));
  }

  @Test
  public void testLessBig_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessBig(BigInteger.ZERO, "x", BigInteger.ZERO, "upper");
    });
  }

  @Test
  public void testLessBig_1()
  {
    Assertions.assertEquals(
      BigInteger.ZERO,
      RangeCheck.checkLessBig(BigInteger.ZERO, "x", BigInteger.ONE, "upper"));
  }

  @Test
  public void testLessDouble_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessDouble(0.0, "x", 0.0, "upper");
    });
  }

  @Test
  public void testLessDouble_1()
  {
    Assertions.assertEquals(
      0.0, RangeCheck.checkLessDouble(0.0, "x", 1.0, "upper"), 0.0);
  }

  @Test
  public void testLessEqualLong_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessEqualLong(1L, "x", 0L, "upper");
    });
  }

  @Test
  public void testLessEqualLong_1()
  {
    Assertions.assertEquals(
      1L,
      RangeCheck.checkLessEqualLong(1L, "x", 1L, "upper"));
  }

  @Test
  public void testLessEqualInteger_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessEqualInteger(1, "x", 0, "upper");
    });
  }

  @Test
  public void testLessEqualInteger_1()
  {
    Assertions.assertEquals(
      1L,
      RangeCheck.checkLessEqualInteger(1, "x", 1, "upper"));
  }

  @Test
  public void testLessEqualBig_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessEqualBig(
        BigInteger.ONE, "x", BigInteger.ZERO, "upper");
    });
  }

  @Test
  public void testLessEqualBig_1()
  {
    Assertions.assertEquals(
      BigInteger.ONE, RangeCheck.checkLessEqualBig(
        BigInteger.ONE, "x", BigInteger.ONE, "upper"));
  }

  @Test
  public void testLessEqualDouble_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkLessEqualDouble(1.0, "x", 0.0, "upper");
    });
  }

  @Test
  public void testLessEqualDouble_1()
  {
    Assertions.assertEquals(
      1.0, RangeCheck.checkLessEqualDouble(1.0, "x", 1.0, "upper"), 0.0);
  }

  @Test
  public void testLessEqualNullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualLong(
        0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
    });
  }

  @Test
  public void testLessEqualNullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualLong(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessEqualNullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualInteger(
        0, (String) TestUtilities.actuallyNull(), 1, "upper");
    });
  }

  @Test
  public void testLessEqualNullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualInteger(
        0, "x", 1, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessEqualNullBig_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualBig(
        (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "upper");
    });
  }

  @Test
  public void testLessEqualNullBig_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualBig(
        BigInteger.ZERO,
        (String) TestUtilities.actuallyNull(),
        BigInteger.ONE,
        "upper");
    });
  }

  @Test
  public void testLessEqualNullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualBig(
        BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "upper");
    });
  }

  @Test
  public void testLessEqualNullBig_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualBig(
        BigInteger.ZERO,
        "x",
        BigInteger.ONE,
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessEqualNullDouble_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualDouble(
        0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
    });
  }

  @Test
  public void testLessEqualNullDouble_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessEqualDouble(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessNullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessLong(
        0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
    });
  }

  @Test
  public void testLessNullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessLong(
        0L,
        "x",
        1L,
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessNullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessInteger(
        0, (String) TestUtilities.actuallyNull(), 1, "upper");
    });
  }

  @Test
  public void testLessNullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessInteger(
        0, "x", 1, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessNullBig_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessBig(
        (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "upper");
    });
  }

  @Test
  public void testLessNullBig_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessBig(
        BigInteger.ZERO,
        (String) TestUtilities.actuallyNull(),
        BigInteger.ONE,
        "upper");
    });
  }

  @Test
  public void testLessNullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessBig(
        BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "upper");
    });
  }

  @Test
  public void testLessNullBig_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessBig(
        BigInteger.ZERO,
        "x",
        BigInteger.ONE,
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testLessNullDouble_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessDouble(
        0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
    });
  }

  @Test
  public void testLessNullDouble_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkLessDouble(
        0L, "x", 1L, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncludedLong_0()
  {
    Assertions.assertEquals(
      RangeInclusiveL.of(0, 0), RangeCheck.checkRangeIncludedInLong(
        RangeInclusiveL.of(0, 0),
        "Inner",
        RangeInclusiveL.of(0, 0),
        "Outer"));
  }

  @Test
  public void testRangeIncludedLong_1()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkRangeIncludedInLong(
        RangeInclusiveL.of(1, 1), "Inner", RangeInclusiveL.of(0, 0), "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInLong(
        (RangeInclusiveL) TestUtilities.actuallyNull(),
        "Inner",
        RangeInclusiveL.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInLong(
        RangeInclusiveL.of(0, 0),
        (String) TestUtilities.actuallyNull(),
        RangeInclusiveL.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInLong(
        RangeInclusiveL.of(0, 0),
        "Inner",
        (RangeInclusiveL) TestUtilities.actuallyNull(),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInLong(
        RangeInclusiveL.of(0, 0),
        "Inner",
        RangeInclusiveL.of(0, 0),
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncludedInteger_0()
  {
    Assertions.assertEquals(
      RangeInclusiveI.of(0, 0), RangeCheck.checkRangeIncludedInInteger(
        RangeInclusiveI.of(0, 0),
        "Inner",
        RangeInclusiveI.of(0, 0),
        "Outer"));
  }

  @Test
  public void testRangeIncludedInteger_1()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkRangeIncludedInInteger(
        RangeInclusiveI.of(1, 1), "Inner", RangeInclusiveI.of(0, 0), "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInInteger(
        (RangeInclusiveI) TestUtilities.actuallyNull(),
        "Inner",
        RangeInclusiveI.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInInteger(
        RangeInclusiveI.of(0, 0),
        (String) TestUtilities.actuallyNull(),
        RangeInclusiveI.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInInteger(
        RangeInclusiveI.of(0, 0),
        "Inner",
        (RangeInclusiveI) TestUtilities.actuallyNull(),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInInteger(
        RangeInclusiveI.of(0, 0),
        "Inner",
        RangeInclusiveI.of(0, 0),
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncluded_NullBig_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInBig(
        (RangeInclusiveB) TestUtilities.actuallyNull(),
        "Inner",
        RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullBig_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInBig(
        RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
        (String) TestUtilities.actuallyNull(),
        RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInBig(
        RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
        "Inner",
        (RangeInclusiveB) TestUtilities.actuallyNull(),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullBig_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkRangeIncludedInBig(
        RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO),
        "Inner",
        RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO),
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncludedBig_0()
  {
    Assertions.assertEquals(
      RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
      RangeCheck.checkRangeIncludedInBig(
        RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Inner", RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Outer"));
  }

  @Test
  public void testRangeIncludedBig_1()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkRangeIncludedInBig(
        RangeInclusiveB.of(
          BigInteger.ONE, BigInteger.ONE), "Inner", RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Outer");
    });
  }

  @Test
  public void testIncludedIntNull_1()
  {
    final var range = RangeInclusiveI.of(0, 9);

    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInInteger(
        0, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedIntNull_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInInteger(
        0, "name", (RangeInclusiveI) TestUtilities.actuallyNull(), "range");
    });
  }

  @Test
  public void testIncludedIntNull_3()
  {
    final var range = RangeInclusiveI.of(0, 9);

    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeCheck.checkIncludedInInteger(
        0, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedIntRange_0()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInInteger(
        -1, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedIntRange_1()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeCheck.checkIncludedInInteger(10, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedIntRange_2()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertEquals(
      0, RangeCheck.checkIncludedInInteger(
        0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedIntRange_3()
  {
    final var range = RangeInclusiveI.of(0, 9);
    Assertions.assertEquals(
      9, RangeCheck.checkIncludedInInteger(
        9, "Value", range, "Range"));
  }

}
