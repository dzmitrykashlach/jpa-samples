plugins {
    kotlin("plugin.jpa") version "2.0.0"
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.spring") version "2.0.0"
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"

}

group = "com.jpa"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("net.datafaker:datafaker:2.3.0")
        implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.1")
        implementation("org.apache.tomcat:tomcat-dbcp:11.0.0-M22")
        implementation("org.postgresql:postgresql:42.7.2")
        testImplementation("org.junit.jupiter:junit-jupiter-params:5.0.0-M4")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        testImplementation(kotlin("test"))
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}