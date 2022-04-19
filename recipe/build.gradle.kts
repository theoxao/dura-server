plugins {
    java
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":orm"))
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.jooq:jooq-codegen:3.14.7")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("net.sourceforge.htmlcleaner:htmlcleaner:2.26")
    implementation("com.huaban:jieba-analysis:1.0.2")

    implementation("joda-time:joda-time:2.10.6")

    runtimeOnly("org.postgresql:postgresql:42.2.19")

    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}