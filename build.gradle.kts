import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.6.10"
    application
    `maven-publish`
}

group = "id.walt"
version = "1.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.walt.id/repository/waltid/")
    maven("https://maven.walt.id/repository/waltid-ssi-kit/")
    maven("https://repo.danubetech.com/repository/maven-public/")
    mavenLocal()
}

dependencies {
    // SSIKIT
    implementation("id.walt:waltid-ssi-kit:1.13.0-SNAPSHOT2")
    implementation("id.walt:waltid-ssikit-vclib:1.24.2")

    implementation("io.javalin:javalin-bundle:4.6.4")
    implementation("com.github.kmehrunes:javalin-jwt:0.3")
    implementation("com.beust:klaxon:5.6")
    implementation("com.nimbusds:oauth2-oidc-sdk:9.43.1")
    // CLI
    implementation("com.github.ajalt.clikt:clikt-jvm:3.5.0")
    implementation("com.github.ajalt.clikt:clikt:3.5.0")

    // Service-Matrix
    implementation("id.walt.servicematrix:WaltID-ServiceMatrix:1.1.0")

    // Logging
    implementation("org.slf4j:slf4j-api:2.0.1")
    implementation("org.slf4j:slf4j-simple:2.0.0")
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.0")

    implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.1")
    implementation("io.ktor:ktor-client-core:2.1.1")
    implementation("io.ktor:ktor-client-cio:2.1.1")

    // Cache
    implementation("io.github.pavleprica:kotlin-cache:1.1.1")

    // Testing
    //testImplementation(kotlin("test-junit"))
    testImplementation("io.mockk:mockk:1.12.8")

    testImplementation("io.kotest:kotest-runner-junit5:5.4.2")
    testImplementation("io.kotest:kotest-assertions-core:5.4.2")
    testImplementation("io.kotest:kotest-assertions-json:5.4.2")

    // HTTP
    testImplementation("io.ktor:ktor-client-core:2.1.1")
    testImplementation("io.ktor:ktor-client-cio:2.1.1")
    testImplementation("io.ktor:ktor-client-logging:2.1.1")
    testImplementation("io.github.rybalkinsd:kohttp:0.12.0")
    testImplementation("io.ktor:ktor-client-content-negotiation:2.1.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("id.walt.MainKt")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name.set("walt.id SSI Wallet Kit")
                description.set("Kotlin/Java wallet API backend, including issuer and verifier API backends.")
                url.set("https://walt.id")
            }
            from(components["java"])
        }
    }

    repositories {
        maven {
            url = uri("https://maven.walt.id/repository/waltid-ssi-kit/")
            val usernameFile = File("secret_maven_username.txt")
            val passwordFile = File("secret_maven_password.txt")
            val secretMavenUsername = System.getenv()["MAVEN_USERNAME"] ?: if (usernameFile.isFile) { usernameFile.readLines()[0] } else { "" }
            val secretMavenPassword = System.getenv()["MAVEN_PASSWORD"] ?: if (passwordFile.isFile) { passwordFile.readLines()[0] } else { "" }

            credentials {
                username = secretMavenUsername
                password = secretMavenPassword
            }
        }
    }
}
