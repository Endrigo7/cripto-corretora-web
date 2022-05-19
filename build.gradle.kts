import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.7"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "school.cesar"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

sourceSets {
	create("componentTest") {
		compileClasspath += sourceSets.main.get().output
		runtimeClasspath += sourceSets.main.get().output
	}
}

val componentTestImplementation: Configuration by configurations.getting {
	extendsFrom(configurations.implementation.get())
}

configurations["componentTestRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.h2database:h2:2.1.210")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	componentTestImplementation(sourceSets["test"].output)
	componentTestImplementation("org.springframework.boot:spring-boot-starter-test")
	componentTestImplementation("io.rest-assured:kotlin-extensions:5.0.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()

	testLogging {
		events(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED, org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
		exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
		showCauses = true
		showExceptions = true
		showStackTraces = true
	}
}

val componentTestTask = tasks.create("componentTest", Test::class) {
	description = "Runs the component testes."
	group = "verification"

	testClassesDirs = sourceSets["componentTest"].output.classesDirs
	classpath = sourceSets["componentTest"].runtimeClasspath

	useJUnitPlatform()
}

tasks.test {
	finalizedBy(
		"componentTest"
	)
}
