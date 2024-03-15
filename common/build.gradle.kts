dependencies {
    // Core dependencies
    compileOnly(libs.slf4j)
    compileOnly(libs.jetbrainsAnnotations)
    compileOnly(libs.bundles.adventure)
    compileOnly(libs.hydrazine)
    compileOnly(libs.bundles.kotlin)
    compileOnly(libs.bundles.hephaistos)
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
