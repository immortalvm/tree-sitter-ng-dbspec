# Tree Sitter NG DbSpec

Java bindings for the DbSpec language, for use with [Tree Sitter NG](https://github.com/bonede/tree-sitter-ng).

![package](https://github.com/immortalvm/tree-sitter-ng-dbspec/actions/workflows/gradle-publish.yml/badge.svg)

You must have Zig installed in order to build this package.


## Usage

Add dependencies to your `build.gradle` or `pom.xml`.

```groovy
// Gradle
repositories {
    mavenCentral()
    maven {
        name = "ImmortalVM"
        url = uri("https://maven.pkg.github.com/immortalvm/tree-sitter-ng-dbspec")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}
dependencies {
    // Add tree sitter
    implementation 'io.github.bonede:tree-sitter:0.22.5a'
    // Add DbSpec parser
    implementation("no.nr:tree-sitter-ng-dbspec:1.0-SNAPSHOT")
}
```
For pom.xml (Maven) see [Working with the Apache Maven registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry).
