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
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class RangeCheckTest
{
  @Test(expected = RangeCheckException.class)
  public void testGreaterLong_0()
  {
    RangeCheck.checkGreaterLong(0L, "x", 0L, "lower");
  }

  @Test
  public void testGreaterLong_1()
  {
    Assert.assertEquals(2L, RangeCheck.checkGreaterLong(2L, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterInteger_0()
  {
    RangeCheck.checkGreaterInteger(0, "x", 0, "lower");
  }

  @Test
  public void testGreaterInteger_1()
  {
    Assert.assertEquals(2L, RangeCheck.checkGreaterInteger(2, "x", 1, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterBig_0()
  {
    RangeCheck.checkGreaterBig(BigInteger.ZERO, "x", BigInteger.ZERO, "lower");
  }

  @Test
  public void testGreaterBig_1()
  {
    Assert.assertEquals(
      BigInteger.ONE, RangeCheck.checkGreaterBig(
        BigInteger.ONE, "x", BigInteger.ZERO, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterDouble_0()
  {
    RangeCheck.checkGreaterDouble(0L, "x", 0L, "lower");
  }

  @Test
  public void testGreaterDouble_1()
  {
    Assert.assertEquals(
      2L, RangeCheck.checkGreaterDouble(2L, "x", 1L, "lower"), 0.0);
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualLong_0()
  {
    RangeCheck.checkGreaterEqualLong(0L, "x", 1L, "lower");
  }

  @Test
  public void testGreaterEqualLong_1()
  {
    Assert.assertEquals(
      1L, RangeCheck.checkGreaterEqualLong(1L, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualInteger_0()
  {
    RangeCheck.checkGreaterEqualInteger(0, "x", 1, "lower");
  }

  @Test
  public void testGreaterEqualInteger_1()
  {
    Assert.assertEquals(
      1L, RangeCheck.checkGreaterEqualInteger(1, "x", 1, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualBig_0()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO, "x", BigInteger.ONE, "lower");
  }

  @Test
  public void testGreaterEqualBig_1()
  {
    Assert.assertEquals(
      BigInteger.ONE, RangeCheck.checkGreaterEqualBig(
        BigInteger.ONE, "x", BigInteger.ONE, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualDouble_0()
  {
    RangeCheck.checkGreaterEqualDouble(0.0, "x", 1.0, "lower");
  }

  @Test
  public void testGreaterEqualDouble_1()
  {
    Assert.assertEquals(
      1L, RangeCheck.checkGreaterEqualDouble(1.0, "x", 1.0, "lower"), 0.0);
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullDouble_0()
  {
    RangeCheck.checkGreaterEqualDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullDouble_1()
  {
    RangeCheck.checkGreaterEqualDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullLong_0()
  {
    RangeCheck.checkGreaterEqualLong(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullLong_1()
  {
    RangeCheck.checkGreaterEqualLong(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullInteger_0()
  {
    RangeCheck.checkGreaterEqualInteger(
      0, (String) TestUtilities.actuallyNull(), 1, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullInteger_1()
  {
    RangeCheck.checkGreaterEqualInteger(
      0, "x", 1, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullBig_0()
  {
    RangeCheck.checkGreaterEqualBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullBig_1()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullBig_2()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullBig_3()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullLong_0()
  {
    RangeCheck.checkGreaterLong(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullLong_1()
  {
    RangeCheck.checkGreaterLong(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullInteger_0()
  {
    RangeCheck.checkGreaterInteger(
      0, (String) TestUtilities.actuallyNull(), 1, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullInteger_1()
  {
    RangeCheck.checkGreaterInteger(
      0, "x", 1, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullBig_0()
  {
    RangeCheck.checkGreaterBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullBig_1()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullBig_2()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullBig_3()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullDouble_0()
  {
    RangeCheck.checkGreaterDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullDouble_1()
  {
    RangeCheck.checkGreaterDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullBig_0()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      (BigInteger) TestUtilities.actuallyNull(), "value", range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullBig_1()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      BigInteger.ZERO, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullBig_2()
  {
    RangeCheck.checkIncludedInBig(
      BigInteger.ZERO,
      "name",
      (RangeInclusiveB) TestUtilities.actuallyNull(),
      "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullBig_3()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      BigInteger.ZERO, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedBigRange_0()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      BigInteger.valueOf(-1), "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedBigRange_1()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(BigInteger.TEN, "Value", range, "Range");
  }

  @Test
  public void testIncludedBigRange_2()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assert.assertEquals(
      BigInteger.ZERO, RangeCheck.checkIncludedInBig(
        BigInteger.ZERO, "Value", range, "Range"));
  }

  @Test
  public void testIncludedBigRange_3()
  {
    final RangeInclusiveB range =
      RangeInclusiveB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assert.assertEquals(
      BigInteger.valueOf(9), RangeCheck.checkIncludedInBig(
        BigInteger.valueOf(9), "Value", range, "Range"));
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullLong_0()
  {
    final RangeInclusiveL range = RangeInclusiveL.of(0, 9);
    RangeCheck.checkIncludedInLong(
      0L, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullLong_1()
  {
    RangeCheck.checkIncludedInLong(
      0L, "name", (RangeInclusiveL) TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullLong_2()
  {
    final RangeInclusiveL range = RangeInclusiveL.of(0, 9);
    RangeCheck.checkIncludedInLong(
      0L, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullInteger_0()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(
      0, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullInteger_1()
  {
    RangeCheck.checkIncludedInInteger(
      0, "name", (RangeInclusiveI) TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullInteger_2()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(
      0, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeLong_0()
  {
    final RangeInclusiveL range = RangeInclusiveL.of(0, 9);
    RangeCheck.checkIncludedInLong(-1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeLong_1()
  {
    final RangeInclusiveL range = RangeInclusiveL.of(0, 9);
    RangeCheck.checkIncludedInLong(10, "Value", range, "Range");
  }

  @Test
  public void testIncludedRangeLong_2()
  {
    final RangeInclusiveL range = RangeInclusiveL.of(0, 9);
    Assert.assertEquals(
      0, RangeCheck.checkIncludedInLong(0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeLong_3()
  {
    final RangeInclusiveL range = RangeInclusiveL.of(0, 9);
    Assert.assertEquals(
      9, RangeCheck.checkIncludedInLong(9, "Value", range, "Range"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessLong_0()
  {
    RangeCheck.checkLessLong(0L, "x", 0L, "upper");
  }

  @Test
  public void testLessLong_1()
  {
    Assert.assertEquals(0L, RangeCheck.checkLessLong(0L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeInteger_0()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(-1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeInteger_1()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(10, "Value", range, "Range");
  }

  @Test
  public void testIncludedRangeInteger_2()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      0, RangeCheck.checkIncludedInInteger(0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeInteger_3()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      9, RangeCheck.checkIncludedInInteger(9, "Value", range, "Range"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessInteger_0()
  {
    RangeCheck.checkLessInteger(0, "x", 0, "upper");
  }

  @Test
  public void testLessInteger_1()
  {
    Assert.assertEquals(0L, RangeCheck.checkLessInteger(0, "x", 1, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessBig_0()
  {
    RangeCheck.checkLessBig(BigInteger.ZERO, "x", BigInteger.ZERO, "upper");
  }

  @Test
  public void testLessBig_1()
  {
    Assert.assertEquals(
      BigInteger.ZERO,
      RangeCheck.checkLessBig(BigInteger.ZERO, "x", BigInteger.ONE, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessDouble_0()
  {
    RangeCheck.checkLessDouble(0.0, "x", 0.0, "upper");
  }

  @Test
  public void testLessDouble_1()
  {
    Assert.assertEquals(
      0.0, RangeCheck.checkLessDouble(0.0, "x", 1.0, "upper"), 0.0);
  }

  @Test(expected = RangeCheckException.class)
  public void testLessEqualLong_0()
  {
    RangeCheck.checkLessEqualLong(1L, "x", 0L, "upper");
  }

  @Test
  public void testLessEqualLong_1()
  {
    Assert.assertEquals(
      1L,
      RangeCheck.checkLessEqualLong(1L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessEqualInteger_0()
  {
    RangeCheck.checkLessEqualInteger(1, "x", 0, "upper");
  }

  @Test
  public void testLessEqualInteger_1()
  {
    Assert.assertEquals(
      1L,
      RangeCheck.checkLessEqualInteger(1, "x", 1, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessEqualBig_0()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ONE, "x", BigInteger.ZERO, "upper");
  }

  @Test
  public void testLessEqualBig_1()
  {
    Assert.assertEquals(
      BigInteger.ONE, RangeCheck.checkLessEqualBig(
        BigInteger.ONE, "x", BigInteger.ONE, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessEqualDouble_0()
  {
    RangeCheck.checkLessEqualDouble(1.0, "x", 0.0, "upper");
  }

  @Test
  public void testLessEqualDouble_1()
  {
    Assert.assertEquals(
      1.0, RangeCheck.checkLessEqualDouble(1.0, "x", 1.0, "upper"), 0.0);
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullLong_0()
  {
    RangeCheck.checkLessEqualLong(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullLong_1()
  {
    RangeCheck.checkLessEqualLong(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullInteger_0()
  {
    RangeCheck.checkLessEqualInteger(
      0, (String) TestUtilities.actuallyNull(), 1, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullInteger_1()
  {
    RangeCheck.checkLessEqualInteger(
      0, "x", 1, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullBig_0()
  {
    RangeCheck.checkLessEqualBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullBig_1()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullBig_2()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullBig_3()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullDouble_0()
  {
    RangeCheck.checkLessEqualDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullDouble_1()
  {
    RangeCheck.checkLessEqualDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullLong_0()
  {
    RangeCheck.checkLessLong(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullLong_1()
  {
    RangeCheck.checkLessLong(
      0L,
      "x",
      1L,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullInteger_0()
  {
    RangeCheck.checkLessInteger(
      0, (String) TestUtilities.actuallyNull(), 1, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullInteger_1()
  {
    RangeCheck.checkLessInteger(
      0, "x", 1, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullBig_0()
  {
    RangeCheck.checkLessBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullBig_1()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullBig_2()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullBig_3()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullDouble_0()
  {
    RangeCheck.checkLessDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullDouble_1()
  {
    RangeCheck.checkLessDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test
  public void testRangeIncludedLong_0()
  {
    Assert.assertEquals(
      RangeInclusiveL.of(0, 0), RangeCheck.checkRangeIncludedInLong(
        RangeInclusiveL.of(0, 0),
        "Inner",
        RangeInclusiveL.of(0, 0),
        "Outer"));
  }

  @Test(expected = RangeCheckException.class)
  public void testRangeIncludedLong_1()
  {
    RangeCheck.checkRangeIncludedInLong(
      RangeInclusiveL.of(1, 1), "Inner", RangeInclusiveL.of(0, 0), "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_0()
  {
    RangeCheck.checkRangeIncludedInLong(
      (RangeInclusiveL) TestUtilities.actuallyNull(),
      "Inner",
      RangeInclusiveL.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_1()
  {
    RangeCheck.checkRangeIncludedInLong(
      RangeInclusiveL.of(0, 0),
      (String) TestUtilities.actuallyNull(),
      RangeInclusiveL.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_2()
  {
    RangeCheck.checkRangeIncludedInLong(
      RangeInclusiveL.of(0, 0),
      "Inner",
      (RangeInclusiveL) TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_3()
  {
    RangeCheck.checkRangeIncludedInLong(
      RangeInclusiveL.of(0, 0),
      "Inner",
      RangeInclusiveL.of(0, 0),
      (String) TestUtilities.actuallyNull());
  }

  @Test
  public void testRangeIncludedInteger_0()
  {
    Assert.assertEquals(
      RangeInclusiveI.of(0, 0), RangeCheck.checkRangeIncludedInInteger(
        RangeInclusiveI.of(0, 0),
        "Inner",
        RangeInclusiveI.of(0, 0),
        "Outer"));
  }

  @Test(expected = RangeCheckException.class)
  public void testRangeIncludedInteger_1()
  {
    RangeCheck.checkRangeIncludedInInteger(
      RangeInclusiveI.of(1, 1), "Inner", RangeInclusiveI.of(0, 0), "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_0()
  {
    RangeCheck.checkRangeIncludedInInteger(
      (RangeInclusiveI) TestUtilities.actuallyNull(),
      "Inner",
      RangeInclusiveI.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_1()
  {
    RangeCheck.checkRangeIncludedInInteger(
      RangeInclusiveI.of(0, 0),
      (String) TestUtilities.actuallyNull(),
      RangeInclusiveI.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_2()
  {
    RangeCheck.checkRangeIncludedInInteger(
      RangeInclusiveI.of(0, 0),
      "Inner",
      (RangeInclusiveI) TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_3()
  {
    RangeCheck.checkRangeIncludedInInteger(
      RangeInclusiveI.of(0, 0),
      "Inner",
      RangeInclusiveI.of(0, 0),
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullBig_0()
  {
    RangeCheck.checkRangeIncludedInBig(
      (RangeInclusiveB) TestUtilities.actuallyNull(),
      "Inner",
      RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullBig_1()
  {
    RangeCheck.checkRangeIncludedInBig(
      RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
      (String) TestUtilities.actuallyNull(),
      RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullBig_2()
  {
    RangeCheck.checkRangeIncludedInBig(
      RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
      "Inner",
      (RangeInclusiveB) TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullBig_3()
  {
    RangeCheck.checkRangeIncludedInBig(
      RangeInclusiveB.of(
        BigInteger.ZERO, BigInteger.ZERO),
      "Inner",
      RangeInclusiveB.of(
        BigInteger.ZERO, BigInteger.ZERO),
      (String) TestUtilities.actuallyNull());
  }

  @Test
  public void testRangeIncludedBig_0()
  {
    Assert.assertEquals(
      RangeInclusiveB.of(BigInteger.ZERO, BigInteger.ZERO),
      RangeCheck.checkRangeIncludedInBig(
        RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Inner", RangeInclusiveB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Outer"));
  }

  @Test(expected = RangeCheckException.class)
  public void testRangeIncludedBig_1()
  {
    RangeCheck.checkRangeIncludedInBig(
      RangeInclusiveB.of(
        BigInteger.ONE, BigInteger.ONE), "Inner", RangeInclusiveB.of(
        BigInteger.ZERO, BigInteger.ZERO), "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedIntNull_1()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(
      0, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedIntNull_2()
  {
    RangeCheck.checkIncludedInInteger(
      0, "name", (RangeInclusiveI) TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedIntNull_3()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(
      0, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedIntRange_0()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(
      -1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedIntRange_1()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    RangeCheck.checkIncludedInInteger(10, "Value", range, "Range");
  }

  @Test
  public void testIncludedIntRange_2()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      0, RangeCheck.checkIncludedInInteger(
        0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedIntRange_3()
  {
    final RangeInclusiveI range = RangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      9, RangeCheck.checkIncludedInInteger(
        9, "Value", range, "Range"));
  }

}
