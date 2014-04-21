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

import com.io7m.jranges.RangeCheckException;
import com.io7m.jranges.RangeInclusiveI;

@SuppressWarnings("static-method") public class RangeInclusiveITest
{
  @Test public void testEquals_0()
  {
    final RangeInclusiveI r00 = new RangeInclusiveI(0, 0);
    final RangeInclusiveI r00a = new RangeInclusiveI(0, 0);
    final RangeInclusiveI r01 = new RangeInclusiveI(0, 1);
    final RangeInclusiveI r12 = new RangeInclusiveI(1, 2);

    Assert.assertEquals(r00, r00);
    Assert.assertEquals(r00a, r00);

    Assert.assertNotEquals(r00, null);
    Assert.assertNotEquals(r00, BigInteger.ZERO);
    Assert.assertNotEquals(r01, r00);
    Assert.assertNotEquals(r12, r00);
  }

  @Test public void testIncluded()
  {
    Assert.assertTrue(new RangeInclusiveI(0, 10)
      .isIncludedIn(new RangeInclusiveI(0, 10)));

    Assert.assertFalse(new RangeInclusiveI(0, 10)
      .isIncludedIn(new RangeInclusiveI(0, 9)));
    Assert.assertFalse(new RangeInclusiveI(0, 10)
      .isIncludedIn(new RangeInclusiveI(1, 10)));
  }

  @Test public void testRange_0()
  {
    final RangeInclusiveI r = new RangeInclusiveI(0, 9);
    Assert.assertEquals(0L, r.getLower());
    Assert.assertEquals(9L, r.getUpper());
    Assert.assertEquals(10L, r.getInterval());
  }

  @SuppressWarnings("unused") @Test(expected = RangeCheckException.class) public
    void
    testRangeBad_0()
  {
    new RangeInclusiveI(1, 0);
  }
}
