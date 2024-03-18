plugins {
    `java-library`
    alias(libs.plugins.blossom)

    `maven-publish`
    alias(libs.plugins.nexuspublish)
}

version = "1.0.0-SNAPSHOT"

allprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    group = "net.minestom"
    version = rootProject.version

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

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])

                this.groupId = project.group.toString()
                this.artifactId = project.name
                this.version = project.version.toString()
            }
        }

        repositories {
            maven {
                name = "bytemc"
                url = uri("https://nexus.bytemc.de/repository/maven-public/")
                credentials {
                    username = System.getenv("BYTEMC_REPO_USER")
                    password = System.getenv("BYTEMC_REPO_PASSWORD")
                }
            }
        }
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
