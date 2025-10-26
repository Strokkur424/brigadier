plugins {
  id("java-library")
  id("maven-publish")
}

repositories {
  mavenCentral()
  maven("https://libraries.minecraft.net")
}

dependencies {
  testCompileOnly("com.google.guava:guava:32.0.1-android")
  testCompileOnly("junit:junit-dep:4.11")
  testCompileOnly("org.hamcrest:hamcrest-library:1.3")
  testCompileOnly("org.mockito:mockito-core:1.10.19")
  testCompileOnly("com.google.guava:guava-testlib:26.0-jre")
  testCompileOnly("org.openjdk.jmh:jmh-core:1.21")
  annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.21")
}

java {
  withSourcesJar()
  withJavadocJar()
}

publishing {
  repositories {
    maven {
      authentication {
        credentials(PasswordCredentials::class) {
          username = System.getenv("NEXUS_USERNAME")
          password = System.getenv("NEXUS_PASSWORD")
        }
      }

      name = "EldoNexus"
      setUrl("https://eldonexus.de/repository/maven-releases/")
    }
  }

  publications {
    create<MavenPublication>("eldonexus") {
      from(components["java"])
      withBuildIdentifier()
    }
  }
}