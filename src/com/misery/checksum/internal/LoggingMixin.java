package com.misery.checksum.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

import picocli.CommandLine.Option;

public class LoggingMixin {
  @Option(names = { "-l",
      "--level" }, defaultValue = "INFO", arity = "0..1", description = "Logger class to use. Can be @|underline OFF|@, @|underline INFO|@, @|underline WARN|@ or @|underline ERROR|@")
  private String level = "INFO";
  private Logger logger = Logger.getLogger("Logger");
  public Level logLevel = Level.parse(level);

  public LoggingMixin() {
    this.logger.setLevel(this.logLevel);
  }

  public void info(String msg, Object... args) {
    this.logger.info(String.format(msg, args));
  }

  public void info(String msg) {
    this.logger.info(msg);
  }

  public void debug(String msg, Object... args) {
    // this.logger.(String.format(msg, args));
  }

  public void debug(String msg) {
    // this.logger.debug(msg);
  }

}
