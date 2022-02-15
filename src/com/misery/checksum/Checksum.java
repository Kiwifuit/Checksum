package com.misery.checksum;

import com.misery.checksum.internal.BaseCommand;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

// VSCode do be formatting this annotation :(
@Command(name = "checksum", description = "Computes a file's SHA-256 checksum", subcommands = {
    com.misery.checksum.command.Update.class,
    com.misery.checksum.command.Check.class,
    com.misery.checksum.command.CheckSum.class }, usageHelpAutoWidth = true, abbreviateSynopsis = true, versionProvider = com.misery.checksum.internal.VersionProvider.class)
public class Checksum extends BaseCommand {
  @Spec
  CommandSpec spec;

  @Override
  public Integer call() {
    // System.out.println();
    spec.commandLine().usage(System.out);
    return 0;
  }

  public static void main(String[] args) {
    CommandLine cmd = new CommandLine(new Checksum());
    System.exit(cmd.execute(args));
  }
}
