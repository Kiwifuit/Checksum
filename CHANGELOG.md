# 0.0.4
- Minor changes to how the program prints error messages
- Added a `--verbose` flag for printing stack traces instead
- Isolated `Check.call`'s computation code to `Check.compute`
  - As a byproduct, a new subcommand was added: `checksum`, used to check the JAR's checksum
# 0.0.3
- Swapped `--version` and `--help` flags for subcommands, `version` and `help`
- Added a `update` subcommand, though not implemented yet as at this stage, I am yet to publish the repo on Github
- Swapped the `--files` parameter for a subcommand `check`, which lengthens the syntax by 1 word, but the idea is inspired by Git
- Rerouted I/O traffic for `project.properties` to `BaseCommand`'s `resourceBundle` parameter. Same apparently goes for `VersionProvider`
  - TL;DR:
    ---
    - `BaseCommand` takes `project.properties` and gives it to subclasses. Which makes bundles pretty cool
- 0.0.x updates are public

# 0.0.2
- Major overhauls to codebase including the following:
  - Subcommands
  - Re-usable Base Command
  - Logging Mixin
  - Version and Resource providers
- Will be releasing the repository somewhere on 0.1.0 or something. For now, 0.0x updates are not public

# 0.0.1
- Started the project