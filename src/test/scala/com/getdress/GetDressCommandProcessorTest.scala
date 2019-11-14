package com.getdress

import com.getdress.GetDressCommands._
import com.getdress.GetDressDataDefinition.{CommandsProcess, GetDressResult}
import org.scalatest.{FlatSpecLike, Matchers}

class GetDressCommandProcessorTest extends GetDressCommandProcessor
  with Matchers
  with FlatSpecLike {

  "processCommands" should "return expected results for input 1" in {
    val commands = List(command8, command6, command4, command2, command1, command7)
    processCommands(CommandsProcess(GetDressDataDefinition.Hot, commands), GetDressResult()).result.mkString(", ") shouldBe "Removing PJs, shorts, shirt, sunglasses, sandals, leaving house"
  }

  "processCommands" should "return expected results for input 2" in {
    val commands = List(command8, command6, command3, command4, command2, command5, command1, command7)
    processCommands(CommandsProcess(GetDressDataDefinition.Cold, commands), GetDressResult()).result.mkString(", ") shouldBe "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house"
  }

  "processCommands" should "fail for input 3" in {
    val commands = List(command8, command6, command6)
    processCommands(CommandsProcess(GetDressDataDefinition.Hot, commands), GetDressResult()).result.mkString(", ") shouldBe "Removing PJs, shorts, fail"
  }

  "processCommands" should "fail for input 4" in {
    val commands = List(command8, command6, command3)
    processCommands(CommandsProcess(GetDressDataDefinition.Hot, commands), GetDressResult()).result.mkString(", ") shouldBe "Removing PJs, shorts, fail"
  }

  "processCommands" should "fail for input 5" in {
    val commands = List(command8, command6, command3, command4, command2, command5, command7)
    processCommands(CommandsProcess(GetDressDataDefinition.Cold, commands), GetDressResult()).result.mkString(", ") shouldBe "Removing PJs, pants, socks, shirt, hat, jacket, fail"
  }

  "processCommands" should "fail for input 6" in {
    val commands = List(command6)
    processCommands(CommandsProcess(GetDressDataDefinition.Cold, commands), GetDressResult()).result.mkString(", ") shouldBe "fail"
  }


}
