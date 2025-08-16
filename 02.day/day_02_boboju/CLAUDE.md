# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是一个基于 Vue 2 和 LCAP 平台的前端组件库项目，名为 "第二天作业"。项目使用 Vite 作为构建工具，集成了 Storybook 用于组件开发和调试。

## 常用命令

### 开发
```bash
npm start          # 启动 Storybook 开发服务器 (端口 8008)
npm run dev        # 等同于 npm start
```

### 构建和发布
```bash
npm run build      # 使用 Vite 构建项目
npm run release    # 发布到 LCAP 平台
```

### 测试
```bash
npm test           # 运行 Vitest 单元测试
```

### LCAP 工具命令
```bash
lcap create component  # 创建新组件
lcap create logic      # 创建新逻辑
npm run create         # 等同于 lcap-scripts create
npm run watch          # 监听文件变化
npm run play           # 播放模式
```

## 代码架构

### 核心结构
- `src/index.ts` - 主入口文件，导出 `UseComponents` 和 `UtilsLogics` 两个 Vue 插件
- `src/components/` - 组件目录，通过 `index.ts` 统一导出
- `src/logics/` - 逻辑/工具函数目录，通过 `index.ts` 统一导出
- `src/typings.d.ts` - TypeScript 类型声明文件

### 框架和工具
- **Vue 2.6.12** - 主框架，使用 Vue 2 语法
- **Vite 5** - 构建工具，配置了 Vue 2 插件和 LCAP 插件
- **Storybook 7** - 组件开发和调试环境
- **Vitest** - 单元测试框架 (jsdom 环境)
- **TypeScript** - 类型检查，目标 ES2020

### 别名配置
- `@/*` - 指向 `./src/*`
- `@components/*` - 指向 `./src/components/*`
- `@lcap-ui/*` - 指向 `./.lcap/lcap-ui/package/*`

### 插件安装机制
项目导出两个 Vue 插件：
- `UseComponents` - 自动注册所有组件为全局组件
- `UtilsLogics` - 将逻辑函数挂载到 `Vue.prototype.$library[LIBRARY_NAME]`

### 构建输出
- 构建目标：ES2020，支持现代浏览器
- 输出格式：UMD 库，入口为 `src/index`
- CSS 模块化：使用 scoped name 生成
- 源码映射：已启用

## 开发注意事项

### 组件开发
- 使用 Vue 2 语法
- 支持 JSX/TSX（配置了 `@lcap/vite-plugin-vue2`）
- 新组件需要在 `src/components/index.ts` 中导出
- 可使用 `lcap create component` 快速创建

### 逻辑开发
- 新逻辑函数需要在 `src/logics/index.ts` 中导出
- 可使用 `lcap create logic` 快速创建

### 测试
- 使用 Vitest + jsdom 环境
- 测试文件位置遵循标准约定
- 时区设置为 Asia/Shanghai