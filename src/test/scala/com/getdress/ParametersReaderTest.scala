package com.getdress

import com.getdress.GetDressDataDefinition.Hot
import org.scalatest.{FlatSpecLike, Matchers}

class ParametersReaderTest extends ParametersReader
  with Matchers
  with FlatSpecLike {

  "readParameters" should "fail for invalid input 1" in {
    readParameters(Array("1", "2", "3")).isDefined shouldBe false
  }

  "readParameters" should "fail for invalid input 2" in {
    readParameters(Array("COLD", "HOT", "3")).isDefined shouldBe false
  }

  "readParameters" should "return correct temperature for valid input 1" in {
    val cmds = readParameters(Array("HOT", "2", "3"))
    cmds.get.temp shouldBe Hot
  }

  "readParameters" should "return correct cmds for valid input 1" in {
    val cmds = readParameters(Array("HOT", "2", "3"))
    cmds.get.cmds(0) shouldBe GetDressCommands.command2
  }

  "readParameters" should "return correct cmds for valid input 2" in {
    val cmds = readParameters(Array("HOT", "2", "3"))
    cmds.get.cmds(1) shouldBe GetDressCommands.command3
  }
}
