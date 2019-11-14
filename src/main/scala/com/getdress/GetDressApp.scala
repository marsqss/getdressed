package com.getdress

import com.getdress.GetDressDataDefinition._

object GetDressApp extends App
  with ParametersReader
  with GetDressCommandTranslator
  with GetDressCommandProcessor {

  readParameters(args).foreach(cmds => println(s"${processCommands(cmds, GetDressResult()).result.mkString(", ")}"))

}

