import dev.bombinating.gradle.jooq.*

plugins {
    java
    id("dev.bombinating.jooq-codegen") version "1.7.0"
}

group = "com.theoxao"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jooq:2.6.2")
    runtimeOnly("org.postgresql:postgresql:42.2.19")
    jooqRuntime("org.postgresql:postgresql:42.2.19")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}


jooq {
    version = "3.14.7"
    jdbc {
        driver = "org.postgresql.Driver"
        url = "jdbc:postgresql://www.theoxao.com:5432/duraemon"
        user = "postgres"
        password = System.getenv("MONGO_PASSWORD")
    }
    generator {
        database {
            name = "org.jooq.meta.postgres.PostgresDatabase"
            inputSchema = "public"
        }
        generate {
            isPojos = true
            isDaos = false
            isKeys = false
            isSequences= false
            isRoutines = false
            isIndexes = false
            isSpringAnnotations = true
        }
        target {
            packageName = "com.theoxao.duraemon.orm.dto"
            directory = "src/main/java"
        }
    }
}

task<Delete>("cleanJooq") {
    delete("${projectDir}/src/main/java/com/theoxao/duraemon/orm/dto")
}

tasks.named("jooq"){
    dependsOn("cleanJooq")
}