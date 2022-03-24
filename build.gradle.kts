plugins {
    java
    kotlin("jvm") version "1.5.32"
    id("org.springframework.boot") version "2.6.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("plugin.spring") version "1.5.32"
}

group = "com.theoxao"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}