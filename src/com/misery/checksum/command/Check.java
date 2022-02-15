package com.misery.checksum.command;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.misery.checksum.internal.BaseCommand;

import picocli.CommandLine.*;

@Command(name = "check", description = "Computes the SHA 256 checksum of a file")
public class Check extends BaseCommand {
  @Parameters(arity = "1..*", descriptionKey = "check.files")
  public File[] files;

  @Option(names = "--algorithm", descriptionKey = "check.algo")
  private String algo = "SHA-256";

  @Option(names = { "-v", "--verbose" }, descriptionKey = "common.verbose.description")
  private boolean pst = false;

  public byte[] compute(File file) throws NoSuchAlgorithmException, IOException {
    byte[] fileContents = Files.readAllBytes(file.toPath());
    byte[] digest = MessageDigest.getInstance(this.algo).digest(fileContents);

    return digest;
  }

  @Override
  public Integer call() {
    int onFileIndex = 0;
    try {
      for (int i = 0; i < files.length; i++) {
        File file = files[i];
        byte[] digest = compute(file);
        String res = "%s Checksum of %s:\n  %0" + (digest.length * 2) + "x\n";

        System.out.printf(res, algo.toUpperCase(), file.getName(), new BigInteger(1, digest));
        onFileIndex++;
      }
      return 0;
    } catch (Exception err) {
      if (pst) {
        err.printStackTrace(System.out);
      } else {
        System.err.println(files[onFileIndex] + ": " + err);
      }
      return 1;
    }
  }
}
