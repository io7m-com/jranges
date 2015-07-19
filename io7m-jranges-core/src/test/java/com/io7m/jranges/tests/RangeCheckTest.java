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

import com.io7m.jnull.NullCheckException;
import com.io7m.jranges.RangeCheck;
import com.io7m.jranges.RangeCheckException;
import com.io7m.jranges.RangeInclusiveB;
import com.io7m.jranges.RangeInclusiveI;
import com.io7m.jranges.RangeInclusiveL;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

@SuppressWarnings({ "null", "static-method" }) public class RangeCheckTest
{
  @Test(expected = RangeCheckException.class) public void testGreater_0()
  {
    RangeCheck.checkGreater(0L, "x", 0L, "lower");
  }

  @Test public void testGreater_1()
  {
    Assert.assertEquals(2L, RangeCheck.checkGreater(2L, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class) public void testGreaterBig_0()
  {
    RangeCheck.checkGreaterBig(BigInteger.ZERO, "x", BigInteger.ZERO, "lower");
  }

  @Test public void testGreaterBig_1()
  {
    Assert.assertEquals(
      BigInteger.ONE, RangeCheck.checkGreaterBig(
        BigInteger.ONE, "x", BigInteger.ZERO, "lower"));
  }

  @Test(expected = RangeCheckException.class) public void testGreaterDouble_0()
  {
    RangeCheck.checkGreaterDouble(0L, "x", 0L, "lower");
  }

  @Test public void testGreaterDouble_1()
  {
    Assert.assertEquals(
      2L, RangeCheck.checkGreaterDouble(2L, "x", 1L, "lower"), 0.0);
  }

  @Test(expected = RangeCheckException.class) public void testGreaterEqual_0()
  {
    RangeCheck.checkGreaterEqual(0L, "x", 1L, "lower");
  }

  @Test public void testGreaterEqual_1()
  {
    Assert.assertEquals(
      1L, RangeCheck.checkGreaterEqual(1L, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualBig_0()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO, "x", BigInteger.ONE, "lower");
  }

  @Test public void testGreaterEqualBig_1()
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

  @Test public void testGreaterEqualDouble_1()
  {
    Assert.assertEquals(
      1L, RangeCheck.checkGreaterEqualDouble(1.0, "x", 1.0, "lower"), 0.0);
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualDoubleNull_0()
  {
    RangeCheck.checkGreaterEqualDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualDoubleNull_1()
  {
    RangeCheck.checkGreaterEqualDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualNull_0()
  {
    RangeCheck.checkGreaterEqual(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualNull_1()
  {
    RangeCheck.checkGreaterEqual(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualNullBig_0()
  {
    RangeCheck.checkGreaterEqualBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "lower");
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualNullBig_1()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualNullBig_2()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "lower");
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterEqualNullBig_3()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testGreaterNull_0()
  {
    RangeCheck.checkGreater(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullCheckException.class) public void testGreaterNull_1()
  {
    RangeCheck.checkGreater(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testGreaterNullBig_0()
  {
    RangeCheck.checkGreaterBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "lower");
  }

  @Test(expected = NullCheckException.class) public void testGreaterNullBig_1()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullCheckException.class) public void testGreaterNullBig_2()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "lower");
  }

  @Test(expected = NullCheckException.class) public void testGreaterNullBig_3()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterNullDouble_0()
  {
    RangeCheck.checkGreaterDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullCheckException.class)
  public void testGreaterNullDouble_1()
  {
    RangeCheck.checkGreaterDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testIncludedBigNull_0()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      (BigInteger) TestUtilities.actuallyNull(), "value", range, "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedBigNull_1()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      BigInteger.ZERO, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedBigNull_2()
  {
    RangeCheck.checkIncludedInBig(
      BigInteger.ZERO,
      "name",
      (RangeInclusiveB) TestUtilities.actuallyNull(),
      "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedBigNull_3()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      BigInteger.ZERO, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedBigRange_0()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(
      BigInteger.valueOf(-1), "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedBigRange_1()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    RangeCheck.checkIncludedInBig(BigInteger.TEN, "Value", range, "Range");
  }

  @Test public void testIncludedBigRange_2()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assert.assertEquals(
      BigInteger.ZERO, RangeCheck.checkIncludedInBig(
        BigInteger.ZERO, "Value", range, "Range"));
  }

  @Test public void testIncludedBigRange_3()
  {
    final RangeInclusiveB range =
      new RangeInclusiveB(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assert.assertEquals(
      BigInteger.valueOf(9), RangeCheck.checkIncludedInBig(
        BigInteger.valueOf(9), "Value", range, "Range"));
  }

  @Test(expected = NullCheckException.class) public void testIncludedNull_0()
  {
    final RangeInclusiveL range = new RangeInclusiveL(0, 9);
    RangeCheck.checkIncludedIn(
      0L, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedNull_1()
  {
    RangeCheck.checkIncludedIn(
      0L, "name", (RangeInclusiveL) TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedNull_2()
  {
    final RangeInclusiveL range = new RangeInclusiveL(0, 9);
    RangeCheck.checkIncludedIn(
      0L, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class) public void testIncludedRange_0()
  {
    final RangeInclusiveL range = new RangeInclusiveL(0, 9);
    RangeCheck.checkIncludedIn(-1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class) public void testIncludedRange_1()
  {
    final RangeInclusiveL range = new RangeInclusiveL(0, 9);
    RangeCheck.checkIncludedIn(10, "Value", range, "Range");
  }

  @Test public void testIncludedRange_2()
  {
    final RangeInclusiveL range = new RangeInclusiveL(0, 9);
    Assert.assertEquals(
      0, RangeCheck.checkIncludedIn(0, "Value", range, "Range"));
  }

  @Test public void testIncludedRange_3()
  {
    final RangeInclusiveL range = new RangeInclusiveL(0, 9);
    Assert.assertEquals(
      9, RangeCheck.checkIncludedIn(9, "Value", range, "Range"));
  }

  @Test(expected = RangeCheckException.class) public void testLess_0()
  {
    RangeCheck.checkLess(0L, "x", 0L, "upper");
  }

  @Test public void testLess_1()
  {
    Assert.assertEquals(0L, RangeCheck.checkLess(0L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class) public void testLessBig_0()
  {
    RangeCheck.checkLessBig(BigInteger.ZERO, "x", BigInteger.ZERO, "upper");
  }

  @Test public void testLessBig_1()
  {
    Assert.assertEquals(
      BigInteger.ZERO,
      RangeCheck.checkLessBig(BigInteger.ZERO, "x", BigInteger.ONE, "upper"));
  }

  @Test(expected = RangeCheckException.class) public void testLessDouble_0()
  {
    RangeCheck.checkLessDouble(0.0, "x", 0.0, "upper");
  }

  @Test public void testLessDouble_1()
  {
    Assert.assertEquals(
      0.0, RangeCheck.checkLessDouble(0.0, "x", 1.0, "upper"), 0.0);
  }

  @Test(expected = RangeCheckException.class) public void testLessEqual_0()
  {
    RangeCheck.checkLessEqual(1L, "x", 0L, "upper");
  }

  @Test public void testLessEqual_1()
  {
    Assert.assertEquals(1L, RangeCheck.checkLessEqual(1L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class) public void testLessEqualBig_0()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ONE, "x", BigInteger.ZERO, "upper");
  }

  @Test public void testLessEqualBig_1()
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

  @Test public void testLessEqualDouble_1()
  {
    Assert.assertEquals(
      1.0, RangeCheck.checkLessEqualDouble(1.0, "x", 1.0, "upper"), 0.0);
  }

  @Test(expected = NullCheckException.class) public void testLessEqualNull_0()
  {
    RangeCheck.checkLessEqual(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessEqualNull_1()
  {
    RangeCheck.checkLessEqual(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class)
  public void testLessEqualNullBig_0()
  {
    RangeCheck.checkLessEqualBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "upper");
  }

  @Test(expected = NullCheckException.class)
  public void testLessEqualNullBig_1()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "upper");
  }

  @Test(expected = NullCheckException.class)
  public void testLessEqualNullBig_2()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "upper");
  }

  @Test(expected = NullCheckException.class)
  public void testLessEqualNullBig_3()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class)
  public void testLessEqualNullDouble_0()
  {
    RangeCheck.checkLessEqualDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullCheckException.class)
  public void testLessEqualNullDouble_1()
  {
    RangeCheck.checkLessEqualDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testLessNull_0()
  {
    RangeCheck.checkLess(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNull_1()
  {
    RangeCheck.checkLess(0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testLessNullBig_0()
  {
    RangeCheck.checkLessBig(
      (BigInteger) TestUtilities.actuallyNull(), "x", BigInteger.ONE, "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNullBig_1()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNullBig_2()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO, "x", (BigInteger) TestUtilities.actuallyNull(), "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNullBig_3()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testLessNullDouble_0()
  {
    RangeCheck.checkLessDouble(
      0L, (String) TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNullDouble_1()
  {
    RangeCheck.checkLessDouble(
      0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test public void testRangeIncluded_0()
  {
    Assert.assertEquals(
      new RangeInclusiveL(0, 0), RangeCheck.checkRangeIncludedIn(
        new RangeInclusiveL(0, 0),
        "Inner",
        new RangeInclusiveL(0, 0),
        "Outer"));
  }

  @Test(expected = RangeCheckException.class) public void testRangeIncluded_1()
  {
    RangeCheck.checkRangeIncludedIn(
      new RangeInclusiveL(1, 1), "Inner", new RangeInclusiveL(0, 0), "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_Null_0()
  {
    RangeCheck.checkRangeIncludedIn(
      (RangeInclusiveL) TestUtilities.actuallyNull(),
      "Inner",
      new RangeInclusiveL(0, 0),
      "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_Null_1()
  {
    RangeCheck.checkRangeIncludedIn(
      new RangeInclusiveL(0, 0),
      (String) TestUtilities.actuallyNull(),
      new RangeInclusiveL(0, 0),
      "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_Null_2()
  {
    RangeCheck.checkRangeIncludedIn(
      new RangeInclusiveL(0, 0),
      "Inner",
      (RangeInclusiveL) TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_Null_3()
  {
    RangeCheck.checkRangeIncludedIn(
      new RangeInclusiveL(0, 0),
      "Inner",
      new RangeInclusiveL(0, 0),
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_NullBig_0()
  {
    RangeCheck.checkRangeIncludedInBig(
      (RangeInclusiveB) TestUtilities.actuallyNull(),
      "Inner",
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO),
      "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_NullBig_1()
  {
    RangeCheck.checkRangeIncludedInBig(
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO),
      (String) TestUtilities.actuallyNull(),
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO),
      "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_NullBig_2()
  {
    RangeCheck.checkRangeIncludedInBig(
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO),
      "Inner",
      (RangeInclusiveB) TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullCheckException.class)
  public void testRangeIncluded_NullBig_3()
  {
    RangeCheck.checkRangeIncludedInBig(
      new RangeInclusiveB(
        BigInteger.ZERO, BigInteger.ZERO),
      "Inner",
      new RangeInclusiveB(
        BigInteger.ZERO, BigInteger.ZERO),
      (String) TestUtilities.actuallyNull());
  }

  @Test public void testRangeIncludedBig_0()
  {
    Assert.assertEquals(
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO),
      RangeCheck.checkRangeIncludedInBig(
        new RangeInclusiveB(
          BigInteger.ZERO, BigInteger.ZERO), "Inner", new RangeInclusiveB(
          BigInteger.ZERO, BigInteger.ZERO), "Outer"));
  }

  @Test(expected = RangeCheckException.class)
  public void testRangeIncludedBig_1()
  {
    RangeCheck.checkRangeIncludedInBig(
      new RangeInclusiveB(
        BigInteger.ONE, BigInteger.ONE), "Inner", new RangeInclusiveB(
        BigInteger.ZERO, BigInteger.ZERO), "Outer");
  }

  @Test(expected = NullCheckException.class) public void testIncludedIntNull_1()
  {
    final RangeInclusiveI range = new RangeInclusiveI(0, 9);
    RangeCheck.checkIncludedInInt(
      0, (String) TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedIntNull_2()
  {
    RangeCheck.checkIncludedInInt(
      0, "name", (RangeInclusiveI) TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullCheckException.class) public void testIncludedIntNull_3()
  {
    final RangeInclusiveI range = new RangeInclusiveI(0, 9);
    RangeCheck.checkIncludedInInt(
      0, "name", range, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedIntRange_0()
  {
    final RangeInclusiveI range = new RangeInclusiveI(0, 9);
    RangeCheck.checkIncludedInInt(
      -1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedIntRange_1()
  {
    final RangeInclusiveI range = new RangeInclusiveI(0, 9);
    RangeCheck.checkIncludedInInt(10, "Value", range, "Range");
  }

  @Test public void testIncludedIntRange_2()
  {
    final RangeInclusiveI range = new RangeInclusiveI(0, 9);
    Assert.assertEquals(
      0, RangeCheck.checkIncludedInInt(
        0, "Value", range, "Range"));
  }

  @Test public void testIncludedIntRange_3()
  {
    final RangeInclusiveI range = new RangeInclusiveI(0, 9);
    Assert.assertEquals(
      9, RangeCheck.checkIncludedInInt(
        9, "Value", range, "Range"));
  }

}
