plugins {
    `java-library`
    alias(libs.plugins.blossom)

    `maven-publish`
    signing
    alias(libs.plugins.nexuspublish)
}

// Read env vars (used for publishing generally)
version = System.getenv("MINESTOM_VERSION") ?: "dev"
val channel = System.getenv("MINESTOM_CHANNEL") ?: "local" // local, snapshot, release

val shortDescription = "1.20.4 Lightweight Minecraft server"

allprojects {
    apply(plugin = "java")

    group = "net.minestom"
    version = rootProject.version
    description = shortDescription

    repositories {
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    configurations.all {
        // We only use Jetbrains Annotations
        exclude("org.checkerframework", "checker-qual")
    }

    tasks.withType<Zip> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    tasks.withType<Test> {
        useJUnitPlatform()

        // Viewable packets make tracking harder. Could be re-enabled later.
        jvmArgs("-Dminestom.viewable-packet=false")
        jvmArgs("-Dminestom.inside-test=true")
    }
}

subprojects {
    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
        options.encoding = "UTF-8"
    }
}

tasks {
    jar {
        manifest {
            attributes("Automatic-Module-Name" to "net.minestom.server")
        }
    }
    withType<Javadoc> {
        (options as? StandardJavadocDocletOptions)?.apply {
            encoding = "UTF-8"

            // Custom options
            addBooleanOption("html5", true)
            addStringOption("-release", "17")
            // Links to external javadocs
            links("https://docs.oracle.com/en/java/javase/17/docs/api/")
            links("https://jd.adventure.kyori.net/api/${libs.versions.adventure.get()}/")
        }
    }
}
