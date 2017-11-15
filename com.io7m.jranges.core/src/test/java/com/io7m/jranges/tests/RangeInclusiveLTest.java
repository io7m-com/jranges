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

import com.io7m.jranges.RangeCheckException;
import com.io7m.jranges.RangeInclusiveL;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public final class RangeInclusiveLTest
{
  @Test
  public void testEquals_0()
  {
    final RangeInclusiveL r00 = RangeInclusiveL.of(0L, 0L);
    final RangeInclusiveL r00a = RangeInclusiveL.of(0L, 0L);
    final RangeInclusiveL r01 = RangeInclusiveL.of(0L, 1L);
    final RangeInclusiveL r12 = RangeInclusiveL.of(1L, 2L);

    Assert.assertEquals(r00, r00);
    Assert.assertEquals(r00a, r00);

    Assert.assertNotEquals(r00, null);
    Assert.assertNotEquals(r00, BigInteger.ZERO);
    Assert.assertNotEquals(r01, r00);
    Assert.assertNotEquals(r12, r00);
  }

  @Test
  public void testHashCode_0()
  {
    final RangeInclusiveL r00 = RangeInclusiveL.of(0, 0);
    final RangeInclusiveL r00a = RangeInclusiveL.of(0, 0);
    final RangeInclusiveL r01 = RangeInclusiveL.of(0, 1);
    final RangeInclusiveL r12 = RangeInclusiveL.of(1, 2);

    Assert.assertEquals(r00.hashCode(), r00.hashCode());
    Assert.assertEquals(r00a.hashCode(), r00.hashCode());
    Assert.assertNotEquals(r01.hashCode(), r00.hashCode());
    Assert.assertNotEquals(r12.hashCode(), r00.hashCode());
    Assert.assertNotEquals(r00.hashCode(), r01.hashCode());
    Assert.assertNotEquals(r00.hashCode(), r12.hashCode());
  }

  @Test
  public void testToString_0()
  {
    final RangeInclusiveL r00 = RangeInclusiveL.of(0, 0);
    final RangeInclusiveL r00a = RangeInclusiveL.of(0, 0);
    final RangeInclusiveL r01 = RangeInclusiveL.of(0, 1);
    final RangeInclusiveL r12 = RangeInclusiveL.of(1, 2);

    Assert.assertEquals(r00.toString(), r00.toString());
    Assert.assertEquals(r00a.toString(), r00.toString());
    Assert.assertNotEquals(r01.toString(), r00.toString());
    Assert.assertNotEquals(r12.toString(), r00.toString());
    Assert.assertNotEquals(r00.toString(), r01.toString());
    Assert.assertNotEquals(r00.toString(), r12.toString());
  }

  @Test
  public void testIncluded()
  {
    Assert.assertTrue(
      RangeInclusiveL.of(0, 10).isIncludedIn(RangeInclusiveL.of(0, 10)));

    Assert.assertFalse(
      RangeInclusiveL.of(0, 10).isIncludedIn(RangeInclusiveL.of(0, 9)));
    Assert.assertFalse(
      RangeInclusiveL.of(0, 10).isIncludedIn(RangeInclusiveL.of(1, 10)));
  }

  @Test
  public void testRange_0()
  {
    final RangeInclusiveL r = RangeInclusiveL.of(0L, 9L);
    Assert.assertEquals(0L, r.lower());
    Assert.assertEquals(9L, r.upper());
    Assert.assertEquals(10L, r.interval());
  }

  @Test
  public void testRange_1()
  {
    final RangeInclusiveL r = RangeInclusiveL.of(0L, 9L);
    Assert.assertFalse(r.includesValue(-1));
    Assert.assertFalse(r.includesValue(10));
    Assert.assertTrue(r.includesValue(0));
    Assert.assertTrue(r.includesValue(9));
  }

  @SuppressWarnings("unused")
  @Test(expected = RangeCheckException.class)
  public void testRangeBad_0()
  {
    RangeInclusiveL.of(1L, 0L);
  }
}
