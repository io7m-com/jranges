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

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.io7m.jnull.NullCheckException;
import com.io7m.jranges.RangeCheck;
import com.io7m.jranges.RangeCheckException;

@SuppressWarnings({ "null", "static-method" }) public class RangeCheckTest
{
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

  @Test(expected = RangeCheckException.class) public void testLessEqual_0()
  {
    RangeCheck.checkLessEqual(1L, "x", 0L, "upper");
  }

  @Test public void testLessEqual_1()
  {
    Assert.assertEquals(1L, RangeCheck.checkLessEqual(1L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class) public
    void
    testLessEqualBig_0()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ONE,
      "x",
      BigInteger.ZERO,
      "upper");
  }

  @Test public void testLessEqualBig_1()
  {
    Assert.assertEquals(BigInteger.ONE, RangeCheck.checkLessEqualBig(
      BigInteger.ONE,
      "x",
      BigInteger.ONE,
      "upper"));
  }

  @Test(expected = NullCheckException.class) public
    void
    testLessEqualNull_0()
  {
    RangeCheck.checkLessEqual(
      0L,
      (String) TestUtilities.actuallyNull(),
      1L,
      "upper");
  }

  @Test(expected = NullCheckException.class) public
    void
    testLessEqualNull_1()
  {
    RangeCheck.checkLessEqual(
      0L,
      "x",
      1L,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public
    void
    testLessEqualNullBig_0()
  {
    RangeCheck.checkLessEqualBig(
      (BigInteger) TestUtilities.actuallyNull(),
      "x",
      BigInteger.ONE,
      "upper");
  }

  @Test(expected = NullCheckException.class) public
    void
    testLessEqualNullBig_1()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "upper");
  }

  @Test(expected = NullCheckException.class) public
    void
    testLessEqualNullBig_2()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      "x",
      (BigInteger) TestUtilities.actuallyNull(),
      "upper");
  }

  @Test(expected = NullCheckException.class) public
    void
    testLessEqualNullBig_3()
  {
    RangeCheck.checkLessEqualBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testLessNull_0()
  {
    RangeCheck.checkLess(
      0L,
      (String) TestUtilities.actuallyNull(),
      1L,
      "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNull_1()
  {
    RangeCheck.checkLess(0L, "x", 1L, (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public void testLessNullBig_0()
  {
    RangeCheck.checkLessBig(
      (BigInteger) TestUtilities.actuallyNull(),
      "x",
      BigInteger.ONE,
      "upper");
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
      BigInteger.ZERO,
      "x",
      (BigInteger) TestUtilities.actuallyNull(),
      "upper");
  }

  @Test(expected = NullCheckException.class) public void testLessNullBig_3()
  {
    RangeCheck.checkLessBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }

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
    RangeCheck
      .checkGreaterBig(BigInteger.ZERO, "x", BigInteger.ZERO, "lower");
  }

  @Test public void testGreaterBig_1()
  {
    Assert.assertEquals(BigInteger.ONE, RangeCheck.checkGreaterBig(
      BigInteger.ONE,
      "x",
      BigInteger.ZERO,
      "lower"));
  }

  @Test(expected = RangeCheckException.class) public
    void
    testGreaterEqual_0()
  {
    RangeCheck.checkGreaterEqual(0L, "x", 1L, "lower");
  }

  @Test public void testGreaterEqual_1()
  {
    Assert.assertEquals(
      1L,
      RangeCheck.checkGreaterEqual(1L, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class) public
    void
    testGreaterEqualBig_0()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      "lower");
  }

  @Test public void testGreaterEqualBig_1()
  {
    Assert.assertEquals(BigInteger.ONE, RangeCheck.checkGreaterEqualBig(
      BigInteger.ONE,
      "x",
      BigInteger.ONE,
      "lower"));
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterEqualNull_0()
  {
    RangeCheck.checkGreaterEqual(
      0L,
      (String) TestUtilities.actuallyNull(),
      1L,
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterEqualNull_1()
  {
    RangeCheck.checkGreaterEqual(
      0L,
      "x",
      1L,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterEqualNullBig_0()
  {
    RangeCheck.checkGreaterEqualBig(
      (BigInteger) TestUtilities.actuallyNull(),
      "x",
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterEqualNullBig_1()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterEqualNullBig_2()
  {
    RangeCheck.checkGreaterEqualBig(
      BigInteger.ZERO,
      "x",
      (BigInteger) TestUtilities.actuallyNull(),
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterEqualNullBig_3()
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
      0L,
      (String) TestUtilities.actuallyNull(),
      1L,
      "lower");
  }

  @Test(expected = NullCheckException.class) public void testGreaterNull_1()
  {
    RangeCheck.checkGreater(
      0L,
      "x",
      1L,
      (String) TestUtilities.actuallyNull());
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterNullBig_0()
  {
    RangeCheck.checkGreaterBig(
      (BigInteger) TestUtilities.actuallyNull(),
      "x",
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterNullBig_1()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      (String) TestUtilities.actuallyNull(),
      BigInteger.ONE,
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterNullBig_2()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      "x",
      (BigInteger) TestUtilities.actuallyNull(),
      "lower");
  }

  @Test(expected = NullCheckException.class) public
    void
    testGreaterNullBig_3()
  {
    RangeCheck.checkGreaterBig(
      BigInteger.ZERO,
      "x",
      BigInteger.ONE,
      (String) TestUtilities.actuallyNull());
  }
}
