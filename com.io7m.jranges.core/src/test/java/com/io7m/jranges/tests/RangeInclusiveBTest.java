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
import com.io7m.jranges.RangeCheckException;
import com.io7m.jranges.RangeInclusiveB;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

@SuppressWarnings({ "null", "unused", "static-method" }) public class RangeInclusiveBTest
{
  @Test public void testEquals_0()
  {
    final RangeInclusiveB r00 =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO);
    final RangeInclusiveB r00a =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO);
    final RangeInclusiveB r01 =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ONE);
    final RangeInclusiveB r12 =
      new RangeInclusiveB(BigInteger.ONE, BigInteger.valueOf(2));

    Assert.assertEquals(r00, r00);
    Assert.assertEquals(r00a, r00);
    Assert.assertNotEquals(r00, null);
    Assert.assertNotEquals(r00, BigInteger.ZERO);
    Assert.assertNotEquals(r01, r00);
    Assert.assertNotEquals(r12, r00);
  }

  @Test public void testHashcode_0()
  {
    final RangeInclusiveB r00 =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO);
    final RangeInclusiveB r00a =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ZERO);
    final RangeInclusiveB r01 =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.ONE);
    final RangeInclusiveB r12 =
      new RangeInclusiveB(BigInteger.ONE, BigInteger.valueOf(2));

    Assert.assertEquals(r00.hashCode(), r00.hashCode());
    Assert.assertEquals(r00a.hashCode(), r00.hashCode());
    Assert.assertNotEquals(r01.hashCode(), r00.hashCode());
    Assert.assertNotEquals(r12.hashCode(), r00.hashCode());
  }

  @Test public void testIncluded()
  {
    Assert.assertTrue(new RangeInclusiveB(BigInteger.ZERO, BigInteger.TEN)
      .isIncludedIn(new RangeInclusiveB(BigInteger.ZERO, BigInteger.TEN)));

    Assert.assertFalse(new RangeInclusiveB(BigInteger.ZERO, BigInteger.TEN)
      .isIncludedIn(new RangeInclusiveB(BigInteger.ZERO, BigInteger
        .valueOf(9))));
    Assert.assertFalse(new RangeInclusiveB(BigInteger.ZERO, BigInteger.TEN)
      .isIncludedIn(new RangeInclusiveB(BigInteger.ONE, BigInteger.TEN)));
  }

  @Test public void testRange_0()
  {
    final RangeInclusiveB r =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.valueOf(9));
    Assert.assertEquals(BigInteger.ZERO, r.getLower());
    Assert.assertEquals(BigInteger.valueOf(9), r.getUpper());
    Assert.assertEquals(BigInteger.TEN, r.getInterval());
  }

  @Test public void testRange_1()
  {
    final RangeInclusiveB r =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.valueOf(9));

    Assert.assertTrue(r.includesValue(BigInteger.ZERO));
    Assert.assertTrue(r.includesValue(BigInteger.ONE));
    Assert.assertFalse(r.includesValue(BigInteger.valueOf(-1)));
    Assert.assertFalse(r.includesValue(BigInteger.valueOf(10)));
  }

  @Test(expected = NullCheckException.class) public void testRange_2()
  {
    final RangeInclusiveB r =
      new RangeInclusiveB(BigInteger.ZERO, BigInteger.valueOf(9));

    r.includesValue((BigInteger) TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class) public void testRangeBad_0()
  {
    new RangeInclusiveB(BigInteger.ONE, BigInteger.ZERO);
  }
}
