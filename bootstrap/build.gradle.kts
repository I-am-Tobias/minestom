plugins {
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "net.minestom.bootstrap.MinestomBootstrap"
    }
}

dependencies {
    implementation(project(":common"))
    implementation(libs.bundles.adventure)
}