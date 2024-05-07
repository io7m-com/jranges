jranges
===

[![Maven Central](https://img.shields.io/maven-central/v/com.io7m.jranges/com.io7m.jranges.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.io7m.jranges%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/com.io7m.jranges/com.io7m.jranges?server=https%3A%2F%2Fs01.oss.sonatype.org&style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/io7m/jranges/)
[![Codecov](https://img.shields.io/codecov/c/github/io7m-com/jranges.svg?style=flat-square)](https://codecov.io/gh/io7m-com/jranges)
![Java Version](https://img.shields.io/badge/21-java?label=java&color=007fff)

![com.io7m.jranges](./src/site/resources/jranges.jpg?raw=true)

| JVM | Platform | Status |
|-----|----------|--------|
| OpenJDK (Temurin) Current | Linux | [![Build (OpenJDK (Temurin) Current, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jranges/main.linux.temurin.current.yml)](https://www.github.com/io7m-com/jranges/actions?query=workflow%3Amain.linux.temurin.current)|
| OpenJDK (Temurin) LTS | Linux | [![Build (OpenJDK (Temurin) LTS, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jranges/main.linux.temurin.lts.yml)](https://www.github.com/io7m-com/jranges/actions?query=workflow%3Amain.linux.temurin.lts)|
| OpenJDK (Temurin) Current | Windows | [![Build (OpenJDK (Temurin) Current, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jranges/main.windows.temurin.current.yml)](https://www.github.com/io7m-com/jranges/actions?query=workflow%3Amain.windows.temurin.current)|
| OpenJDK (Temurin) LTS | Windows | [![Build (OpenJDK (Temurin) LTS, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jranges/main.windows.temurin.lts.yml)](https://www.github.com/io7m-com/jranges/actions?query=workflow%3Amain.windows.temurin.lts)|

## jranges

A set of functions and types for dealing with ranges and intervals.

## Features

* Immutable range types, for specifying ranges over all the available integral
  and floating point types.
* Functions for checking that values fall within given ranges.
* High coverage test suite.
* [OSGi-ready](https://www.osgi.org/)
* [JPMS-ready](https://en.wikipedia.org/wiki/Java_Platform_Module_System)
* ISC license.

## Usage

### Range Checks

Use the `RangeCheck` class to perform range checks:

```
RangeCheck.checkIncludedInLong(
  23L,
  "Number of assignments",
  RangeInclusiveL.of(0L, 99),
  "Valid number of assignments"
);

RangeCheck.checkIncludedInLong(
  130L,
  "Number of assignments",
  RangeInclusiveL.of(0L, 99),
  "Valid number of assignments"
);
```

The second call will throw a `RangeCheckException` with a message similar to
`Range check failed: 0 <= Number of assignments (130) <= 99 (Valid number of assignments) == false`.

### Range Types

The package exposes numerous immutable half-open and inclusive range types,
specialized to various Java numeric types:

  * `RangeHalfOpenB`
  * `RangeHalfOpenD`
  * `RangeHalfOpenI`
  * `RangeHalfOpenL`
  * `RangeInclusiveB`
  * `RangeInclusiveD`
  * `RangeInclusiveI`
  * `RangeInclusiveL`

