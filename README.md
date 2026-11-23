<!--
SPDX-License-Identifier: Apache-2.0
SPDX-FileCopyrightText: 2026 stack-cpu-0 contributors
-->

# stack-cpu-0

A starting point for a stack CPU hardware project in Chisel/Scala.

The build follows the toolchain used by the neighboring `chisel-6502` project.
No CPU, instruction set, word width, or stack architecture is implemented yet.
`ExampleRegister` is a standalone toolchain example, not a CPU component
specification.

## Requirements

- JDK 17 or later (JDK 17 or 21 LTS recommended)
- sbt 1.10.1, selected by `project/build.properties`

The build uses Scala 2.13.14, Chisel 6.5.0, chiseltest 6.0.0, and
ScalaTest 3.2.19. sbt downloads dependencies on the first build.

## Development

```bash
sbt compile
sbt test
sbt "testOnly stackcpu.ExampleRegisterTest"
```

The tests check register reset, clocked data capture, and configurable width.
Build output and test-generated hardware are ignored by Git.

## Layout

- `build.sbt`: dependencies and Scala compiler configuration
- `project/build.properties`: pinned sbt version
- `src/main/scala/stackcpu/`: hardware sources
- `src/test/scala/stackcpu/`: hardware tests

## License

Project-owned files are licensed under the [Apache License, Version 2.0](LICENSE).
Dependencies retain their respective licenses.
