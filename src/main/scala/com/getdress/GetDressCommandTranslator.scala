package com.getdress

import com.getdress.GetDressDataDefinition._

trait GetDressCommandTranslator {
  def translateCommand(temperature: Temperature, command: GetDressCommand): String = {
    command match {
      case c if c.id == 1 && temperature == Hot =>
        "sandals"
      case c if c.id == 1 && temperature == Cold =>
        "boots"

      case c if c.id == 2 && temperature == Hot =>
        "sunglasses"
      case c if c.id == 2 && temperature == Cold =>
        "hat"

      case c if c.id == 3 =>
        "socks"

      case c if c.id == 4 =>
        "shirt"

      case c if c.id == 5 =>
        "jacket"

      case c if c.id == 6 && temperature == Hot =>
        "shorts"
      case c if c.id == 6 && temperature == Cold =>
        "pants"

      case c if c.id == 7 =>
        "leaving house"

      case c if c.id == 8 =>
        "Removing PJs"

      case c => throw new Exception(s"Translation called for an invalid value: $c")
    }
  }
}