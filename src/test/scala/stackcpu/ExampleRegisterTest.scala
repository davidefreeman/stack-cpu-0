// SPDX-License-Identifier: Apache-2.0
// SPDX-FileCopyrightText: 2026 stack-cpu-0 contributors

package stackcpu

import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class ExampleRegisterTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "ExampleRegister"

  it should "reset to zero after capturing nonzero data" in {
    test(new ExampleRegister) { dut =>
      dut.io.dataIn.poke(0xA5.U)
      dut.clock.step()
      dut.io.dataOut.expect(0xA5.U)

      dut.reset.poke(true.B)
      dut.clock.step()
      dut.io.dataOut.expect(0.U)

      dut.reset.poke(false.B)
      dut.clock.step()
      dut.io.dataOut.expect(0xA5.U)
    }
  }

  it should "capture input only on a clock edge" in {
    test(new ExampleRegister) { dut =>
      dut.io.dataIn.poke(0x12.U)
      dut.io.dataOut.expect(0.U)
      dut.clock.step()
      dut.io.dataOut.expect(0x12.U)

      dut.io.dataIn.poke(0xFF.U)
      dut.io.dataOut.expect(0x12.U)
      dut.clock.step()
      dut.io.dataOut.expect(0xFF.U)
    }
  }

  it should "support a configurable register width" in {
    test(new ExampleRegister(width = 16)) { dut =>
      dut.io.dataIn.poke(0xCAFE.U)
      dut.clock.step()
      dut.io.dataOut.expect(0xCAFE.U)
    }
  }
}
