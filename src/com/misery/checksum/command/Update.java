package com.misery.checksum.command;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.misery.checksum.internal.BaseCommand;

import picocli.CommandLine.Command;

@Command(name = "update", description = "Downloads the latest JAR of the project")
public class Update extends BaseCommand {
  public int stat = 1;

  public void connect() throws IOException {
    URLConnection url = new URL("https://github.com/kiwifuit/checksum").openConnection();
    url.connect();

    // System.out.println();
    stat = 0;
  }

  @Override
  public Integer call() {
    System.out.println("Not implemented");
    return stat;
  }

  public static void main(String[] args) {
    Update self = new Update();

    try {
      self.connect();
    } catch (Exception err) {
      System.err.println(err);
    } finally {
      System.out.println("Program exited with code " + self.stat);
    }
  }
}
