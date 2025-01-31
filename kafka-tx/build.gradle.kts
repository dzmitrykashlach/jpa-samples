
plugins {
    java
    kotlin("jvm") version "2.0.0"
    id("org.jooq.jooq-codegen-gradle") version "3.20.1"
}

group = "org.jooq"

repositories {
    mavenCentral()
}

dependencies {
    jooqCodegen(platform("org.springframework.boot:spring-boot-dependencies:3.4.3"))
    jooqCodegen("org.jooq:jooq-codegen")
    jooqCodegen("org.postgresql:postgresql:42.7.5")
    jooqCodegen("org.jooq:jooq-meta-extensions-hibernate:3.20.1")
    implementation("org.jooq:jooq:3.20.2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.3")
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.13")
    implementation("org.postgresql:postgresql:42.7.5")
    implementation ("com.gruelbox:transactionoutbox-spring:6.0.585")
    implementation ("com.gruelbox:transactionoutbox-jooq:6.0.585")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.3")
    testImplementation(kotlin("test"))
}
jooq {
    configuration {
        generator {
            name = "org.jooq.codegen.KotlinGenerator"
        }
        jdbc{
            driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=kafka-tx"
            user = "postgres"
            password = "root"
        }
        generator{
            database{
                name = "org.jooq.meta.postgres.PostgresDatabase"
                properties {
                    property {
                        key = "packages"
                        value = "tx.entities"
                    }
                }
                excludes = """
                Job|Address|UserDetails|pagination\..*|information_schema\..*|pg_catalog\..*
                """.trimMargin()
            }
            target {

                packageName = "kafka.tx.jooq.generated"

                directory = "src/main/kotlin"
            }


        }
    }
}

java.sourceSets.getByName("main"){
    java.srcDir("src/main/kotlin")
}
java.sourceSets.getByName("test"){
    java.srcDir("src/test/kotlin")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}