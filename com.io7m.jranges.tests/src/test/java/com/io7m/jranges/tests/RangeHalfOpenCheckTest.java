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
import com.io7m.jranges.RangeHalfOpenCheck;
import com.io7m.jranges.RangeHalfOpenI;
import com.io7m.jranges.RangeHalfOpenL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class RangeHalfOpenCheckTest
{
  @Test
  public void testIncludedNullBig_0()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInBig(
        (BigInteger) TestUtilities.actuallyNull(), "value", range, "range");
    });
  }

  @Test
  public void testIncludedNullBig_1()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInBig(
        BigInteger.ZERO, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedNullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInBig(
        BigInteger.ZERO,
        "name",
        (RangeHalfOpenB) TestUtilities.actuallyNull(),
        "range");
    });
  }

  @Test
  public void testIncludedNullBig_3()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInBig(
        BigInteger.ZERO, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedBigRange_0()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInBig(
        BigInteger.valueOf(-1), "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedBigRange_1()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInBig(BigInteger.TEN, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedBigRange_2()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertEquals(
      BigInteger.ZERO, RangeHalfOpenCheck.checkIncludedInBig(
        BigInteger.ZERO, "Value", range, "Range"));
  }

  @Test
  public void testIncludedBigRange_3()
  {
    final var range =
      RangeHalfOpenB.of(BigInteger.valueOf(0), BigInteger.valueOf(9));
    Assertions.assertEquals(
      BigInteger.valueOf(8),
      RangeHalfOpenCheck.checkIncludedInBig(BigInteger.valueOf(8), "Value", range, "Range"));
  }

  @Test
  public void testIncludedNullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeHalfOpenL.of(0, 9);
      RangeHalfOpenCheck.checkIncludedInLong(
        0L, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedNullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInLong(
        0L, "name", (RangeHalfOpenL) TestUtilities.actuallyNull(), "range");
    });
  }

  @Test
  public void testIncludedNullLong_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeHalfOpenL.of(0, 9);
      RangeHalfOpenCheck.checkIncludedInLong(
        0L, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedNullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeHalfOpenI.of(0, 9);
      RangeHalfOpenCheck.checkIncludedInInteger(
        0, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedNullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(
        0, "name", (RangeHalfOpenI) TestUtilities.actuallyNull(), "range");
    });
  }

  @Test
  public void testIncludedNullInteger_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      final var range = RangeHalfOpenI.of(0, 9);
      RangeHalfOpenCheck.checkIncludedInInteger(
        0, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedRangeLong_0()
  {
    final var range = RangeHalfOpenL.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInLong(-1, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeLong_1()
  {
    final var range = RangeHalfOpenL.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInLong(10, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeLong_2()
  {
    final var range = RangeHalfOpenL.of(0, 9);
    Assertions.assertEquals(
      0, RangeHalfOpenCheck.checkIncludedInLong(0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeLong_3()
  {
    final var range = RangeHalfOpenL.of(0, 9);
    Assertions.assertEquals(
      8, RangeHalfOpenCheck.checkIncludedInLong(8, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeInteger_0()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(-1, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeInteger_1()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(10, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedRangeInteger_2()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertEquals(
      0, RangeHalfOpenCheck.checkIncludedInInteger(0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeInteger_3()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertEquals(
      8, RangeHalfOpenCheck.checkIncludedInInteger(8, "Value", range, "Range"));
  }

  @Test
  public void testRangeIncludedLong_0()
  {
    Assertions.assertEquals(
      RangeHalfOpenL.of(0, 0), RangeHalfOpenCheck.checkRangeIncludedInLong(
        RangeHalfOpenL.of(0, 0),
        "Inner",
        RangeHalfOpenL.of(0, 0),
        "Outer"));
  }

  @Test
  public void testRangeIncludedLong_1()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInLong(
        RangeHalfOpenL.of(1, 1), "Inner", RangeHalfOpenL.of(0, 0), "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInLong(
        (RangeHalfOpenL) TestUtilities.actuallyNull(),
        "Inner",
        RangeHalfOpenL.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInLong(
        RangeHalfOpenL.of(0, 0),
        (String) TestUtilities.actuallyNull(),
        RangeHalfOpenL.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInLong(
        RangeHalfOpenL.of(0, 0),
        "Inner",
        (RangeHalfOpenL) TestUtilities.actuallyNull(),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullLong_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInLong(
        RangeHalfOpenL.of(0, 0),
        "Inner",
        RangeHalfOpenL.of(0, 0),
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncludedInteger_0()
  {
    Assertions.assertEquals(
      RangeHalfOpenI.of(0, 0), RangeHalfOpenCheck.checkRangeIncludedInInteger(
        RangeHalfOpenI.of(0, 0),
        "Inner",
        RangeHalfOpenI.of(0, 0),
        "Outer"));
  }

  @Test
  public void testRangeIncludedInteger_1()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInInteger(
        RangeHalfOpenI.of(1, 1), "Inner", RangeHalfOpenI.of(0, 0), "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInInteger(
        (RangeHalfOpenI) TestUtilities.actuallyNull(),
        "Inner",
        RangeHalfOpenI.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInInteger(
        RangeHalfOpenI.of(0, 0),
        (String) TestUtilities.actuallyNull(),
        RangeHalfOpenI.of(0, 0),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInInteger(
        RangeHalfOpenI.of(0, 0),
        "Inner",
        (RangeHalfOpenI) TestUtilities.actuallyNull(),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullInteger_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInInteger(
        RangeHalfOpenI.of(0, 0),
        "Inner",
        RangeHalfOpenI.of(0, 0),
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncluded_NullBig_0()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInBig(
        (RangeHalfOpenB) TestUtilities.actuallyNull(),
        "Inner",
        RangeHalfOpenB.of(BigInteger.ZERO, BigInteger.ZERO),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullBig_1()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInBig(
        RangeHalfOpenB.of(BigInteger.ZERO, BigInteger.ZERO),
        (String) TestUtilities.actuallyNull(),
        RangeHalfOpenB.of(BigInteger.ZERO, BigInteger.ZERO),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullBig_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInBig(
        RangeHalfOpenB.of(BigInteger.ZERO, BigInteger.ZERO),
        "Inner",
        (RangeHalfOpenB) TestUtilities.actuallyNull(),
        "Outer");
    });
  }

  @Test
  public void testRangeIncluded_NullBig_3()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInBig(
        RangeHalfOpenB.of(
          BigInteger.ZERO, BigInteger.ZERO),
        "Inner",
        RangeHalfOpenB.of(
          BigInteger.ZERO, BigInteger.ZERO),
        (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testRangeIncludedBig_0()
  {
    Assertions.assertEquals(
      RangeHalfOpenB.of(BigInteger.ZERO, BigInteger.ZERO),
      RangeHalfOpenCheck.checkRangeIncludedInBig(
        RangeHalfOpenB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Inner", RangeHalfOpenB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Outer"));
  }

  @Test
  public void testRangeIncludedBig_1()
  {
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkRangeIncludedInBig(
        RangeHalfOpenB.of(
          BigInteger.ONE, BigInteger.ONE), "Inner", RangeHalfOpenB.of(
          BigInteger.ZERO, BigInteger.ZERO), "Outer");
    });
  }

  @Test
  public void testIncludedIntNull_1()
  {
    final var range = RangeHalfOpenI.of(0, 9);

    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(
        0, (String) TestUtilities.actuallyNull(), range, "range");
    });
  }

  @Test
  public void testIncludedIntNull_2()
  {
    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(
        0, "name", (RangeHalfOpenI) TestUtilities.actuallyNull(), "range");
    });
  }

  @Test
  public void testIncludedIntNull_3()
  {
    final var range = RangeHalfOpenI.of(0, 9);

    Assertions.assertThrows(NullPointerException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(
        0, "name", range, (String) TestUtilities.actuallyNull());
    });
  }

  @Test
  public void testIncludedIntRange_0()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(
        -1, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedIntRange_1()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertThrows(RangeCheckException.class, () -> {
      RangeHalfOpenCheck.checkIncludedInInteger(10, "Value", range, "Range");
    });
  }

  @Test
  public void testIncludedIntRange_2()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertEquals(
      0, RangeHalfOpenCheck.checkIncludedInInteger(
        0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedIntRange_3()
  {
    final var range = RangeHalfOpenI.of(0, 9);
    Assertions.assertEquals(
      8, RangeHalfOpenCheck.checkIncludedInInteger(
        8, "Value", range, "Range"));
  }

}
