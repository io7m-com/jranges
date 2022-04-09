/*
 * Copyright © 2019 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

import com.io7m.jranges.RangeCheck;
import com.io7m.jranges.RangeHalfOpenCheck;
import com.io7m.jranges.Ranges;
import com.io7m.junreachable.UnreachableCodeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public final class Unreachable
{
  @TestFactory
  public Stream<DynamicTest> testUnreachable()
  {
    return Stream.of(
      RangeCheck.class,
      RangeHalfOpenCheck.class,
      Ranges.class)
      .map(clazz -> DynamicTest.dynamicTest("testUnreachable" + clazz.getSimpleName(), () -> {
        try {
          final var cons = clazz.getDeclaredConstructor();
          cons.setAccessible(true);
          cons.newInstance();
          Assertions.fail();
        } catch (final NoSuchMethodException
          | SecurityException
          | InstantiationException
          | IllegalAccessException
          | IllegalArgumentException e) {
          throw e;
        } catch (final InvocationTargetException e) {
          Assertions.assertEquals(UnreachableCodeException.class, e.getCause().getClass());
        }
      }));
  }
}
