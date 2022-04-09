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
import com.io7m.jranges.RangeHalfOpenB;
import com.io7m.jranges.RangeHalfOpenBType;
import com.io7m.jranges.RangeInclusiveB;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public final class RangeHalfOpenBTest
{
  private static final BigInteger MINUS_20 = valueOf(-20L);

  @Test
  public void testEquals_0()
  {
    EqualsVerifier.forClass(RangeHalfOpenB.class)
      .withNonnullFields("lower", "upper")
      .verify();
  }

  @Test
  public void testToString_0()
  {
    final var r00 = RangeHalfOpenB.of(valueOf(0), valueOf(0));
    final var r00a = RangeHalfOpenB.of(valueOf(0), valueOf(0));
    final var r01 = RangeHalfOpenB.of(valueOf(0), valueOf(1));
    final var r12 = RangeHalfOpenB.of(valueOf(1), valueOf(2));

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
      RangeHalfOpenB.of(ZERO, TEN).isIncludedIn(RangeHalfOpenB.of(ZERO, TEN)));
    Assertions.assertFalse(
      RangeHalfOpenB.of(ZERO, TEN).isIncludedIn(RangeHalfOpenB.of(ZERO, valueOf(9))));
    Assertions.assertFalse(
      RangeHalfOpenB.of(ZERO, TEN).isIncludedIn(RangeHalfOpenB.of(ONE, TEN)));
  }

  @Test
  public void testIncludedInclusive()
  {
    Assertions.assertTrue(
      RangeHalfOpenB.of(ZERO, TEN).isIncludedIn(RangeInclusiveB.of(ZERO, TEN)));
    Assertions.assertFalse(
      RangeHalfOpenB.of(ZERO, TEN).isIncludedIn(RangeInclusiveB.of(ZERO, valueOf(8))));
    Assertions.assertFalse(
      RangeHalfOpenB.of(MINUS_20, valueOf(8L)).isIncludedIn(RangeInclusiveB.of(ZERO, valueOf(8))));
  }

  @Test
  public void testIncludesValue()
  {
    final var range = RangeHalfOpenB.of(ZERO, TEN);

    for (var index = -10; index < 20; ++index) {
      if (index < 0 || index >= 10) {
        Assertions.assertFalse(range.includesValue(valueOf(index)));
      } else {
        Assertions.assertTrue(range.includesValue(valueOf(index)));
      }
    }
  }

  @Test
  public void testRange_0()
  {
    final var r = RangeHalfOpenB.of(ZERO, valueOf(9));
    Assertions.assertEquals(ZERO, r.lower());
    Assertions.assertEquals(valueOf(9), r.upper());
    Assertions.assertEquals(valueOf(9), r.interval());
  }

  @Test
  public void testRange_1()
  {
    final var r =
      RangeHalfOpenB.of(ZERO, valueOf(9));

    Assertions.assertTrue(r.includesValue(ZERO));
    Assertions.assertTrue(r.includesValue(ONE));
    Assertions.assertFalse(r.includesValue(valueOf(-1)));
    Assertions.assertFalse(r.includesValue(valueOf(10)));
  }

  @Test
  public void testWith()
  {
    final var r =
      RangeHalfOpenB.of(ZERO, valueOf(9));

    Assertions.assertTrue(r.withLower(ONE).lower().equals(ONE));
    Assertions.assertTrue(r.withLower(ZERO).lower().equals(ZERO));
    Assertions.assertTrue(r.withUpper(TEN).upper().equals(TEN));
    Assertions.assertTrue(r.withUpper(valueOf(9)).upper().equals(valueOf(9)));
  }

  @Test
  public void testRange_2()
  {
    final var r =
      RangeHalfOpenB.of(ZERO, valueOf(9));

    Assertions.assertThrows(NullPointerException.class, () -> {
      r.includesValue(TestUtilities.actuallyNull());
    });
  }

  @Property
  public void testCopyOf(
    final @ForAll @IntRange(min = -100, max = 100) int low)
  {
    final var r = RangeHalfOpenB.of(valueOf(low), valueOf(low + 10));

    Assertions.assertEquals(r, RangeHalfOpenB.copyOf(r));
    Assertions.assertEquals(r, RangeHalfOpenB.copyOf(new RangeHalfOpenBType()
    {
      @Override
      public BigInteger lower()
      {
        return r.lower();
      }

      @Override
      public BigInteger upper()
      {
        return r.upper();
      }
    }));
  }

  @Test
  public void testBuilderMissing()
  {
    Assertions.assertThrows(IllegalStateException.class, () -> {
      RangeHalfOpenB.builder().build();
    });
  }

  @Test
  public void testRangeBad_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenB.of(ONE, ZERO);
    });
  }
}
