plugins {
    java
}

group = "com.kodilla"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
}

tasks.withType<Test> {
    useJUnitPlatform()
}
