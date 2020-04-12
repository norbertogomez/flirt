plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    val kweriVersion: String by project

    implementation(project(":flirt-libs:shared"))
    implementation("com.github.andrewoma.kwery", "core", kweriVersion)
}