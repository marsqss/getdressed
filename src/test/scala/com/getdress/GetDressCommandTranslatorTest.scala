package com.getdress

import com.getdress.GetDressDataDefinition.{Cold, Hot}
import org.scalatest.{FlatSpecLike, Matchers}

class GetDressCommandTranslatorTest extends GetDressCommandTranslator
  with Matchers
  with FlatSpecLike {

  "translateCommand" should "translate correctly footwear for Hot weather" in {
    translateCommand(Hot, GetDressCommands.command1) shouldBe "sandals"
  }

  "translateCommand" should "translate correctly footwear for Cold weather" in {
    translateCommand(Cold, GetDressCommands.command1) shouldBe "boots"
  }

  "translateCommand" should "translate correctly headwear for Hot weather" in {
    translateCommand(Hot, GetDressCommands.command2) shouldBe "sunglasses"
  }

  "translateCommand" should "translate correctly headwear for Cold weather" in {
    translateCommand(Cold, GetDressCommands.command2) shouldBe "hat"
  }

  // We can add more here!

}
