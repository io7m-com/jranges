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
import com.io7m.jranges.RangeInclusiveB;
import com.io7m.jranges.RangeInclusiveBType;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Objects;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

public final class RangeInclusiveBTest
{
  @Test
  public void testEquals_0()
  {
    EqualsVerifier.forClass(RangeInclusiveB.class)
      .withNonnullFields("lower", "upper")
      .verify();
  }

  @Test
  public void testToString_0()
  {
    final var r00 = RangeInclusiveB.of(valueOf(0), valueOf(0));
    final var r00a = RangeInclusiveB.of(valueOf(0), valueOf(0));
    final var r01 = RangeInclusiveB.of(valueOf(0), valueOf(1));
    final var r12 = RangeInclusiveB.of(valueOf(1), valueOf(2));

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
      RangeInclusiveB.of(ZERO, TEN).isIncludedIn(RangeInclusiveB.of(ZERO, TEN)));
    Assertions.assertFalse(
      RangeInclusiveB.of(ZERO, TEN).isIncludedIn(RangeInclusiveB.of(ZERO, valueOf(9))));
    Assertions.assertFalse(
      RangeInclusiveB.of(ZERO, TEN).isIncludedIn(RangeInclusiveB.of(ONE, TEN)));
  }

  @Test
  public void testRange_0()
  {
    final var r = RangeInclusiveB.of(ZERO, valueOf(9));
    Assertions.assertEquals(ZERO, r.lower());
    Assertions.assertEquals(valueOf(9), r.upper());
    Assertions.assertEquals(TEN, r.interval());
  }

  @Test
  public void testRange_1()
  {
    final var r = RangeInclusiveB.of(ZERO, valueOf(9));
    Assertions.assertTrue(r.includesValue(ZERO));
    Assertions.assertTrue(r.includesValue(ONE));
    Assertions.assertFalse(r.includesValue(valueOf(-1)));
    Assertions.assertFalse(r.includesValue(valueOf(10)));
  }

  @Test
  public void testWith()
  {
    final var r = RangeInclusiveB.of(ZERO, valueOf(9));
    Assertions.assertTrue(r.withLower(ONE).lower().equals(ONE));
    Assertions.assertTrue(r.withLower(ZERO).lower().equals(ZERO));
    Assertions.assertTrue(r.withUpper(TEN).upper().equals(TEN));
    Assertions.assertTrue(Objects.equals(r.withUpper(valueOf(9)).upper(), valueOf(9)));
  }

  @Test
  public void testRange_2()
  {
    final var r = RangeInclusiveB.of(ZERO, valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      r.includesValue(TestUtilities.actuallyNull());
    });
  }

  @Property
  public void testCopyOf(
    final @ForAll @IntRange(min = -100, max = 100) int low)
  {
    final var r = RangeInclusiveB.of(valueOf(low), valueOf(low + 10));

    Assertions.assertEquals(r, RangeInclusiveB.copyOf(r));
    Assertions.assertEquals(r, RangeInclusiveB.copyOf(new RangeInclusiveBType()
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
      RangeInclusiveB.builder().build();
    });
  }

  @Test
  public void testRangeBad_0()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeInclusiveB.of(ONE, ZERO);
    });
  }
}
