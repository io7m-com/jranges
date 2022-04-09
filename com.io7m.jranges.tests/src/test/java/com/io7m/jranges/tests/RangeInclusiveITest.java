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
import com.io7m.jranges.RangeInclusiveI;
import com.io7m.jranges.RangeInclusiveIType;
import com.io7m.jranges.Ranges;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class RangeInclusiveITest
{
  @Test
  public void testEquals_0()
  {
    EqualsVerifier.forClass(RangeInclusiveI.class)
      .verify();
  }

  @Test
  public void testToString_0()
  {
    final var r00 = RangeInclusiveI.of(0, 0);
    final var r00a = RangeInclusiveI.of(0, 0);
    final var r01 = RangeInclusiveI.of(0, 1);
    final var r12 = RangeInclusiveI.of(1, 2);

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
      RangeInclusiveI.of(0, 10).isIncludedIn(RangeInclusiveI.of(0, 10)));

    Assertions.assertFalse(
      RangeInclusiveI.of(0, 10).isIncludedIn(RangeInclusiveI.of(0, 9)));
    Assertions.assertFalse(
      RangeInclusiveI.of(0, 10).isIncludedIn(RangeInclusiveI.of(1, 10)));
  }

  @Test
  public void testPredefined()
  {
    Assertions.assertTrue(Ranges.NATURAL_INTEGER.includesValue(0));
    Assertions.assertTrue(Ranges.NATURAL_INTEGER.includesValue(Integer.MAX_VALUE));
    Assertions.assertFalse(Ranges.NATURAL_INTEGER.includesValue(-1));

    Assertions.assertTrue(Ranges.POSITIVE_INTEGER.includesValue(1));
    Assertions.assertTrue(Ranges.POSITIVE_INTEGER.includesValue(Integer.MAX_VALUE));
    Assertions.assertFalse(Ranges.POSITIVE_INTEGER.includesValue(0));
  }

  @Test
  public void testRange_0()
  {
    final var r = RangeInclusiveI.of(0, 9);
    Assertions.assertEquals(0L, r.lower());
    Assertions.assertEquals(9L, r.upper());
    Assertions.assertEquals(10L, r.interval());
  }

  @Test
  public void testWith()
  {
    final var r = RangeInclusiveI.of(0, 9);
    Assertions.assertTrue(r.withLower(1).lower() == (1));
    Assertions.assertTrue(r.withLower(0).lower() == (0));
    Assertions.assertTrue(r.withUpper(10).upper() == (10));
    Assertions.assertTrue(r.withUpper(9).upper() == (9));
  }

  @Property
  public void testCopyOf(
    final @ForAll @IntRange(min = -100, max = 100) int low)
  {
    final var r = RangeInclusiveI.of(low, low + 10);

    Assertions.assertEquals(r, RangeInclusiveI.copyOf(r));
    Assertions.assertEquals(r, RangeInclusiveI.copyOf(new RangeInclusiveIType()
    {
      @Override
      public int lower()
      {
        return r.lower();
      }

      @Override
      public int upper()
      {
        return r.upper();
      }
    }));
  }

  @Test
  public void testBuilderMissing()
  {
    Assertions.assertThrows(IllegalStateException.class, () -> {
      RangeInclusiveI.builder().build();
    });
  }

  @SuppressWarnings("unused")
  @Test
  public void
  testRangeBad_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeInclusiveI.of(1, 0);
    });
  }
}
