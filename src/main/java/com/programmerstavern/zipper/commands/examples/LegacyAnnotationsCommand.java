package com.programmerstavern.zipper.commands.examples;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class LegacyAnnotationsCommand {

  @ShellMethod(key = "test")
  public String test() {
    return "TEST!";
  }

}