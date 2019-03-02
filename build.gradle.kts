plugins {
    kotlin("jvm") version "1.2.71"
    `java-gradle-plugin`
    `maven`
}

repositories {
    jcenter()
    maven("https://dl.bintry.com/cdimascio/maven")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(gradleApi())
    implementation("io.github.cdimascio:java-dotenv:4.1.0")
}

tasks.withType<Jar>() {
    configurations["compileClasspath"].forEach { file ->
        from(zipTree(file.absoluteFile))
    }
}

group = "io.github.pwoolcoc"
version = "1.0.0-SNAPSHOT"
