import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}

plugins {
    val kotlinVersion = "1.3.70"

    base
    java
    id("org.springframework.boot") version "2.0.3.RELEASE"
    id("com.github.ben-manes.versions") version "0.27.0"
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
}

allprojects {
    val javaVersion: String by project

    group = "flirtapp.app"

    tasks.withType<JavaCompile> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = javaVersion
        }
    }
}

subprojects {
    val springBootVersion: String by project
    val axonVersion: String by project

    apply(plugin = "java")
    apply(plugin = "kotlin-spring")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation("com.sksamuel.hoplite", "hoplite-core", "1.2.0")
        implementation("com.sksamuel.hoplite", "hoplite-yaml", "1.2.0")
        implementation("io.github.microutils", "kotlin-logging", "1.4.6")
        implementation("com.google.code.gson", "gson", "2.8.5")

        // Spring
        implementation("org.springframework.boot", "spring-boot-starter", springBootVersion)
        implementation("org.springframework.boot", "spring-boot-starter-logging", springBootVersion)
        implementation("org.springframework.boot", "spring-boot-starter-amqp", springBootVersion)
        implementation("org.springframework.amqp", "spring-rabbit", springBootVersion)
        implementation("org.springframework.amqp", "spring-amqp", springBootVersion)

        // Axon
        implementation("org.axonframework", "axon-core", axonVersion)
        implementation("org.axonframework", "axon-spring", axonVersion)
        implementation("org.axonframework", "axon-spring-boot-autoconfigure", axonVersion)
        implementation("org.axonframework", "axon-amqp", "3.4.3")

        // Logger
        implementation("org.apache.logging.log4j", "log4j-to-slf4j", "2.10.0")
        implementation("commons-logging", "commons-logging", "1.1.1")

        // RabbitMQ
        implementation("com.rabbitmq:http-client:3.6.1.RELEASE")

        // Testing
        testImplementation("org.springframework.boot", "spring-boot-starter-test", springBootVersion)
        testImplementation("org.amshove.kluent", "kluent", "1.60")
    }
}
