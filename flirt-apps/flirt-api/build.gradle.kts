plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

dependencies {
    val hikariCPVersion: String by project

    implementation(project(":flirt-libs:shared"))
    implementation(project(":flirt-libs:flirt:users"))
    implementation("org.springframework.boot","spring-boot-starter-web", "2.0.3.RELEASE")
    implementation("com.zaxxer", "HikariCP", hikariCPVersion)
}