# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a multi-module Gradle project for algorithm practice, primarily implementing LeetCode solutions in both Kotlin
and Java. The project structure follows a clear separation between language implementations:

- `version4k/` - Kotlin implementations (primary focus)
- `version4j/` - Java implementations (secondary, fewer features)
- `buildSrc/` - Shared Gradle build logic

## Development Commands

### Build and Test

- **Build entire project**: `./gradlew build`
- **Clean build outputs**: `./gradlew clean`
- **Run all tests**: `./gradlew check` or `./gradlew test`
- **Run tests for specific module**: `./gradlew :version4k:test` or `./gradlew :version4j:test`
- **Run single test class**: `./gradlew :version4k:test --tests "ClassNameTest"`

### Environment Requirements

- JDK 17 (configured via Gradle toolchain)
- Kotlin 2.1.20
- Uses Gradle Wrapper (always use `./gradlew` not `gradle`)

## Code Architecture

### Module Structure

The project uses a multi-module Gradle setup with shared build logic:

- **buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts**: Convention plugin defining common Kotlin/JVM configuration
- **gradle/libs.versions.toml**: Centralized dependency versioning
- Both modules share similar package structure: `com.only4.algorithm.version4[k|j]`

### Data Structures

Both modules define common data structures in their `extra` packages:

- **TreeNode**: Binary tree node class for tree-related algorithms
- **ListNode**: Linked list node class for list-related algorithms
- **Kotlin location**: `com.only4.algorithm.version4k.extra.Structure`
- **Java location**: `com.only4.algorithm.version4j.extra.{TreeNode,ListNode}`

### LeetCode Implementation Pattern

Algorithm solutions are organized in the `leetcode` package of each module:

- Each algorithm typically has a corresponding test file
- Kotlin module has more comprehensive implementations
- Java module focuses on core algorithms with Spring Boot integration

### Dependencies

- **Kotlin module**: Uses Hutool utilities and Kotlin serialization
- **Java module**: Includes Spring Boot framework along with Hutool utilities
- Both use JUnit 5 for testing (configured via convention plugin)

## Testing Configuration

- All test tasks use JUnitPlatform
- Test logging shows PASSED, FAILED, and SKIPPED events
- Tests are located in standard `src/test/{kotlin|java}` directories

## Gradle Configuration

- Build and configuration caching enabled for performance
- Uses Foojay Toolchains plugin for automatic JDK management
- Dependencies resolved from Maven Central
