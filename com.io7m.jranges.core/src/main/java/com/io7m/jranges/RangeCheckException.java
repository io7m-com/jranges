/*
 * Copyright © 2015 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

package com.io7m.jranges;

/**
 * <p> An exception raised when a {@link RangeCheck} assertion fails. </p> <p>
 * Exceptions of this type are <i>not</i> intended to be caught and handled; they indicate program
 * bugs. </p>
 *
 * @see RangeCheck
 */

public final class RangeCheckException extends RuntimeException
{
  private static final long serialVersionUID;

  static {
    serialVersionUID = 8903526524825509413L;
  }

  /**
   * Construct an exception with the given message.
   *
   * @param message The message
   */

  public RangeCheckException(
    final String message)
  {
    super("Range check failed: " + message);
  }

  /**
   * Construct an exception with the given cause and message.
   *
   * @param message The message
   * @param cause   The cause
   */

  public RangeCheckException(
    final String message,
    final Throwable cause)
  {
    super("Range check failed: " + message, cause);
  }
}
