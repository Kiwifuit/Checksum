package com.misery.checksum.internal;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

// @Command(descriptionHeading = "Description:\n  ", parameterListHeading = "Positional Arguments:\n", optionListHeading = "Optional Flags:\n", synopsisHeading = "Usage:\n  ", exitCodeListHeading = "Error Codes:\n", exitCodeList = {
//     "0: Successful Execution. This means everything went well",
//     "1: Big Oopsie. This means something went wrong. Stack Trace is printed instead of the normal output",
//     "2: Missing Parameter. It's self explanatory: you missed a required parameter",
//     "-100: Internal Oopsie. This means that a subclass has not implemented its call() method. This is very nerdy so you probably won't encounter it" })
@Command(resourceBundle = "com.misery.res.project", subcommands = {
    com.misery.checksum.internal.VersionProvider.class, })
public abstract class BaseCommand implements Callable<Integer> {
  @Spec
  CommandSpec spec;

  @Command(name = "help", description = "Show program usage and exit")
  public void help() {
    spec.commandLine().usage(System.out);
  }

  // @Command(name = "help", description = "Shows Program usage and exit")

  // @Mixin
  // LoggingMixin logging;

  public Integer call() {
    System.out.println(
        "The subclass' call method is not implemented!\nReport this error to the Github Repo as an issue.\n\nRemember to include this message and the command you ran");
    return -100;
  }
}
