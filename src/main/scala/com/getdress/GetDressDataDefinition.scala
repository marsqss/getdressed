package com.getdress

object GetDressDataDefinition {
  trait Temperature

  case object Hot extends Temperature {
    override def toString: String = "HOT"
  }

  case object Cold extends Temperature {
    override def toString: String = "COLD"
  }

  case class GetDressCommand(id: Int, desc: String)

  case class CommandsProcess(temp: Temperature, cmds: List[GetDressCommand]) {
    def isHot_? : Boolean = temp == Hot
    def isCold_? : Boolean = temp == Cold
  }

  case class CommandsProcessResult(cp: CommandsProcess, result: List[String]) {
    def isHot_? : Boolean = cp.temp == Hot
    def isCold_? : Boolean = cp.temp == Cold
  }

  case class GetDressResult(
                             hasPjsOff: Boolean = false,
                             hasFootwear: Boolean = false,
                             hasHeadwear: Boolean = false,
                             hasSocks: Boolean = false,
                             hasShirt: Boolean = false,
                             hasJacket: Boolean = false,
                             hasPants: Boolean = false,
                             result: List[String] = List()
                           )
}
