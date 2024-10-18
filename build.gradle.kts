plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.hexsoftwares"
version = "0.0.1-SNAPSHOT"

// Specify Java 22 as the toolchain version
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

repositories {
    mavenCentral() 
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // JPA support
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf") // Thymeleaf for the view layer
    implementation("org.springframework.boot:spring-boot-starter-web") // Web support
    developmentOnly("org.springframework.boot:spring-boot-devtools") // Dev tools for easier development
    runtimeOnly("org.postgresql:postgresql") // PostgreSQL driver
    testImplementation("org.springframework.boot:spring-boot-starter-test") // Testing support
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") 
}

tasks.withType<Test> {
    useJUnitPlatform() 
}
