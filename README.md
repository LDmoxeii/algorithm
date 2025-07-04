# Algorithm 算法练习项目

这是一个基于Kotlin语言的算法练习项目，主要收集整理了各种算法问题的解决方案，特别是LeetCode上的经典题目。

## 项目简介

本项目旨在提供高质量的算法题解决方案，使用Kotlin语言实现，代码风格清晰易懂。项目包含了以下几个方面：

- LeetCode经典题目的Kotlin实现
- 数据结构相关的算法实现
- 额外的算法练习和示例

## 项目结构

```
algorithm/
├── core/                           # 核心代码模块
│   └── src/main/kotlin/com/only4/algorithm/
│       ├── leetcode/               # LeetCode题目实现
│       └── extra/                  # 额外的算法实现
├── buildSrc/                       # Gradle构建逻辑
├── gradle/                         # Gradle配置
└── ...
```

### LeetCode题目实现

项目包含了大量LeetCode题目的Kotlin实现，涵盖以下类型：

- 数组与字符串
- 链表操作
- 二叉树与图
- 动态规划
- 回溯算法
- 双指针技巧
- 滑动窗口
- 深度优先搜索与广度优先搜索
- 设计类问题

每个实现都包含详细的题目描述、解题思路和完整代码。

## 构建与运行

本项目使用[Gradle](https://gradle.org/)进行构建管理。

### 前提条件

- JDK 11或更高版本
- Kotlin 1.8.x

### 常用命令

* 运行应用：`./gradlew run`
* 构建项目：`./gradlew build`
* 运行测试：`./gradlew check`
* 清理构建输出：`./gradlew clean`

注意：项目使用Gradle Wrapper（`./gradlew`），这是在生产项目中使用Gradle的推荐方式。

## 项目特点

- 使用现代Kotlin语法和惯用写法
- 详细的注释和文档
- 多模块项目结构
- 使用版本目录（见`gradle/libs.versions.toml`）声明和版本化依赖
- 启用构建缓存和配置缓存（见`gradle.properties`）