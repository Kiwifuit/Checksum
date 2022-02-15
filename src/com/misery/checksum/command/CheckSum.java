package com.misery.checksum.command;

import java.io.File;
import java.math.BigInteger;

import com.misery.checksum.internal.BaseCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(name = "checksum", description = "Computes and displays the current JAR's checksum")
public class CheckSum extends BaseCommand {
  private File jar = new File("./README.md");

  @Spec
  CommandSpec spec;

  @Override
  public Integer call() {
    try {
      byte[] digest = new Check().compute(jar);
      String res = "Checksum:\n  %0" + (digest.length * 2) + "x";
      System.out.println(String.format(res, new BigInteger(1, digest)));
    } catch (Exception err) {
      err.printStackTrace();
    }
    return 0;
  }
}