package com.getdress

import com.getdress.GetDressApp.translateCommand
import com.getdress.GetDressDataDefinition.{CommandsProcess, GetDressResult}

import scala.annotation.tailrec

trait GetDressCommandProcessor {
  @tailrec
  final def processCommands(commandsProcess: CommandsProcess, getDressResult: GetDressResult): GetDressResult = {

    commandsProcess.cmds match {
      case currentCommand :: nextCmds =>
        getDressResult match {
          //First Rule
          case e if !e.hasPjsOff && currentCommand == GetDressCommands.command8 => // we must check that the first cmd is 8
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasPjsOff = true, result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case e if !e.hasPjsOff =>
            getDressResult.copy(result = getDressResult.result ++ fail)


          //3rd Rule
          case _ if commandsProcess.isHot_? && currentCommand == GetDressCommands.command3 => // Cannot put socks if its hot
            getDressResult.copy(result = getDressResult.result ++ fail)

          //4th Rule
          case _ if commandsProcess.isHot_? && currentCommand == GetDressCommands.command5 => // Cannot put jacket if its hot
            getDressResult.copy(result = getDressResult.result ++ fail)


          //5 and 6th Rule
          case e if ((commandsProcess.isCold_? && !e.hasSocks) || !e.hasPants) && currentCommand == GetDressCommands.command1 => //  footwear
            getDressResult.copy(result = getDressResult.result ++ fail)


          case e if (currentCommand == GetDressCommands.command5 || currentCommand == GetDressCommands.command2) && !e.hasShirt => //
            getDressResult.copy(result = getDressResult.result ++ fail)

          case e if currentCommand == GetDressCommands.command7 &&
            (!e.hasShirt || !e.hasHeadwear || !e.hasPants || !e.hasFootwear || !e.hasPjsOff || (commandsProcess.isCold_? && (!e.hasJacket || !e.hasSocks))) =>
            getDressResult.copy(result = getDressResult.result ++ fail)

          case e if currentCommand == GetDressCommands.command1 && !e.hasFootwear =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasFootwear = true,result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case e if currentCommand == GetDressCommands.command2 && !e.hasHeadwear =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasHeadwear = true,result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case e if currentCommand == GetDressCommands.command3 && !e.hasSocks =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasSocks = true,result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case e if currentCommand == GetDressCommands.command4 && !e.hasShirt =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasShirt = true,result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case e if currentCommand == GetDressCommands.command5 && !e.hasJacket =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasJacket = true,result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case e if currentCommand == GetDressCommands.command6 && !e.hasPants =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(hasPants = true,result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case _ if currentCommand == GetDressCommands.command7 =>
            processCommands(commandsProcess.copy(cmds = nextCmds), getDressResult.copy(result = getDressResult.result ++ List(translateCommand(commandsProcess.temp, currentCommand))))

          case _ =>
            getDressResult.copy(result = getDressResult.result ++ fail)

        }

      case _ => getDressResult
    }
  }
  val fail = List("fail")
}
