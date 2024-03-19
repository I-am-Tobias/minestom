import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "net.minestom.bootstrap.MinestomBootstrap"
    }
}

tasks.withType<ShadowJar> {
    archiveFileName = "bootstrap-${project.version}.jar"
}

dependencies {
    implementation(project(":common"))
    implementation(libs.bundles.adventure)
}