# Brigadier [![License](https://img.shields.io/github/license/Mojang/brigadier.svg)](https://github.com/Mojang/brigadier/blob/master/LICENSE)

Brigadier is a command parser & dispatcher, designed and developed for Minecraft: Java Edition and now freely available for use elsewhere under the MIT license.

## This repository is a mirror **which adds a module-info.java**
For the original repository, see https://github.com/Mojang/brigadier.

# Usage

## Gradle
```kts
repositories {
  maven("https://eldonexus.de/repositories/maven-public/")
}

dependencies {
  api("net.strokkur:brigadier:1.3.0")
}
```