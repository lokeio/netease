# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是一个基于Spring Boot的网易低代码平台依赖库项目，主要实现日期相关的业务逻辑功能。项目使用Maven构建，包含了NASL元数据收集器和Maven插件。

## 常用命令

### 构建和打包
```bash
# 快速构建（跳过测试）
mvn clean package -Dmaven.test.skip=true

# 使用run.bat脚本构建
./run.bat
```

### 安装依赖
在使用项目前需要先安装本地依赖包：
```bash
# 安装nasl-metadata-collector
cd jar/nasl-metadata-collector-0.12.0/nasl-metadata-collector-0.12.0
./install.bat  # Windows
./install.sh   # Linux/Mac

# 安装nasl-metadata-maven-plugin
cd jar/nasl-metadata-maven-plugin-1.5.1
./install.bat  # Windows
./install.sh   # Linux/Mac
```

### 测试
```bash
# 运行所有测试
mvn test

# 运行单个测试
mvn test -Dtest=具体测试类名
```

## 项目架构

### 技术栈
- **Spring Boot 2.2.9**: 主框架
- **Java 8**: 编程语言
- **Joda-Time 2.10.14**: 日期时间处理
- **NASL低代码框架**: 网易低代码平台注解支持
- **Maven**: 构建工具

### 包结构
```
com.wesoftcn/
├── Day01BasicSpringEnvironmentConfiguration.java  # Spring配置类
├── LibraryAutoScan.java                          # 组件扫描标记类
├── api/
│   └── TestApi.java                              # 测试API（包含示例逻辑）
└── logic/
    ├── CalendarInput.java                        # 日历输入数据结构
    ├── InvalidInputException.java               # 自定义异常类
    └── MyLogic.java                             # 核心业务逻辑
```

### 核心组件

#### MyLogic.java
主要业务逻辑类，包含：
- `getWeekOfYear()`: 计算给定日期是当年的第几周（基于ISO 8601标准）

#### CalendarInput.java
日历输入数据结构，包含：
- 年、月、日字段及其验证逻辑
- 闰年判断和日期有效性检查
- `@NaslStructure`注解标记为低代码平台结构体

#### Spring配置
- 通过`META-INF/spring.factories`自动配置
- 使用`@ComponentScan`扫描`com.wesoftcn`包下的所有组件
- 依赖包设置为`provided`作用域以避免与父应用版本冲突

### NASL低代码平台集成
- 使用`@NaslLogic`注解标记业务逻辑方法
- 使用`@NaslStructure`注解标记数据结构
- 配置了`nasl-metadata-maven-plugin`用于元数据生成
- 日志使用`LCAP_EXTENSION_LOGGER`以在平台中显示

## 开发注意事项

### 依赖管理
- 大部分Spring Boot相关依赖使用`provided`作用域
- 需要手动安装jar目录下的本地依赖包
- Jackson版本使用Spring Boot父项目管理的版本

### 日期处理
- 优先使用Joda-Time而非Java 8的LocalDate
- 周数计算基于ISO 8601标准（周一为一周开始）
- 包含完整的日期有效性验证逻辑

### 异常处理
- 使用自定义`InvalidInputException`处理业务异常
- 所有输入验证都应抛出带有清晰错误信息的异常