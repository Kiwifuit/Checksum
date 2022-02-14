package com.misery.checksum.subcommands;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

import com.misery.checksum.internal.BaseCommand;

import picocli.CommandLine.*;

@Command(name = "check", description = "Computes the SHA 256 checksum of a file")
public class Check extends BaseCommand {
  @Parameters(arity = "1..*", descriptionKey = "check.files")
  public File[] files;

  @Option(names = "--algorithm", descriptionKey = "check.algo")
  private String algo = "SHA-256";

  @Override
  public Integer call() {
    try {
      for (int i = 0; i < files.length; i++) {
        File file = files[i];

        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algo).digest(fileContents);
        String res = "%s Checksum of %s:\n  %0" + (digest.length * 2) + "x\n";

        System.out.printf(res, algo, file.getName(), new BigInteger(1, digest));
      }
      return 0;
    } catch (Exception err) {
      err.printStackTrace();
      return 1;
    }
  }
}
