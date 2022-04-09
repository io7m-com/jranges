/*
 * Copyright © 2014 <code@io7m.com> https://www.io7m.com
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
import com.io7m.jranges.RangeInclusiveLType;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class RangeInclusiveLTest
{
  @Test
  public void testEquals_0()
  {
    EqualsVerifier.forClass(RangeInclusiveL.class)
      .verify();
  }

  @Test
  public void testToString_0()
  {
    final var r00 = RangeInclusiveL.of(0, 0);
    final var r00a = RangeInclusiveL.of(0, 0);
    final var r01 = RangeInclusiveL.of(0, 1);
    final var r12 = RangeInclusiveL.of(1, 2);

    Assertions.assertEquals(r00.toString(), r00.toString());
    Assertions.assertEquals(r00a.toString(), r00.toString());
    Assertions.assertNotEquals(r01.toString(), r00.toString());
    Assertions.assertNotEquals(r12.toString(), r00.toString());
    Assertions.assertNotEquals(r00.toString(), r01.toString());
    Assertions.assertNotEquals(r00.toString(), r12.toString());
  }

  @Test
  public void testIncluded()
  {
    Assertions.assertTrue(
      RangeInclusiveL.of(0, 10).isIncludedIn(RangeInclusiveL.of(0, 10)));
    Assertions.assertFalse(
      RangeInclusiveL.of(0, 10).isIncludedIn(RangeInclusiveL.of(0, 9)));
    Assertions.assertFalse(
      RangeInclusiveL.of(0, 10).isIncludedIn(RangeInclusiveL.of(1, 10)));
  }

  @Test
  public void testRange_0()
  {
    final var r = RangeInclusiveL.of(0L, 9L);
    Assertions.assertEquals(0L, r.lower());
    Assertions.assertEquals(9L, r.upper());
    Assertions.assertEquals(10L, r.interval());
  }

  @Test
  public void testRange_1()
  {
    final var r = RangeInclusiveL.of(0L, 9L);
    Assertions.assertFalse(r.includesValue(-1));
    Assertions.assertFalse(r.includesValue(10));
    Assertions.assertTrue(r.includesValue(0));
    Assertions.assertTrue(r.includesValue(9));
  }

  @Test
  public void testWith()
  {
    final var r = RangeInclusiveL.of(0, 9);
    Assertions.assertTrue(r.withLower(1).lower() == (1));
    Assertions.assertTrue(r.withLower(0).lower() == (0));
    Assertions.assertTrue(r.withUpper(10).upper() == (10));
    Assertions.assertTrue(r.withUpper(9).upper() == (9));
  }

  @Property
  public void testCopyOf(
    final @ForAll @IntRange(min = -100, max = 100) int low)
  {
    final var r = RangeInclusiveL.of(low, low + 10);

    Assertions.assertEquals(r, RangeInclusiveL.copyOf(r));
    Assertions.assertEquals(r, RangeInclusiveL.copyOf(new RangeInclusiveLType()
    {
      @Override
      public long lower()
      {
        return r.lower();
      }

      @Override
      public long upper()
      {
        return r.upper();
      }
    }));
  }

  @Test
  public void testBuilderMissing()
  {
    Assertions.assertThrows(IllegalStateException.class, () -> {
      RangeInclusiveL.builder().build();
    });
  }

  @SuppressWarnings("unused")
  @Test
  public void testRangeBad_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeInclusiveL.of(1L, 0L);
    });
  }
}
