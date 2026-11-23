// SPDX-License-Identifier: Apache-2.0
// SPDX-FileCopyrightText: 2026 stack-cpu-0 contributors

package stackcpu

import chisel3._

/** Toolchain example only; not a CPU datapath or an ISA definition. */
class ExampleRegister(val width: Int = 8) extends Module {
  require(width > 0, "Register width must be positive")

  val io = IO(new Bundle {
    val dataIn = Input(UInt(width.W))
    val dataOut = Output(UInt(width.W))
  })

  val value = RegInit(0.U(width.W))
  value := io.dataIn
  io.dataOut := value
}
