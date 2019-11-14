package com.getdress

import com.getdress.GetDressDataDefinition.{Cold, CommandsProcess, Hot}

import scala.util.{Failure, Success, Try}

trait ParametersReader {
  def readParameters(args: Array[String]): Option[GetDressDataDefinition.CommandsProcess] = {
    if(args.length > 1) {
      Try({
        // Read temperature in the first parameter
        val temperature = args(0).toUpperCase() match {
          case "HOT" => Hot
          case "COLD" => Cold
        }

        val cmds = args.tail.flatMap { id =>
          GetDressCommands.currentCommands.find(_.id == id.toInt)
        }

        if(cmds.length != args.length-1)
          throw new Exception(s"Some commands ids are not present, got: ${cmds.mkString(", ")}")
        else
          CommandsProcess(temperature, cmds.toList)
      }) match {
        case Success(value) => Some(value)
        case Failure(_) =>
          printUsage()
          None

      }
    } else {
      printUsage()
      None
    }
  }

  def printUsage(): Unit = {
    println(
      s"""Parameters are the following: Temperature and numbers with commands, example:
         |> HOT 1 2 3 4 5 6
       """.stripMargin)
  }
}