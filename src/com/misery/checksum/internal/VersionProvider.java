package com.misery.checksum.internal;

import java.util.LinkedList;
import java.util.concurrent.Callable;

import picocli.CommandLine.*;
import picocli.CommandLine.Model.CommandSpec;

@Command(name = "version", description = "Show program version and exit")
public class VersionProvider implements IVersionProvider, Callable<Integer> {
  @Spec
  CommandSpec spec;

  public String[] getVersion() {
    String version = spec.resourceBundle().getString("project.format.version");
    String author = spec.resourceBundle().getString("project.format.author");
    String infos = spec.resourceBundle().getString("project.version");
    LinkedList<String> lines = new LinkedList<String>();

    lines.add(String.format("%s v%s by %s", spec.qualifiedName(), version, author));
    lines.add(infos);

    return convertList(lines);
  }

  public static LinkedList<String> convertArray(String[] array) {
    LinkedList<String> res = new LinkedList<String>();

    for (int i = 0; i < array.length; i++) {
      res.add(array[i]);
    }

    return res;
  }

  public static String[] convertList(LinkedList<String> list) {
    String[] res = new String[list.size()];

    list.forEach((String item) -> {
      int i = list.indexOf(item);
      res[i] = item;
    });

    return res;
  }

  public Integer call() {
    try {
      String[] versionLines = getVersion();

      if (versionLines == null) {
        System.out.println("Not Implemented");
      } else {
        for (int i = 0; i < versionLines.length; i++) {
          System.out.println(versionLines[i]);
        }
      }

      return 0;
    } catch (Exception err) {
      err.printStackTrace();
      return 1;
    }
  }
}
