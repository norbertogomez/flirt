plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    val hikariCPVersion: String by project

    implementation("com.zaxxer", "HikariCP", hikariCPVersion)
}