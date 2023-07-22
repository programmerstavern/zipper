package com.programmerstavern.zipper.commands.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandRegistration;

@Configuration
public class ProgrammaticCommand {

  @Bean
  CommandRegistration commandRegistration() {
    return CommandRegistration.builder()
        .command("programmatic")
        .withTarget()
        .function(ctx -> {
          String arg = ctx.hasMappedOption("arg") ? ctx.getOptionValue("arg") : null;
          return String.format("Hi arg='%s'", arg);
        })
        .and()
        .withOption()
        .longNames("arg")
        .shortNames('a')
        .required()
        .and()
        .build();
  }

}
