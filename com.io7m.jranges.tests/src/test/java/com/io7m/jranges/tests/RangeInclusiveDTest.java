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
import com.io7m.jranges.RangeInclusiveD;
import com.io7m.jranges.RangeInclusiveDType;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class RangeInclusiveDTest
{
  @Test
  public void testEquals_0()
  {
    EqualsVerifier.forClass(RangeInclusiveD.class)
      .verify();
  }

  @Test
  public void testToString_0()
  {
    final var r00 = RangeInclusiveD.of(0, 0);
    final var r00a = RangeInclusiveD.of(0, 0);
    final var r01 = RangeInclusiveD.of(0, 1);
    final var r12 = RangeInclusiveD.of(1, 2);

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
      RangeInclusiveD.of(0, 10).isIncludedIn(RangeInclusiveD.of(0, 10)));

    Assertions.assertFalse(
      RangeInclusiveD.of(0, 10).isIncludedIn(RangeInclusiveD.of(0, 9)));
    Assertions.assertFalse(
      RangeInclusiveD.of(0, 10).isIncludedIn(RangeInclusiveD.of(1, 10)));
  }

  @Test
  public void testRange_0()
  {
    final var r = RangeInclusiveD.of(0L, 9L);
    Assertions.assertEquals(0L, r.lower(), 0.00000001);
    Assertions.assertEquals(9L, r.upper(), 0.00000001);
    Assertions.assertEquals(9L, r.interval(), 0.00000001);
  }

  @Test
  public void testRange_1()
  {
    final var r = RangeInclusiveD.of(0L, 9L);
    Assertions.assertFalse(r.includesValue(-1));
    Assertions.assertFalse(r.includesValue(10));
    Assertions.assertTrue(r.includesValue(0));
    Assertions.assertTrue(r.includesValue(9));
  }

  @Test
  public void testWith()
  {
    final var r = RangeInclusiveD.of(0, 9);
    Assertions.assertTrue(r.withLower(1).lower() == (1));
    Assertions.assertTrue(r.withLower(0).lower() == (0));
    Assertions.assertTrue(r.withUpper(10).upper() == (10));
    Assertions.assertTrue(r.withUpper(9).upper() == (9));
  }

  @Property
  public void testCopyOf(
    final @ForAll @IntRange(min = -100, max = 100) int low)
  {
    final var r = RangeInclusiveD.of(low, low + 10);

    Assertions.assertEquals(r, RangeInclusiveD.copyOf(r));
    Assertions.assertEquals(r, RangeInclusiveD.copyOf(new RangeInclusiveDType()
    {
      @Override
      public double lower()
      {
        return r.lower();
      }

      @Override
      public double upper()
      {
        return r.upper();
      }
    }));
  }

  @Test
  public void testBuilderMissing()
  {
    Assertions.assertThrows(IllegalStateException.class, () -> {
      RangeInclusiveD.builder().build();
    });
  }

  @SuppressWarnings("unused")
  @Test
  public void testRangeBad_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeInclusiveD.of(1L, 0L);
    });
  }
}
