# Checksum Creator
A simple project to get me used to Java's `picocli` which is, in fact, vastly superior to Python's `arparse` module (sorry, `argparse`. Though you're built into the Python Standard Library, you don't have ANSI coloring for parameters)

# Why Java?
Well, I've been considerably inactive when using my GitHub, but I've learned C++ and Java now, the latter being my favorite besides Python for various reasons like Jars, *actual* build tools like Apache Maven and Gradle, and namespaced projects. You don't get that in Python

Besides, `picocli` has ANSI coloring and is pretty customizable

# Usage
I will assume that you've done the following:
- You've downloaded and installed the JRE 11
- You've downloaded the latest JAR release of this project
- Your shell's PWD is where you downloaded said latest JAR release

Run the following command to get the list of subcommands:
```
$ java -jar CheckSum.jar help
```
Run the following command to get the checksums of Java class files:
```
$ java -jar path/to/checksum-x.x.x.jar check **/*.class
```
<sub>**Notes:** 1) Must have Java class files. 2) Not tested on Windows</sub>

Output would look something like this:
```
SHA256 Checksum of Checksum.class:
  37a960b10198c247738afb9b3d6723fac3c8b24f5c6a4569536f4b900d55c232
SHA256 Checksum of BaseCommand.class:
  9786c0d4d4e3fdbab7edd643612931c70d1c0d4cc58d3e389506628d1d50302a
SHA256 Checksum of Update.class:
  2bdae72c8f4e54f59fce7a16ae82479ab27638d4adaf27585b778937df5c10c5
SHA256 Checksum of VersionProvider.class:
  327d8768323d035b47a74eeea25936e2e6934b9e63cbd7e96dfce04dbdd3c7f4
```

Optional flags & subcommands can be found by passing in `help` instead of `check`

# Checksum
A program that is written to compute checksums yet doesn't have its own checksum is kinda silly, so here's the official checksum for the current release
```
SHA256 Checksum of checksum-0.0.3.jar:
  215c9d926412d8fe79a62d69cec8b47c8f01c99b619c62e38719346dcaf9f4cd
```

# TODO
- [ ] Uniform the usage output.
  - Right now, the `Usage`, `Description` and `Command-local Flags` sections are tabbed, while the `Commands` and `Error Codes` sections aren't
- [ ] `com.misery.internal.Update`.
  - Basically a class that downloads the latest JAR and replaces the old one, maybe making a dump just in case stuff breaks
  - Probably gonna make it optional/runnable with a command
- [ ] A suite of tools that are bundled with the JAR to *maybe* help debug the program