package com.getdress

import com.getdress.GetDressDataDefinition.GetDressCommand

object GetDressCommands {
  val command1: GetDressCommand = GetDressDataDefinition.GetDressCommand(1, "Put on footwear")
  val command2: GetDressCommand = GetDressDataDefinition.GetDressCommand(2, "Put on headwear")
  val command3: GetDressCommand = GetDressDataDefinition.GetDressCommand(3, "Put on socks")
  val command4: GetDressCommand = GetDressDataDefinition.GetDressCommand(4, "Put on shirt")
  val command5: GetDressCommand = GetDressDataDefinition.GetDressCommand(5, "Put on jacket")
  val command6: GetDressCommand = GetDressDataDefinition.GetDressCommand(6, "Put on pants")
  val command7: GetDressCommand = GetDressDataDefinition.GetDressCommand(7, "Leave house")
  val command8: GetDressCommand = GetDressDataDefinition.GetDressCommand(8, "Take off pajamas")

  lazy val currentCommands: List[GetDressCommand] = List(
    command1,command2,command3,command4,command5,command6,command7,command8
  )
}
