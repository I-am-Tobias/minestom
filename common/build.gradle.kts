import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

tasks.withType<ShadowJar> {
    archiveFileName = "common-${project.version}.jar"
}

dependencies {
    // Core dependencies
    implementation(libs.slf4j)
    implementation(libs.log4j)
    compileOnly(libs.jetbrainsAnnotations)
    implementation(libs.bundles.adventure)
    compileOnly(libs.hydrazine)
    compileOnly(libs.bundles.kotlin)
    implementation(libs.bundles.hephaistos)
    implementation(libs.minestomData)
    implementation(libs.dependencyGetter)

    // Performance/data structures
    implementation(libs.caffeine)
    compileOnly(libs.fastutil)
    implementation(libs.bundles.flare)
    compileOnly(libs.gson)
    implementation(libs.jcTools)

    // Testing
    testImplementation(libs.bundles.junit)
}
