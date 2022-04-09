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
import com.io7m.jranges.RangeHalfOpenL;
import com.io7m.jranges.RangeHalfOpenLType;
import com.io7m.jranges.RangeInclusiveL;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class RangeHalfOpenLTest
{
  @Test
  public void testEquals_0()
  {
    EqualsVerifier.forClass(RangeHalfOpenL.class)
      .verify();
  }

  @Test
  public void testToString_0()
  {
    final var r00 = RangeHalfOpenL.of(0L, 0L);
    final var r00a = RangeHalfOpenL.of(0L, 0L);
    final var r01 = RangeHalfOpenL.of(0L, 1L);
    final var r12 = RangeHalfOpenL.of(1L, 2L);

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
      RangeHalfOpenL.of(0L, 10L).isIncludedIn(RangeHalfOpenL.of(0L, 10L)));
    Assertions.assertFalse(
      RangeHalfOpenL.of(0L, 10L).isIncludedIn(RangeHalfOpenL.of(0L, 9L)));
    Assertions.assertFalse(
      RangeHalfOpenL.of(0L, 10L).isIncludedIn(RangeHalfOpenL.of(1L, 10L)));
  }

  @Test
  public void testIncludedInclusive()
  {
    Assertions.assertTrue(
      RangeHalfOpenL.of(0L, 10L).isIncludedIn(RangeInclusiveL.of(0L, 10L)));
    Assertions.assertFalse(
      RangeHalfOpenL.of(0L, 10L).isIncludedIn(RangeInclusiveL.of(0L, 8L)));
    Assertions.assertFalse(
      RangeHalfOpenL.of(-20L, 8L).isIncludedIn(RangeInclusiveL.of(0L, 8L)));
  }

  @Test
  public void testIncludesValue()
  {
    final var range = RangeHalfOpenL.of(0, 10);

    for (var index = -10; index < 20; ++index) {
      if (index < 0 || index >= 10) {
        Assertions.assertFalse(range.includesValue(index));
      } else {
        Assertions.assertTrue(range.includesValue(index));
      }
    }
  }

  @Test
  public void testRange_0()
  {
    final var r = RangeHalfOpenL.of(0L, 9L);
    Assertions.assertEquals(0L, r.lower());
    Assertions.assertEquals(9L, r.upper());
    Assertions.assertEquals(9L, r.interval());
  }

  @Test
  public void testWith()
  {
    final var r = RangeHalfOpenL.of(0, 9);
    Assertions.assertTrue(r.withLower(1).lower() == (1));
    Assertions.assertTrue(r.withLower(0).lower() == (0));
    Assertions.assertTrue(r.withUpper(10).upper() == (10));
    Assertions.assertTrue(r.withUpper(9).upper() == (9));
  }

  @Property
  public void testCopyOf(
    final @ForAll @IntRange(min = -100, max = 100) int low)
  {
    final var r = RangeHalfOpenL.of(low, low + 10);

    Assertions.assertEquals(r, RangeHalfOpenL.copyOf(r));
    Assertions.assertEquals(r, RangeHalfOpenL.copyOf(new RangeHalfOpenLType()
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
      RangeHalfOpenL.builder().build();
    });
  }

  @SuppressWarnings("unused")
  @Test
  public void
  testRangeBad_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenL.of(1L, 0L);
    });
  }
}
